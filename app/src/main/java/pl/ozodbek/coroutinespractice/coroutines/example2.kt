package pl.ozodbek.coroutinespractice.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    repeat(1_000_000){
        launch {
            delay(5000)
            print(".")
        }
    }
}