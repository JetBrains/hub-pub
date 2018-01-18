import node.module
import node.process

fun main(args: Array<String>) {
    if (module.parent != null) return
    parseArguments(process.argv.drop(2))
}
