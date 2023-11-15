package org.alexcawl.memorize.common.resolver

import android.content.Context
import org.alexcawl.memorize.common.R
import org.alexcawl.memorize.common.model.CategoryModel
import javax.inject.Inject

class CategoryResolver @Inject constructor(
    private val context: Context
) : ICategoryResolver {
    override fun map(from: CategoryModel): String {
        return when (from) {
            CategoryModel.BUSINESS -> context.getString(R.string.business)
            CategoryModel.ENTERTAINMENT -> context.getString(R.string.entertainment)
            CategoryModel.GENERAL -> context.getString(R.string.general)
            CategoryModel.HEALTH -> context.getString(R.string.health)
            CategoryModel.SCIENCE -> context.getString(R.string.science)
            CategoryModel.SPORTS -> context.getString(R.string.sports)
            CategoryModel.TECHNOLOGY -> context.getString(R.string.technology)
        }
    }
}