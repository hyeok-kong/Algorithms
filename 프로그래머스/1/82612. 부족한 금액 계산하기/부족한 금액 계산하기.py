def solution(price, money, count):
    answer = -1
    pr = [price*c for c in range(1, count+1)]
    if money > sum(pr):
        answer = 0
    else:
        answer = sum(pr) - money
    return answer