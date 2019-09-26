package com.hqapps.dazntestapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.hqapps.domain.model.Displayable

class DomainEntityDiffUtil<T: Displayable> : DiffUtil.Callback {

    private val oldList: List<T>
    private val newList: List<T>

    constructor(oldList: List<T>, newList: List<T>){
        this.oldList = oldList
        this.newList = newList
    }
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
            = oldList[oldItemPosition].getIdentifier() == newList[newItemPosition].getIdentifier()


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
            = oldList[oldItemPosition].getIdentifier() == newList[newItemPosition].getIdentifier()

}