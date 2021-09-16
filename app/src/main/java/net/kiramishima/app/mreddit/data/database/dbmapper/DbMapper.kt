package net.kiramishima.app.mreddit.data.database.dbmapper

import net.kiramishima.app.mreddit.data.database.model.PostDbModel
import net.kiramishima.app.mreddit.domain.model.PostModel

interface DbMapper {

  fun mapPost(dbPostDbModel: PostDbModel): PostModel

  fun mapDbPost(postModel: PostModel): PostDbModel
}