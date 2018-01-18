package archiver

@JsModule("archiver")
@JsNonModule
@JsName("Archiver")

external fun Archiver(format: String): Zip

external interface Zip {
    fun on(event: String /* finish */, listener: () -> Unit)
    fun on(event: String /* "error" */, listener: (err: Error) -> Unit)
    fun pipe(file: Unit)
    fun finalize()
    fun directory(dirpath: String,
                  destpath: String? = definedExternally,
                  data: (() -> Any)? = definedExternally)
}
