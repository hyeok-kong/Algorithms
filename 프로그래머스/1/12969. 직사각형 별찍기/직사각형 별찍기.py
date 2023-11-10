a, b = map(int, input().strip().split(' '))
string = "*"
for n1 in range(b):
    string = "*"
    string *= a
    print(string)
