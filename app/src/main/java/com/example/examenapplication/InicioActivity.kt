package com.example.examenapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenapplication.ui.theme.CalculadoraActivity

class InicioActivity : AppCompatActivity() {

    private lateinit var btnEntrar: Button
    private lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        // Ajustar los paddings de la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar componentes
        iniciarComponentes()

        // Asignar eventos de clic a los botones
        eventosClic()
    }

    private fun iniciarComponentes() {
        btnEntrar = findViewById(R.id.btnEntrar)
        btnSalir = findViewById(R.id.btnSalir)
    }

    private fun eventosClic() {
        btnEntrar.setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }

        btnSalir.setOnClickListener {
            finish() // Cierra la actividad actual
        }
    }
}
