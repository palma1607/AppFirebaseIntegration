package br.com.up.appfirebaseintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firestore = FirebaseFirestore.getInstance()
        val collection = firestore.collection("VivianMarcal")
        val documents = collection.document("Mensagens")

        val documentsTask = documents.get()
        documentsTask.addOnCompleteListener { messages ->

            val list = messages.result["listaMensagens"] as ArrayList<Any>
            val item = list[0] as HashMap<String,Any>
            val title = item["titulo"]
            Log.v("App", title.toString())
        }

    }
}