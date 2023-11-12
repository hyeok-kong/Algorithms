def solution(record):
    answer = []
    id_name = {}
    for rec in record:
        r = rec.split(" ")

        result = ""
        action, uid = r[0], r[1]
        if action == "Leave":
            result = f"{uid}|님이 나갔습니다."
        else:
            id_name[uid] = r[2]
            if action == "Enter":
                result = f"{uid}|님이 들어왔습니다."            

        if result:
            answer.append(result)
        
    for i in range(len(answer)):
        uid, other = answer[i].split("|")
        answer[i] = id_name[uid] + other
        
    return answer