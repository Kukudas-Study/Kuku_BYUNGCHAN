# 3항 연산: x if C else y
a, b = input().split(" ")
a = int(a)
b = int(b)
result = a if (a > b) else b
print(result)