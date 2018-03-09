package com.example.mazena.quicknotes.notes

import android.content.Context
import com.example.mazena.quicknotes.data.Note

/**
 * Created by mazena on 28.01.18.
 */
interface NotesContract {
    interface View {
        fun showNotes(notesList: List<Note>)

        fun showAddNote()

        fun openNoteDetails(noteId: Int)
    }

    interface Presenter {
        fun loadNotes()

        fun addNote()

        fun itemClicked(position: Int)
    }
}