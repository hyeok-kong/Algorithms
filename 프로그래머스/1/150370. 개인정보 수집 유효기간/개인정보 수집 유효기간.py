def solution(today, terms, privacies):
    answer = []
    term = {}
    for t in terms:
        p = t.split(" ")
        term[p[0]] = int(p[1])
    
    for idx, privacy in enumerate(privacies):
        p = privacy.split(" ")
        if isDeprecated(today, calculate_date(p[0], term[p[1]])):
            answer.append(idx+1)
            
    return answer


def isDeprecated(today, end_date):
    d = today.split(".")
    for i in range(3):
        d[i] = int(d[i])
    if (d[0] > end_date[0]):
        return True
    if (d[0] == end_date[0]):
        if d[1] > end_date[1]:
            return True
        if d[1] == end_date[1]:
            if d[2] > end_date[2]:
                return True
    return False

def calculate_date(day, limit):
    d = day.split(".")
    for i in range(3):
        d[i] = int(d[i])
    
    d[2] -= 1
    if d[2] == 0:
        d[1] -= 1
        d[2] = 28
    d[1] += limit
    if d[1] > 12:
        d[0] += (d[1]-1) // 12
        d[1] = 12 if d[1] % 12 == 0 else d[1] % 12
    return d