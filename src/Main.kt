import data.Compass

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//    println("Please enter the grid system")
//    val gridLine = readlnOrNull()?.split(",")?.map { it.toInt() }
//
//    println("Grid line are ${gridLine?.get(0)},${gridLine?.get(0)}")

    val robot = Robot(5, 5, 1, 2, Compass.North, "LMLMLMLMM")
//    val robot = Robot(6, 6, 3, 3, Compass.West, "LMMLMMRMM")
    robot.moveRobot()
    println(robot.currentRobotPosition())
}