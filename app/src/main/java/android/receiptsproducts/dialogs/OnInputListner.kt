package android.receiptsproducts.dialogs

interface OnInputListener {
    fun sendInput(inputName:String, intInput:HashMap<String,Int>)
}