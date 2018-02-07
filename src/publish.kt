import node.fs
import node.os
import kotlin.js.Promise

fun publish(file: String, params: HashMap<String, String>): Promise<Int> {
    if (!fs.existsSync(file)) {
        throw Error("$file does not exist")
    }

    if (fs.lstatSync(file).isFile()) {
        return upload(file, params)
    }

    val packParams: HashMap<String, String> = HashMap()
    packParams["out-dir"] = os.tmpdir()
    return pack(file, packParams).then({ archive -> publish(archive, params) }).then({ it })
}
