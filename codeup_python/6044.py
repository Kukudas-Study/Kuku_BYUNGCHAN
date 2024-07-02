# input:
# 10 3
# output:
# 13
# 7
# 30
# 3
# 1
# 3.33
a, b = map(int, input().split(" "))
print(a+b)
print(a-b)
print(a*b)
print(a//b)
print(a%b)
print(format(a/b, ".2f"))