class Node:
    def __init__(self, vector, left=None, right=None):
        self.vector = vector
        self.left = left
        self.right = right

def validate_model(model):
    assert model is not None, "ERROR: Model none."
    assert model is not False, "ERROR: Model false."
    assert model, "ERROR: Input model dictionary is empty."
    assert check_dimensions(model), "ERROR: All vectors must be in the same dimension."
    assert check_distinct_vectors(model), "ERROR: All vectors must be distinct."

def build_kdtree(model, depth=0):
    if depth == 0:
        validate_model(model)

    if not model:
        return None

    k = len(next(iter(model.values())))
    axis = depth % k

    vector_items = model.items()
    def sort_key(item):
        return item[1][axis]

    sorted_vector_items = sorted(vector_items, key=sort_key)
    sorted_model = dict(sorted_vector_items)

    unique_vectors = set()
    for _, current_vector in sorted_model.items():
        assert tuple(current_vector) not in unique_vectors, "ERROR: There are duplicated vectors."
        unique_vectors.add(tuple(current_vector))

    median = len(sorted_model) // 2

    vector_values = list(sorted_model.values())
    vector_items = list(sorted_model.items())

    left_subtree_items = vector_items[:median]
    left_subtree_model = dict(left_subtree_items)
    left_subtree = build_kdtree(left_subtree_model, depth + 1)

    right_subtree_items = vector_items[median+ 1:]
    right_subtree_model = dict(right_subtree_items)
    right_subtree = build_kdtree(right_subtree_model, depth + 1)

    current_node = Node(
        vector=vector_values[median],
        left=left_subtree,
        right=right_subtree
    )

    return current_node


def check_dimensions(model):
    dimensions = None
    for word, vector in model.items():
        if dimensions is None:
            dimensions = len(vector)
        else:
            if len(vector) != dimensions:
                return False
    return True

def check_distinct_vectors(model):
    met_vectors = set()
    for _, current_vector in model.items():
        model_tuple = tuple(current_vector)
        if model_tuple in met_vectors:
            return False
        met_vectors.add(model_tuple)
    return True

def delete_vector_in_kd_tree(root, target_vector):
    def delete_recursive(node, target_vector, depth=0):
        if node is None:
            return None

        k = len(target_vector)
        axis = depth % k

        def find_min(node, axis, depth=0):
            if node is None:
                return None

            k = len(node.vector)
            next_axis = (depth + 1) % k

            if axis == depth % k:
                if node.left is None:
                    return node
                return find_min(node.left, axis, depth + 1)
            else:
                left_min = find_min(node.left, axis, depth + 1)
                right_min = find_min(node.right, axis, depth + 1)

                current_min = node
                if left_min is not None and left_min.vector[axis] < current_min.vector[axis]:
                    current_min = left_min
                if right_min is not None and right_min.vector[axis] < current_min.vector[axis]:
                    current_min = right_min

                return current_min

        if node.vector == target_vector:
            if node.right is not None:
                min_node = find_min(node.right, axis, depth + 1)
                node.vector = min_node.vector
                node.right = delete_recursive(node.right, min_node.vector, depth + 1)
            elif node.left is not None:
                return node.left
            else:
                return None
        elif target_vector[axis] < node.vector[axis]:
            node.left = delete_recursive(node.left, target_vector, depth + 1)
        else:
            node.right = delete_recursive(node.right, target_vector, depth + 1)

        return node

    return delete_recursive(root, target_vector)












