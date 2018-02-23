package com.example.mazena.quicknotes.notes

import com.example.mazena.quicknotes.data.NoteDbDao
import com.example.mazena.quicknotes.notedetails.NoteDetailsPresenter
import com.example.mazena.quicknotes.notedetails.NotesDetailsContract
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by mazena on 18.02.18.
 */
class NoteDetailsTest {
    lateinit var mPresenter: NoteDetailsPresenter

    val view = mock(NotesDetailsContract.View::class.java)
    val dbReader = mock(NoteDbDao::class.java)

    @Before
    fun beforeTest() {
        mPresenter = NoteDetailsPresenter(view, dbReader)
    }

    @Test
    fun loadNoteTest() {
        mPresenter.loadNote(0)
        verify(view).showNote(mockk())
    }

}