package android.receiptsproducts.adapters

import android.content.Context
import android.receiptsproducts.R
import android.receiptsproducts.models.Product
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(
    val applicationContext:Context,
    var products: List<Product>):
    RecyclerView.Adapter<ProductHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
       // val view = inflate(R.layout.product_item_view, parent, false)
        val view = inflate(applicationContext,R.layout.product_item_view,parent)
        return ProductHolder(applicationContext,view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

}


class ProductHolder(val applicationContext: Context, view: View):
    RecyclerView.ViewHolder(view), View.OnClickListener {
    private lateinit var product: Product

    private val productNameTextView: TextView = itemView.findViewById(R.id.product_name)
    private val productCaloriesTextView: TextView = itemView.findViewById(R.id.product_kilocalories)
    private val productCostTextView: TextView = itemView.findViewById(R.id.product_cost)

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