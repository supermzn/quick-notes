package com.example.mazena.quicknotes.notes

import com.example.mazena.quicknotes.data.NoteDbDao
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


/**
 * Created by mazena on 30.01.18.
 */
class NotesPresenterTest {
    lateinit var mPresenter: NotesPresenter

    val view = mock(NotesContract.View::class.java)
    val dbReader = mock(NoteDbDao::class.java)

    @Before
    fun beforeTest() {
        mPresenter = NotesPresenter(view, dbReader)
    }

    @Test
    fun loadTest() {
        assertTrue(mPresenter.mNotesList.isEmpty())
        mPresenter.loadNotes()
        assertNotNull(mPresenter.mNotesList)
    }

    @Test
    fun addNoteTest() {
        mPresenter.addNote()
        verify(view).showAddNote()
    }
}