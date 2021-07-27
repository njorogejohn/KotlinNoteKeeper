package com.njoro.notekeeper

data class CourseInfo(val courseId: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

data class NoteInfo(var course: CourseInfo? = null, var title: String? = null, var body: String? = null)