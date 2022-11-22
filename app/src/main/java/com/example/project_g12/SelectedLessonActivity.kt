package com.example.project_g12

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g12.databinding.ActivitySelectedLessonBinding

class SelectedLessonActivity : AppCompatActivity() {
    lateinit var binding: ActivitySelectedLessonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySelectedLessonBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var data = DataSource.getInstance()

        if (data != null) {
            binding.tvCourseHeader.text = "${data.selectedLesson?.position}. ${data.selectedLesson?.name}"
            binding.tvCourseDetails.text = data.selectedLesson?.description ?: "None"
            binding.tvCourseDuration.text = "${data.selectedLesson?.fromMinutesToHHmm()} minutes"
            binding.tvUserNameHeader.text = data.user.userName
            binding.edtNotes.setText(data.selectedLesson?.note ?: "none")
        }

        binding.btnComplete.setOnClickListener {
            data.selectedLesson?.isComplete = true ?: false
            var intent = Intent(this,MainMenuActivity::class.java)
            startActivity(intent)
        }
        binding.btnSaveNote.setOnClickListener {
            data.selectedLesson?.note = binding.edtNotes.text.toString()
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
            finish();
            startActivity(intent);
        }
        binding.btnWatchVideo.setOnClickListener {
            val websiteAddressFromUI = data.selectedLesson?.url
            val uriToOpen: Uri = Uri.parse(websiteAddressFromUI)
            val intent: Intent = Intent(Intent.ACTION_VIEW,uriToOpen)
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else {
                Log.d("IMP_INTENT","Cannot open website")
            }
        }
    }
}