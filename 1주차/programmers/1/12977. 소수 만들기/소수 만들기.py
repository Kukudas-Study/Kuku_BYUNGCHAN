def solution(nums):
    cnt = 0;
    length = len(nums)
    triplets = []
    
    # 모든 경우의 수를 고려하여 3개의 값을 추출
    for i in range(length - 2):
        for j in range(i + 1, length - 1):
            for k in range(j + 1, length):
                triplet = (nums[i], nums[j], nums[k])
                triplets.append(triplet)
    
    for triplet in triplets:
        sumOfTriplet = sum(triplet)

        # 소수인지 check 하는 flag
        result = True
        # 1과 자기 자신 이외의 숫자로 나누어 떨어지지 않는다면, 소수
        # break 조건 : 하나의 수라도 나누어 떨어진다면, 소수가 아니다
        for j in range(2, sumOfTriplet):
            if (sumOfTriplet % j == 0):
                result = False
                break
    
        if (result is True):
            cnt += 1

    return cnt
