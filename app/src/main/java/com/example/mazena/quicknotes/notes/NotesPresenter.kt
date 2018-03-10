package com.example.mazena.quicknotes.notes

import com.example.mazena.quicknotes.data.Note
import com.example.mazena.quicknotes.data.NoteDbDao
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by mazena on 28.01.18.
 */
class NotesPresenter(val mView: NotesContract.View, val mDbReader: NoteDbDao) : NotesContract.Presenter {
    val mNotesList = arrayListOf<Note>()

    override fun loadNotes() {
        mNotesList.clear()
        doAsync {
            mNotesList.addAll(mDbReader.getAllNotes())
            uiThread {
                mView.showNotes(mNotesList)
            }
        }
    }

    override fun addNote() {
        mView.showAddNote()
    }

    override fun itemClicked(position: Int) {
        if (position >= 0 && position < mNotesList.size)
            mView.openNoteDetails(mNotesList[position].id)
    }
}
