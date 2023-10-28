package org.alexcawl.memorize.newsline.ui

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import org.alexcawl.memorize.newsline.R
import org.alexcawl.memorize.newsline.databinding.LayoutArticleBinding
import org.alexcawl.memorize.newsline.domain.Article

class ArticleViewHolder(
    private val binding: LayoutArticleBinding
) : ViewHolder(binding.root) {
    fun onBind(article: Article) {
        binding.title.text = article.title.trim()
        binding.source.text = article.source.trim()

        binding.articleImage.load(article.urlToImage ?: "") {
            scale(Scale.FILL)
            placeholder(org.alexcawl.memorize.ui.R.drawable.outline_image_not_supported_24)
            error(org.alexcawl.memorize.ui.R.drawable.outline_broken_image_24)
            transformations(
                RoundedCornersTransformation(
                    binding.root.context.resources.getDimension(
                        R.dimen.articles_margin_between
                    )
                )
            )
        }
    }
}

