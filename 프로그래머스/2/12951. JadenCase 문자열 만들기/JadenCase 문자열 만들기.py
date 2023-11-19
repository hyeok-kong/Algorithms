def solution(s):
    answer, temp = '', ''
    for c in s:
        temp += c
        if ' ' in temp:
            if temp == ' ':
                answer += temp
                temp = ''
                continue
            answer += f'{temp[0].upper()}{temp[1:].lower()}'
            temp = ''
            continue
    answer = answer + temp if len(temp) == 0 else answer + f'{temp[0].upper()}{temp[1:].lower()}'
    return answer
    
    # return ' '.join([f'{w[0].upper()}{w[1:].lower()}' for w in s.split()])