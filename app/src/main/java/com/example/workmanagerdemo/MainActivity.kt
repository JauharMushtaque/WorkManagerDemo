package com.example.workmanagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val constraints: Constraints = Constraints.Builder().setRequiresCharging(true).build()
        val workRequest: WorkRequest =
            OneTimeWorkRequest.Builder(MyWorker::class.java).setConstraints(constraints).build()

        findViewById<Button>(R.id.buttonEnqueue).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                WorkManager.getInstance().enqueue(workRequest)
            }
        })
    }
}