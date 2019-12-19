def func_constant(values):  # O(1) Constant
    print(values[0])


def func_lin(values):  # O(n) Linear
    for val in values:
        print(val)


def func_quad(values):  # O(n^2) Quadratic
    for item_1 in values:
        for item_2 in values:
            print(item_1, item_2)


def print_2(values):  # O(2n)
    for item_1 in values:
        print(item_1)
    for item_2 in values:
        print(item_2)


lst = [1, 2, 3]
func_constant(lst)
func_lin(lst)
func_quad(lst)
