def solution(s, skip, index):
    answer = ''
    alpha = [chr(i) for i in range(ord('a'), ord('z')+1) if chr(i) not in skip]
    s_list = []
    for count in s:
      for idx, c in enumerate(alpha):
        if count == c:
          s_list.append(idx)
          break

    for idx in s_list:
        step = idx+index if idx+index < len(alpha)-1 else (idx+index) % len(alpha)
        answer += alpha[step]
    return answer