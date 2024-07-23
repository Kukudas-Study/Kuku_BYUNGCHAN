# input:
# 10.0 3.0
# output:
# 3.333
a, b = input().split()
result = float(a) / float(b)
print(format(result, '.3f'))