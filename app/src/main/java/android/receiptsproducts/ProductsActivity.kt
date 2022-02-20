package android.receiptsproducts

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProviders

class ProductsActivity : Activity() {

    lateinit var productRecyclerView: RecyclerView
    private val crimeListViewModel: ProductListViewModel by lazy {
        ViewModelProviders.of(this).get(ProductListViewModel::class.java)
    } //TODO добавить нужную зависимость

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        productRecyclerView = findViewById(R.id.products_recycler_view)
    }

    private fun updateUI(){

    }

    private inner class ProductAdapter(var products: List<Product>): RecyclerView.Adapter<ProductHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
            val view = layoutInflater.inflate(R.layout.product_item_view, parent, false)
            return ProductHolder(view)
        }

        override fun onBindViewHolder(holder: ProductHolder, position: Int) {
            val product = products[position]
            holder.bind(product)
        }

        override fun getItemCount(): Int {
            return 0
        }
    }

    private inner class ProductHolder(view: View):
        RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var product: Product

        val productNameTextView: TextView = itemView.findViewById(R.id.product_name)
        val productCaloriesTextView: TextView = itemView.findViewById(R.id.product_kilocalories)
        val productCostTextView: TextView = itemView.findViewById(R.id.product_cost)

        fun bind(product: Product) {
            this.product = product
            productNameTextView.text = this.product.name
            productCaloriesTextView.text = this.product.kilocalories.toString()
            productCostTextView.text = this.product.cost.toString()
        }

        override fun onClick(v: View) {
            Toast.makeText(applicationContext, "${product.name} pressed!", Toast.LENGTH_SHORT)
                .show()
        }

    }
}