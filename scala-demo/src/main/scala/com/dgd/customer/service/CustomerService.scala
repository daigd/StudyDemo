package com.dgd.customer.service

import com.dgd.customer.bean.Customer

import scala.collection.mutable.ListBuffer
import scala.util.control._

/**
 * @author : DaiGD
 * @createtime :  2020年12月31日 15:30
 * @description : 
 */
class CustomerService {
  val customers = new ListBuffer[Customer]
  var customerId = 1

  def add(customer: Customer): Boolean = {
    customer.id = customerId
    customerId += 1
    customers.append(customer)
    true
  }

  def list(): List[Customer] = {
    customers.toList
  }

  def get(id: Int): Customer = {
    var customer: Customer = null
    val breaks = new Breaks
    breaks.breakable {
      for (c <- customers) {
        if (c.id == id) {
          customer = c
          breaks.break()
        }
      }
    }
    customer
  }

  def del(id: Int): Boolean = {
    val index = findIndexById(id)
    if (index != -1) {
      customers.remove(index)
      true
    } else {
      false
    }
  }

  private def findIndexById(id: Int): Int = {
    var index = -1
    val breaks = new Breaks
    breaks.breakable {
      for (i <- customers.indices) {
        if (customers(i).id == id)
          index = i
        breaks.break()
      }
    }
    index
  }
}
