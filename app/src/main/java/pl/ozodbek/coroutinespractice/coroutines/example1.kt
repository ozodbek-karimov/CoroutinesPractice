package pl.ozodbek.coroutinespractice.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    joinAll(
        async { coroutine(1, 500) },
        async { coroutine(2, 300) }
    )
}

suspend fun coroutine(number:Int, delay:Long){
    println("Coroutine $number starts work")
    delay(delay)
    println("Coroutine $number has finished")
}