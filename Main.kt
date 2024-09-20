package com.dicoding.funcProgramming

//Lambda
/*val name: (String) -> String = { value ->
    val first = "Dicoding"

    "$first $value"
}*/

//High-order function
fun printName(value: String, name:(String) -> String){
    println(name(value))
}

//Extension Function
fun Int.println(){
    println("value $this")
}

/*fun String.firstAndLast(): Map<String, Char>{
    return mapOf(
        "first" to first(), "last" to last()
    )
}*/

//Extension Property
val String.firstAndLast: Map<String, Char>
    get() = mapOf(
        "first" to first(), "last" to last()
    )

class User(val name: String){
    fun printName(){
        println(name)
    }
}

//function type
typealias Arithmetic = (Int, Int) -> Int

//Lambda
val messageLength = {message : String -> message.length}

//higher order function
fun printGreet(name: String, message: (String) -> String){
    println(message(name))
}

//inline made compiling faster and efficient
inline fun printResult(value: Int, sum: (Int) -> Int){
    println(sum(value))
}

//function inside function
fun sum(valueA: Int, valueB: Int, valueC: Int): Int {
    fun Int.validateNumber(){
        if (this == 0) {
            throw IllegalArgumentException("value must be better than 0")
        }
    }

    valueA.validateNumber()
    valueB.validateNumber()
    valueC.validateNumber()

    return valueA + valueB + valueC
}

//Recursion
fun factorial(n: Int): Int {
    return if (n == 1) {
        n
    } else {
        n * factorial(n - 1)
    }
}

//tail recursion
tailrec fun factoriil(n: Int, result: Int = 1): Int {
    val newResult = n * result
    return if (n == 1) {
        newResult
    } else {
        factoriil(n - 1, newResult)
    }
}

fun main() {
    printName("Academy"/*, name*/) { value ->
        val first = "Dicoding"

        "$first $value"
    }

    10.println()

    val dicoding = "Dicoding Academy".firstAndLast
    val first = dicoding["first"]
    val last = dicoding["last"]

    println("Pertama $first Terakhir $last")

    //Scope Function
    val dicomy = StringBuilder()
    dicomy.apply{
        append("Dicoding ")
        append("Academy")
    }
    println(dicomy.toString())

    val message = StringBuilder()
        .apply {
        append("Hello ")
        append("From ")
        append("Lambda")
    }
    println(message.toString())

    //Collection Function
    val dicod = 1..10
    println(dicod.take(3))

    //OOP
    val user = User("Dicoding")
    user.printName()

    val sum: Arithmetic = {valueA, valueB -> valueA + valueB}
    val multiply: Arithmetic = {valueA, valueB -> valueA * valueB}
    val sumResult = sum.invoke(10, 10)
    val multiplyResult = multiply(20, 20)
    println("$sumResult, $multiplyResult")

    //Lambda
    val length = messageLength("Hello from lambda")
    println("Message length is $length")

    val ranges = 1.rangeTo(5) step 2
    ranges.forEachIndexed(){ index, value ->
        println("value is $value index number $index")
    }

    //High Order Function
    printGreet("Irfan"){ name ->
        "Hello $name"
    }

    printResult(10){ value ->
        value + value
    }

    //sum(0,1,2)

    println("Factorial 80 is ${factorial(80)}")
    println("Factorial 10 is ${factoriil(10)}")

}