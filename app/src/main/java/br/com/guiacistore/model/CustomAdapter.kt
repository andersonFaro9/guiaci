package br.com.guiacistore.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.com.guiacistore.R
import java.util.*


internal class CustomAdapter(context: Context) : BaseAdapter() {

    private val mData = ArrayList<String>()
    private val sectionHeader = TreeSet<Int>()

    private val mInflater: LayoutInflater

    init {
        mInflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    fun addItem(item: String) {
        mData.add(item)
        notifyDataSetChanged()
    }

    fun addSectionHeaderItem(item: String) {
        mData.add(item)
        sectionHeader.add(mData.size - 1)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (sectionHeader.contains(position)) TYPE_SEPARATOR else TYPE_ITEM
    }

    override fun getViewTypeCount(): Int {
        return 2
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun getItem(position: Int): String {
        return mData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var holder: ViewHolder? = null
        val rowType = getItemViewType(position)

        if (convertView == null) {
            holder = ViewHolder()
            when (rowType) {
                TYPE_ITEM -> {
                    convertView = mInflater.inflate(R.layout.snippet_item1, null)
                    holder.textView = convertView!!.findViewById(R.id.text)
                }
                TYPE_SEPARATOR -> {
                    convertView = mInflater.inflate(R.layout.snippet_item2, null)
                    holder.textView = convertView!!.findViewById(R.id.textSeparator)
                }
            }
            convertView!!.setTag(holder)
        } else {
            holder = convertView!!.tag as ViewHolder?
        }
        holder?.textView!!.text = mData[position]

        return convertView
    }

    class ViewHolder {
        var textView: TextView? = null
    }

    companion object {

        private val TYPE_ITEM = 0
        private val TYPE_SEPARATOR = 1
    }

}