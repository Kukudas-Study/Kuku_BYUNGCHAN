def check_integer(num):
    if num<0:
        if num%2==0:
            print("A")
        else:
            print("B")
    else:
        if num%2==0:
            print("C")
        else:
            print("D")

n = int(input())
check_integer(n)
