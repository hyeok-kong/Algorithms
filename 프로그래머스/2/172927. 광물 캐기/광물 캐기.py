import queue

def solution(picks, minerals):
    answer = 0
    mineral_sets = []
    work = queue.Queue()

    for i in range(len(minerals)//5+1):
        mineral_sets.append([])
    mineral_sets[0].append(calculate_mineral(minerals[0]))

    for i in range(1, len(minerals)):
        mineral_sets[i//5].append(calculate_mineral(minerals[i]))
    
    if sum(picks) < len(mineral_sets):
        mineral_sets = mineral_sets[0:sum(picks)]

    for i in range(len(mineral_sets)):
        max_sum = max(mineral_sets, key=sum)
        work.put(max_sum)
        mineral_sets.remove(max_sum)

    pick_num = 0
    while not work.empty():
        while picks[pick_num] == 0:
            pick_num += 1
            if pick_num > 2:
                break
        picks[pick_num] -= 1
        answer += calculate_fatigue(pick_num, work.get())

    return answer

def calculate_fatigue(pick, minerals):
    if pick == 0:
        power = 25
    elif pick == 1:
        power = 5
    else:
        power = 1

    fatigue = 0
    
    for mineral in minerals:
        if mineral // power < 1:
            fatigue += 1
        else:
            fatigue += mineral // power

    return fatigue

def calculate_mineral(mineral):
    if mineral == "diamond":
        return 25
    elif mineral == "iron":
        return 5
    else:
        return 1