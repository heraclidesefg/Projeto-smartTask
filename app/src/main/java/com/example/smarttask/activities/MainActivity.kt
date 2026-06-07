package com.example.smarttask.activities

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smarttask.R
import com.example.smarttask.adapter.TarefaAdapter
import com.example.smarttask.model.Tarefa
import com.example.smarttask.utils.Prefs

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var editTarefa: EditText
    private lateinit var btnAdicionar: Button
    private lateinit var adapter: TarefaAdapter
    private lateinit var prefs: Prefs

    private var lista = mutableListOf<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recyclerTarefas)
        editTarefa = findViewById(R.id.editTarefa)
        btnAdicionar = findViewById(R.id.btnAdicionar)

        prefs = Prefs(this)

        lista = prefs.carregar()

        adapter = TarefaAdapter(

            lista,

            onDelete = { position ->

                lista.removeAt(position)

                prefs.salvar(lista)

                adapter.notifyDataSetChanged()
            },

            onEdit = { position ->

                val editText = EditText(this)

                editText.setText(lista[position].titulo)

                AlertDialog.Builder(this)
                    .setTitle("Editar Tarefa")
                    .setView(editText)

                    .setPositiveButton("Salvar") { _, _ ->

                        val novoTexto = editText.text.toString().trim()

                        if (novoTexto.isNotEmpty()) {

                            lista[position].titulo = novoTexto

                            prefs.salvar(lista)

                            adapter.notifyItemChanged(position)
                        }
                    }

                    .setNegativeButton("Cancelar", null)

                    .show()
            }
        )

        recycler.layoutManager = LinearLayoutManager(this)

        recycler.adapter = adapter

        btnAdicionar.setOnClickListener {

            val texto = editTarefa.text.toString().trim()

            if (texto.isNotEmpty()) {

                lista.add(Tarefa(texto))

                prefs.salvar(lista)

                adapter.notifyItemInserted(lista.size - 1)

                editTarefa.text.clear()
            }
        }
    }
}