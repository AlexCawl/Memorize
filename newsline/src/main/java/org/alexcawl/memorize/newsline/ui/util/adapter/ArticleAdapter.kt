package org.alexcawl.memorize.newsline.ui.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import org.alexcawl.memorize.common.ArticleModel
import org.alexcawl.memorize.newsline.R
import org.alexcawl.memorize.newsline.databinding.LayoutArticleBinding
import org.alexcawl.memorize.ui.delegates.DelegateAdapter
import org.alexcawl.memorize.ui.delegates.DelegateViewHolder

object ArticleAdapter : DelegateAdapter<ArticleModel, ArticleAdapter.ArticleViewHolder>(
    ArticleModel::class.java
) {
    class ArticleViewHolder(
        binding: LayoutArticleBinding
    ) : DelegateViewHolder<ArticleModel, LayoutArticleBinding>(binding) {
        override fun onBind(model: ArticleModel) {
            binding.title.text = model.title.trim()
            binding.source.text = model.source.trim()

            binding.articleImage.load(model.urlToImage ?: "") {
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

    override fun bindViewHolder(model: ArticleModel, viewHolder: ArticleViewHolder) =
        viewHolder.onBind(model)
}