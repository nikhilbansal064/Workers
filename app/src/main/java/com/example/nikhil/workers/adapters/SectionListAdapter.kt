package com.example.nikhil.workers.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.nikhil.workers.R
import kotlinx.android.synthetic.main.section_list_group.view.*
import kotlinx.android.synthetic.main.section_list_item.view.*

class SectionListAdapter(val context: Context?, var roleList: MutableList<String>, private var workerList: HashMap<String, MutableList<String>>?) : BaseExpandableListAdapter() {


    override fun getChild(groupPosition: Int, childPosititon: Int): String? {
        return workerList?.get(roleList[groupPosition])?.get(childPosititon)
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val workerName = getChild(groupPosition, childPosition) as String

        if (convertView == null) {
            val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.section_list_item, null)
        }

        convertView?.tv_worker_name?.text = workerName

        return convertView!!
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return workerList?.get(roleList[groupPosition])?.size ?: 0
    }

    override fun getGroup(groupPosition: Int): Any {
        return roleList[groupPosition]
    }

    override fun getGroupCount(): Int {
        return roleList.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean,
                              convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val workerRole = getGroup(groupPosition) as String
        if (convertView == null) {
            val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.section_list_group, null)
        }


        convertView?.tv_worker_role?.text = workerRole

        return convertView!!
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    fun updateData(mRoleList: MutableList<String>, mWorkersWithRoleMap: HashMap<String, MutableList<String>>?) {
        roleList = mRoleList
        workerList = mWorkersWithRoleMap

    }
}