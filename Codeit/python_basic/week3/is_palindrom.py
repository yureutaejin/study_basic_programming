def is_palindrome(word):
    new_word = ""
    for i in range(-1, -len(word)-1, -1):
        new_word += word[i]

    return new_word == word

def is_palindrome_2(word):
    new_word = list(word)
    new_word.reverse() # string 타입(클래스)내에 reverse 메서드가 존재
    new_word = "".join(new_word) # string 타입(클래스)내에 join 메서드가 존재, 파라미터는 String 타입이 들어간 list
    return new_word == word


# 테스트
print(is_palindrome("racecar"))
print(is_palindrome("stars"))
print(is_palindrome("토마토"))
print(is_palindrome("kayak"))
print(is_palindrome("hello"))

print()
# 테스트2
print(is_palindrome_2("racecar"))
print(is_palindrome_2("stars"))
print(is_palindrome_2("토마토"))
print(is_palindrome_2("kayak"))
print(is_palindrome_2("hello"))
