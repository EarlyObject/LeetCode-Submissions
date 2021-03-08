/*
https://leetcode.com/problems/shortest-completing-word/

Given a string licensePlate and an array of strings words, find the shortest completing word in words.

A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.

For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".

Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in words.

 

Example 1:

Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
Output: "steps"
Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
"step" contains 't' and 'p', but only contains 1 's'.
"steps" contains 't', 'p', and both 's' characters.
"stripe" is missing an 's'.
"stepple" is missing an 's'.
Since "steps" is the only word containing all the letters, that is the answer.
Example 2:

Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
Output: "pest"
Explanation: licensePlate only contains the letter 's'. All the words contain 's', but among these "pest", "stew", and "show" are shortest. The answer is "pest" because it is the word that appears earliest of the 3.
Example 3:

Input: licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
Output: "husband"
Example 4:

Input: licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
Output: "enough"
Example 5:

Input: licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
Output: "simple"
 

Constraints:

1 <= licensePlate.length <= 7
licensePlate contains digits, letters (uppercase or lowercase), or space ' '.
1 <= words.length <= 1000
1 <= words[i].length <= 15
words[i] consists of lower case English letters.
 */

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        boolean isOption = false;
        int strLen = 0;
        int[] plateChars = new int[128];
        int[] wordChars;
        String answer = "";
        char[] chars;

        chars = licensePlate.toCharArray();
        for (char c : chars) {
            if(c >= 65 && c <= 90){
                plateChars[c + 32] += 1;
            }
            else if (c >= 97 && c <= 122){
                plateChars[c] += 1;
            }
        }

        isOption = false;
        for (String str : words) {
            if(isOption && str.length() > strLen)
                continue;
            wordChars = new int[128];
            chars = str.toCharArray();
            for (char c : chars) {
                wordChars[c] += 1;
            }

            for(int i = 97; i <= 122; i++){
                if(plateChars[i] > wordChars[i])
                    break;
                if(i == 122) {
                    if (!isOption) {
                        isOption = true;
                        strLen = str.length();
                        answer = str;
                    } else {
                        if (str.length() < strLen){
                            strLen = str.length();
                            answer = str;
                        }
                    }
                }
            }
        }
        return answer;

    }
}