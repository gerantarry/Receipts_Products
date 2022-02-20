package android.receiptsproducts

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ProductListViewModel: ViewModel() {
    val products = mutableListOf<Product>()

    init {
        for (i in 0 until 50){
            val product = Product(
                "Product #$i",
                 i*3+72,
                i*2+i)
            products += product
        }
    }
}