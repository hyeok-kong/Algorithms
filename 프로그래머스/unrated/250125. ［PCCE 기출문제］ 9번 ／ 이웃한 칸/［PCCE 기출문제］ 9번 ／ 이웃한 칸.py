def solution(board, h, w):
    count, color = 0, board[h][w]
    
    for i in range(len(board)):
        if h-1 == i or h+1 == i:
            count += 1 if board[i][w] == color else 0
        if w-1 == i or w+1 == i:
            count += 1 if board[h][i] == color else 0
        
    return count