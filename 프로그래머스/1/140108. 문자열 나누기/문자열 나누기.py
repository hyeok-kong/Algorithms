def solution(s):
    answer = 1
    isNotEnd = True
    while isNotEnd:
        s = split_str(s)
        if not s:
            isNotEnd = False
        else:
            answer += 1
    return answer

def split_str(s):
    if not s:
        return False
    count = [1, 0] # 1번째 개수, 나머지 개수
    for idx in range(1, len(s)):
        if s[idx] == s[0]:
            count[0] += 1
        else:
            count[1] += 1
        
        if count[0] == count[1]:
            return s[count[0]+count[1]:]
        