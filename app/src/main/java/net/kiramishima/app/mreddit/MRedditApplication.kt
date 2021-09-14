package net.kiramishima.app.mreddit

import android.app.Application
import net.kiramishima.app.mreddit.dependencyinjection.DependencyInjector

class MRedditApplication : Application() {

  lateinit var dependencyInjector: DependencyInjector

  override fun onCreate() {
    super.onCreate()
    initDependencyInjector()
  }

  private fun initDependencyInjector() {
    dependencyInjector = DependencyInjector(this)
  }
}