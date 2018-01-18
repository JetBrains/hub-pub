import node.require

fun printVersion() {
    console.log(require("../../package.json").version)
}
