import math
import random
import datetime
import os
import os.path
import re
import pickle
import json
import copy
import sqlite3

print(math.cos(0))
print(math.log10(100))

print(random.randint(1, 20))
print(random.uniform(0,1))

today = datetime.datetime.now()
print(today)
print(today.strftime("%A, %B %dth %Y"))

pi_day = datetime.datetime(2020, 3, 14, 13, 6, 15)
print(pi_day)

print(today - pi_day)

print(os.getlogin())
print(os.getcwd())
print(os.getpid())

pattern = re.compile('^[A-Za-z]+$')
print(pattern.match('I'))
print(pattern.match('love'))
print(pattern.match('python3'))
print()

pattern = re.compile('.*\d+')
print(pattern.match('I'))
print(pattern.match('love'))
print(pattern.match('python3'))

# 딕셔너리 오브젝트
obj = {'my': 'dictionary'}

# obj를 filename.pickle 파일에 저장
with open('filename.pickle', 'wb') as f:
    pickle.dump(obj, f)

# filename.pickle에 있는 오브젝트를 읽어옴
with open('filename.pickle', 'rb') as f:
    obj = pickle.load(f)

print(obj)


# 딕셔너리 오브젝트
obj = {'my': 'dictionary'}

# obj를 filename.json 파일에 저장
with open('filename.json', 'w') as f:
    json.dump(obj, f)

# filename.json에 있는 오브젝트를 읽어옴
with open('filename.json', 'r') as f:
    obj = json.load(f)

print(obj)

# '=' 연산자는 실제로 리스트를 복사하지 않음
# 리스트를 복사하려면 슬라이싱을 사용하거나 copy.copy() 함수를 사용해야 함
a = [1, 2, 3]
b = a
c = a[:]
d = copy.copy(a)
a[0] = 4
print(a, b, c, d)

# 하지만 오브젝트 안에 오브젝트가 있는 경우 copy.copy() 함수는 가장 바깥에 있는 오브젝트만 복사함
# 오브젝트를 재귀적으로 복사하려면 copy.deepcopy() 함수를 사용해야 함
a = [[1,2,3], [4,5,6], [7,8,9]]
b = copy.copy(a)
c = copy.deepcopy(a)
a[0][0] = 4
print(a, b, c)

# 데이터베이스 연결
conn = sqlite3.connect('example.db')

# SQL 문 실행
c = conn.cursor()
c.execute('''SELECT ... FROM ... WHERE ... ''')

# 가져온 데이터를 파이썬에서 사용
rows = c.fetchall()
for row in rows:
    print(row)

# 연결 종료
conn.close()