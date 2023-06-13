Apporach//
    /*Certainly! Here's an explanation of the approach and each step of the iteration in the provided code:

1. The `allZero` method checks if all the values in the `count` list are zero. It creates a new list called `zeroList` filled with zeros using `Arrays.asList` and `Collections.fill`, and then compares it with the `count` list using the `equals` method.

2. The `search` method takes two strings, `pat` and `txt`, as input and returns the count of occurrences of `pat` in `txt`.

3. The variable `k` is initialized with the length of the `pat` string, which represents the pattern we are searching for.

4. The `count` list is created with an initial size of 26 (representing the 26 lowercase letters) and all values set to 0 using `Collections.nCopies`.

5. The `count` list is updated by iterating over each character `ch` in the `pat` string. The character `ch` is converted to an index by subtracting the ASCII value of 'a', and the value at that index in the `count` list is incremented by 1.

6. Variables `i` and `j` are initialized to 0, representing the starting indices of the sliding window in the `txt` string.

7. The variable `n` is set to the length of the `txt` string.

8. The variable `result` is initialized to 0, which will store the count of occurrences of the pattern `pat` in `txt`.

9. The while loop continues until the end of the `txt` string (`j < n`).

10. Inside the while loop, the current character's index (`idx`) is calculated by subtracting the ASCII value of 'a' from the character at position `j` in the `txt` string.

11. The value at index `idx` in the `count` list is decremented by 1 to indicate that we have encountered this character in the current window.

12. If the size of the current window (`j - i + 1`) is equal to the length of the pattern (`k`), we check if all the values in the `count` list are zero by calling the `allZero` method.

13. If all the values in the `count` list are zero, it means that the current window contains all the characters of the pattern. In this case, we increment the `result` variable to count this occurrence.

14. The character at index `i` in the `txt` string is used to calculate its index (`txt.charAt(i) - 'a'`) in the `count` list, and the value at that index is incremented by 1 to prepare for the next window.

15. The indices `i` and `j` are incremented to slide the window by one position to the right.

16. Finally, after the while loop, the `result` variable contains the count of occurrences of the pattern `pat` in the `txt` string, which is returned as the result of the `search` method.

This approach uses a sliding window technique to efficiently count the occurrences of the pattern in the given text.*/

class Solution {

  public boolean allZero(List<Integer> count) {
        List<Integer> zeroList = Arrays.asList(new Integer[26]);
        Collections.fill(zeroList, 0);
        return count.equals(zeroList);
    }

    public int search(String pat, String txt) {
        int k = pat.length();
        List<Integer> count = new ArrayList<>(Collections.nCopies(26, 0));
        for (char ch : pat.toCharArray()) {
            count.set(ch - 'a', count.get(ch - 'a') + 1);
        }
        int i = 0, j = 0;
        int n = txt.length();
        int result = 0;
        while (j < n) {
            int idx = txt.charAt(j) - 'a';
            count.set(idx, count.get(idx) - 1);

            if (j - i + 1 == k) {
                if (allZero(count)) {
                    result++;
                }

                count.set(txt.charAt(i) - 'a', count.get(txt.charAt(i) - 'a') + 1);
                i++;
            }
            j++;
        }
        return result;
    }
}






////SLIDING WONDOW

Question
https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

Code
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int search(String pat, String txt) {
        // Create two hash maps: mp for the pattern pat and m for the text txt
        Map<Character, Integer> mp = new HashMap<>(); // for pat
        Map<Character, Integer> m = new HashMap<>(); // for txt

        // Initialize mp map with character counts from the pattern
        for (int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int k = pat.length(); // Length of the pattern
        int i = 0, j = 0; // Pointers for the sliding window

        // Move the window to cover the initial pattern length
        while (j < k) {
            char ch = txt.charAt(j);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
            j++;
        }

        int count = 0; // Count of pattern occurrences

        // Check if initial window matches the pattern
        if (m.equals(mp)) {
            count++;
        }

        // Slide the window and check for pattern matches
        while (j < txt.length()) {
            char ch1 = txt.charAt(i); // Leftmost character of the window
            char ch2 = txt.charAt(j); // Rightmost character of the window

            // Update counts for the leftmost character
            if (m.get(ch1) == 1) {
                m.remove(ch1);
            } else {
                m.put(ch1, m.get(ch1) - 1);
            }

            // Update counts for the rightmost character
            m.put(ch2, m.getOrDefault(ch2, 0) + 1);

            i++; // Move left pointer
            j++; // Move right pointer

            // Check if the current window matches the pattern
            if (m.equals(mp)) {
                count++;
            }
        }

        return count; // Return the count of pattern occurrences
    }
}



Apporach

The approach of the given code can be described as follows:

Create two hash maps, mp for the pattern pat and m for the text txt. These maps will store the character counts of each character in the respective strings.

Initialize the mp map by iterating over each character in the pattern pat and incrementing its count in the map.

Set the variable k to the length of the pattern pat.

Initialize two pointers, i and j, both set to 0, to represent the left and right boundaries of the sliding window.

Move the window to cover the initial pattern length (k) in the text. For each character in this window, increment its count in the m map.

Check if the m map is equal to the mp map. If they are equal, it means that the initial window matches the pattern. In such a case, increment the count variable by 1.

Slide the window by incrementing both i and j together.

For each subsequent window, update the m map by decrementing the count of the leftmost character txt[i] and incrementing the count of the rightmost character txt[j].

Slide the window by incrementing both i and j together.

Check if the m map is equal to the mp map for each window. If they are equal, increment the count variable by 1. This indicates that the current window matches the pattern.

Repeat steps 8-10 until the window reaches the end of the text.

Finally, return the count variable, which represents the number of times the pattern pat occurs in the text txt.




