package com.example.githubusers.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.databinding.ItemListRvBinding
import com.example.githubusers.model.UserDto
import com.example.githubusers.repository.OnItemClick
import com.example.githubusers.utils.loadImage

class UsersAdapter(
    private val onItemClick: OnItemClick,
) : RecyclerView.Adapter<UsersAdapter.UsersHolderView>() {
    var user: List<UserDto> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class UsersHolderView(
        private val binding: ItemListRvBinding,
        private val onItemClick: OnItemClick,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserDto) = with(binding) {
            tvUsers.text = item.login
            ImageUsers.loadImage(item.avatar_url)
            tvUsers.setOnClickListener {
                onItemClick.onClick(item.login)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolderView {
        val binding = ItemListRvBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UsersHolderView(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: UsersHolderView, position: Int) {
        holder.bind(user[position])
    }

    override fun getItemCount(): Int = user.size

}