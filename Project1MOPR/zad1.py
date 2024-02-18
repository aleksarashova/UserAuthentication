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
    assert k > 0, "ERROR: Invalid dimension number."
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












