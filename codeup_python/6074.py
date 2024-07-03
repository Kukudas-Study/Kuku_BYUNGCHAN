# 문자 1개 입력받아 알파벳 출력

# ord(문자): 문자의 정수값 리턴
# chr(정수값): 유니코드 문자 리턴
target_char_num = ord(input())
start_char_num = ord('a')
while start_char_num <= target_char_num:
    print(chr(start_char_num), end=' ')
    start_char_num += 1
