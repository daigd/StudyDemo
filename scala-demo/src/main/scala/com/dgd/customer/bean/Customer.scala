package com.dgd.customer.bean

/**
 * @author : DaiGD
 * @createtime :  2020年12月31日 14:09
 * @description : 
 */
class Customer {
  var id: Int = _
  var name: String = _
  var age: Int = _
  var gender: Char = _
  var email: String = _

  def this(id: Int, name: String, age: Int, gender: Char, email: String) {
    this
    this.id = id
    this.name = name
    this.age = age
    this.gender = gender
    this.email = email
  }

  def this(name: String, age: Int, gender: Char, email: String) {
    this
    this.name = name
    this.age = age
    this.gender = gender
    this.email = email
  }

  override def toString: String = {
    this.id + "\t\t" + this.name + "\t\t" + this.age + "\t\t" + this.gender + "\t\t" + this.email
  }
}
