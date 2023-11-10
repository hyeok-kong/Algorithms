def solution(storey):
    answer = 0
    
    while storey > 0:
        storey = abs(storey - 10**len(str(storey))) if storey > 10**len(str(storey))//2 + 10**(len(str(storey))-1)//2 else storey - 10**(len(str(storey))-1)

        answer += 1
            
    return answer
