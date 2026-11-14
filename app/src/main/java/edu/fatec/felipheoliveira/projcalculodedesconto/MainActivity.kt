package edu.fatec.felipheoliveira.projcalculodedesconto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var editValorCompra: EditText
    private lateinit var btnCalcular: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editValorCompra = findViewById(R.id.editValorCompra)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            calcularDesconto()
        }
    }

    private fun calcularDesconto() {
        val valorTexto = editValorCompra.text.toString()

        if (valorTexto.isEmpty()) {
            txtResultado.text = "Erro: Digite o valor do produto!"
            return
        }

        val valorCompra = valorTexto.toDouble()
        var percentualDesconto = 0.0

        if (valorCompra > 500.0) {
            percentualDesconto = 0.15
        } else if (valorCompra >= 100.0) {
            percentualDesconto = 0.10
        }

        val valorDesconto = valorCompra * percentualDesconto
        val valorFinal = valorCompra - valorDesconto

        if (valorCompra < 100) {
            txtResultado.text = "Valor da Compra foi de: R$ %.2f\n \n".format(valorCompra) +
                    "Nenhum desconto aplicado. O valor do produto não atendeu o mínimo. \n \n"+
                    "Valor final do produto é: R$ %.2f".format(valorFinal)
        }
        else {
            txtResultado.text = "Valor da Compra: R$ %.2f\n".format(valorCompra) +
                    "Desconto Aplicado: %.0f%%\n".format(percentualDesconto * 100) +
                    "Valor Final: R$ %.2f".format(valorFinal)
        }
    }
}