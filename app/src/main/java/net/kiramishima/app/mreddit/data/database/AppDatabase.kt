package net.kiramishima.app.mreddit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import net.kiramishima.app.mreddit.data.database.dao.PostDao
import net.kiramishima.app.mreddit.data.database.model.PostDbModel

/**
 * App's database.
 *
 * It contains a table for posts
 */
@Database(entities = [PostDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

  companion object {
    const val DATABASE_NAME = "m-reddit-database"
  }

  abstract fun postDao(): PostDao
}