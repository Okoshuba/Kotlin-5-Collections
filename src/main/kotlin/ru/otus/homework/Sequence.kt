package ru.otus.homework

import kotlin.random.Random

fun main() {
    val list = createList(10)
    println("Source list:")
    println(list)

    println("Collection transformation:")
    println(list.collectionTransform())
}

fun List<RandomNumber>.collectionTransform(take: Int = 5) =
    filter { random -> random.filter { it >= 0 } }
        .map { it.stringify() }
        .take(take)
        .toSet()

fun createList(length: Int = 10): List<RandomNumber> {
    return (1..length).map { RandomNumber() }
}

class RandomNumber {
    val value: Int = Random.nextInt(-10, 10)

    init {
        println("Created: $value")
    }

    fun filter(block: (Int) -> Boolean): Boolean {
        println("Filtering: $value")
        return block(value)
    }

    fun stringify(): String {
        println("Stringifying: $value")
        return toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RandomNumber

        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return "($value)"
    }
}