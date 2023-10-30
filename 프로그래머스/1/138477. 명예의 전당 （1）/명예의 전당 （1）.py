def solution(k, score):
    answer = []
    honor = []
    for s in score:
        if len(honor) < k:
            honor.append(s)
        else:
            if honor[k-1] < s:
                honor[k-1] = s
        honor.sort(reverse=True)
        answer.append(honor[-1])
    return answer