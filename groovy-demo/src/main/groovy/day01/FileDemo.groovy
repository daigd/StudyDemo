package day01

def number = 0

new File("demo.txt").eachLine{line->
    number++
    println "$number:$line"
}

def classes = [String,List,File]
for(clazz in classes)
{
    println clazz.'package'.name
}