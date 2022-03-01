package android.receiptsproducts.viewmodels

import android.receiptsproducts.models.Product
import androidx.lifecycle.ViewModel

class ProductListViewModel: ViewModel() {
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

    fun addProduct(
        productName:String,
        productCost:Int,
        productCalories:Int
    ){
       val product = Product(
           productName,
           productCost,
           productCalories)

        products.add(product)
    }
}