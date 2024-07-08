package org.example.models

import java.util.UUID

data class SplitGroup(
    var id: String?,
    var groupName: String?,
    var createdAt: Long?,
    var members: MutableList<Member>
): Group{
    constructor(): this(
        id = UUID.randomUUID().toString(),
        groupName = null,
        createdAt = System.currentTimeMillis(),
        members = mutableListOf()
    )
    fun validateGroup(){
        if(this.groupName.isNullOrBlank()){
            throw Exception("Group name cannot be blank")
        }
    }
}
