package com.example.novel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:wxh
 * @date:2022/7/20
 **/
public class LeetCode {
    @Test
    public void test(){
        Solution solution = new Solution();
    }
}
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder onePath = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return res;
        }
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, letters, 0);
        return res;
    }

    public void backTracking(String digits, String[] letters, int num){

        if (num == digits.length()){
            res.add(onePath.toString());
            return;
        }

        String s = letters[digits.charAt(num) - '0'];
        for (int i = 0; i < s.length(); i++){
           onePath.append(s.charAt(i));
           backTracking(digits,letters, num + 1);
           onePath.deleteCharAt(onePath.length() - 1);
        }
    }
}