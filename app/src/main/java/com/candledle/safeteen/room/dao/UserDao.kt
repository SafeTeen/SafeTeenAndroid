package com.candledle.safeteen.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.candledle.safeteen.room.entity.UserEntity

@Dao
interface UserDao{
    @Query("SELECT * FROM userentity")
    fun getUser(): UserEntity

    @Insert
    fun insertUser(userEntity: UserEntity)
}