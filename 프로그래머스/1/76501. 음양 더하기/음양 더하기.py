def solution(absolutes, signs):
    answer = 0
    for num, sign in zip(absolutes, signs):
        n = num if sign else -num
        answer += n
    return answer