package com.example.mazena.quicknotes.editNote

import com.example.mazena.quicknotes.data.Note
import com.example.mazena.quicknotes.data.NoteDbDao
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mazena on 10.03.18.
 */
class EditNotePresenter(
        val view: EditNoteContract.View,
        val dbReader: NoteDbDao
) : EditNoteContract.Presenter {
    lateinit var mNote: Note

    override fun loadNote(id: Int) {
        doAsync {
            mNote = dbReader.getNoteById(id)
            uiThread { view.displayNote(mNote)}
        }
    }

    override fun saveNote(updatedTitle: String, updatedDescription: String) {
        doAsync {
            mNote.title = updatedTitle
            mNote.description = updatedDescription
            dbReader.updateNote(mNote)
        }
    }

}