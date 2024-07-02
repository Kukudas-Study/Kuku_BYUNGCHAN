# 점수 입력받아 평가 출력
def check_score(score):
    if score>=90:
        print("A")
    elif score>=70:
        print("B")
    elif score>=40:
        print("C")
    else:
        print("D")

my_score = input()
my_score = int(my_score)
check_score(my_score)