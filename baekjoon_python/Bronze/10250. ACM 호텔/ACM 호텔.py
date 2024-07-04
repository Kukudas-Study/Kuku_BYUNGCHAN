T = int(input())

def solution(W, H, N):
  answer_str = ""
  n_th_row_num = 0
  n_th_col_num = 0
  # room_list: 2차원 배열로 호텔 방 리스트 초기화
  room_list = [[False for j in range(H)] for i in range(W)]
  booked_room_cnt = 0
  is_loop_end = False
  
  for col_num in range(H):
    for row_num in range(W):
      if room_list[row_num][col_num] is False:
        room_list[row_num][col_num] = True
        booked_room_cnt += 1
      # 2번 째 for문 종료조건
      if booked_room_cnt == N:
        # N번째 손님 방 row_num, col_num 
        n_th_row_num = row_num
        n_th_col_num = col_num
        is_loop_end = True
        break
    # 1번 째 for문 종료조건
    if is_loop_end is True:
      break
  return (n_th_row_num+1) * 100 + (n_th_col_num+1)

for _ in range(T):
    H, W, N = map(int, input().split())
    print(solution(H, W, N))
    