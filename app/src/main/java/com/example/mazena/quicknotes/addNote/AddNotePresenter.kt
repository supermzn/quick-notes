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
//            The noteView is first added, then displayed, otherwise will not be present in result list
//            Can be moved outside async with live updates or something.
            view.closeView()
        }
    }

}