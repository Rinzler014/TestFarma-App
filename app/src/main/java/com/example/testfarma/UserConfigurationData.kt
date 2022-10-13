package com.example.testfarma

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class UserConfigurationData : Fragment() {
    //Instance of Firebase DataBase
    private val database = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_configuration_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userUID = FirebaseAuth.getInstance().currentUser?.uid.toString()
        val userNameTitle = view.findViewById<TextView>(R.id.config_user)
        val userName = view.findViewById<EditText>(R.id.field_username_input_edit)
        val personalName = view.findViewById<EditText>(R.id.field_personal_name_input_edit)
        val lastName = view.findViewById<EditText>(R.id.field_personal_lastname_input_edit)
        val momLastName = view.findViewById<EditText>(R.id.field_personal_momlastname_input_edit)
        val mail = view.findViewById<EditText>(R.id.field_mail_input_edit)

        val updateButton = view.findViewById<Button>(R.id.update_button)

        database.child(userUID).child("username").get().addOnSuccessListener {
            userNameTitle.text = it.value.toString()

        }.addOnFailureListener{

            Log.e("MAIN", "Error getting username title", it)
            userNameTitle.text = getString(R.string.error_label_text)
        }

        database.child(userUID).child("username").get().addOnSuccessListener {

            userName.hint = it.value.toString()

        }.addOnFailureListener {

            Log.w("MAIN", "Error getting username")
            userName.hint = getString(R.string.error_label_text)

        }

        database.child(userUID).child("name").get().addOnSuccessListener {

            personalName.hint = it.value.toString()

        }.addOnFailureListener {

            Log.w("MAIN", "Error getting name")
            personalName.hint = getString(R.string.error_label_text)

        }

        database.child(userUID).child("lastname").get().addOnSuccessListener {

            lastName.hint = it.value.toString()

        }.addOnFailureListener {

            Log.w("MAIN", "Error getting username")
            lastName.hint = getString(R.string.error_label_text)

        }

        database.child(userUID).child("mom_lastname").get().addOnSuccessListener {

            momLastName.hint = it.value.toString()

        }.addOnFailureListener {

            Log.w("MAIN", "Error getting username")
            momLastName.hint = getString(R.string.error_label_text)

        }

        database.child(userUID).child("mail").get().addOnSuccessListener {

            mail.hint = it.value.toString()

        }.addOnFailureListener {

            Log.w("MAIN", "Error getting username")
            mail.hint = getString(R.string.error_label_text)

        }

        updateButton.setOnClickListener {

            if (userName.text.isNotEmpty()) {
                database.child(userUID).child("username").setValue(userName.text.toString())
            }
            if (personalName.text.isNotEmpty()) {
                database.child(userUID).child("name").setValue(personalName.text.toString())
            }
            if (lastName.text.isNotEmpty()) {
                database.child(userUID).child("lastname").setValue(lastName.text.toString())
            }
            if (momLastName.text.isNotEmpty()) {
                database.child(userUID).child("mom_lastname").setValue(momLastName.text.toString())
            }

            val intent = Intent(context, PopUpWindow::class.java)
            intent.putExtra("popuptitle", getString(R.string.updated_user_data_title))
            intent.putExtra("popuptext", getString(R.string.updated_user_data_message))
            intent.putExtra("popupbtn", getString(R.string.ok_label))
            intent.putExtra("darkstatusbar", false)
            startActivity(intent)

        }

    }

}