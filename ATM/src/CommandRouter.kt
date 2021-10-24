internal class CommandRouter {
    val commands: Map<String, Command> = emptyMap()

    fun route(input: String?): Command.Status {
        val splitInput: List<String> = input?.split(" ") ?: emptyList()
        if (splitInput.isEmpty()) {
            return invalidCommand(null)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)
        val arguments = splitInput.drop(1)

        val status = command.handleArguments(arguments)
        if (status == Command.Status.INVALID) println("Invalid arguments passed to $commandKey.")

        return status
    }

    private fun invalidCommand(input: String?): Command.Status {
        if (input !== null) {
            println("Couldn't understand \"${input}\", please try again.")
        } else println("No command entered")
        return Command.Status.INVALID
    }
}