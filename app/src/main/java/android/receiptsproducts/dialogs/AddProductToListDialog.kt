package android.receiptsproducts.dialogs

import android.os.Bundle
import android.receiptsproducts.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

private const val TAG = "AddProductToListDialog"

class AddProductToListDialog : DialogFragment() {

    private lateinit var nameInput: EditText
    private lateinit var costInput: EditText
    private lateinit var caloriesInput: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.dialog_add_product_to_list,container,false)
        val mActionOk: TextView = view.findViewById(R.id.action_ok)
        val mActionCancel: TextView = view.findViewById(R.id.action_cancel)

        mActionCancel.setOnClickListener(View.OnClickListener {
            fun onClick(view: View){
                Log.d(TAG,"OnCLick, closing dialog")
                dialog?.dismiss()
            }
        })

        mActionOk.setOnClickListener(View.OnClickListener {
            Log.d(TAG,"OnClick, adding product")
            //TODO need to add method for fill productList
        })

        return view
    }
}