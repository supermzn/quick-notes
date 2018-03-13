package com.example.mazena.quicknotes.data

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by mazena on 06.02.18.
 */
@Dao
interface NoteDbDao {
    @Insert(onConflict = REPLACE)
    fun insertNote(note: Note)

    @Update(onConflict = REPLACE)
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM Note")
    fun getAllNotes(): List<Note>

    @Query("SELECT * FROM Note where id = :id")
    fun getNoteById(id: Int): Note
}