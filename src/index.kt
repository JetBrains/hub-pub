import node.process

fun main(args: Array<String>) {
    if (process.env.NODE_ENV != "production") return
    parseArguments(process.argv.drop(2))
}
