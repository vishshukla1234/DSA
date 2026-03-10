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

## Approach 2: **Sorting + Two Pointers** (Better)

**Thought Process**

Instead of checking every possible pair, we try to reduce unnecessary comparisons.

First, we store each number along with its **original index** because sorting will change the positions of elements.

Then we **sort the array based on the values**.

After sorting, we apply the **two-pointer technique**:

- One pointer at the **beginning (left)**
- One pointer at the **end (right)**

We calculate the sum of the elements at both pointers.

- If `sum == target`, we return their **original indices**.
- If `sum < target`, we move the **left pointer forward** to increase the sum.
- If `sum > target`, we move the **right pointer backward** to decrease the sum.

This method reduces the number of comparisons compared to the brute force approach.

---

## Algorithm

Store `(value, index)` pairs.

Sort the array based on the values.

Initialize `left = 0` and `right = n - 1`.

While `left < right`:

If `arr[left] + arr[right] == target` → return the stored indices.

If `sum < target` → `left++`.

If `sum > target` → `right--`.

---

**Time Complexity:** O(n log n)

**Space Complexity:** O(n)

---

## Approach 3: **HashMap** (Optimal)

**Thought Process**

Instead of searching for pairs, we can solve the problem in a single pass.

For every element `nums[i]`, we calculate the number needed to reach the target:

`complement = target - nums[i]`

Then we check whether this **complement already exists in the HashMap**.

- If it exists, we have found the two numbers that sum to the target.
- If it does not exist, we store the current number and its index in the HashMap.

This allows us to **find the answer in one traversal of the array**.

---

## Algorithm

Create a `HashMap` to store `(number → index)`.

Traverse the array.

For each element:

Compute `complement = target - nums[i]`.

If `complement` exists in the map → return the indices.

Otherwise, store the current element in the map.

---

**Time Complexity:** O(n)

**Space Complexity:** O(n)
