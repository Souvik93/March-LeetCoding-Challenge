/*
Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:

Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:

Input: "owoztneoer"

Output: "012"
Example 2:

Input: "fviefuro"

Output: "45"
*/
class Solution {
    public String originalDigits(String s) {
        int chars[] = new int[26];
        
        for(char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        
        int d[] = new int[10];
        
        d[0]= chars['z'-'a'];
        d[2] = chars['w'-'a'];
        d[4] = chars['u'-'a'];
        d[6] = chars['x'-'a'];
        d[8] = chars['g'-'a'];
        
        
        d[5] = chars['f'-'a']-d[4];
        d[1] = chars['o'-'a'] - d[0] - d[2]-d[4];
        d[7] = chars['s'-'a'] - d[6];
        d[3] = chars['t'-'a'] -d[2] -d[8];
        d[9] = chars['i'-'a'] - d[5]-d[8]-d[6];
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<10;i++) {
            for(int j=1;j<=d[i];j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
        
        
    }
}
