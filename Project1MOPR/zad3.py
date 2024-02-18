from zad1 import Node
from zad2 import euclidean_distance

def get_nearest_neighbors(node, target_word, depth=0):
    if not node:
        return []
    assert node is not None, "ERROR: node none."
    assert isinstance(node, Node), "ERROR: node must be an instance of the class Node."
    assert isinstance(target_word, list), "ERROR: target_word must be a list."
    assert all(isinstance(coord, (int, float)) for coord in target_word), "ERROR: All target_word coordinates must be numbers."

    length = len(target_word)
    assert length > 0, "ERROR: Invalid dimension number."
    axis = depth % length

    if target_word[axis] < node.vector[axis]:
        next_branch = node.left
        opposite_branch = node.right
    else:
        next_branch = node.right
        opposite_branch = node.left

    neighbour = get_nearest_neighbors(next_branch, target_word, depth + 1)

    current_vector = node.vector
    distance_to_target = euclidean_distance(target_word, current_vector)
    neighbour.append((current_vector, distance_to_target))

    opposite_neighbors = get_nearest_neighbors(opposite_branch, target_word, depth + 1)
    neighbour.extend(opposite_neighbors)

    return neighbour

def find_nearest_vectors(kd_tree, target_word, n):
    assert kd_tree is not None, "ERROR: Kd_tree none."
    assert isinstance(kd_tree, Node), "ERROR: Kd_tree must be an instance of class Node."
    assert isinstance(target_word, list), "ERROR: target_word must be a list and nothing else."
    assert all(isinstance(coord, (int, float)) for coord in target_word), ("ERROR: All coordinates in target_word must "
                                                                           "be numbers.")
    length = len(target_word)
    assert length > 0, "ERROR: Invalid dimension number."
    assert isinstance(n, (int, float)), "ERROR: n must be a number and nothing else."
    assert n >= 0, "ERROR: n must be non-negative."

    nearest_neighbors = get_nearest_neighbors(kd_tree, target_word)
    nearest_neighbors.sort(key=lambda x: x[1])
    top_n_neighbors = nearest_neighbors[:n]
    return top_n_neighbors
