package org.alexcawl.memorize.newsline.ui

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.alexcawl.memorize.newsline.databinding.LayoutArticleBinding
import org.alexcawl.memorize.newsline.domain.Article

class ArticleViewHolder(
    private val binding: LayoutArticleBinding
) : ViewHolder(binding.root) {
    fun onBind(article: Article) {

    }
}