package com.example.mazena.quicknotes.notedetails

import com.example.mazena.quicknotes.data.Note
import com.example.mazena.quicknotes.data.NoteDbDao
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mazena on 17.02.18.
 */
class NoteDetailsPresenter(
        val view: NotesDetailsContract.View,
        val dbReader: NoteDbDao
) : NotesDetailsContract.Presenter {
    lateinit var mNote: Note

    override fun loadNote(id: Int) {
        doAsync {
            mNote = dbReader.getNoteById(id)
            uiThread {
                view.showNote(mNote)
            }
        }
    }

    override fun onEdit() {
        view.openEditNote(mNote.id)
    }

    override fun onNoteDelete() {
        doAsync {
            dbReader.deleteNote(mNote)
            uiThread {
                view.closeDetails()
            }
        }
    }
}