# kotlin-mockito-tests

## Introduction

> This repository was created to experiment on what would be a good structure for writting unit tests with Kotlin + Mockito

## Code Samples

> The idea was to try to replicate as much as possible, the structure of unit tests with JEST (NodeJS), and using the pattern of MakeSuts (System Under Test).

Example
```kotlin
private data class SUT(
    val sut: LoadRecordFromCDC,
    val recordLoaderFactory: RecordLoaderFactory,
    val dummyLoader: RecordLoader,
    val metadata: RecordMetadata,
    val record: Record
)

internal class LoadRecordFromCDCTest {

    private fun makeSut(): SUT {
        val recordLoaderFactory = mock<RecordLoaderFactory>()
        val metadata = RecordMetadata(
            schemaName = "OT",
            tableName = "CUSTOMER",
            operation = "insert"
        )
        val record = Record(
            metadata,
            data = linkedMapOf(
                "ID" to "1",
                "NAME" to "Joselito da Silva"
            )
        )
        return SUT(
            sut = LoadRecordFromCDC(recordLoaderFactory),
            recordLoaderFactory,
            dummyLoader = mock(),
            metadata,
            record
        )
    }

    @Test
    fun `it invokes the RecordLoaderFactory and passes the record to the loader`() {
        val (sut, recordLoaderFactory, dummyLoader, metadata, record) = makeSut()
        //Given
        whenever(
            recordLoaderFactory.factory(schemaName = any(), tableName = any())
        ).thenReturn(dummyLoader)
        //When
        sut.invoke(record)
        //Then
        verify(recordLoaderFactory).factory(
            schemaName = metadata.schemaName,
            tableName = metadata.tableName
        )
        verify(dummyLoader).loadRecord(record)
    }

}
```
## Running the tests

> ./gradlew test