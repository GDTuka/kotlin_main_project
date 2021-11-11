package com.example.mainproject.data.db.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.domain.dbdata.CheckListModelDBDao

@Database(entities = [CheckListModel::class],version = 1,exportSchema = false)
abstract class CheckListDB : RoomDatabase() {

    abstract fun CheckListDBDao():CheckListModelDBDao

    companion object {

        @Volatile
        private var instance: CheckListDB? = null

        fun getInstance(context: Context):CheckListDB{
            return instance ?: synchronized(this){
                instance?: buildDatabase(context).also { instance = it }
            }
        }
        private fun buildDatabase(context: Context): CheckListDB{
            return Room.databaseBuilder(context,CheckListDB::class.java,"check_list_model").build()
        }
    }
}
