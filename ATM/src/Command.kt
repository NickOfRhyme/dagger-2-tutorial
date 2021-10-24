internal interface Command {
    fun key(): String

    fun handleArguments(arguments: List<String>): Status

    enum class Status {
        INVALID, HANDLED
    }
}