def solution(number, limit, power):
    answer = 0
    for i in range(1, number+1):
        weapon = getDivCount(i)
        if weapon > limit:
            weapon = power
        answer += weapon
    return answer

def getDivCount(number):
    if number == 1:
        return 1
    
    count = 0
    for i in range(1, int(number**0.5+1)):
        if number % i == 0:
            count += 2
    if (number**0.5) % 1 == 0:
        count -= 1
    
    return count