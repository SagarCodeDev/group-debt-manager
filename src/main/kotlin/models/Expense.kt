package org.example.models

import java.util.UUID

data class Expense(
    var id: String?,
    var expenseName: String?,
    var groupId: String?,
    var expenseBy: String?,
    var totalExpenditure: Double?,
    var amountDistribution: MutableList<TransactionInfo>
){
    constructor(): this(
        id = UUID.randomUUID().toString(),
        expenseName = null,
        groupId = null,
        expenseBy = null,
        totalExpenditure = null,
        amountDistribution = mutableListOf()
    )

    fun validateExpense(){
        if(id.isNullOrBlank()){
            throw Exception("Invalid id")
        }
        if(groupId.isNullOrBlank()){
            throw Exception("Invalid group id")
        }
        if(totalExpenditure == null){
            throw Exception("Invalid expenditure")
        }
        if(amountDistribution.isEmpty()){
            throw Exception("Invalid id")
        }
    }
}