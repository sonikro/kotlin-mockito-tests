package provider.loaders

import core.domain.Record
import core.provider.RecordLoader

class CustomerLoader : RecordLoader {
    override fun loadRecord(record: Record) {
        println("Loading record $record")
    }
}