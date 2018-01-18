import node.fs
import node.os
import node.path
import kotlin.js.Promise

fun pack(dir: String): Promise<String> {
    val manifestFile = "manifest.json"

    if (!fs.existsSync(dir)) {
        throw Error("$dir does not exist")
    }

    if (!fs.existsSync(path.resolve(dir, manifestFile))) {
        throw Error("$program not being able to find a $manifestFile in $dir you are trying to pack")
    }

    val archive = path.resolve(os.tmpdir(), path.basename(dir) + ".zip")
    return zip(dir, archive).then({ archive })
}
