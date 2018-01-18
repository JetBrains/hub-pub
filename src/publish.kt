import node.fs
import kotlin.js.Promise

fun publish(file: String, params: HashMap<String, String>): Promise<Int> {
    if (!fs.existsSync(file)) {
        throw Error("$file does not exist")
    }

    if (fs.lstatSync(file).isFile()) {
        return upload(file, params)
    }

    return pack(file).then({ archive -> publish(archive, params) }).then({ it })
}
