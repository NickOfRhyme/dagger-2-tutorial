fun main (args: Array<String>) {
    val commandRouter = CommandRouter()
    var nextLine: String?

    do {
       nextLine = readLine()
       commandRouter.route(nextLine)
    } while (nextLine != null)
}