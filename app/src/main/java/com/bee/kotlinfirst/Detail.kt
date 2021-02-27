package com.bee.kotlinfirst

data class Detail(var name: String, var value: String) {
    companion object {
        private const val STRING_LENGTH = 5
        private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        fun randomString(length: Int = STRING_LENGTH): String {
            return (1..length)
                    .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                    .map(charPool::get)
                    .joinToString("")
        }

        fun random(): Detail {
            return Detail(name = "rand_name: ${randomString()}", value = "rand_value: ${randomString()}")
        }
    }
}
