def solution(n, lost, reserve):
    answer = 0
    students = [1 for i in range(n+2)]
    students[0] = -1
    students[-1] = -1
    
    for l in lost:
        students[l] -= 1
    for r in reserve:
        students[r] += 1


    for idx in range(1, len(students)-1):
        if students[idx] == 2:
            if students[idx-1] == 0 or students[idx+1] == 0:
                if students[idx-1] == 0 and students[idx+1] == 0:
                    continue
                else:
                    if students[idx-1] == 0:
                        students[idx-1] += 1
                    elif students[idx+1] == 0:
                        students[idx+1] += 1
                    students[idx] -= 1

    for idx in range(1, len(students)-1):
        if students[idx] == 2:
            if students[idx-1] == 0:
                students[idx-1] += 1
            elif students[idx+1] == 0:
                students[idx+1] += 1
            students[idx] -= 1
    if students[-1] == 2 and students[-2] == 0:
        students[-1] -= 1
        students[-2] += 1

    for s in students:
        if s > 0:
            answer += 1
            
    return answer