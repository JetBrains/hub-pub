package node

@JsModule("fs")
external object fs {
    fun existsSync(path: String): Boolean
    fun lstatSync(path: String): Stats
    fun createWriteStream(path: String)
    fun createReadStream(path: String)
}

interface Stats {
    fun isFile(): Boolean
}
