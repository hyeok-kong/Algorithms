def solution(numbers):
    answer = []
    max_num = []
    for i in range(len(numbers)-1, -1, -1):
        while len(max_num) > 0:
            if numbers[i] < max_num[-1]:
                answer.append(max_num[-1])
                max_num.append(numbers[i])
                break
            else:
                max_num.pop()
        if len(max_num) == 0:
            answer.append(-1)
            max_num.append(numbers[i])
    return answer[::-1]