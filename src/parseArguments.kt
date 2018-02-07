fun parseArguments(args: List<String>) {
    if (args.isEmpty()) {
        printUsage()
        return
    }

    val it = args.iterator()
    var other = listOf<String>()
    val params = HashMap<String, String>()
    while (it.hasNext()) {
        val arg = it.next()

        when (arg) {
            "-h" -> {
                printUsage()
                return
            }
            "-v" -> {
                printVersion()
                return
            }
            else -> {
                if (arg.startsWith("--")) {
                    val dr = "="
                    val key = arg
                            .replaceAfter(dr, "")
                            .removePrefix("--")
                            .removeSuffix(dr)
                    params[key] = if (arg.contains(dr)) arg
                            .replaceBefore(dr, "")
                            .removePrefix(dr) else ""
                } else {
                    other += arg
                }
            }
        }
    }

    if (other.isEmpty()) {
        printUsage()
        return
    }

    when (other.first()) {
        "pack" -> {
            pack(other.get(1), params).then { archive -> console.log(archive) }
            return
        }
        "publish" -> {
            publish(other.get(1), params).then { console.log("Done") }
            return
        }
        "version" -> {
            version(other.get(1), params)
            return
        }
        else -> printUsage()
    }
}
