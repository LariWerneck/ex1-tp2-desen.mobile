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
import com.example.appduastelas.model.Produto
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtNomeProduto = findViewById<EditText>(R.id.edt_nome_produto)
        val edtPrecoProduto = findViewById<EditText>(R.id.edt_preco_produto)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)


        var produto = Produto("Sem Produto", 0.0)

        btnCadastrar.setOnClickListener {
            val nome = edtNomeProduto.text.toString()
            val preco = edtPrecoProduto.text.toString().toDouble()
            produto = Produto(nome, preco)
            alertaSucesso()
            edtNomeProduto.text.clear()
            edtPrecoProduto.text.clear()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, ProdutoActivity::class.java)
            intent.putExtra("nomeProduto", produto.nomeProduto)
            intent.putExtra("precoProduto", produto.precoProduto.toString())
            startActivity(intent)
        }

    }
    fun alertaSucesso(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sucesso!")
        builder.setMessage("Produto cadastrado com sucesso!")
        val alert = builder.create()
        alert.show()
    }


}