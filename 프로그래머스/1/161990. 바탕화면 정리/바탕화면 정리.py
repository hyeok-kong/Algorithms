def solution(wallpaper):
    answer = [-1, -1, -1, -1] # top, left, bottom, right
    last = 0
    for idx, block in enumerate(wallpaper):
        indices = [index for index, char in enumerate(block) if char == "#"]
        if indices:
            last = idx
            if answer[0] == -1:
                answer[0] = idx
            if answer[1] == -1:
                answer[1] = indices[0]
            elif answer[1] > indices[0]:
                answer[1] = indices[0]
            if answer[3] < indices[-1]+1:
                answer[3] = indices[-1] + 1
    answer[2] = last + 1
    return answer