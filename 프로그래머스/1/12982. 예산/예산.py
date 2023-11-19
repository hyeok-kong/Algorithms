def solution(d, budget):
    answer = 0
    for b in sorted(d):
        if b > budget:
            break
        budget -= b
        answer += 1
    return answer