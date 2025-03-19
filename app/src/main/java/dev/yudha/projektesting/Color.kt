package dev.yudha.projektesting

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Color")
data class Color(
        @PrimaryKey(autoGenerate = true) val _id: Int,
        @ColumnInfo(name = "hex_color") val hexColor:String,
        val name:String
)
