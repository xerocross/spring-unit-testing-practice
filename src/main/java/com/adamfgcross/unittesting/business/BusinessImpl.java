package com.adamfgcross.unittesting.business;

import com.adamfgcross.unittesting.data.SomeDataService;

public class BusinessImpl {


    SomeDataService someDataService;

    public SomeDataService getSomeDataService() {
        return someDataService;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value: data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.getAllData();
        for (int value: data) {
            sum += value;
        }
        return sum;
    }

    public void storeSum() {
        int sum = 0;
        int[] data = someDataService.getAllData();
        for (int value: data) {
            sum += value;
        }
        someDataService.storeData(sum);
    }

}
