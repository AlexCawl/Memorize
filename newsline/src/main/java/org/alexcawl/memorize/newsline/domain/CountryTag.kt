package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.network.dto.Country
import org.alexcawl.memorize.ui.DelegateAdapterItem

data class CountryTag(
    val country: Country,
    val description: String
) : DelegateAdapterItem {
    override val id: Any
        get() = country
    override val content: Any
        get() = description
}