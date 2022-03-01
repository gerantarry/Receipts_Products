package android.receiptsproducts

import android.os.Bundle
import android.receiptsproducts.adapters.ProductsAdapter
import android.receiptsproducts.dialogs.AddProductToListDialog
import android.receiptsproducts.dialogs.OnInputListener
import android.receiptsproducts.viewmodels.ProductListViewModel
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.NumberFormatException

private const val TAG ="ProductListActivity"

class ProductListActivity : FragmentActivity(), ViewModelStoreOwner, OnInputListener {

    //lazy - отложенная инициализация через механизм делегатов.
    // Инициализация требует вычислений, которые желательно не выполнять если их результат никогда не будет использован

    //vars
    private val productListViewModelStore:ViewModelStore by lazy {
        ViewModelStore()
    }
    private val productListViewModel: ProductListViewModel by lazy {
        ViewModelProvider(this)[ProductListViewModel::class.java]
    }

    //widgets
    private lateinit var productRecyclerView: RecyclerView
    private lateinit var addButton:FloatingActionButton
    private var productsAdapter:ProductsAdapter? = null

    override fun getViewModelStore(): ViewModelStore {
        return productListViewModelStore
    }

    /**
     * send input to create and add product
     * to productListViewModel
     */
    override fun sendInput(inputName:String, intInput:HashMap<String,Int>) {
        Log.d(TAG,"sendInput: $inputName, $intInput")

        productListViewModel.addProduct(
            inputName,
            intInput.getValue("cost"),
            intInput.getValue("calories")
        )
        updateUI()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        Log.d(TAG, "Total products ${productListViewModel.products.size}")

        addButton = findViewById(R.id.add_product_fab)
        productRecyclerView = findViewById(R.id.products_recycler_view)

        addButton.setOnClickListener {
            Log.d(TAG, "OnClick: Opening dialog")

            val dialog = AddProductToListDialog()
            dialog.show(supportFragmentManager, "AddProductToListDialog")
        }
        updateUI()
    }

    //give the adapter new product list
    private fun updateUI() {
        val products = productListViewModel.products
        productRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ProductListActivity)
            productsAdapter = ProductsAdapter(products)
            adapter = productsAdapter
        }
    }
}