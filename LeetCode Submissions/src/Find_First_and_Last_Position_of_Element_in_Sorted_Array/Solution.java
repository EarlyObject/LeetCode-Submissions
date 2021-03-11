package Find_First_and_Last_Position_of_Element_in_Sorted_Array;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> list =Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        int[] rv = new int[2];
        rv[0] = list.indexOf(target);
        rv[1] = list.lastIndexOf(target);
        return rv;
    }
}