package android.receiptsproducts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var productsButton:Button
    private lateinit var receiptsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productsButton = findViewById(R.id.go_to_products_button)
        receiptsButton = findViewById(R.id.go_to_receipts_button)

    }
}