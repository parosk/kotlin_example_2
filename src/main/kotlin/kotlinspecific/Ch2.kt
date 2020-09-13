package kotlinspecific

import java.io.BufferedReader

/**
 *  If is an expression
 *  expression has a value, and can be used as part of other expression
 *  statement is always top=level in its enclosing block, and dont have value
 *  in Kotlin, only the loops (for,do,do/while) are statement, other, such as IF, are expression
 *
 *  Assignments are expressions in Java and become statements in Kotlin
 */

class Rectangle(val height: Int, val width: Int) {
    // if need a value but not need to be stored,
    // the value is computed every time the property is accessed
    // the different from a no argument function is just the readability
    val isSquare: Boolean
        get() = height == width
}

/**
 * in Java package structure and file/directoris structure are the same
 * in Kotlin, multiple classes in same file is possible, and can choose the package name
 */

/**
 *  'when' dont need break and dont "fall throught"
 *  if a match is successful, only that branch is executed
 *  when can have n argument, then branch condition is any Boolean expression
 */

/** Smart case example
 * 2.3
 */
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num // there is no need to case, because it is within the is block
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun evalWithWhen(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> evalWithWhen(e.right) + evalWithWhen(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun testEval() {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}

/** Use in to check collection and range
 * Ranges support any class that supports comparing instances
 */

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z' // still just check if it is in the char code range

/** 2.5 Exceptions
 * A function can complete in a normal way or throw an exception if an error occurs.
 * The function caller can catch this exception and process it; if it doesn’t,
 * the exception is rethrown further up the stack.
 *
 * Kotlin didnt dofferentiate between checked and unchecked exceptions
 * there for function caller dont HAVE TO explicitly handle the checked exception throw by the function
 */

fun readNumber(reader: BufferedReader) {
    //try as an expression, can be used to assign to value
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}
