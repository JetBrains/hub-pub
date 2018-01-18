package node

@JsModule("process")
external object process {
    val argv: Array<String>
    fun cwd(): String
}
