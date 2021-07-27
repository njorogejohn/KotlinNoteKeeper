package com.njoro.notekeeper

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.njoro.notekeeper.databinding.FragmentAddNoteBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    val args: AddNoteFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var  mContext: Context
    private lateinit var arrayAdapter: ArrayAdapter<CourseInfo>
    private var notePosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrayAdapter = ArrayAdapter<CourseInfo>(mContext,
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toMutableList())
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        notePosition = args.notePosition

    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]

        binding.textNoteTitle.setText(note.title)
        binding.textNoteText.setText(note.body)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        binding.spinnerCourses.setSelection(coursePosition)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinnerCourses.adapter = arrayAdapter

        if (notePosition != -1){
            displayNote()
        }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}