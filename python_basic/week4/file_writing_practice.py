# w = 덮어쓰기
with open("data/writing_practice.txt", 'w') as f:
    f.write("Hello, World!\n")
    f.write('My name is Codeit!')

# a = append
with open("data/writing_practice.txt", 'a') as f:
    f.write("\nHello, World!\n")
    f.write('My name is Codeit!')

with open("data/writing_practice.txt", 'r') as f:
    for line in f:
        print(line)