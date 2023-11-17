def solution(x):
    num1, num2 = x, 0
    for i in range(5):
        x, y = x//10, x % 10
        num2 += y
    return True if num1%num2==0 else False