package node

@JsModule("process")
external object process {
    val argv: Array<String>
    val env: dynamic
}
