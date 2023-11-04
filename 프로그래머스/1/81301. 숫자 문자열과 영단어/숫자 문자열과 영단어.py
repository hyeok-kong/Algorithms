def solution(string):
    str_to_num = {
        "zero":"0", "one":"1", "two":"2", "three":"3", "four":"4",
        "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"
    }
    answer = ""
    temp_str = ""
    for s in string:
        if temp_str in str_to_num:
            answer += str_to_num[temp_str]
            temp_str = ""
        if s.isalpha():
            temp_str += s
        else:
            answer += s
    if temp_str:
        answer += str_to_num[temp_str]
    return int(answer)
    
