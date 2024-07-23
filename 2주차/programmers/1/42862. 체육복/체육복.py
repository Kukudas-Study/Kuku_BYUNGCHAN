# Solution 1
# def solution(n, lost, reserve):
#     # 여벌 체육복을 가져온 학생이 도난당한 경우를 처리
#     reserve_set = set(reserve) - set(lost)
#     lost_set = set(lost) - set(reserve)
    
#     # 체육복을 빌려줄 수 있는 학생이 있는지 확인
#     for r in sorted(reserve_set):
#         if r - 1 in lost_set:
#             lost_set.remove(r - 1)
#         elif r + 1 in lost_set:
#             lost_set.remove(r + 1)
    
#     # 체육복을 잃어버린 학생 수를 전체 학생 수에서 뺀 값을 반환
#     return n - len(lost_set)

# Solution 2
def solution(n, lost, reserve):
    # 반드시 오름차순 정렬
    # 입력값 (5, [2, 4], [3, 1]) 에 대해,
    # 정렬하지 않으면, 5, [2, 4], [3, 1] => 4
    # 정렬하면, 5, [2, 4], [1, 3] => 5
    lost.sort()
    reserve.sort()
    
    # 여벌의 체육복을 가져왔다가 도난당한 경우, 양쪽에서 공통원소 제거
    for i in reserve[:]:
        if i in lost:
            reserve.remove(i)
            lost.remove(i)
            
    
    # 각 루프를 돌며, 
    # 체육복을 최대한 앞뒤 학생에게 빌려주려고 함
    for i in reserve:
        # 체육복을 앞이나 뒤의 학생에게 빌려준 경우,
        if i - 1 in lost:
            lost.remove(i - 1)
        elif i + 1 in lost:
            lost.remove(i + 1)
    
    return n - len(lost)