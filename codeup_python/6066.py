# 3개의 정수 a, b, c 에 대해 각각 짝(even)/홀(odd) 출력
a, b, c = input().split(" ")
a = int(a)
b = int(b)
c = int(c)

def check_even_odd(num):
    if num % 2 == 0:
        print("even")
    else:
        print("odd")

check_even_odd(a)
check_even_odd(b)
check_even_odd(c)


