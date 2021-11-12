package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object NotesEntity: Table<Nothing>("note_table") {
    val id = int("id").primaryKey()
    val title = varchar("title")
    val description = varchar("description")
}