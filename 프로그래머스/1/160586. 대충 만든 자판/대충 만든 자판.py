def solution(keymap, targets):
    answer = []
    key_dict = {}
    
    for key in keymap:
        for idx, k in enumerate(key):
            if (k not in key_dict) or (key_dict[k] > idx):
                key_dict[k] = idx+1
        
    print(key_dict)
    for target in targets:
        times = 0
        for t in target:
            if t not in key_dict:
                times = -1
                break
            else:
                times += key_dict[t]
        answer.append(times)
        
    return answer