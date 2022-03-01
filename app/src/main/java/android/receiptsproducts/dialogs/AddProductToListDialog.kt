package android.receiptsproducts.dialogs

import android.content.Context
import android.os.Bundle
import android.receiptsproducts.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.ClassCastException
import java.lang.NumberFormatException

private const val TAG = "AddProductToListDialog"

class AddProductToListDialog : DialogFragment() {

    //widgets
    private lateinit var nameInput: EditText
    private lateinit var costInput: EditText
    private lateinit var caloriesInput: EditText

    //vars
    private lateinit var mOnInputListener: OnInputListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_add_product_to_list,container,false)
        nameInput = view.findViewById(R.id.input_product_name)
        costInput = view.findViewById(R.id.input_product_cost)
        caloriesInput = view.findViewById(R.id.input_product_calories)
        val mActionOk: TextView = view.findViewById(R.id.action_ok)
        val mActionCancel: TextView = view.findViewById(R.id.action_cancel)


        mActionCancel.setOnClickListener {
            Log.d(TAG, "OnCLick, closing dialog")
            dialog?.dismiss()
        }

        mActionOk.setOnClickListener {
            Log.d(TAG, "OnClick, adding product")

            //checking name, cost, calories fields
            if (nameInput.text.toString() == ""){
                Toast.makeText(
                    context,
                    "Please enter the correct product name",
                    Toast.LENGTH_SHORT)
                    .show()
                dialog?.dismiss()
            }else
            {
                val nameInputString = nameInput.text.toString()
                val costInputInt: Int = try {
                    costInput.text.toString().toInt()
                } catch (e: NumberFormatException) {
                    Log.e(TAG, "mActionOk.OnClickListener: NumberFormatException ${e.message}")
                    0
                }
                val caloriesInputInt: Int = try {
                    caloriesInput.text.toString().toInt()
                } catch (e: NumberFormatException) {
                    Log.e(TAG, "mActionOk.OnClickListener: NumberFormatException ${e.message}")
                    0
                }

                val intInput = mutableMapOf(
                    "cost" to costInputInt,
                    "calories" to caloriesInputInt
                ) as HashMap

                mOnInputListener.sendInput(nameInputString, intInput)
                dialog?.dismiss()
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mOnInputListener = activity as OnInputListener
        }catch (e:ClassCastException){
            Log.e(TAG,"OnAttach: ClassCastException ${e.message}")
        }
    }
}