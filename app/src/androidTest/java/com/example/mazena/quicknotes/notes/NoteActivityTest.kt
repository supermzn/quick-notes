package com.example.mazena.quicknotes.notes

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.mazena.quicknotes.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by mazena on 28.01.18.
 */
@RunWith(AndroidJUnit4::class)
class NoteActivityTest {

    @get:Rule
    val notesActivityTestRule: ActivityTestRule<NotesActivity> =
            ActivityTestRule(NotesActivity::class.java, true, true)

    @Test
    fun testTest() {
        onView(withId(R.id.rv_notes)).perform(click())
    }
}