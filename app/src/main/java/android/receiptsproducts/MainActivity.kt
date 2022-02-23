package android.receiptsproducts

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {
    private lateinit var productsButton:Button
    private lateinit var receiptsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productsButton = findViewById(R.id.go_to_products_button)
        receiptsButton = findViewById(R.id.go_to_receipts_button)

        productsButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ProductListActivity::class.java)
            startActivity(intent)
        }

    }
}