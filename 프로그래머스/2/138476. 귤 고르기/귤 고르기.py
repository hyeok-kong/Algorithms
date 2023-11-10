from collections import Counter
def solution(k, tangerine):
    answer = 0
    tanger = Counter(tangerine)
    sorted_tanger = dict(sorted(tanger.items(), key=lambda item: item[1], reverse=True))
    for tan, count in sorted_tanger.items():
        if k <= 0:
            break
        answer += 1
        k -= count
    return answer