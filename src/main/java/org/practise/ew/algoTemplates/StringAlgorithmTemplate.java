package algoTemplates;

public class StringAlgorithmTemplate {

    /*
    1. Check Palindrome
        Set left  <- 0
        Set right <- length of str - 1
        While left < right do:
            if(str[left] != str[right]):
                return false
            left <- left + 1
            right <- right + 1
        End While
        Return true

        -----------------------------------------------------------------------

    1.1 Reverse a String
        public String reverse(String s) {
            return new StringBuilder(s).reverse().toString();
        }

        -----------------------------------------------------------------------

    2. Check Anagram (Using Frequency Array)
        Anagram: An anagram is a word or phrase formed by rearranging the letters of another word or phrase — using all original letters exactly once.

       isAnagram(String s, String t)
        If length of s != length of t
            Return false
        Create count[26] <- all zeroes
        For i from 0 to length of s - 1 do
            Increment count[s[i] - 'a']
            Decrement count[t[i] - 'a']
        End For

        For each value in count do
            If value != 0
                Return false
        End For
        Return true

        -----------------------------------------------------------------------

    3. Longest Common Prefix
        -   The Longest Common Prefix is the longest starting substring that is common to all strings in a given array.

        If strs is empty
            Return ""
        Set prefix <- strs[0]
        For i from 0 to length of strs - 1 do
            While strs[i] does not start with prefix
                Remove last character from prefix
                If prefix is empty
                    Return ""
            End While
        End For
        Return prefix

        -----------------------------------------------------------------------

    4. Longest Substring Without Repeating Characters
        Set left ← 0
        Create empty set seen
        Set maxLength ← 0
        For right from 0 to n - 1 do
            While s[right] ∈ seen do
                Remove s[left] from seen
                Set left ← left + 1
            End While

            Add s[right] to seen
            Set maxLength ← max(maxLength, right - left + 1)
        End For
        Return maxLength

        -----------------------------------------------------------------------

    5. KMP Prefix Table (LPS Array)
    -   The KMP Prefix Table, also called the LPS array (Longest Prefix which is also Suffix), is a key part of the KMP (Knuth-Morris-Pratt) string matching algorithm.

        Create lps[] of length m ← all zeros
        Set length ← 0
        Set i ← 1
        While i < m do
            If pattern[i] == pattern[length]
                Set length ← length + 1
                Set lps[i] ← length
                Set i ← i + 1
            Else If length ≠ 0
                Set length ← lps[length - 1]
            Else
            Set lps[i] ← 0
            Set i ← i + 1
        End While
        Return lps

     */


}
