import node.fs
import node.path
import node.process
import node.require

fun version(newVersion: String) {
    val manifestPath = path.resolve(process.cwd(), manifestFile)

    val manifestJson = require(manifestPath)
    manifestJson.version = newVersion

    val ws = fs.createWriteStream(manifestPath)
    ws.write(JSON.stringify(manifestJson))
    ws.end()
}