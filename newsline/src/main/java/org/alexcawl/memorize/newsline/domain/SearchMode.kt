package org.alexcawl.memorize.newsline.domain

interface SearchMode : Iterable<Filter> {
    val actionIcon: ActionIcon

    enum class IconType {
        ADD, CHANGE, CONFIGURE
    }

    data class ActionIcon(
        val iconType: IconType,
        override val content: String = iconType.toString()
    ) : Filter {
        override val id: Int
            get() = iconType.hashCode()
    }
}