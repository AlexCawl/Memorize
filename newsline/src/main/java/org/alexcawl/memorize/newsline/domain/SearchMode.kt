package org.alexcawl.memorize.newsline.domain

interface SearchMode : Iterable<Filter> {
    val actionIcon: ActionIcon

    enum class IconType {
        ADD,
        CHANGE,
        CONFIGURE
    }

    data class ActionIcon(
        val iconType: IconType,
        override val description: String = iconType.toString()
    ) : Filter {
        override val diffId: Any
            get() = iconType
        override val diffContent: Any
            get() = description
    }
}