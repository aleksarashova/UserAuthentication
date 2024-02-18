import math
from zad1 import Node

def euclidean_distance(point1, point2):
    return math.sqrt(sum((a - b) ** 2 for a, b in zip(point1, point2)))

def nearest_neighbors(node, search_point, depth=0):
    if not node:
        return []
    assert isinstance(node, Node), "ERROR: node must be an instance of the class Node."

    length = len(search_point)
    axis = depth % length

    if search_point[axis] < node.vector[axis]:
        next_branch = node.left
        opposite_branch = node.right
    else:
        next_branch = node.right
        opposite_branch = node.left

    nearest = nearest_neighbors(next_branch, search_point, depth + 1)

    if not nearest:
        nearest.append(node.vector)
    else:
        current_search_axis_value = search_point[axis]
        last_nearest_axis_value = nearest[-1][axis]
        if current_search_axis_value  != last_nearest_axis_value:
            nearest.append(node.vector)

    length_of_nearest = len(nearest)
    if length_of_nearest < length:
        nearest.extend(nearest_neighbors(opposite_branch, search_point, depth + 1))
    else:
        difference_current_node = abs(search_point[axis] - node.vector[axis])
        difference_last_nearest = abs(search_point[axis] - nearest[-1][axis])
        if difference_current_node < difference_last_nearest:
            nearest.extend(nearest_neighbors(opposite_branch, search_point, depth + 1))

    return nearest

def find_vectors_in_cube(kd_tree, side, target_word):
    assert kd_tree is not None, "Kd_tree none."
    assert isinstance(kd_tree, Node), "ERROR: Kd_tree must be an instance of class Node."
    assert isinstance(side, (int, float)) and side > 0, "ERROR: Side must be a positive number."
    assert isinstance(target_word, list), "ERROR: target_word must be a list and nothing else."
    assert all(isinstance(coord, (int, float)) for coord in target_word), ("ERROR: All coordinates in target_word must "
                                                                           "be numbers.")
    axis = 0

    nearest_points = nearest_neighbors(kd_tree, target_word, axis)

    vectors_in_cube = []
    for point in nearest_points:
        if all(abs(a - b) <= side / 2 for a, b in zip(point, target_word)):
            dist = euclidean_distance(point, target_word)
            vectors_in_cube.append((point, dist))

    return vectors_in_cube
