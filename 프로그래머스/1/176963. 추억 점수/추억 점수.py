def solution(name, yearning, photo):
    answer = []
    for p in photo:
        # score = [y for idx, y in enumerate(yearning) if name[idx] in p]
        score = 0
        for idx, y in enumerate(yearning):
            if name[idx] in p:
                score += y
        answer.append(score)
    return answer