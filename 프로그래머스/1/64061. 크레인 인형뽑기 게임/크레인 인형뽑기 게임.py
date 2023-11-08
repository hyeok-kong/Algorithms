def solution(board, moves):
    answer = 0
    res_stack = []
    board_stack = [[] for _ in range(len(board))]
    
    for b in board:
        for idx, item in enumerate(b):
            if item == 0:
                continue
            board_stack[idx].insert(0,item)
        
    for i in range(len(moves)):
        if len(board_stack[moves[i]-1]) <= 0:
            continue
        if len(res_stack) == 0:
            res_stack.append(board_stack[moves[i]-1].pop())
        else:
            if board_stack[moves[i]-1][-1] == res_stack[-1]:
                res_stack.pop()
                board_stack[moves[i]-1].pop()
                answer += 2
            else:
                res_stack.append(board_stack[moves[i]-1].pop())


    return answer