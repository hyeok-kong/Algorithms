def solution(s):
    num = [int(n) for n in s.split()]
    return f"{str(min(num))} {str(max(num))}"