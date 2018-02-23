package com.example.mazena.quicknotes.addNote

/**
 * Created by mazena on 16.02.18.
 */
interface AddNoteContract {
    interface View {
        fun closeView()
    }

    interface Presenter {
        fun addNote(toString: String, toString1: String)
    }
}