from collections import Counter
def solution(N, stages):
    answer = []
    failure_rate = {}
    counter = Counter(stages)
    total = len(stages)

    for n in range(N):
        do = total - sum([counter[i] for i in range(1, n+1)])
        fail = counter[n+1]
        # print(n+1, do, fail)  
        failure_rate[n+1] = 0 if do == 0 else fail/do
    
    print(failure_rate)
    sorted_rate = dict(sorted(failure_rate.items(), key=lambda item: item[1], reverse=True))
    for k in sorted_rate.keys():
        answer.append(k)
    
    return answer