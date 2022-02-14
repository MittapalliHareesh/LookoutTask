package com.mylookout.task.viewModel

import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    private var sameValues: MutableList<Int>? = null
    private var finalCommonValuesList = mutableListOf<List<Int>>()

    private val map1 = HashMap<Int, List<Int>>()
    private val map2 = HashMap<Int, List<Int>>()

    fun partition(inputList1: List<Int>, inputList2: List<Int>, realNumber: (Int) -> Int):
            MutableList<List<Int>> {
        createMapObject(map1, inputList1, realNumber)
        createMapObject(map2, inputList2, realNumber)
        return if (map1.size < map2.size) {
            generateFinalList(map1.entries, map2)
        } else {
            generateFinalList(map2.entries, map1)
        }
    }

    private fun generateFinalList(
        entries: MutableSet<MutableMap.MutableEntry<Int, List<Int>>>,
        map: HashMap<Int, List<Int>>
    ): MutableList<List<Int>> {
        for (entry in entries) {
            if (map.keys.contains(entry.key)) {
                sameValues = mutableListOf()
                entry.value.filter { sameValues!!.add(it) }
                map[entry.key]?.let { valuesList ->
                    valuesList.filter { sameValues!!.add(it) }
                }
                finalCommonValuesList.add(sameValues!!)
            }
        }
        return finalCommonValuesList
    }


    private fun createMapObject(
        map: HashMap<Int, List<Int>>,
        inputList: List<Int>,
        realNumber: (Int) -> Int
    ) {
        for (i in inputList.indices) {
            if (map[realNumber(inputList[i])] != null) {
                sameValues = map[realNumber(inputList[i])] as MutableList<Int>
                sameValues?.add(inputList[i])
            } else {
                sameValues = mutableListOf()
                sameValues?.add(inputList[i])
                map[realNumber(inputList[i])] = sameValues as List<Int>
            }
        }
    }
}