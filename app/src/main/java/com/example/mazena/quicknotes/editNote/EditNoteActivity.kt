package com.example.mazena.quicknotes.editNote

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.mazena.quicknotes.R
import com.example.mazena.quicknotes.data.Note
import com.example.mazena.quicknotes.data.NoteDatabase
import kotlinx.android.synthetic.main.activity_add_note.*

/**
 * Created by mazena on 10.03.18.
 */
class EditNoteActivity : AppCompatActivity(), EditNoteContract.View {
    private lateinit var mPresenter: EditNoteContract.Presenter
    private val NOTE_ID_EXTRA = "note_id_extra"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val database = NoteDatabase.getInstance(this)
        mPresenter = EditNotePresenter(this, database.noteDao)
        mPresenter.loadNote(intent.getIntExtra(NOTE_ID_EXTRA, -1))
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_note, menu)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_save) {
            mPresenter.saveNote(et_title.text.toString(), et_description.text.toString())
        } else if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun displayNote(note: Note) {
        et_title.setText(note.title)
        et_description.setText(note.description)
    }

    override fun onNavigateUp(): Boolean {
        finish()
        return true
    }
}