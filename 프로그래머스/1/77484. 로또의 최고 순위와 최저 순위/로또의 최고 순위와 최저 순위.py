def solution(lottos, win_nums):
    dknow, know = 0, 0
    for lotto in lottos:
        if lotto == 0:
            dknow += 1
        if lotto in win_nums:
            know += 1
    return [6 if 7-(know+dknow) > 6 else 7-(know+dknow), 6 if 7-know > 6 else 7-know]