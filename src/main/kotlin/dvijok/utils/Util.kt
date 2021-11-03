package dvijok.utils

object Util {
    inline fun<T> T?.guard(nullClause: () -> Nothing): T {
        return this ?: nullClause()
    }
}