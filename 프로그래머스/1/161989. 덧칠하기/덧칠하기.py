def solution(n, m, section):
    answer = 0
    walls = [0 for _ in range(n)]
    for s in section:
      walls[s-1] = 1
    
    print(len(walls))
    for idx in range(n):
      if walls[idx] == 1:
        answer += 1
        for brush in range(m):
          if idx+brush < n:
            walls[idx+brush] = 0

    return answer