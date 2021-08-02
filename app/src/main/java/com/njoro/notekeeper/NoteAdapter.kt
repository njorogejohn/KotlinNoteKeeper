package com.njoro.notekeeper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.njoro.notekeeper.databinding.ListNoteItemBinding


class NoteAdapter(private val context: Context, private val fragment: NotesFragment, private val notes: List<NoteInfo>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = ListNoteItemBinding.inflate(layoutInflater,parent,false)
        return NoteViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]

        holder.notePosition = position
        holder.setData(note)

    }

    override fun getItemCount(): Int =  notes.size


    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ListNoteItemBinding.bind(itemView)
        var notePosition = 0

        init {
            itemView.setOnClickListener{
                val action = NotesFragmentDirections.actionNotesFragmentToAddNoteFragment(notePosition)
                findNavController(fragment).navigate(action)
            }
        }

        fun setData(note: NoteInfo){
            binding.tvCourse.text = note.course?.title
            binding.tvNoteTitle.text = note.title
        }
    }

}