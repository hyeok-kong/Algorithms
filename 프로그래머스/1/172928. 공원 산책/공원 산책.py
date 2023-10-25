def solution(park, routes):
    answer = []
    width = len(park[0])-1
    height = len(park)-1
    fail = []
    now = [0, 0] # 세로, 가로
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "X":
                fail.append([j,i])
            if park[i][j] == "S":
                now = [j,i]
    answer = [now[1], now[0]]
    
    for route in routes:
        dir, dist = route.split(" ")
        isFail = False
        temp = [now[0], now[1]]
        
        for count in range(int(dist)):
            temp = move(temp, dir)
            if not ((temp[0] >= 0) and (temp[0] <= width) and ((temp[1] >= 0) and (temp[1] <= height))):
                isFail = True
                break
            for f in fail:
                if temp[0] == f[0] and temp[1] == f[1]:
                    isFail = True
                    break
            if isFail:
                break
        if isFail:
            continue
        now = temp

        answer = [now[1], now[0]]
    return answer

def move(pos, dir):
    # N, S, W, E // (0, 1), (0, -1), (-1, 0), (1, 0)
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    move = 0
    if dir == "N":
        move = 0
    elif dir == "S":
        move = 1
    elif dir == "W":
        move = 2
    else:
        move = 3
    pos[0] += dx[move]
    pos[1] += dy[move]
    
    return pos