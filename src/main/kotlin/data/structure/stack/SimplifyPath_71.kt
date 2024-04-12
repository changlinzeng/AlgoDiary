package data.structure.stack

import java.util.Stack

class KtSimplifyPath_71 {
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        path.split("/").filter { it.isNotBlank() }.forEach { folder ->
            when (folder) {
                ".." -> {
                    if (stack.isNotEmpty()) {
                        stack.pop()
                    }
                }
                "." -> { /* do nothing */ }
                else -> {
                    stack.push(folder)
                }
            }
        }

        return "/" + stack.joinToString("/")
    }
}

fun main() {
    val simplify = KtSimplifyPath_71()
    println(simplify.simplifyPath("/a/./b/../../c/"))
}