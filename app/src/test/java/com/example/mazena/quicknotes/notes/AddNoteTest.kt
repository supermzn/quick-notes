package com.example.mazena.quicknotes.notes

import com.example.mazena.quicknotes.addNote.AddNoteContract
import com.example.mazena.quicknotes.addNote.AddNotePresenter
import com.example.mazena.quicknotes.data.NoteDbDao
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by mazena on 18.02.18.
 */
class AddNoteTest {
    lateinit var mPresenter: AddNotePresenter

    val view = mock(AddNoteContract.View::class.java)
    val dbReader = mock(NoteDbDao::class.java)

    @Before
    fun beforeTest() {
        mPresenter = AddNotePresenter(view, dbReader)
    }

    @Test
    fun addNoteTest() {

        mPresenter.addNote(String(), String())
        verify(view).closeView()
    }
}