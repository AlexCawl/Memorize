package org.alexcawl.memorize.newsline.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import org.alexcawl.memorize.newsline.R
import org.alexcawl.memorize.newsline.databinding.LayoutArticleBinding
import org.alexcawl.memorize.newsline.domain.Article
import org.alexcawl.memorize.ui.DelegateAdapter
import org.alexcawl.memorize.ui.DelegateAdapterItem

class ArticleDelegateAdapter : DelegateAdapter<Article, ArticleDelegateAdapter.ArticleViewHolder>(Article::class.java) {
    inner class ArticleViewHolder(
        private val binding: LayoutArticleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
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

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutArticleBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Article, viewHolder: ArticleViewHolder, payloads: List<DelegateAdapterItem.Payload>
    ) = viewHolder.onBind(model)
}