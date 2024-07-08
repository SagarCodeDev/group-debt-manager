package org.example.models

import java.util.UUID

/**
 * Same member can be part of multiple groups.
 * Amount calculation Would be Group specific.
 *
 */
data class Member(
    var id: String?,
    var name: String?,
    var phoneNumber: String?
): Person{
    constructor(): this(
        id = UUID.randomUUID().toString(),
        name = null,
        phoneNumber = null
    )

    fun validateMember(){
        if(this.name.isNullOrBlank()){
            throw Exception("Name cannot be blank of the member")
        }
        if(this.id.isNullOrBlank()){
            throw Exception("Id cannot be blank of the member")
        }
        if(this.phoneNumber.isNullOrBlank()){
            throw Exception("Phone Number cannot be blank of the member")
        }
    }
}
