package com.fadhiil2010.klinik_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.klinik_app.adapter.AdapterMenuIcon
import com.fadhiil2010.klinik_app.model.ModelIcon

class Doctors : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var iconAdapter: AdapterMenuIcon
    private var itemList = mutableListOf<ModelIcon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctors)

        val ActButton1 = findViewById<TextView>(R.id.tvKembali)
        ActButton1.setOnClickListener {
            val Intent = Intent(this, SignIn::class.java)
            startActivity(Intent)
        }


        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.rvCardiologyst)

        // Inisialisasi Adapter dengan fungsi onClick di item
        iconAdapter = AdapterMenuIcon(this, itemList) { position ->
            // Menampilkan dialog gambar detail ketika item di-klik
            showDetailDialog(position)
        }

        // Set LayoutManager untuk RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = iconAdapter

        // Menyiapkan item untuk RecyclerView
        prepareItemList()

        // Menangani window insets (padding untuk status bar dll.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareItemList() {
        // Tambahkan logika untuk mempersiapkan item yang akan ditampilkan
        // Contoh:
        itemList.add(ModelIcon(R.drawable.icontooth, "Dentist" ))
        itemList.add(ModelIcon(R.drawable.iconeye, "Cardiologyst"))
        itemList.add(ModelIcon(R.drawable.iconheart, "Cardiologyst"))

        // Update Adapter setelah item ditambahkan
        iconAdapter.notifyDataSetChanged()
    }

    private fun showDetailDialog(position: Int) {
        // Implementasi untuk menampilkan detail dialog
        // Misalnya, bisa menggunakan AlertDialog atau custom dialog
    }
}
