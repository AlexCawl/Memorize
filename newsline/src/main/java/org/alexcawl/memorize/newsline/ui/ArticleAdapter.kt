package org.alexcawl.memorize.newsline.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import org.alexcawl.memorize.newsline.databinding.LayoutArticleBinding
import org.alexcawl.memorize.newsline.domain.Article

class ArticleAdapter : ListAdapter<Article, ArticleViewHolder>(ArticleCallback()) {
    private companion object {
        class ArticleCallback : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutArticleBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int): Unit =
        holder.onBind(getItem(position))
}