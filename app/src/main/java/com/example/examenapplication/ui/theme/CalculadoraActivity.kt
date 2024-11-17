package com.example.examenapplication.ui.theme

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenapplication.R

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var txtBase: EditText
    private lateinit var txtAltura: EditText
    private lateinit var txtArea: EditText
    private lateinit var txtPerimetro: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnRegresar: Button
    private lateinit var btnLimpiar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarComponentes()
        eventoClic()
    }

    private fun iniciarComponentes() {
        txtBase = findViewById(R.id.txtBase)
        txtAltura = findViewById(R.id.txtAltura) // Corregido el identificador
        txtArea = findViewById(R.id.txtArea)
        txtPerimetro = findViewById(R.id.txtPerimetro)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)
    }

    private fun eventoClic() {

        btnCalcular.setOnClickListener {
            val base = txtBase.text.toString()
            val altura = txtAltura.text.toString()

            if (base.isEmpty() || altura.isEmpty()) {
                Toast.makeText(this, "Falto capturar información", Toast.LENGTH_LONG).show()
            } else {
                try {
                    val baseValue = base.toDouble()
                    val alturaValue = altura.toDouble()


                    val area = baseValue * alturaValue
                    val perimetro = 2 * (baseValue + alturaValue)


                    txtArea.setText(area.toString())
                    txtPerimetro.setText(perimetro.toString())

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor ingrese valores numéricos válidos", Toast.LENGTH_LONG).show()
                }
            }
        }

        btnLimpiar.setOnClickListener {
            txtBase.text.clear()
            txtAltura.text.clear()
            txtArea.text.clear()
            txtPerimetro.text.clear()
        }


        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
