package com.example.workmanagerdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.workmanagerdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.main = this
    }

     fun setOneTimeWorkRequest() {
         val workManager = WorkManager.getInstance(applicationContext)
         val constraints = Constraints.Builder()
             .setRequiresCharging(true)
             .build()

         val oneTimeWorkRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
             .setConstraints(constraints)
             .build()
         workManager.enqueue(oneTimeWorkRequest)
         workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
             .observe(this, Observer {
                 binding.textView.text = it.state.name.toString()
             })


    }
}