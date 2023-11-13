package org.alexcawl.memorize.network.mapper

import org.alexcawl.memorize.common.OneWayMapper
import org.alexcawl.memorize.common.model.ArticleModel
import org.alexcawl.memorize.network.dto.article.ArticleDTO
import java.util.UUID

object ArticleMapper : OneWayMapper<ArticleDTO, ArticleModel> {
    override fun map(from: ArticleDTO): ArticleModel {
        return with(from) {
            ArticleModel(
                UUID.randomUUID(),
                title,
                url,
                source.name,
                publishedAt,
                urlToImage,
                author,
                content,
                description
            )
        }
    }
}