package me.panpf.sketch.sample.item

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import me.panpf.adapter.AssemblyItem
import me.panpf.adapter.AssemblyItemFactory
import me.panpf.adapter.ktx.bindView
import me.panpf.sketch.sample.R
import me.panpf.sketch.sample.ui.Page

class PageMenuItemFactory(private val onClickItemListener: OnClickItemListener) : AssemblyItemFactory<Page>() {

    override fun match(o: Any?): Boolean {
        return o is Page
    }

    override fun createAssemblyItem(viewGroup: ViewGroup): PageMenuItem {
        return PageMenuItem(R.layout.list_item_page_menu, viewGroup)
    }

    interface OnClickItemListener {
        fun onClickItem(page: Page)
    }

    inner class PageMenuItem(itemLayoutId: Int, parent: ViewGroup) : AssemblyItem<Page>(itemLayoutId, parent) {
        private val textView: TextView by bindView(R.id.text_pageMenuItem)

        override fun onConfigViews(context: Context) {
            textView.setOnClickListener { data?.let { it1 -> onClickItemListener.onClickItem(it1) } }
        }

        override fun onSetData(i: Int, pageMenu: Page?) {
            textView.text = pageMenu?.showName
        }
    }
}
