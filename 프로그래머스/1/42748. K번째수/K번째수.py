def solution(array, commands):
    answer = []
    for command in commands:
        i, j, k = command[0], command[1], command[2]
        item = sorted(array[i-1:j])
        answer.append(item[k-1])
    return answer