def solution(babbling):
    answer = 0
    
    for bab in babbling:
        if isPossible(bab):
            answer += 1
        
    return answer

def isPossible(bab):
    can = ["aya", "ye", "woo", "ma"]
    before = ""
    string = ""
    for b in bab:
        string += b
        for c in can:
            if string != before and string == c:
                before = string
                string = ""
    return False if string else True