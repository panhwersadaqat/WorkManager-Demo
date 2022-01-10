package com.example.workmanagerdemo1

import android.content.Context
import android.content.ContextParams
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/10/22.
 */

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        try {
            for (i in 0..6000) {
                Log.i("MYTAG", "Uploading $i")
            }
            return Result.success()
        }catch (e: Exception) {
            return Result.failure()
        }

    }
}