package com.weight68kg.jetpackdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//人物
@Entity
class CharacterBean(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var gender: Gender,
    var age: Int,
    var weight: Int,
    var height: Int,
    var camp: Camp,
    var race: Race
)


class Organisation

enum class Gender {
    MALE, FEMALE
}

enum class Camp() {
    //海军
    NAVY,

    //海盗
    PIRATE,

    //革命军
    REVOLUTIONARY_ARMY,

    //世界政府
    WORLD_GOVERNMENT
}

enum class Race {
    //天龙人
    DRAGON_PERPLE,

    //巨人
    GIANTS,

    //小人族
    Terran,

    //D族
    D,

    //长臂族
    LONG_ARM,

    //足脚族
    LONG_LEGS,

    //鱼人
    Murloc,

    //人鱼
    Mermaid,

    //毛皮族
    MINK_FAMILY
}