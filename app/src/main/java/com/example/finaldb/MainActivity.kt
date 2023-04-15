package com.example.finaldb

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldb.entities.UserInfo


class MainActivity : AppCompatActivity() {

        private val userRegisterActivityRequestCode = 1
        private val userViewModel: UserViewModel by viewModels {
                UserViewModelFactory((application as UserApplication).repository)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
                val adapter = UserListAdapter()
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)

                userViewModel.allUser.observe(this, Observer { users ->
                        users?.let { adapter.submitList(it) }
                })



                val newbtn = findViewById<Button>(R.id.newbtn)
                newbtn.setOnClickListener {
                        val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                        startActivityForResult(intent, userRegisterActivityRequestCode)
                }


        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, intentdata: Intent?) {
                super.onActivityResult(requestCode, resultCode, intentdata)

                if (requestCode == userRegisterActivityRequestCode && resultCode == Activity.RESULT_OK){
                intentdata?.getStringExtra(RegisterActivity.EXTRA_REPLY)?.let {
                        val userInfo = UserInfo(
                                userId = 0,
                                firstName = "",
                                lastName = "",
                                middleName = ""
                                )
                        userViewModel.insert(userInfo)
                }
        } else {
                Toast.makeText(
                        applicationContext,
                        R.string.empty_not_saved,
                        Toast.LENGTH_LONG
                ).show()
                }
}
}
