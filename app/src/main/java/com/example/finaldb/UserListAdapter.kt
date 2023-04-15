package com.example.finaldb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldb.entities.UserInfo

class UserListAdapter : ListAdapter<UserInfo, UserListAdapter.UserViewHolder>(UserInfoComparator()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder.create(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.firstName, current.middleName, current.lastName)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userItemView = itemView.findViewById<TextView>(R.id.firstName_et)
        private val userItemView1 = itemView.findViewById<TextView>(R.id.middleName_et)
        private val userItemView2 = itemView.findViewById<TextView>(R.id.lastName_et)

        fun bind(firstName: String?, middleName: String?, lastName: String?) {
            userItemView?.text = firstName
            userItemView1?.text = middleName
            userItemView2?.text = lastName
        }

        companion object {
            fun create(parent: ViewGroup): UserViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return UserViewHolder(view)
            }
        }
    }

        class UserInfoComparator : DiffUtil.ItemCallback<UserInfo>() {
            override fun areItemsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
                return oldItem.firstName == newItem.firstName &&
                oldItem.middleName == newItem.middleName &&
                oldItem.lastName == newItem.lastName
            }
        }
    }
