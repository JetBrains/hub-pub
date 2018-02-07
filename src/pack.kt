import node.fs
import node.path
import node.process
import kotlin.js.Promise

fun pack(dir: String, params: HashMap<String, String> = HashMap()): Promise<String> {
    if (!fs.existsSync(dir)) {
        throw Error("$dir does not exist")
    }

    if (!fs.existsSync(path.resolve(dir, manifestFile))) {
        throw Error("$program not being able to find a $manifestFile in $dir you are trying to pack")
    }

    val outDir = params.get("out-dir") ?: process.cwd()
    val archive = params.get("out") ?: path.resolve(outDir, path.basename(dir) + ".zip")
    return zip(dir, archive).then({ archive })
}
