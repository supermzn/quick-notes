package com.example.mazena.quicknotes.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by mazena on 27.01.18.
 */
@Entity
data class Note(@PrimaryKey (autoGenerate = true) val id: Int = 0,
                val title: String,
                val description: String
)
