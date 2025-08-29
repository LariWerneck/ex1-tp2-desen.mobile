package com.example.appduastelas.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appduastelas.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LivroActivity : AppCompatActivity(R.layout.activity_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvTituloLivro = findViewById<TextView>(R.id.txv_titulo_livro)
        val txvAutorLivro = findViewById<TextView>(R.id.txv_autor_livro)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_volta)

        txvTituloLivro.text = intent.getStringExtra("tituloLivro")
        txvAutorLivro.text = intent.getStringExtra("autorLivro")

        fabVoltar.setOnClickListener {
            finish()
        }
    }
}
