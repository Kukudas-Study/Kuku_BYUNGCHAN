def solution(cur_floor, cur_ho):
  # 이전 층의 각 호 별 거주자 수(동기화 대상)
  people = [i for i in range(1, cur_ho+1)]

  for x in range(cur_floor):
    new = []
    # 문제 해결 아이디어: 
    # 1. 각 호 별 거주자 수를 구하는 과정에서 people을 참조해 이전 층에 거주하는 호수의 인원 수를 더해준다.
    # 2. 층이 증가함에 따라 이전 층 거주하는 호 별 인원 수 리스트를 동기화해준다. 
    for y in range(cur_ho):
      new.append(sum(people[:y+1])) # 이전 층 1호 ~ 각 루프 별 주어진 호 수인 y 거주자의 합
    people = new.copy()
  return people[-1]

T = int(input())

for _ in range(T):
    k = int(input()) # 층
    n = int(input()) # 호
    
    print(solution(k, n))
        