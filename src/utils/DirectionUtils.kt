package utils


inline fun <reified T : Enum<T>> enumValueOf(name: String): T {
    return T::class.java.enumConstants.first { it.toString() == name }
}

inline fun <reified T : Enum<T>> enumValueOf(name: Char): T {
    return T::class.java.enumConstants.first { it.toString() == name.toString() }
}

