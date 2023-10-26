def solution(t, p):
    answer = 0
    length = len(p)
    for idx in range(len(t)):
        if not (idx+length > len(t)):
            answer += 1 if int(t[idx:idx+length]) <= int(p) else 0
        else:
          break
    return answer