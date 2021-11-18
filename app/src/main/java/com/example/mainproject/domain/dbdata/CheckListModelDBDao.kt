package com.example.mainproject.domain.dbdata


import androidx.room.*
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CheckListModelDBDao {

    @Insert
    fun insert(data:CheckListWithCheckListModel)
    @Delete
    fun deleteCheckList(checkList: CheckListWithCheckListModel)

    @Transaction
    @Query("SELECT * FROM check_list_model " )
    fun getEverything(): Flow<List<CheckListWithCheckListModel>>
}