package com.example.testnavigation.ui.meterage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testnavigation.R
import com.example.testnavigation.model.Meterage
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class MeterageFragment : Fragment(), MeterageScreen {
    @Inject
    lateinit var presenter:  MeteragePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_meterage, container, false)
        val textView1: TextView = root.findViewById(R.id.textView1)
        val textView2: TextView = root.findViewById(R.id.textView2)
        val textView3: TextView = root.findViewById(R.id.textView3)
        val textView4: TextView = root.findViewById(R.id.textView4)

        textView1.text = "0";
        textView2.text = "0";
        textView3.text = "0";
        textView4.text = "0";

        val license: EditText = root.findViewById(R.id.editTextPlate)
        val place: EditText = root.findViewById(R.id.editTextPlace)
        val product: EditText = root.findViewById(R.id.editTextCorp)

        license.text.clear();
        place.text.clear();
        product.text.clear();

        val button: Button = root.findViewById(R.id.button) as Button
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("Meterage", "onClick");
                val textView1: TextView = root.findViewById(R.id.textView1)
                val textView2: TextView = root.findViewById(R.id.textView2)
                val textView3: TextView = root.findViewById(R.id.textView3)
                val textView4: TextView = root.findViewById(R.id.textView4)
                val license: EditText = root.findViewById(R.id.editTextPlate)
                val place: EditText = root.findViewById(R.id.editTextPlace)
                val product: EditText = root.findViewById(R.id.editTextCorp)

                var meterage = Meterage()
                meterage.license = license.text.toString()
                meterage.place = place.text.toString()
                meterage.date = Date();
                meterage.product = product.text.toString()
                meterage.values = floatArrayOf(
                        textView1.text.toString().toFloat(),
                        textView2.text.toString().toFloat(),
                        textView3.text.toString().toFloat(),
                        textView4.text.toString().toFloat()
                );

                presenter.CreateNewMeterage(meterage)

                license.text.clear();
                place.text.clear();
                product.text.clear();
            }
        })

        return root
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        presenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        presenter.GetScales();
    }

    override fun showSucces() {
        Toast.makeText(getActivity(), "Saved",
                Toast.LENGTH_LONG).show();
    }

    override fun updateScales(scales: FloatArray) {
        val view = this.view;
        if (view != null) {
            val textView1: TextView = view.findViewById(R.id.textView1)
            val textView2: TextView = view.findViewById(R.id.textView2)
            val textView3: TextView = view.findViewById(R.id.textView3)
            val textView4: TextView = view.findViewById(R.id.textView4)

            textView1.text = scales[0].toString()
            textView2.text = scales[1].toString()
            textView3.text = scales[2].toString()
            textView4.text = scales[3].toString()
        }
    }
}