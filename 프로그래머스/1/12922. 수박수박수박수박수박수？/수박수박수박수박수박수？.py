def solution(n):
    string = ['수', '박']
    answer = ''
    for i in range(n):
        answer += string[i%2]
    return answer