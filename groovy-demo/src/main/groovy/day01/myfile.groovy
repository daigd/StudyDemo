import day01.Book

def book = new Book('Groovy in Action')
assert book.title == 'Groovy in Action'
println book.getTitle()
assert getTitleBackwards(book) == 'noitcA ni yvoorG'
println getTitleBackwards(book)


String getTitleBackwards(book){
    title = book.getTitle()
    return title.reverse()
}

def nick = 'Gina'
def name = 'Groovy in Action'
println("$nick is $name")
assert "$nick is $name" == 'Gina is Groovy in Action'

def r = 1..50
assert r.size() == 50
assert r.contains(45)
assert !r.contains(55)
println(r.to)
println(r.from)

def list1 = [1,2,3]
def list2 = [3,4,5]
println(list1+list2)

def store = ''
5.times {
    store += 'x'
}
assert store == 'xxxxx'

store = ''
1.upto(5) {
    num -> store += num
}
assert store == '12345'

store = ''
2.downto(-2) {
    num -> store += num + ' '
}
assert store == '2 1 0 -1 -2 '

store = ''
0.step(0.5,0.1){
    num -> store += num + ' '
}
assert store == '0 0.1 0.2 0.3 0.4 '