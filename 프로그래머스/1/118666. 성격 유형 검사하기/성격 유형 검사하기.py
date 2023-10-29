def solution(survey, choices):
    answer = ''
    survey_result = { "R":0, "T":0, "C":0, "F":0, "J":0, "M":0, "A":0, "N":0 }
    survey_list = []
    for idx, s in enumerate(survey):
        if choices[idx]-4 > 0:
            survey_result[s[1]] += abs(choices[idx]-4)
        else:
            survey_result[s[0]] += abs(choices[idx]-4)
    
    item = {}
    for key, value in survey_result.items():
        item[key] = value
        if len(item) == 2:
            survey_list.append(item)
            item = {}
    
    for res in survey_list:
        bigger = ""
        score = 0
        check = False
        for key, value in res.items():
            if not check and value == 0:
                bigger = key
            elif value > score:
                bigger = key
                score = value
            check = True
        answer += bigger
        
    return answer