def solution(players, callings):
    answer = []
    
    d = {player:idx for idx, player in enumerate(players)}

    for calling in callings:
        rank = d[calling]
        d[calling] -= 1
        d[players[rank-1]] += 1
        
        players[rank], players[rank-1] = players[rank-1], players[rank]
        
    answer = players
    return answer
