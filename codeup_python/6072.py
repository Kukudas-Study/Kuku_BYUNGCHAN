# 정수 1개 입력받아 카운트다운 출력
n = int(input())

while n != 0:
    if n == 0:
        break
    print(n)
    n -= 1
