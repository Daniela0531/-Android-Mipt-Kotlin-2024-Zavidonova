fun main() {
    var coordinates = readLine()!!.split(" ")
    var lineSegment: LineSegment = LineSegment(coordinates[0].toInt(), coordinates[1].toInt(), coordinates[2].toInt(), coordinates[3].toInt())
    val riverNum = readLine()!!.toInt()
    var count: Int = 0
    for (i in 1..riverNum) {
        coordinates = readLine()!!.split(" ")
        var line = Line(coordinates[0].toInt(), coordinates[1].toInt(), coordinates[2].toInt(), coordinates[3].toInt())

        if (lineSegment.crosses(line)) {
            ++count
        }
    }
    println(count)
}

class Line(val x0: Int, val y0: Int, val x: Int, val y: Int) {
    var a = y - y0
    var b = x0 - x
    var c = -(a*x + b*y)

    fun print() {
        print("print: ")
        print(x0)
        print(y0)
        print(x)
        println(y)
    }
}

class Vector(val x0: Int, val y0: Int, val x1: Int, val y1: Int) {
    var x = x1 - x0
    var y = y1 - y0

    fun print() {
        print("print: ")
        print(x)
        print(y)
    }
}

class LineSegment(private val x0: Int, private val y0: Int, private val x: Int, private val y: Int) {
    private var a = y - y0
    private var b = x0 - x
    private var c = -(a * x + b * y)

    fun crosses(line: Line): Boolean {
        if (a * line.b == b * line.a) {
            return false
        }
        var vector = Vector(line.x0, line.y0, line.x, line.y)
        var vector0 = Vector(line.x0, line.y0, x0, y0)
        var vector1 = Vector(line.x0, line.y0, x, y)
        var vectorProduct0 = vector0.x * vector.y - vector0.y * vector.x
        var vectorProduct1 = vector1.x * vector.y - vector1.y * vector.x

        vector = Vector(x0, y0, x, y)
        vector0 = Vector(x0, y0, line.x0, line.y0)
        vector1 = Vector(x0, y0, line.x, line.y)
        var vectorProduct2 = vector0.x * vector.y - vector0.y * vector.x
        var vectorProduct3 = vector1.x * vector.y - vector1.y * vector.x
        if (vectorProduct0 * vectorProduct1 < 0 && vectorProduct2 * vectorProduct3 < 0) {
            return true
        }
        return false
    }
}