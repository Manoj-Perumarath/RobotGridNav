import data.Compass
import data.Direction
import data.InvalidCompassException
import utils.enumValueOf

class Robot(
    private val gridW: Int,
    private val gridH: Int,
    private var x: Int,
    private var y: Int,
    private var facing: Compass,
    private val directions: String
) {


    //Sample Input
    //5,5
    //1 2 N
    //LMLMLMLMM
    //Sample Output
    //1 3 N

    fun moveRobot() {
        directions.forEach { command ->
            when (enumValueOf<Direction>(command)) {
                Direction.L -> facing = facing.turnLeft()
                Direction.R -> facing = facing.turnRight()
                Direction.M -> {
                    val (newX, newY) = facing.move(x, y)
                    if (newX in 0..gridW && newY in 0..gridH) {
                        x = newX
                        y = newY
                    } else {
                        throw InvalidCompassException("Outside Grid")
                    }
                }
            }
        }
    }

    fun currentRobotPosition() = "$x $y ${Compass.fromCompass(facing)}"
}