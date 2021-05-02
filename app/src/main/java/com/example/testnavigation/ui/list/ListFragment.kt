package com.example.testnavigation.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testnavigation.R
import com.example.testnavigation.model.Meterage
import com.example.testnavigation.ui.details.DetailsActivity

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment(), ListScreen {
    @Inject
    lateinit var presenter: ListPresenter

    private var listAdapter: MeterageListAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_list, container, false)
        listAdapter = MeterageListAdapter { meterage -> adapterOnClick(meterage)}
        val recyclerView: RecyclerView  = root.findViewById(R.id.recycler_view);
        val manager: RecyclerView.LayoutManager = LinearLayoutManager(root.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = listAdapter
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
        presenter.queryMeterages();
    }

    private fun adapterOnClick(meterage: Meterage) {
       val intent = Intent(this.context, DetailsActivity()::class.java)
       intent.putExtra("METERAGE_ID", meterage.id)
       startActivity(intent)
    }



    override fun showList(list: List<Meterage>) {
        getActivity()?.runOnUiThread( Runnable() {
            listAdapter?.submitList(list)
        });
    }

}