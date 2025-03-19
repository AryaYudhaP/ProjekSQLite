package dev.yudha.projektesting

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import androidx.room.RoomDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    val db = ColorDatabase.getInstance((this))
    val colorRed = Color(0, "#ff0000", "Red")
//    db.colorDao().insert(colorRed)

//    val db = Room.databaseBuilder(
//        applicationContext,
//        ColorDatabase::class.java, name = "color_database"
//    ).build()
//
//    val arrayOfColor = db.colorDAO()
}