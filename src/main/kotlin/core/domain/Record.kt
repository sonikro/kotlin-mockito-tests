package core.domain

data class RecordMetadata(
    val tableName: String,
    val schemaName: String,
    val operation: String
)

typealias JSONMap = LinkedHashMap<String, Any>

data class Record(
    val metadata: RecordMetadata,
    val data: JSONMap
)