package com.example.quizpemro3

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.LayoutInflaterCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.quizpemro3.databinding.ActivityMainBinding
import com.example.quizpemro3.ui.theme.QuizPemro3Theme
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitInstance.getRetrofitInstance().create(LocationService::class.java)

        val responseLiveData: LiveData<Response<Location>> =
            liveData {
                val response = retrofitService.getLocation()
                emit(response)
            }

        responseLiveData.observe(this, Observer {
            val locationList = it.body()?.listIterator()
            if (locationList != null){
                while (locationList.hasNext()){
                    val locationItem = locationList.next()

                    val location = "Location Information : ${locationItem.country_name}," +
                            "${locationItem.country_code3} " +
                            "${locationItem.city}" +
                            "${locationItem.latitude}" +
                            "${locationItem.longitude}"
                    binding.locationTextView.append(location)
                }
            }
        })
    }

}