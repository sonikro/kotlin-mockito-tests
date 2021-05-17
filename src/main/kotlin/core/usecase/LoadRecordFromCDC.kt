package core.usecase

import core.domain.Record
import core.provider.RecordLoaderFactory

class LoadRecordFromCDC(
    private val recordLoaderFactory: RecordLoaderFactory
) {
    fun invoke(record: Record) {
        val loader = recordLoaderFactory.factory(
            schemaName = record.metadata.schemaName,
            tableName = record.metadata.tableName
        )
        loader.loadRecord(record)
    }
}