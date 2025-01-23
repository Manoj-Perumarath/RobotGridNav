package test

import Robot
import data.Compass
import data.InvalidCompassException
import org.junit.Test

class RobotTest {

    private fun testRobot(
        gridWidth: Int,
        gridHeight: Int,
        startX: Int,
        startY: Int,
        startDir: Char,
        commands: String,
        expected: String
    ) {
        val robot = Robot(gridWidth, gridHeight, startX, startY, Compass.fromChar(startDir), commands)
        robot.moveRobot()
        assert(robot.currentRobotPosition() == expected) { "Expected $expected but got ${robot.currentRobotPosition()}" }
    }

    @org.junit.Test
    fun moveRobot() {
    }

    @org.junit.Test
    fun currentRobotPosition() {
    }

    @Test
    fun `turning movement`() {
        testRobot(5, 5, 1, 2, 'N', "LMLMLMLMM", "1 3 N")
    }


    @Test
    fun `normal movement`() {
        testRobot(6, 6, 2, 1, 'E', "MM", "4 1 E")
    }

    @Test
    fun `full rotation movement`() {
        testRobot(5, 5, 1, 1, 'N', "LLLL", "1 1 N")
    }

    @Test(expected = InvalidCompassException::class)
    fun `outside grid movement`() {
        val expected = "5 6 N"
        try {
            val robot = Robot(5, 5, 5, 5, Compass.fromChar('N'), "M")
            robot.moveRobot()
            assert(robot.currentRobotPosition() == expected) { "Expected $expected but got ${robot.currentRobotPosition()}" }
        } catch (e: InvalidCompassException) {
            assert(false)
            println("Caught expected failure: ${e.message}")
        }
    }
}