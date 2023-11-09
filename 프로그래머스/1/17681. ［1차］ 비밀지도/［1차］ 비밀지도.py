def solution(n, arr1, arr2):
    answer = []
    for num1, num2 in zip(arr1, arr2):
        a, b = toBinary(n, num1, num2)
        temp = ""
        for s1, s2 in zip(a, b):
            if s1 == "1" or s2 == "1":
                temp += "#"
            else:
                temp += " "
        answer.append(temp)
    return answer

def toBinary(n, num1, num2):
    a, b = bin(num1).replace("0b", ""), bin(num2).replace("0b", "")
    
    return f"{a:0>{n}}", f"{b:0>{n}}"