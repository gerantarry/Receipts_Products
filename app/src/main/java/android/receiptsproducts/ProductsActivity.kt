package android.receiptsproducts

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsActivity : Activity() {

   lateinit var productRecyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        productRecyclerView = findViewById(R.id.products_recycler_view)
    }

    private inner class ProductHolder(view: View):RecyclerView.ViewHolder(view){
        private lateinit var product:Product

        val productNameTextView:TextView = itemView.findViewById(R.id.product_name)
        val productCaloriesTextView:TextView = itemView.findViewById(R.id.product_kilocalories)
        val productCostTextView:TextView = itemView.findViewById(R.id.product_cost)

    }
}