package com.CK;

public class Main {

    public static void main(String[] args) {

    }
}

//
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String[] arr = S.split("-");
        int size = arr.length, itr = 0, arrPos = 1, cPos = 0, kPos = 0;
        StringBuilder sb = new StringBuilder();
        if(size == 0)
            return "";
        if (arr[0].length() <= K && size == 1 ){
            return arr[0].toUpperCase();
        }

        while(arrPos <= size){
            int stringLen = arr[size - arrPos].length();

            if (kPos < K && cPos < stringLen){
                sb.insert(0,Character.toUpperCase(arr[size - arrPos].charAt(stringLen - cPos - 1)));
                cPos++;
                kPos++;
            }
            else if (cPos == stringLen){
                cPos = 0;
                arrPos++;
            }
            else if (kPos == K){
                kPos = 0;
                if (arrPos <= size)
                    sb.insert(0,"-");
            }

        }
        return sb.toString();
    }
}

class Solution2 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }
}