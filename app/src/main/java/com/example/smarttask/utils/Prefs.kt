package com.example.smarttask.utils
import android.content.Context
import com.example.smarttask.model.Tarefa
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class Prefs(context: Context) {
    private val prefs =
        context.getSharedPreferences("tarefas", Context.MODE_PRIVATE)
    fun salvar(lista: MutableList<Tarefa>) {
        val json = Gson().toJson(lista)
        prefs.edit().putString("lista", json).apply()
    }
    fun carregar(): MutableList<Tarefa> {
        val json = prefs.getString("lista", null)
        return if (json != null) {
            val tipo = object : TypeToken<MutableList<Tarefa>>() {}.type
            Gson().fromJson(json, tipo)
        } else {
            mutableListOf()
        }
    }
}