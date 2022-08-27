package com.example.githubusers.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter():RecyclerView.Adapter<UsersAdapter.UsersHolderView>() {


    inner class UsersHolderView(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolderView {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UsersHolderView, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}