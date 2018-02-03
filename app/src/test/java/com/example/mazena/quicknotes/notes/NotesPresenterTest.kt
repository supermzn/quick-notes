package com.example.mazena.quicknotes.notes

import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by mazena on 30.01.18.
 */
class NotesPresenterTest {
    lateinit var mPresenter: NotesPresenter

    @Before
    fun beforeTest() {
        mPresenter = NotesPresenter()
    }

    @Test
    fun loadTest() {
        assertTrue(mPresenter.mNotesList.isEmpty())
        mPresenter.loadNotes()
        assertNotNull(mPresenter.mNotesList)
    }

    @Test
    fun attachTest() {
        assertNull(mPresenter.mView)

        mPresenter.attachView(mockk())
        assertNotNull(mPresenter.mView)
    }

    @Test
    fun detachTest() {
        mPresenter.attachView(mockk())
        assertNotNull(mPresenter.mView)
        mPresenter.detachView()
        assertNull(mPresenter.mView)
    }
}