package org.alexcawl.memorize.newsline.ui

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import org.alexcawl.memorize.newsline.databinding.LayoutArticleBinding
import org.alexcawl.memorize.newsline.domain.Article

class ArticleViewHolder(
    private val binding: LayoutArticleBinding
) : ViewHolder(binding.root) {
    fun onBind(article: Article) {
        binding.title.text = article.title
        binding.source.text = article.source

        binding.articleImage.load(article.urlToImage ?: "") {
            crossfade(true)
            placeholder(org.alexcawl.memorize.core.ui.R.drawable.baseline_newspaper_24)
            error(org.alexcawl.memorize.core.ui.R.drawable.baseline_newspaper_24)
        }
    }
}

