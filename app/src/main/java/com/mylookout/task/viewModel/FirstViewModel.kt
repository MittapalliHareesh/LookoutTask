package com.mylookout.task.viewModel

import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private var finalCommonValuesList = mutableListOf<List<Int>>()
    private val map = HashMap<Int, Content>()


    fun partition(
        inputList1: List<Int>,
        inputList2: List<Int>,
        realNumber: (Int) -> Int
    ): MutableList<List<Int>> {
        var i = 0
        while (i < inputList1.size || i < inputList2.size) {
            if (i < inputList1.size) {
                val x = realNumber(inputList1[i])
                if (map[x] != null) {
                    val data = map[x]
                    data?.list1Boolean = true
                    data?.list?.add(inputList1[i])
                } else {
                    map[x] = Content(
                        list1Boolean = true,
                        list2Boolean = false,
                        list = mutableListOf(inputList1[i])
                    )
                }
            }
            if (i < inputList2.size) {
                val x = realNumber(inputList2[i])
                if (map[x] != null) {
                    val data = map[x]
                    data?.list2Boolean = true
                    data?.list?.add(inputList2[i])
                } else {
                    map[x] = Content(
                        list1Boolean = false,
                        list2Boolean = true,
                        list = mutableListOf(inputList2[i])
                    )
                }
            }
            i++
        }

        map.values.filter { it.list1Boolean && it.list2Boolean }
            .forEach { content -> finalCommonValuesList.add(content.list) }

        return finalCommonValuesList
    }
}


data class Content(
    var list1Boolean: Boolean = false,
    var list2Boolean: Boolean = false,
    var list: MutableList<Int>
)