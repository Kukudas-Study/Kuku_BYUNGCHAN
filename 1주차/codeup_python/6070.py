# 월 입력받아 계절 출력
m = int(input())


def print_season(month):
    if month//3 == 1:
        print("spring")
    elif month//3 == 2:
        print("summer")
    elif month//3 == 3:
        print("fall")
    else:
        print("winter")


print_season(m)
