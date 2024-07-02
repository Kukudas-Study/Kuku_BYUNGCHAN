# input:
# 1 2 3
# output:
# 6 2.00
a, b, c = map(int, input().split(" "))
sum = a + b + c
avg = sum / 3
print(sum, format(avg, ".2f"), sep=" ")