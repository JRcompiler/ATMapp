package com.example.atmapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var balance = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvBalance = findViewById<TextView>(R.id.tvBalance)
        val etAmount = findViewById<EditText>(R.id.etAmount)
        val btnDeposit = findViewById<Button>(R.id.btnDeposit)
        val btnWithdraw = findViewById<Button>(R.id.btnWithdraw)

        btnDeposit.setOnClickListener {
            val amountText = etAmount.text.toString()
            if (amountText.isNotEmpty()) {
                val amount = amountText.toInt()
                balance += amount
                tvBalance.text = "Bakiye: $balance ₺"
                etAmount.text.clear()
                Toast.makeText(this, "$amount ₺ yatırıldı", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Lütfen bir tutar girin", Toast.LENGTH_SHORT).show()
            }
        }

        btnWithdraw.setOnClickListener {
            val amountText = etAmount.text.toString()
            if (amountText.isNotEmpty()) {
                val amount = amountText.toInt()
                if (amount <= balance) {
                    balance -= amount
                    tvBalance.text = "Bakiye: $balance ₺"
                    etAmount.text.clear()
                    Toast.makeText(this, "$amount ₺ çekildi", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Yetersiz bakiye", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Lütfen bir tutar girin", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
