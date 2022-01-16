package will.shiro.ifly.utils.extensions

fun Int.minsToHour(): String {

    val hour = this / 60
    val mins = this % 60

    return "${hour}h ${mins}m"
}

