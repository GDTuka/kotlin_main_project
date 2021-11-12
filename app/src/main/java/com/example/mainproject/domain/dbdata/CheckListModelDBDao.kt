package com.example.mainproject.domain.dbdata


import androidx.room.*
import com.example.mainproject.data.model.CheckListModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CheckListModelDBDao {

    @Insert
    suspend fun insert(data:CheckListModel)

    @Delete
    fun deleteCheckList(checkList: CheckListModel)

    @Query("SELECT * FROM check_list_model")
    fun getEverything(): Flow<List<CheckListModel>>
}