def solution(food):
    answer = ''
    for idx in range(1, len(food)):
        answer += str(idx)*(food[idx]//2)
    reverse = answer[::-1]
    answer += "0"
    answer += reverse
    return answer