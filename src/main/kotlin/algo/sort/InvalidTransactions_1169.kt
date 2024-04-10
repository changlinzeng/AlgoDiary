package algo.sort

class KtInvalidTransactions_1169 {
    fun invalidTransactions(transactions: Array<String>): List<String> {
        val trans = transactions.map { t ->
            val strs = t.split(",")
            Transaction(strs[0], strs[1].toInt(), strs[2].toInt(), strs[3])
        }.toList().sortedWith(compareBy ({ it.name }, {it.time}))

        // mark the transaction added as invalid as there might be duplications in input, we could not use set
        val added = BooleanArray(trans.size)
        val invalid: MutableList<Transaction> = mutableListOf()
        trans.indices.forEach { i ->
            var j = i
            while (j < trans.size && trans[j].name == trans[i].name) {
                if (trans[j].amount > 1000 && !added[j]) {
                    invalid.add(trans[j])
                    added[j] = true
                }
                if (trans[j].city != trans[i].city && trans[j].time - trans[i].time <= 60) {
                    if (!added[i]) {
                        invalid.add(trans[i])
                        added[i] = true
                    }
                    if (!added[j]) {
                        invalid.add(trans[j])
                        added[j] = true
                    }
                }
                j++
            }
        }

        return invalid.map { "${it.name},${it.time},${it.amount},${it.city}" }.toList()
    }
}

data class Transaction(val name: String, val time: Int, val amount: Int, val city: String)

fun main() {
    val invalidTrans = KtInvalidTransactions_1169()
    println(invalidTrans.invalidTransactions(arrayOf("alice,20,800,mtv", "alice,50,100,beijing")))
    println(invalidTrans.invalidTransactions(arrayOf("alice,20,800,mtv", "alice,50,1200,mtv")))
    println(invalidTrans.invalidTransactions(arrayOf("alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt")))
    println(invalidTrans.invalidTransactions(arrayOf("bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam")))
    println(invalidTrans.invalidTransactions(arrayOf("bob,977,184,amsterdam","chalicefy,281,96,amsterdam","xnova,949,549,amsterdam","iris,412,294,barcelona","bob,144,102,budapest","lee,760,571,beijing","xnova,863,255,bangkok","chalicefy,670,1018,bangkok","xnova,353,1116,beijing","alex,638,521,barcelona","iris,669,1983,beijing","alex,654,1511,budapest","chalicefy,225,130,bangkok")))
}