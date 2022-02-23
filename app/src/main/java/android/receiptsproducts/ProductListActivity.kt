package android.receiptsproducts

import android.app.Activity
import android.os.Bundle
import android.receiptsproducts.adapters.ProductsAdapter
import android.receiptsproducts.viewmodels.ProductListActivityViewModel
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

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
    private var productsAdapter:ProductsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        Log.d(TAG, "Total products ${productListActivityViewModel.products.size}")
        productRecyclerView = findViewById(R.id.products_recycler_view)
        updateUI()
    }
    //обновляем адаптер новым списком продуктов
    private fun updateUI() {
        val products = productListActivityViewModel.products
        productsAdapter = ProductsAdapter(applicationContext,products)
        productRecyclerView.adapter = productsAdapter
    }

    override fun getViewModelStore(): ViewModelStore {
        return productListViewModelStore
    }
}