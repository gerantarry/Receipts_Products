package android.receiptsproducts

import android.app.Activity
import android.os.Bundle
import android.receiptsproducts.adapters.ProductsAdapter
import android.receiptsproducts.viewmodels.ProductListActivityViewModel
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val TAG ="ProductListActivity"

class ProductListActivity : Activity(), ViewModelStoreOwner {

    //lazy - отложенная инициализация через механизм делегатов.
    // Инициализация требует вычислений, которые желательно не выполнять если их результат никогда не будет использован
    private val productListViewModelStore:ViewModelStore by lazy {
        ViewModelStore()
    }
    private val productListActivityViewModel: ProductListActivityViewModel by lazy {
        ViewModelProvider(this)[ProductListActivityViewModel::class.java]
    }
    private lateinit var productRecyclerView: RecyclerView
    private lateinit var addButton:FloatingActionButton
    private var productsAdapter:ProductsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        Log.d(TAG, "Total products ${productListActivityViewModel.products.size}")

        addButton = findViewById(R.id.add_product_fab)
        productRecyclerView = findViewById(R.id.products_recycler_view)

        updateUI()
    }
    //give the adapter new product list
    private fun updateUI() {
        val products = productListActivityViewModel.products
        productRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ProductListActivity)
            productsAdapter = ProductsAdapter(products)
            adapter = productsAdapter
        }
    }

    override fun getViewModelStore(): ViewModelStore {
        return productListViewModelStore
    }
}