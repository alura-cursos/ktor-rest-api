package br.com.alura.services

import br.com.alura.models.Note
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class NoteService(database: Database) {

    private object Notes : Table() {
        val id = uuid("id")
        val title = varchar("title", 255)
        val message = text("message")

        override val primaryKey = PrimaryKey(id)
    }

    init {
        transaction(database) {
            SchemaUtils.create(Notes)
        }
    }

    private suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }

    suspend fun findAll(): List<Note> = dbQuery {
        Notes.selectAll()
            .map { row -> row.toNote() }
    }

    suspend fun findById(id: UUID): Note? {
        return dbQuery {
            Notes.select { Notes.id eq id }
                .map { row -> row.toNote() }
                .singleOrNull()
        }
    }

    suspend fun save(note: Note): Note = dbQuery {
        Notes.insertIgnore {
            it[id] = note.id
            it[title] = note.title
            it[message] = note.message
        }.let {
            Note(
                id = it[Notes.id],
                title = it[Notes.title],
                message = it[Notes.message]
            )
        }
    }

    suspend fun delete(id: UUID) {
        dbQuery {
            Notes.deleteWhere { Notes.id.eq(id) }
        }
    }

    private fun ResultRow.toNote() = Note(
        id = this[Notes.id],
        title = this[Notes.title],
        message = this[Notes.message]
    )

}
