package formdata

import node.IncomingMessage

@JsModule("form-data")
@JsNonModule
@JsName("FormData")

external open class FormData {
    fun append(name: String, value: String)
    fun append(name: String, value: Unit)
    fun submit(url: String, callback: (error: Error?, data: IncomingMessage?) -> Unit)
}

