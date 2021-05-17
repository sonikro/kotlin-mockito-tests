package core.provider

import core.domain.Record

interface RecordLoader {
    fun loadRecord(record: Record)
}