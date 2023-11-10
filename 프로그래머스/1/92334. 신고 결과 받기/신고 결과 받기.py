def solution(id_list, report, k):
    answer = [0 for i in range(len(id_list))]
    blocked = [0 for i in range(len(id_list))]
    report = list(set(report))
    report_dict = { id:[] for id in id_list }
    reported_dict = { id:[] for id in id_list }
    
    for r in report:
        f, t = r.split(" ")
        report_dict[f].append(t)
    
    for report, reported in report_dict.items():
        for r in reported:
            reported_dict[r].append(report)
            
    for reported, report in reported_dict.items():
        if len(report) >= k:
            for r in report:
                answer[id_list.index(r)] += 1

    return answer
