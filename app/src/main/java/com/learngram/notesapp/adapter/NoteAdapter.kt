package com.learngram.notesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.learngram.notesapp.databinding.NoteLayoutBinding
import com.learngram.notesapp.fragments.HomeFragmentDirections
import com.learngram.notesapp.model.Note

class NoteAdapter:RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val itemBinding:NoteLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback= object :DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteDesc == newItem.noteDesc &&
                    oldItem.noteTitle == newItem.noteTitle
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
        val differ=AsyncListDiffer(this@NoteAdapter,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
   return NoteViewHolder(
       NoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
   )
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val curentNote=differ.currentList[position]

        holder.itemBinding.noteTitle.text=curentNote.noteTitle
        holder.itemBinding.noteDesc.text=curentNote.noteDesc

        holder.itemView.setOnClickListener{
            val direction=HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(curentNote)
            it.findNavController().navigate(direction)
    }

}
}