package com.candledle.safeteen.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.candledle.safeteen.feature.main.home.Rank

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Int,

    @ColumnInfo(name = "name")
    val userName: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "nickname")
    val nickName: String,

    @ColumnInfo(name = "reward")
    val reward: Int,
)