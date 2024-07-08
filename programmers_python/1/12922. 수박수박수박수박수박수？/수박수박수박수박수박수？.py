def solution(n):
    answer = ''
    for _ in range(n):
        if _ % 2 == 0:
            answer += "수"
        else:
            answer += "박"
    return answer