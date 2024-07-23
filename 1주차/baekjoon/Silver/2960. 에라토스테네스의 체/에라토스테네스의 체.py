N, K = map(int, input().split())
removeCnt = 0

# True: 아직 지워지지 않았음을 의미함.
# 각각의 인덱스 번호: 지우려는 정수를 의미함.
sieve = [True] * (N + 1)
# 2부터 N까지 모든 정수에 대해서,
for i in range(2, N + 1):
    # 현재 숫자부터 지우고, 현재 숫자의 배수를 크기 순서대로 지운다.
    for j in range(i, N + 1, i):
        if sieve[j] != False:
            sieve[j] = False
            removeCnt += 1
            if removeCnt == K:
                print(j)
                break
