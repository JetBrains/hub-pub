import node.fs
import kotlin.js.Promise
import archiver.Archiver
import archiver.Zip

fun zip(from: String, to: String): Promise<Unit> {
    return Promise { resolve, reject ->
        val output = fs.createWriteStream(to)
        val zip: Zip = Archiver("zip")

        zip.on("finish", { -> resolve(output) })
        zip.on("error", { error -> reject(error) })

        zip.pipe(output)
        zip.directory(from, "")
        zip.finalize()
    }
}
