def solution(targets):
    answer = 0
    bound = 0
    for s, e in sorted(targets):
        if s >= bound:
            answer += 1
            bound = e
        else:
            bound = min(bound, e)
    return answer