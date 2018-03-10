package com.example.mazena.quicknotes.notes

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.mazena.quicknotes.R
import com.example.mazena.quicknotes.addNote.AddNoteActivity
import com.example.mazena.quicknotes.data.Note
import com.example.mazena.quicknotes.data.NoteDatabase
import com.example.mazena.quicknotes.notedetails.NoteDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class NotesActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, NotesContract.View {
    private lateinit var mPresenter: NotesContract.Presenter
    private val mNoteAdapter: NoteAdapter by lazy {
        NoteAdapter { mPresenter.itemClicked(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val database = NoteDatabase.getInstance(this)
        mPresenter = NotesPresenter(this, database.noteDao)

        fab_add_note.setOnClickListener { view ->
            mPresenter.addNote()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        initNotesRecycler()
    }

    private fun initNotesRecycler() {
        rv_notes.layoutManager = LinearLayoutManager(this)
        rv_notes.adapter = mNoteAdapter
    }

    override fun showNotes(notesList: List<Note>) {
        mNoteAdapter.updateNotes(notesList)
    }

    override fun showAddNote() {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }

    override fun openNoteDetails(noteId: Int) {
        val intent = Intent(this, NoteDetailsActivity::class.java)
        intent.putExtra("note_id_extra", noteId)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadNotes()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
