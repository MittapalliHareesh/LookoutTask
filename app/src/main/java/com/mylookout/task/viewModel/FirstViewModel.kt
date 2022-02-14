package com.mylookout.task.viewModel

import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private var finalCommonValuesList = mutableListOf<List<Int>>()
    private val map = HashMap<Int, Content>()

    /**
     * Here Partition fun Implemented in such a way that by passing given two lists & realNumber which
     * is result of func(x).
     *
     * Will loop through each list make a Map Object. Key for Map object is fun(x) realNumber
     * and value will be Content class object.
     *
     * While looping lists, First will check func(x) key present in map or not.
     *   If not then we create a Content object making respective boolean true based on list type and
     *   add list of integers object.
     *
     *   If yes then we fetch a Content object and append list of indices value to existing list.
     *
     * @param Content It's a data class contains two boolean parameters first boolean reference to
     * first list and second boolean reference to second list. And MutableList of integers.
     * @param inputList1 Given inputList1
     * @param inputList2 Given inputList2
     * @param realNumber which returns fun(x) result.
     */

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

/**
 * Content data class.
 * @param list1Boolean whenever we are storing list1 details, will make this value as TRUE
 * @param list2Boolean whenever we are storing list2 details, will make this value as TRUE
 * @param list List of integer values.
 */

data class Content(
    var list1Boolean: Boolean = false,
    var list2Boolean: Boolean = false,
    var list: MutableList<Int>
)