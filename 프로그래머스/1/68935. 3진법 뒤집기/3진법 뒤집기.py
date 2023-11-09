def solution(n):
    answer = 0
    temp = ""
    while True:
        n, e = n//3, n%3
        temp += str(e)
        if n < 1:
            break
        elif n == 1 and e == 0:
            temp += str(n)
            break
    temp = "".join(reversed(temp))
    
    for idx, t in enumerate(temp):
        answer += (3**idx) * int(t)
    return answer