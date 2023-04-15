package com.example.finaldb

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var editUserView: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        editUserView = findViewById(R.id.firstName_et)
        editUserView = findViewById(R.id.lastName_et)
        editUserView = findViewById(R.id.middleName_et)




        val btn = findViewById<Button>(R.id.btn_add)
        btn.setOnClickListener {
            if (TextUtils.isEmpty(editUserView.text)){
                setResult(RESULT_CANCELED, intent)
            } else{
                val word = editUserView.text.toString()
                intent.putExtra(EXTRA_REPLY, word)
                setResult(RESULT_OK, intent)
            }
            finish()
        }
    }
    companion object{
        const val EXTRA_REPLY = "com.example.android.userlistsql.REPLY"
    }


}