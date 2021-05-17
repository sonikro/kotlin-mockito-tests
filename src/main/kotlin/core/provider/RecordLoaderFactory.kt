package core.provider

fun interface RecordLoaderFactory {
    fun factory(schemaName: String, tableName: String): RecordLoader
}