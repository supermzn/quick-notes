package com.example.mazena.quicknotes.addNote

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.mazena.quicknotes.R
import com.example.mazena.quicknotes.data.NoteDatabase
import kotlinx.android.synthetic.main.activity_add_note.*

/**
 * Created by mazena on 15.02.18.
 */
class AddNoteActivity : AppCompatActivity(), AddNoteContract.View {
    private lateinit var mPresenter: AddNoteContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        val database = NoteDatabase.getInstance(this)
        mPresenter = AddNotePresenter(this, database.noteDao)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note, menu)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_accept) {
            mPresenter.addNote(et_title.text.toString(), et_description.text.toString())
        }
        return super.onOptionsItemSelected(item)
    }

    override fun closeView() {
        finish()
    }
}