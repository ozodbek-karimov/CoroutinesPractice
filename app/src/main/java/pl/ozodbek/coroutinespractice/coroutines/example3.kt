package pl.ozodbek.coroutinespractice.coroutines

import kotlin.concurrent.thread


fun main() {
    repeat(1_000_000) {
        thread {
            Thread.sleep(5000)
            print(".")
        }
    }
}