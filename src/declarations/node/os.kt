package node

@JsModule("os")
external object os {
    fun tmpdir(): String
}
