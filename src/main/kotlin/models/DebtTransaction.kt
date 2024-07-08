package org.example.models

import java.util.UUID


/**
 * Need transaction info:
 * 1. Amount
 * 2. Member to which the amount is owed.
 *
 *
 * M1 creates a expense/Debt Transaction of 500 rupees and adds in total 4 members.
 * The amount that M1 owes will be 500*3/4 and 500/4 will be M1's expense.
 *
 *
 * Expense model.
 * Expense Name.
 * Expense By.
 * Debt Transactions.
 */
data class DebtTransaction(
    var id: String?,
    var expenseId: String?,
    var transactionDate: Long?,
    var transactionInfo: TransactionInfo?,
): Transaction{
    constructor(): this(
        id = UUID.randomUUID().toString(),
        expenseId = null,
        transactionDate = System.currentTimeMillis(),
        transactionInfo = null
    )
}
