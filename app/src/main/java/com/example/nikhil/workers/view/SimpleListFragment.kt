package com.example.nikhil.workers.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nikhil.workers.R
import com.example.nikhil.workers.adapters.WorkerListAdapter
import com.example.nikhil.workers.api.ApiCallback
import com.example.nikhil.workers.api.ApiManager
import com.example.nikhil.workers.data_model.Items
import com.example.nikhil.workers.data_model.WorkerListData
import kotlinx.android.synthetic.main.fragment_simple_list.*

class SimpleListFragment : Fragment() {


    private var workerListAdapter: WorkerListAdapter? = null
    private var workerList: MutableList<Items>? = mutableListOf()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_simple_list, container, false)

    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workerListAdapter = WorkerListAdapter(context, workerList)

        val layoutManager = LinearLayoutManager(context)
        rv_workerList.layoutManager = layoutManager
        rv_workerList.adapter = workerListAdapter
        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        rv_workerList.addItemDecoration(itemDecoration)

        if(!WorkerListData.getInstance().hasData()){
            getWorkerData()
        }else{
            updateWorkerListUi()
        }

    }

    private fun getWorkerData() {
        ApiManager.getWorkersList(object : ApiCallback {
            override fun onSuccess(response: Any) {
                val mWorkerListData = response as WorkerListData
                workerList = mWorkerListData?.data?.items?.toMutableList()
                updateWorkerListUi()
            }

            override fun onFailure(failureMsg: String) {
                Toast.makeText(context, getString(R.string.worker_list_api_error), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateWorkerListUi() {
        workerListAdapter?.updateDataList(workerList)
        progress_bar.visibility = View.GONE
        rv_workerList.visibility = View.VISIBLE
    }


    companion object {
        @JvmStatic
        fun newInstance() = SimpleListFragment()

    }
}
