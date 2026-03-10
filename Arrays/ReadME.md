## **Two Sum**

## **Problem Description**

Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to target.

Each input has exactly one solution.

You cannot use the same element twice.

Return the indices in any order.

## **Example**

**Input:**

nums = [2,7,11,15], target = 9

**Output:**

[0,1]

**Explanation:**

nums[0] + nums[1] = 2 + 7 = 9

## Approach 1: **Brute Force**(Naive)

**Thought Process**

The most straightforward idea is:

Take each element.

Check every other element.

If their sum equals target, return their indices.

This guarantees finding the answer but checks many unnecessary pairs.

## Algorithm

Loop i from 0 → n-1

Loop j from i+1 → n-1

If nums[i] + nums[j] == target return [i, j]

**Time Complexity:** O(n²)  

**Space Complexity:** O(1)
