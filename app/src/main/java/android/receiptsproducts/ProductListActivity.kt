package android.receiptsproducts

import android.app.Activity
import android.os.Bundle
import android.receiptsproducts.viewmodels.ProductListActivityViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class ProductListActivity : Activity(), ViewModelStoreOwner {

    lateinit var productRecyclerView: RecyclerView
    //lazy - отложенная инициализация через механизм делегатов.
    // Инициализация требует вычислений, которые желательно не выполнять если их результат никогда не будет использован
    private val productListViewModelStore:ViewModelStore by lazy {
        ViewModelStore()
    }
    private val productListActivityViewModel: ProductListActivityViewModel by lazy {
        ViewModelProvider(this)[ProductListActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        productRecyclerView = findViewById(R.id.products_recycler_view)
    }

    private fun updateUI() {

    }

    override fun getViewModelStore(): ViewModelStore {
        return productListViewModelStore
    }
}