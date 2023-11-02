def solution(sizes):
    answer = 0
    s = [[], []]
    for size in sizes:
        if size[0] < size[1]:
            size[0], size[1] = size[1], size[0] 
        s[0].append(size[0])
        s[1].append(size[1])
    
    answer = max(s[0])*max(s[1])
        
    return answer