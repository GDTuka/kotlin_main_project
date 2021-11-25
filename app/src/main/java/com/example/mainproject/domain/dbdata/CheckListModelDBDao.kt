package com.example.mainproject.domain.dbdata


import androidx.room.*
import com.example.mainproject.data.db.entitys.CheckListPoints
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CheckListModelDBDao {

    @Insert
    fun insertCheckList(data:CheckListModel): Long

    @Insert
    fun insertCheckListPoint(vararg data:CheckListPoints)

    @Delete
    fun deleteCheckList(checkList: CheckListModel)

    @Transaction
    @Query("SELECT * FROM check_list_model" )
    fun getEverything(): Flow<MutableList<CheckListWithCheckListModel>>

    @Update
    fun updateCorrectly(checkListPoints: CheckListPoints)
}