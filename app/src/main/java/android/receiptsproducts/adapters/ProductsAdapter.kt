package android.receiptsproducts.adapters

import android.receiptsproducts.R
import android.receiptsproducts.models.Product
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "ProductsAdapter"

class ProductsAdapter(
    var products: List<Product>
) :
    RecyclerView.Adapter<ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item_view, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

}


class ProductHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private lateinit var product: Product

    private val productNameTextView: TextView = this.itemView.findViewById(R.id.product_name)
    private val productCaloriesTextView: TextView =
        this.itemView.findViewById(R.id.product_kilocalories)
    private val productCostTextView: TextView = this.itemView.findViewById(R.id.product_cost)

    fun bind(product: Product) {
        this.product = product
        productNameTextView.text = this.product.name
        productCaloriesTextView.text = this.product.kilocalories.toString()
        productCostTextView.text = this.product.cost.toString()
    }

    override fun onClick(itemView: View) {
        Toast.makeText(itemView.context, "${product.name} pressed!", Toast.LENGTH_SHORT)
            .show()
    }

}