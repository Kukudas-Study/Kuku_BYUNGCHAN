from collections import deque

N = int(input())
# 양쪽 끝에 삽입, 삭제 시 시간 복잡도 O(1)인 덱(deque) 활용
cards = deque(list(range(1, N+1)))

# 남은 카드가 1장이 될 때까지
while len(cards) > 1:
    # popleft(): 1번째 요소 삭제 및 리턴 
    cards.popleft()
    cards.append(cards.popleft())

print(cards[0])
    