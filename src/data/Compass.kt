package data

sealed class Compass {
    abstract fun turnLeft(): Compass
    abstract fun turnRight(): Compass
    abstract fun move(x: Int, y: Int): Pair<Int, Int>

    data object North : Compass() {
        override fun turnLeft() = West
        override fun turnRight() = East
        override fun move(x: Int, y: Int) = Pair(x, y + 1)
    }

    data object East : Compass() {
        override fun turnLeft() = North
        override fun turnRight() = South
        override fun move(x: Int, y: Int) = Pair(x + 1, y)
    }

    data object South : Compass() {
        override fun turnLeft() = East
        override fun turnRight() = West
        override fun move(x: Int, y: Int) = Pair(x, y - 1)
    }

    data object West : Compass() {
        override fun turnLeft() = South
        override fun turnRight() = North
        override fun move(x: Int, y: Int) = Pair(x - 1, y)
    }

    companion object {
        fun fromChar(c: Char): Compass = when (c) {
            'N' -> North
            'E' -> East
            'S' -> South
            'W' -> West
            else -> throw InvalidCompassException("Invalid Compass: $c")
        }

        fun fromCompass(compass: Compass): Char = when (compass) {
            East -> 'E'
            North -> 'N'
            South -> 'S'
            West -> 'W'
        }
    }
}

class InvalidCompassException(message: String) : Exception(message)