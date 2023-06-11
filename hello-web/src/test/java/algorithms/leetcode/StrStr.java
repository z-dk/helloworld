package algorithms.leetcode;

public class StrStr {

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();
        int[] idx = recheck(nc);
        int i = 0, j = 0;
        while(i < hc.length && j < nc.length) {
            if(hc[i] == nc[j]) {
                i++;
                j++;
            } else if(j > 0) {
                j = idx[j-1];
            } else {
                i++;
            }

        }
        return j == nc.length ? i - j : -1;
    }

    public int[] recheck(char[] cn) {
        int len = cn.length;
        int[] rs = new int[len];
        rs[0] = 0;
        // 最长前缀后缀
        int i = 1, j = 0;
        while(i < len) {
            if(cn[i] == cn[j]) {
                rs[i++] = ++j;
            } else if(j > 0) {
                j = rs[j - 1];
            } else {
                rs[i++] = 0;
            }
        }
        return rs;
    }

}
