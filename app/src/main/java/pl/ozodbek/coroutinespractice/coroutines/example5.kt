package pl.ozodbek.coroutinespractice.coroutines


import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun <T> retry(
    times: Int = 3,
    initialDelayMillis: Long = 1000,
    factor: Double = 2.0,
    block: suspend () -> T
): T {
    var currentDelay = initialDelayMillis
    repeat(times - 1) {
        try {
            return block()
        } catch (e: Exception) {
           println("Cannot fetch data !!   (${(currentDelay * factor).toLong().coerceAtMost(10_000)} seconds)")
        }
        delay(currentDelay)
        currentDelay = (currentDelay * factor).toLong().coerceAtMost(10_000)
    }
    return block()
}

var apiCallCount = 0
fun fetchDataFromApi(): String {
    apiCallCount++
    if (apiCallCount <= 2) {
        throw RuntimeException("Temporary network error")
    }
    return "API Data"
}


fun main() = runBlocking {
    val result = retry {
        fetchDataFromApi()
    }
    println("Data received: $result")
}
