def solution(s):
    answer = []
    char_dict = {}
    for idx, ch in enumerate(s):
        if ch not in char_dict:
            answer.append(-1)
        else:
            answer.append(idx - char_dict[ch])
        char_dict[ch] = idx
        
    return answer