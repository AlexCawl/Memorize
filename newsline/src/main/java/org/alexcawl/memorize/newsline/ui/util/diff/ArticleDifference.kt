package org.alexcawl.memorize.newsline.ui.util.diff

import androidx.recyclerview.widget.DiffUtil
import org.alexcawl.memorize.common.ArticleModel

object ArticleDifference : DiffUtil.ItemCallback<ArticleModel>() {
    override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean =
        oldItem::class == newItem::class && oldItem.newsId == newItem.newsId

    override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean =
        oldItem.url == newItem.url
}