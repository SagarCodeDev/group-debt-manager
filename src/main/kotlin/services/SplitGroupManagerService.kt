package org.example.services

import org.example.models.*

class SplitGroupManagerService {
    private var groups = mutableListOf<SplitGroup>()
    private var members = mutableListOf<Member>()
    private var expenses = mutableListOf<Expense>()
    var debtTransactions = mutableListOf<DebtTransaction>()
    private var creditTransactions = mutableListOf<CreditTransaction>()

    fun addNewGroup(group: SplitGroup): SplitGroup{
        group.validateGroup()
        groups.add(group)
        return group
    }

    fun addMembersToGroup(groupId: String, members: List<Member>): Group{
        val group = groups.find{ it.id == groupId } ?: throw Exception("Group does not exist")
        members.validate()
        group.members.addAll(members)
        group.members.distinctBy { it.id }
        // No need to update explicitly in groups array as it will be updated due to reference
        return group
    }

    fun List<Member>.validate(){
        this.forEach { it.validateMember() }
    }

    fun addExpense(expense: Expense){
        expenses.add(expense)
        val filteredTransaction = expense.amountDistribution.filter { it.memberId != expense.expenseBy }
        createDebtTransactions(expenseId = expense.id!!, transactions = filteredTransaction)
    }

    fun createDebtTransactions(expenseId: String, transactions: List<TransactionInfo>){
        transactions.forEach {
            val debtTransaction = DebtTransaction()
            debtTransaction.expenseId = expenseId
            debtTransaction.transactionInfo = it
            debtTransactions.add(debtTransaction)
        }
    }

    fun settleTransaction(amount: Double, ){

    }

}