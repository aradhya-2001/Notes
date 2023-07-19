#----------------------------------------------------------------------------------------------------------------------------------------
name = "ayush singh"
age = int(input("enter age: ")) # input is by default string
print(f"{name} age is {age}") # string interpolation

age = str(age)
print(name + " is " + age + " years old") # int cannot be concatenated with str. Thats why converted to str first

print(name.split(" ")) 
print(name.upper().lower().islower())
print(len(age))
print(name.index("sin")) # if "sin" is not in name then err 
print(name.replace("ayush", "ayu")) 
#----------------------------------------------------------------------------------------------------------------------------------------
from math import * # imports functions like ceil,floor,sqrt, etc.
#----------------------------------------------------------------------------------------------------------------------------------------
lis = ["hii", "my", "is", "ayu"] # this is called list
print(lis)
lis.pop()
print(lis[-1])
print(lis[1:])
print(lis[1:3])

for x,y in enumerate(lis, start=10): # if start is not given, it starts from 0
    print(x)
    print(y)

lis2 = [1, 2, 3, 2]
for i in zip(lis, lis2): # [(hii,1),(my,2)...]
    print(i)

lis.extend(lis2)
lis.insert(2 , "name")
lis.remove("ayu")
lis2.sort()
lis2.reverse()
print(lis2.count(2)) # frequency of 2 in lis2
#---------------------------------------------------------------------------------------------------------------------------------------- 
tup = (1,2) # tuple
print(tup[0])
#----------------------------------------------------------------------------------------------------------------------------------------
def add(num1, num2):
    return num1 + num2
res = add(2, 3)
print(res)
#----------------------------------------------------------------------------------------------------------------------------------------
def params(*args, **kwargs): 
    print(args)
    print(kwargs)
    print(f"tuple is {args[0] } and dict is { kwargs['food'] }")
params(10,20,30,fruit = "orange", food = "chicken")
#----------------------------------------------------------------------------------------------------------------------------------------
cond = False
if (cond and True):
    print("if")
elif (not(cond)):
    print("else if")
else:
    print("else")
#----------------------------------------------------------------------------------------------------------------------------------------
dic = {"jan" : "january","feb" : "february"} # unordered map
print(dic)
print(dic["feb"]) # or print(dic.get("feb"))
for i in dic.keys():
    print(i)

for i in dic.items():
    print(i)

for i in dic.values(): 
    print(i)
#----------------------------------------------------------------------------------------------------------------------------------------
myset = {1, 2, 3} # set
myset.add(4)
print(myset)
myset2 = set()
myset2.add("hiii")
print(myset2)
#----------------------------------------------------------------------------------------------------------------------------------------
while False:
    print("infinite loop")
#----------------------------------------------------------------------------------------------------------------------------------------
word = "hello hi"
for ch in word:
    print(ch)
for i in range(5): # [0,5)
    print(i)
for i in range(len(word)): # [0,len(word)) 
    print(word[i])
#----------------------------------------------------------------------------------------------------------------------------------------
lis3 = [1, 2, 3, 2]
def square(num):
    return num * num
sq = lambda n : n**2 # anonymous function
print(list(map(square, lis3)))
def not2(num):
    if(num != 2):
        return num
print(list(filter(not2, lis3)))
#----------------------------------------------------------------------------------------------------------------------------------------
try:
    num1 = int(input("enter a num1: "))
    num2 = int(input("enter a num2: "))
    ans = num1 / num2
    print(ans)
except ZeroDivisionError as err:
    print(err)
except ValueError: 
    print("not a number")
#----------------------------------------------------------------------------------------------------------------------------------------
fileContent = open("file.txt", "r") # r -> read, w -> write, a -> append, r+ -> read and write  vb

if fileContent.readable(): # return true if mode is set to r else false
    print(fileContent.read()) # prints all and placed cursor to end

print(fileContent.readline()) # prints top line then moves cursor to next line
fileContent.seek(0) # places cursor to the beginning 

contentArr = fileContent.readlines() # converts into array
print(contentArr[1])

fileContent.close()

with open("file.txt", mode="r") as fileContent: # another way to open. It automatically closes the connection upon read.
    print(fileContent.read())

fileAdd = open("file.txt", "a")
fileAdd.write("\nthis is line 3") # if mode is set to "w" above, this line will overwrite content or create new if file not exists
#----------------------------------------------------------------------------------------------------------------------------------------
def inside():
    if(__name__ == "__main__"): # python assigns "__main__" to __name__ when the scripty is run directly 
        print("inside is run directly")
    else:
        print("inside is imported")
import python_to_import # whole file is imported. For specific import -> from to_import import outside   
python_to_import.outside()
inside()
#----------------------------------------------------------------------------------------------------------------------------------------
class Student:
    def __init__(self, nm, br, ag):
        self.name = nm
        self.branch = br
        self.age = ag

    def func(self):
        print(self.branch)
stu1 = Student("ayu", "ece", 21)
stu2 = Student("sub", "cse", 22)
print(stu1.age)
print(stu1.func())

class Inherit(Student):
    def funct(self):
        print(self.branch)
#----------------------------------------------------------------------------------------------------------------------------------------

