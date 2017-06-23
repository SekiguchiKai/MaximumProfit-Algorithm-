package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // 後の数から先の数を引かなくてはならない
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // 入力される数
            int n = Integer.parseInt(bufferedReader.readLine());

            List<Integer> inputNumArray = new ArrayList<>();
            // そのあとに続く入力
            for (int i = 0; i < n; i++) {
                inputNumArray.add(Integer.parseInt(bufferedReader.readLine()));
            }
            System.out.println(getMaximumProfit(inputNumArray));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static int getMaximumProfit(List<Integer> numArray) {
        // とりあえず0番目の要素をminValueにする
        int minValue = numArray.get(0);
        // 後の要素からminValueを引いたもの
        int maxProfit = numArray.get(1) - minValue;

        for (int j = 1; j < numArray.size(); j++) {
            // maxを先に記述することで、jの要素から引くminvalueが1つ手前の要素までした反映していないものになる
            maxProfit = Math.max(maxProfit, numArray.get(j) - minValue);
            minValue = Math.min(numArray.get(j), minValue);
        }
        return maxProfit;
    }
}
