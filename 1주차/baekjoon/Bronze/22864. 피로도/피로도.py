A, B, C, M = map(int, input().split())

hours = 0
# 피로도
fatigueLevel = 0
# 처리한 일의 양
tasksCompleted = 0

while (hours < 24):
    hours += 1
    # 피로도가 음수로 내려가면
    if (fatigueLevel < 0):
        fatigueLevel = 0
   
    # 현재 피로도 + 일을 하면서 쌓일 피로도 <= M 이면,
    if ((fatigueLevel + A) <= M): 
    	# 일을 한다.
	    fatigueLevel += A
	    tasksCompleted += B
    else:
	    # 쉰다.
	    fatigueLevel -= C
print(tasksCompleted)