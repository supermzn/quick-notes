package com.example.mazena.quicknotes.notedetails

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.mazena.quicknotes.R
import com.example.mazena.quicknotes.data.Note
import com.example.mazena.quicknotes.data.NoteDatabase
import com.example.mazena.quicknotes.editNote.EditNoteActivity
import kotlinx.android.synthetic.main.note_detail.*

/**
 * Created by mazena on 17.02.18.
 */
class NoteDetailsActivity : AppCompatActivity(), NotesDetailsContract.View {

    private lateinit var mPresenter: NotesDetailsContract.Presenter
    private val NOTE_ID_EXTRA = "note_id_extra"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_detail)
        val database = NoteDatabase.getInstance(this)
        mPresenter = NoteDetailsPresenter(this, database.noteDao)
    }

    override fun showNote(note: Note) {
        tv_error_message.visibility = View.GONE
        tv_note_title.visibility = View.VISIBLE
        tv_note_description.visibility = View.VISIBLE
        tv_note_title.text = note.title
        tv_note_description.text = note.description
    }

    override fun showError(errorMessage: String) {
        tv_note_title.visibility = View.GONE
        tv_note_description.visibility = View.GONE
        tv_error_message.text = errorMessage
        tv_error_message.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        val noteId = intent.getIntExtra(NOTE_ID_EXTRA, -1)
        if (noteId != -1)
            mPresenter.loadNote(noteId)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_details, menu)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_edit) {
            mPresenter.onEdit()
        } else if (item?.itemId == R.id.action_delete) {
            mPresenter.onNoteDelete()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun openEditNote(noteId: Int) {
        val intent = Intent(this, EditNoteActivity::class.java)
        intent.putExtra("note_id_extra", noteId)
        startActivity(intent)
    }

    override fun closeDetails() {
        finish()
    }

}