package com.example.mainproject.domain.dbdata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mainproject.data.model.CheckListModel

@Dao
interface CheckListModelDBDao {

    @Insert
    suspend fun insert(data:CheckListModel)

    @Update
    suspend fun update(data:CheckListModel)

    @Query("SELECT * FROM check_list_model")
    suspend fun getEverything(): CheckListModel
}