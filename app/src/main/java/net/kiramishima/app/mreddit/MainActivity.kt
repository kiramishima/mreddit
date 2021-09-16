package net.kiramishima.app.mreddit

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import net.kiramishima.app.mreddit.viewmodel.MainViewModel
import net.kiramishima.app.mreddit.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        MainViewModelFactory(
            this,
            (application as MRedditApplication).dependencyInjector.repository
        )
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MRedditApp(viewModel)
        }
    }
}