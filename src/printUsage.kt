const val program = "hub-pub"

fun printUsage() {
    console.log(
            """
            Usage: $program [<options>] <command> [<param1>, <param2>...]

            where <command> is one of:
                publish, pack, version

            --pluginId         Numeric ID of the plugin, can be retrieved from the plugin repository URL
            --userName         Plugin author username used to access the JetBrains Plugin Repository (JetBrains Account username or email)
            --password         Plugin author password used to access the JetBrains Plugin Repository (JetBrains Account password)
            --chanel           Release channel the update is published to

            -h                 Print a synopsis of standard options
            -v                 Print version
            """.trimIndent()
    )
}
