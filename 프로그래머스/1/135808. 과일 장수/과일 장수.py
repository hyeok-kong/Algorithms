import queue

def solution(k, m, score):
    answer = 0
    q = queue.Queue()
    sorted_score = sorted(score, reverse=True)

    for i in range(len(score)):
        q.put(sorted_score[i])
    
    for i in range(len(score)//m):
        for j in range(m):
            j = q.get()
        answer += j*m
    return answer