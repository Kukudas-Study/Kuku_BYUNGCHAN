total_price = int(input())

def solution(total_price):
  # 거슬러 줄 수 있는 화폐 단위의 종류
  change_coin_list = [500, 100, 50, 10, 5, 1]
  # 거스름돈으로 받는 동전 개수
  change_coin_cnt = 0
  # 타로가 내는 돈: 1000엔
  # 잔돈: 타로가 내는 돈 - 물건 총 가격
  total_change = 1000 - total_price
  # 동전 개수를 최소한으로 받기 위해서는 되도록 큰 화폐 단위부터 거슬러 받아야 한다.
  for coin in change_coin_list:
    if total_change // coin != 0:
      change_coin_cnt += total_change // coin
      total_change %= coin
  return change_coin_cnt

change_coin_cnt = solution(total_price)
print(change_coin_cnt)