package provider.loaders

import core.provider.RecordLoaderFactory

val recordLoaderFactory = RecordLoaderFactory { schemaName, tableName ->
    when("$schemaName.$tableName"){
        "OT.USER" -> CustomerLoader()
        else -> throw RuntimeException("Missing loader for $schemaName.$tableName")
    }
}