# LookoutTask

<b>Idea of this Project :-</b>

Write a function, partition , that takes the following input:
list1 - a list of integers
list2 - a list of integers
func - a function that takes a single integer as an argument and returns a real number

And returns a list of lists where each sublist contains values found in both of the two lists for which the function func returns the
same value.

This point is important: a given value of func needs to be generated by values in both lists.



<b>Design</b>:- Implemented Partiton fun bussniess logic in two ways in viewModel's. Below are the refrence UI screenshots.  


<p align="center">
<img src="https://user-images.githubusercontent.com/16395251/153806413-9cc2e716-1999-4b82-8cc5-6421aea09cd5.png" width="500" height="1000">
</p>


<b>Validation Of Partition Bussniess Logic :- </b>

<h1>Example 1</h1>
For example, suppose that our function, func is:
def func(x): return x % 2

If list1 = [1,2,3,4,5] and list2 = [6,7,8,9,10] then partition(list1, list2, func) would return
[[1,3,5,7,9], [2,4,6,8,10]] .

In this case, func returns its argument mod 2. Thus, partition returns a list containing 2 sublists: one of odd numbers (for
which func returns 1) and the other of even numbers for which func returns 2).

<p align="center">
<img src="https://user-images.githubusercontent.com/16395251/153807254-633c74db-09ff-4f1e-9e41-4bb51eec3e66.png" width="500" height="1000">
</p>


<h1>Example 2</h1>
For example, suppose that our function, func is:
def func(x): return x*x

then partition([-1,2,3],[1,2,-3,4],func) would return [[-1,1],[2,2],[3,-3]]

<p align="center">
<img src="https://user-images.githubusercontent.com/16395251/153807525-3e17a8fb-4bcb-464e-9d93-4994e4de029e.png" width="500" height="1000">
</p>


<h1>Example 3</h1>
For example, suppose that our function, func is:
def func(x): return x % 2

If list1 = [1,3] and list2 = [2] then partition(list1, list2, func) would return [] because although 1 and 3
are both the same mod 2, there is nothing in list2 that yields 1 when modded with 2.

<p align="center">
<img src="https://user-images.githubusercontent.com/16395251/153807806-407efce9-f60d-4684-bad4-d61a286de09a.png" width="500" height="1000">
</p>
