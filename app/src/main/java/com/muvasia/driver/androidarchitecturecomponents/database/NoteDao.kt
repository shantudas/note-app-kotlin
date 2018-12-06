package com.muvasia.driver.androidarchitecturecomponents.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface NoteDao {

    @Query("SELECT * from notes ORDER BY id DESC")
    fun fetchAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :itemId")
    abstract fun getNoteItemById(itemId: Int?): LiveData<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}