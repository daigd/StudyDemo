package day01

// 使用断言
def x = 1
assert x ==1
println x

// 遍历
def classes = [String,List,File]
for(clazz in classes)
{
    println clazz.'package'.name
}

def book = new Book("This is a book.")
println book.title

