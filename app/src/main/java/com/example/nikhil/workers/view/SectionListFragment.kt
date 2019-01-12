package com.example.nikhil.workers.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nikhil.workers.R
import com.example.nikhil.workers.adapters.SectionListAdapter
import com.example.nikhil.workers.api.ApiCallback
import com.example.nikhil.workers.api.ApiManager
import com.example.nikhil.workers.data_model.WorkerListData
import kotlinx.android.synthetic.main.fragment_section_list.*

class SectionListFragment : Fragment() {


    private var sectionListAdapter: SectionListAdapter? = null
    private var roleList = mutableListOf<String>()
    private var mWorkerListData: WorkerListData? = null
    private var workersWithRoleMap: HashMap<String, MutableList<String>>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_section_list, container, false)


        return view
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        roleList = mutableListOf("A", "B", "C")
//        workersWithRoleMap?.set("C", mutableListOf("asda","asfafa"))
//        workersWithRoleMap?.set("B", mutableListOf("asda","asfafa"))
        sectionListAdapter = SectionListAdapter(context, roleList, workersWithRoleMap)
        worker_section_list.setAdapter(sectionListAdapter)
        getWorkerData()

    }




    private fun getWorkerData() {
        ApiManager.getWorkersList(object : ApiCallback {
            override fun onSuccess(response: Any) {
                mWorkerListData = response as WorkerListData
                workersWithRoleMap = getWorkerWithRoleMap()
                updateWorkerListUi()
            }

            override fun onFailure(failureMsg: String) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getWorkerWithRoleMap(): HashMap<String, MutableList<String>> {
        var map = HashMap<String, MutableList<String>>()

        mWorkerListData?.data?.items?.forEach { item ->
            val roleString: String = item.attributes.roleString
            if(map.containsKey(roleString)){
                map[roleString]?.add(item.attributes.full_name)
            }else{
                map[roleString] = mutableListOf(item.attributes.full_name)
            }
        }

        return map
    }

    private fun updateWorkerListUi() {
        section_list_progress_bar.visibility = View.GONE

        sectionListAdapter?.updateData(roleList, workersWithRoleMap)

        worker_section_list.setAdapter(sectionListAdapter)
        sectionListAdapter?.notifyDataSetChanged()
        sectionListAdapter?.notifyDataSetInvalidated()

    }


    companion object {
        @JvmStatic
        fun newInstance() = SectionListFragment()

    }
}
