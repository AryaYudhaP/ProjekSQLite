package dev.yudha.projektesting

import androidx.room.*

@Dao
interface ColorDao {

    @Query("SELECT * FROM Color")
    suspend fun getAll(): List<Color>

    @Insert
    suspend fun insert(vararg color: Color)

    @Update
    suspend fun update(color: Color)

    @Delete
    suspend fun delete(color: Color)

}
