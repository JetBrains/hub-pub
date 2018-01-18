import formdata.FormData
import node.fs
import kotlin.js.Promise

fun upload(file: String, params: HashMap<String, String>): Promise<Int> {
    return Promise { resolve, reject ->
        val form = FormData()
        val host = params.get("host") ?: "https://plugins.jetbrains.com"

        form.append("userName", params.get("userName") ?: "")
        form.append("password", params.get("password") ?: "")
        form.append("pluginId", params.get("pluginId") ?: "")
        form.append("channel", params.get("channel") ?: "")
        form.append("file", fs.createReadStream(file))

        form.submit("$host/plugin/uploadPlugin", { err, resp ->
            val statusCode = resp?.statusCode ?: 0

            if (err != null)
                reject(err) else
                (if (statusCode < 200 || statusCode > 299)
                    reject(Error("${statusCode} :: JetBrains Plugin Repository")) else
                    resolve(0))
        })
    }
}
