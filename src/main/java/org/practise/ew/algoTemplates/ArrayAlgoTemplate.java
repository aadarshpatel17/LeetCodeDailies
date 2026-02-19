package algoTemplates;

public class ArrayAlgoTemplate {

    /*

    1. Two Pointer Technique
        Set left ← 0
        Set right ← n - 1
        While left < right do
            Set sum ← arr[left] + arr[right]
            If sum == target
                Return (left, right)
            Else If sum < target
                Set left ← left + 1
            Else
                Set right ← right - 1
        End While
        Return No such pair exists

        -----------------------------------------------------------------------

    2. Binary Search
        Set left ← 0
        Set right ← n - 1
        While left ≤ right do
            Set mid ← (left + right) / 2
            If arr[mid] == target
                Return mid
            Else If arr[mid] < target
                Set left ← mid + 1
            Else
                Set right ← mid - 1
        End While
        Return -1 (not found)

        -----------------------------------------------------------------------

    3. Bubble Sort
        For i from 0 to n - 2 do
            For j from 0 to n - i - 2 do
                If arr[j] > arr[j + 1]
                Swap arr[j] and arr[j + 1]
            End For
        End For

        -----------------------------------------------------------------------

    4. Prefix Sum (Left to Right)
        Create prefix[0] ← arr[0]
        For i from 1 to n - 1 do
            Set prefix[i] ← prefix[i - 1] + arr[i]
        End For
        Return prefix

        -----------------------------------------------------------------------
    5. Prefix Sum (Right to Left)
        Create suffix[n - 1] ← arr[n - 1]
        For i from n - 2 down to 0 do
            Set suffix[i] ← suffix[i + 1] + arr[i]
        End For
        Return suffix

        -----------------------------------------------------------------------

    6. Kadane’s Algorithm (Maximum Sub-array Sum)
        Set maxSum ← arr[0]
        Set currentSum ← arr[0]
        For i from 1 to n - 1 do
            Set currentSum ← max(arr[i], currentSum + arr[i])
            Set maxSum ← max(maxSum, currentSum)
        End For
        Return maxSum

        -----------------------------------------------------------------------

    7. Sliding Window (Fixed Size)
        Set windowSum ← sum of first k elements
        Set maxSum ← windowSum
        For i from k to n - 1 do
            Set windowSum ← windowSum + arr[i] - arr[i - k]
            Set maxSum ← max(maxSum, windowSum)
        End For
        Return maxSum

        -----------------------------------------------------------------------

    8. Dutch National Flag Algorithm (Sort 0s, 1s, 2s)
        Set low ← 0
        Set mid ← 0
        Set high ← n - 1
        While mid ≤ high do
            If arr[mid] == 0
                Swap arr[low] and arr[mid]
                    Set low ← low + 1
                    Set mid ← mid + 1
            Else If arr[mid] == 1
                Set mid ← mid + 1
            Else
                Swap arr[mid] and arr[high]
            Set high ← high - 1
        End While

        -----------------------------------------------------------------------

    9. Rotate Array (Reversal Algorithm - Right Rotation by k)
        Set k ← k % n
        Reverse array from 0 to n - 1
        Reverse array from 0 to k - 1
        Reverse array from k to n - 1

        -----------------------------------------------------------------------

    10. Product of Array Except Self (Without Division)
        Create leftProduct[n] ← all 1
        Create rightProduct[n] ← all 1
        For i from 1 to n - 1 do
            Set leftProduct[i] ← leftProduct[i - 1] * arr[i - 1]
        For i from n - 2 down to 0 do
            Set rightProduct[i] ← rightProduct[i + 1] * arr[i + 1]
        For i from 0 to n - 1 do
            Set result[i] ← leftProduct[i] * rightProduct[i]
        Return result

        -----------------------------------------------------------------------

    11. Valid Mountain Array
        If n < 3
            Return false
        Set i ← 0
        While i + 1 < n and arr[i] < arr[i + 1]
            Set i ← i + 1
        If i == 0 or i == n - 1
            Return false
        While i + 1 < n and arr[i] > arr[i + 1]
            Set i ← i + 1
        Return i == n - 1

     */

}
