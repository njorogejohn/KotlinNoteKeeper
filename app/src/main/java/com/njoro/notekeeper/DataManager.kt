package com.njoro.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeNotes() {
        var note = NoteInfo(courses["android_async"]!!,"Async Meaning","Async means running without interrupting the main thread, i.e. in a non-blocking way")
        notes.add(note)

        note = NoteInfo(courses["android_intents"]!!, "Intents Meaning","Intents are used for inter-activity communication and allow for data passing.")
        notes.add(note)

        note = NoteInfo(courses["java_lang"]!!,"Java Tip","Java is not a syntactically typed language")
        notes.add(note)

        note = NoteInfo(courses["java_core"]!!, "Java Core Tip","For Java to run you need a runtime environment. Correct?")
        notes.add(note)

        note = NoteInfo(courses["android_async"], "Retrofit", "Used for async network calls")
        notes.add(note)

        note = NoteInfo(courses["android_intents"],"Intents with NavGraph","Check out the passing of data between fragments when using intents")
        notes.add(note)
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses[course.courseId] = course

        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo("java_lang","Java Fundamentals: The Java Language")
        courses[course.courseId] = course

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses[course.courseId] = course

    }
}