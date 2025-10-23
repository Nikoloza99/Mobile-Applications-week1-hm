package com.example.mobileapplicationsdavaleban1

open class Account(val accountNumber : String, var ownerName : String){
 private var balance : Double = 0.0

    fun getBalance(): Double{
        return balance
    }
    fun deposit(amount: Double){
        if (amount >0){
            balance += amount
            println("your balance has increased and is now:$balance")
        }
        else{
            println("the amount must be positive")
        }
    }
    open fun withdraw(amount: Double){
        if(amount>0 && balance >= amount){
            balance -= amount
        }
        else{
            println("withdraw failed sorry buddy")
        }
    }
    fun printInfo(){
        println("Your account number is:$accountNumber, \nyour owner name is: $ownerName, \nyour current balance is:$balance")
    }
}

class SavingsAccount(accountNumber: String, ownerName: String,) : Account(accountNumber, ownerName){
    override fun withdraw(amount: Double){
        if (amount < 500)
            super.withdraw(amount)
        else
            println("withdraw failed, limit is 500$")
    }
}

class VIPAccount(accountNumber: String, ownerName: String, val transactionFee: Double = 2.0) : Account(accountNumber, ownerName){
override fun withdraw(amount: Double) {
    var totalAmount = amount + transactionFee
    if (getBalance() >= totalAmount){
        super.withdraw(totalAmount)
    }
    else{
        println("withdraw failed")
    }
    }
}

fun main(){
    val acc1 = SavingsAccount("S101", "გიორგი გ.")
    val acc2 = VIPAccount("V202", "მარიამი ა.")

//    acc1 ისთვის
    acc1.deposit(1000.0)
    acc1.withdraw(300.0)
    acc1.withdraw(600.0)
    acc1.printInfo()

//    acc2 ისთვის
    acc2.deposit(1000.0)
    acc2.withdraw(50.0)
    acc2.printInfo()
}


