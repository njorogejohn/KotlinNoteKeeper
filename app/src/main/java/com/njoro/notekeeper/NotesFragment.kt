package com.njoro.notekeeper

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.njoro.notekeeper.databinding.FragmentNotesBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private lateinit var mContext: Context

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_NotesFragment_to_AddNoteFragment)
        }

        binding.recyclerviewNotes.layoutManager = LinearLayoutManager(mContext)

        binding.recyclerviewNotes.adapter = NoteAdapter(mContext,this, DataManager.notes)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onResume() {
        super.onResume()
        binding.recyclerviewNotes.adapter?.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}