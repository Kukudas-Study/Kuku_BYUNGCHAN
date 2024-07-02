# a, b, c 중 가장 작은 값 출력
a, b, c = input().split(" ")
a = int(a)
b = int(b)
c = int(c)
min_num = a if a<b else b if ((a if a<b else b) < c) else c
print(min_num)