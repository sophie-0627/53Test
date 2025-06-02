package com.example.a53test.ui.theme

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Database
import androidx.room.RoomDatabase

@Entity(tableName = "userClass")
data class UserClass(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    val email: String,
    val password : String
)

@Dao
interface UserDao {
    @Insert
    suspend fun Insert(user:UserClass)

    @Query("select * from userClass Where email = :email AND password = :password")
    suspend fun Check(email: String,password:String):UserClass?
}

@Database(entities = [UserClass::class], version = 1)
abstract class UserData:RoomDatabase() {
    abstract fun dao():UserDao
}