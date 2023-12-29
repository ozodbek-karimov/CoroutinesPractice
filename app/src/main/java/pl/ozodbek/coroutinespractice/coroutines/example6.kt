package pl.ozodbek.coroutinespractice.coroutines


import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val result = retry {
        fetchDataFromApi()
    }
    println("Data received: $result")
}
