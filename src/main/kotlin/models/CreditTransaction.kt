package org.example.models


/**
 * Credit transaction will always occur one to one.
 * Member M1 cannot settle debts to multiple Members at a time.
 */
data class CreditTransaction(
    var id: String,
    var expenseId: String,
    var transactionDate: Long,
    var transactionInfo: TransactionInfo
): Transaction
