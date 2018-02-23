package com.example.mazena.quicknotes.notedetails

import com.example.mazena.quicknotes.data.NoteDbDao
import org.jetbrains.anko.doAsync

/**
 * Created by mazena on 17.02.18.
 */
class NoteDetailsPresenter(
        val view: NotesDetailsContract.View,
        val dbReader: NoteDbDao
) : NotesDetailsContract.Presenter {

    override fun loadNote(id: Int) {
        doAsync {
            val note = dbReader.getNoteById(id)
            view.showNote(note)
        }
    }
}