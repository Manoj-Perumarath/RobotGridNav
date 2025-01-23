import data.Compass

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Please enter the grid system using x y format")
    val gridLine = readlnOrNull()?.split(" ")?.map { it.toInt() }
    println("Enter starting of the robot using x y n")
    val robotOffsetPosition = readlnOrNull()?.split(" ")
    robotOffsetPosition?.let {
        println("x is ${robotOffsetPosition[0]} y is ${robotOffsetPosition[1]} and d is ${robotOffsetPosition[2]}")
    }

    println("Enter commands for moving robot")
    val commands = readlnOrNull()
    println("Directions $commands")
    if (gridLine.isNullOrEmpty() || robotOffsetPosition.isNullOrEmpty() || commands.isNullOrEmpty())
        return
    val robot = Robot(
        gridLine[0],
        gridLine[1],
        robotOffsetPosition[0].toInt(),
        robotOffsetPosition[1].toInt(),
        Compass.fromChar(robotOffsetPosition[2].toCharArray()[0]),
        commands
    )
    robot.moveRobot()
    println(robot.currentRobotPosition())
}