package com.mylookout.task.viewModel

import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    private var sameValues: MutableList<Int>? = null
    private var finalCommonValuesList = mutableListOf<List<Int>>()

    private val map1 = HashMap<Int, List<Int>>()
    private val map2 = HashMap<Int, List<Int>>()

    /**
     * Here Partition fun Implemented in such a way that
     *
     * First Create a HashMap object by passing key as func(x) realNumber (here x will be indices present list1)
     * and Value will be list of integers present list1 which returns same func(x) value.
     *
     * One more Hashmap created with list2 as well by passing func(x) as key.
     *
     * After two Hashmaps are ready, we should generate finalList which has list of lists where each
     * sublist contains values found in both of the two lists.
     *
     * To generateFinalList we are validating whichever map size is less that entries we are passing
     * it as parameter and other map object as well. From that we are making final list which has
     * a same key.
     */
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

    /**
     * This fun makes a FinalList, By passing entries of whichever map size is less and other map
     * object. Based on key whatever values are common from both maps we are adding in to finalList.
     *
     * @param entries : Map object entries whichever has less size.
     * @param map : Other map object.
     */

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


    /**
     * Creating a HashMap object from list, where key as fun(x) result realNumber
     * and value will be list of integers present list1 which returns same func(x) value.
     *
     * @param map : Map object contains key as fun(x) result and value will be list of integers whose return same fun(x) value.
     * @param inputList : Either be a List1 or List2 which we pass to make map object.
     * @param realNumber : It's a fun(x) result & it's a realNumber and it acts as key for map object.
     */
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