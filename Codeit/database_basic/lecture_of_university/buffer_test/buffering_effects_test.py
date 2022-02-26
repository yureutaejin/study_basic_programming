from random import randint
import os

for i in range(0, 10000):
    print("insert into Sample_buffer_effects values(%d, %d, %d);" %(i, randint(0, 10000), randint(10000, 50000)))
