package algo.depthFirstSearch

class KtRestoreIPAddresses_93 {
    fun restoreIpAddresses(s: String): List<String> {
        fun dfs(s: String, address: String, addrs: MutableList<String>) {
            if (s == "") {
                if (address.count { it == '.' } == 3) {
                    addrs.add(address)
                }
                return
            }
            if (s[0] == '0') {
                val newAddr = if (address == "") "" else "$address."
                dfs(s.substring(1), newAddr + "0", addrs)
            } else {
                var num = 0
                s.indices.forEach { i ->
                    if (i > 2) {
                        return@forEach
                    }
                    val c = s[i]
                    num = num * 10 + (c - '0')
                    if (num in 1..255) {
                        var newAddr = if (address == "") "" else "$address."
                        newAddr += s.substring(0, i + 1)
                        dfs(s.substring(i + 1), newAddr, addrs)
                    }
                }
            }
        }

        val addrs: MutableList<String> = mutableListOf()
        dfs(s, "", addrs)
        return addrs
    }
}

fun main() {
    val restore = KtRestoreIPAddresses_93()
    println(restore.restoreIpAddresses("25525511135"))
    println(restore.restoreIpAddresses("0000"))
    println(restore.restoreIpAddresses("101023"))
}