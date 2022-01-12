package com.example.workmanagerdemo1

import android.content.Context
import android.content.ContextParams
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/12/22.
 */

class CompressingWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        try {
            for (i in 0..3000) {
                Log.i("MYTAG", "Compressing $i")
            }
            return Result.success()
        }catch (e: Exception) {
            return Result.failure()
        }

    }
}