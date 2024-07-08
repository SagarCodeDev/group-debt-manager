package org.example.models

data class TransactionInfo(
    var amount: Double?,
    var memberId: String?
){
    constructor(): this(
        amount = null,
        memberId = null
    )
}
