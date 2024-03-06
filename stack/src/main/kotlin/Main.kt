fun main() {
    val queryNum = readLine()!!.toInt()
    val stack: Stack = Stack(queryNum)
    for (i in 1..queryNum) {
        val query = readLine()!!.split(" ")
        if (query[0] == "push") {
            stack.push(query!![1].toInt())
        } else if (query[0] == "pop") {
            stack.pop()
        } else {
            // quiry == max
            println(stack.max())
        }
    }
}

class Stack(private val size: Int) {
    class Node(public var value: Int, public var max: Int)
    private val stackArray = ArrayList<Node>()
    private var top = -1

    fun push(number: Int) {
        var node: Node = Node(
            number,
            if (stackArray.isEmpty()) number
            else if (stackArray.last().max < number) number
            else stackArray.last().max
        )
        stackArray.add(node)
    }

    fun pop(): Int {
        var res = stackArray.last().value
        stackArray.removeAt(stackArray.size - 1)
        return res
    }

    fun max(): Int {
        return stackArray.last().max
    }

    fun isEmpty(): Boolean {
        return stackArray.isEmpty()
    }

    fun print() {
        println("print start")
        for (node in stackArray) {
            println(node.max)
        }
        println("print finish")
    }
}