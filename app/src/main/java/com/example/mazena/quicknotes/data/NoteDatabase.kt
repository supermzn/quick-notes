package com.example.mazena.quicknotes.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.mazena.quicknotes.R

/**
 * Created by mazena on 07.02.18.
 */
@Database(entities = arrayOf(Note::class), version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDbDao

    companion object {
        private lateinit var INSTANCE: NoteDatabase

        fun getInstance(context: Context): NoteDatabase {
                synchronized(NoteDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            NoteDatabase::class.java,
                            context.getString(R.string.notes_database)).build()
                }
            return INSTANCE
        }
    }
}



