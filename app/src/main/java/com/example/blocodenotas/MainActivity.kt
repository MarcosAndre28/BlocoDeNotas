package com.example.blocodenotas

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.blocodenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencia = PreferenciaAnotacao(applicationContext)

        val botaoSalvar = binding.fab


        botaoSalvar.setOnClickListener {

            val antacaoRecuperado = binding.editConteiner.editAnotacao.text.toString()

            if (antacaoRecuperado == ""){

                Toast.makeText(this,"Digite alguma coisa..." , Toast.LENGTH_SHORT).show()

            }else{

                preferencia.SalvarAnotacao(antacaoRecuperado)

                Toast.makeText(this,"Anotação Salva com Sucesso.." , Toast.LENGTH_SHORT).show()
            }

        }

        val anotacao = preferencia.RecuperaAnotacao()
        if (anotacao != ""){

            binding.editConteiner.editAnotacao.setText(anotacao)

        }


    }
}