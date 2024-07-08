package org.example

import org.example.models.Expense
import org.example.models.Member
import org.example.models.SplitGroup
import org.example.models.TransactionInfo
import org.example.services.SplitGroupManagerService


/**
 * Group Debt Manager:
 * 1. Able to Create a group and add Members.
 * 2. Able to add expenses in a group.
 * 3. Settle Debts inside a group.
 * 4. Simply debts.(bonus)
 *
 */
fun main() {
    val splitGroupManagerService = SplitGroupManagerService()
    val group = SplitGroup()
    group.groupName= "College Wing"
    splitGroupManagerService.addNewGroup(group)
    val m1 = Member()
    m1.name = "Sagar"
    m1.phoneNumber = "7727839857"
    val m2 = Member()
    m2.name = "Sumit"
    m2.phoneNumber = "7727839856"
    splitGroupManagerService.addMembersToGroup(
        groupId = group.id!!,
        members = listOf(m1, m2)
    )
    //Constructor could have been used to initialize classes/ or builder pattern
    val expense = Expense()
    expense.expenseBy = m1.id
    expense.totalExpenditure = 100.0
    val distribution1 = TransactionInfo().apply {
        this.amount = 50.0
        this.memberId = m1.id
    }
    val distribution2 = TransactionInfo().apply {
        this.amount = 50.0
        this.memberId = m2.id
    }
    expense.amountDistribution = mutableListOf(distribution2, distribution1)
    splitGroupManagerService.addExpense(expense)
    println(group.members)
    println(splitGroupManagerService.debtTransactions)
}