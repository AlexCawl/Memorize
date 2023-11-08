package org.alexcawl.memorize.newsline.domain

interface SearchMode : Iterable<Filter> {
    val iconAction: IconAction

    enum class IconType {
        ADD,
        CHANGE,
        CONFIGURE
    }

    data class IconAction(
        val iconType: IconType,
        override val description: String = iconType.toString()
    ) : Filter
}