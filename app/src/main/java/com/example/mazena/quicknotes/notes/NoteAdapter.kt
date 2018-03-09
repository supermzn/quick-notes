package com.example.mazena.quicknotes.notes

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mazena.quicknotes.R
import com.example.mazena.quicknotes.data.Note
import com.example.mazena.quicknotes.utils.inflate
import kotlinx.android.synthetic.main.note_item.view.*
import kotlinx.android.synthetic.main.note_item_content.view.*


/**
 * Created by mazena on 27.01.18.
 */
class NoteAdapter(val itemClickListener: (Int) -> Unit) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private val notesList: MutableList<Note> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(parent.inflate(R.layout.note_item))

    override fun getItemCount() = notesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(notesList[position], itemClickListener)

    fun updateNotes(notesUpdated: List<Note>) {
        notesList.clear()
        notesList.addAll(notesUpdated)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.tv_note_title
        val description: TextView = itemView.tv_note_description
        val noteView: CardView = itemView.note_item

        fun bind(note: Note, onItemClickListener: (Int) -> Unit) {
            title.text = note.title
            description.text = note.description

            noteView.setOnClickListener {
                onItemClickListener(adapterPosition)
            }
        }
    }




}