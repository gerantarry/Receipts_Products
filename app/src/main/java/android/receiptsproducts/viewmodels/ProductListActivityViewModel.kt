package android.receiptsproducts.viewmodels

import android.receiptsproducts.models.Product
import androidx.lifecycle.ViewModel

class ProductListActivityViewModel: ViewModel() {
    val products = mutableListOf<Product>()

    init {
        for (i in 1 until 10){
            val product = Product(
                "Product #$i",
                 i*3+72,
                i*2+i)
            products += product
        }
    }

    fun addProduct(product:Product){
        products.add(product)
    }
}