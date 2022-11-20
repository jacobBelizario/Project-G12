package com.example.project_g12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.project_g12.databinding.ItemLessonListBinding

class LessonListAdapter(context: Context, var dataSource: ArrayList<Lesson>):
    ArrayAdapter<Lesson>(context,0,dataSource) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val currentLesson = dataSource[position]
        var lessonListBinding = ItemLessonListBinding.inflate(
            LayoutInflater.from(context),
            parent,false)
        var lessonItemView = lessonListBinding.root

        if(currentLesson != null) {
            lessonListBinding.tvCourseDetails.append("")
        }
        return lessonItemView
    }
}