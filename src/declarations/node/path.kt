package node

@JsModule("path")
external object path {
    fun basename(path: String): String
    fun resolve(p1: String, p2: String): String
}

