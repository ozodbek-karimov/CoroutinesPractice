package pl.ozodbek.coroutinespractice.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {
    myFun()
}

private fun myFun() {
    GlobalScope.launch {
        delay(300)
        println("Why it is not printed out ?")
    }
}