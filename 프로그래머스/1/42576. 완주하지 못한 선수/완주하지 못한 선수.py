def solution(participant, completion):
    answer = ''
    coms = {}
    for p in participant:
        if p in coms:
            coms[p] += 1
        else:
            coms[p] = 1
    
    for c in completion:
        coms[c] -= 1
    
    for key, value in coms.items():
        if value > 0:
            answer = key
            
    return answer