package com.example.mazena.quicknotes.notes

import com.example.mazena.quicknotes.data.Note

/**
 * Created by mazena on 28.01.18.
 */
class NotesPresenter : NotesContract.Preseneter {
    val mNotesList = arrayListOf<Note>()
    var mView: NotesContract.View? = null

    override fun attachView(notesActivity: NotesActivity) {
        this.mView = notesActivity
    }

    override fun detachView() {
        this.mView = null
    }

    override fun loadNotes() {
        mNotesList.clear()
        mNotesList.addAll(initNotesList())
        mView?.showNotes(mNotesList)
    }

    fun initNotesList() = arrayListOf<Note>()


}