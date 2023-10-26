def solution(cards1, cards2, goal):
    answer = ''
    
    isPossible = True
    idx1, idx2 = 0, 0
    for word in goal:
        if idx1 < len(cards1) and cards1[idx1] == word:
            idx1 += 1
            continue
        elif idx2 < len(cards2) and cards2[idx2] == word:
            idx2 += 1
            continue
        else:
            isPossible = False
            break
    answer = "Yes" if isPossible else "No"
    return answer