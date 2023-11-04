def solution(new_id):
    answer = ''
    possible = ["-", "_", "."]
    
    answer = new_id.lower() # 1
    
    temp_id = "" # 2
    for s in answer:
        if s.isdigit() or s.isalpha() or s in possible:
            temp_id += s
    answer = temp_id        
    
    while True: # 3
        if ".." in answer:
            answer = answer.replace("..", ".")
        else:
            break
    
    while True:
        if answer and answer[0] == ".": # 4
            answer = answer[1:]
        else:
            break
    
    while True:
        if answer and answer[-1] == ".":
            answer = answer[:-1]
        else:
            break
    
    if not answer: # 5
        answer = "a"
    
    print(answer)
    if len(answer) > 15: # 6
        answer = answer[:15]
    print(answer)
    while True:
        if len(answer) < 3:
            answer += answer[len(answer)-1]
        else:
            break
            
    while True: # 마지막 검사
        if answer and answer[-1] == ".":
            answer = answer[:-1]
        else:
            break

    return answer