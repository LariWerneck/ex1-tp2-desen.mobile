package com.example.appduastelas.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appduastelas.R
import com.example.appduastelas.model.Livro
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.jvm.java

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtTituloLivro = findViewById<EditText>(R.id.edt_titulo_livro)
        val edtAutorLivro = findViewById<EditText>(R.id.edt_autor_livro)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)

        var livro = Livro("Sem Título", "Sem Autor")

        btnCadastrar.setOnClickListener {
            val titulo = edtTituloLivro.text.toString()
            val autor = edtAutorLivro.text.toString()
            livro = Livro(titulo, autor)
            alertaSucesso()
            edtTituloLivro.text.clear()
            edtAutorLivro.text.clear()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, LivroActivity::class.java)
            intent.putExtra("tituloLivro", livro.tituloLivro)
            intent.putExtra("autorLivro", livro.autorLivro)
            startActivity(intent)
        }

    }

    fun alertaSucesso(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sucesso!")
        builder.setMessage("Livro cadastrado com sucesso!")
        val alert = builder.create()
        alert.show()
    }
}
