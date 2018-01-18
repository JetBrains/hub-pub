# Description

This package allows to upload a plugin to JetBrains Plugin Repository


# How to use


The simplest way to use is install the latest version form [npm](https://www.npmjs.com/package/hub-pub):
```shell
npm install -g hub-pub
```

## Usage

```
hub-pub publish <plugin directory or zip file> [<options>]
```

Options | Description
--- | :---
pluginId | is a numeric ID of the plugin, can be retrieved from the plugin repository URL. e.g. Scala plugin ID is 1347
userName | is a plugin author username used to access the JetBrains Plugin Repository (JetBrains Account username or email).
password | is a plugin author password used to access the JetBrains Plugin Repository (JetBrains Account password).
channel | is a release channel the update is published to (empty channel means default Stable channel) (optional)

```
hub-pub pack <plugin directory>
```


<div align="center">
    <img src="./kotlin.svg" width="28">
    <div></div>
    <sub><b>Powered by kotlin</b></sub>
</div>
