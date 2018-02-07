import node.fs
import node.path
import node.process
import node.require

fun version(newVersion: String, params: HashMap<String, String> = HashMap()) {
    val prefix = params["prefix"] ?: process.cwd()
    val manifestPath = path.resolve(prefix, manifestFile)

    val manifestJson = require(manifestPath)
    manifestJson.version = newVersion

    val ws = fs.createWriteStream(manifestPath)
    ws.write(JSON.stringify(manifestJson))
    ws.end()
}