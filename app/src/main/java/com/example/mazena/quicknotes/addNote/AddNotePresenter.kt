package com.example.mazena.quicknotes.addNote

import com.example.mazena.quicknotes.data.Note
import com.example.mazena.quicknotes.data.NoteDatabase
import com.example.mazena.quicknotes.data.NoteDbDao
import com.example.mazena.quicknotes.notedetails.NotesDetailsContract
import org.jetbrains.anko.doAsync

/**
 * Created by mazena on 15.02.18.
 */
class AddNotePresenter(
        val view: AddNoteContract.View,
        val dbReader: NoteDbDao
): AddNoteContract.Presenter {

    override fun addNote(title: String, content: String) {
        doAsync {
            dbReader.insertNote(Note(title = title, description = content))
        }
        view.closeView()
    }

}