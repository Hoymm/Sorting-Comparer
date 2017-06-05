package com.hoymm.root.sortingcomparer;

import android.app.Activity;

/**
 * Created by root on 05.06.17.
 */

public class ChartDisplaying {
    private Activity activity;

    public ChartDisplaying(Activity activity) {
        this.activity = activity;
    }

    public void addPositiveCaseBars(){}
    public void addNegativeCaseBars(){}
    public void addRandomCaseBars(){}

    public void addSelectionSortBars(){}
    public void addInsertionSortBars(){}
    public void addMergeSortBars(){}
    public void addQuickSortBars(){}

    public void changeArraySize(ArraySize arraySize){
        switch (arraySize){
            case small:
                showForSmallArraySize();
            case average:
                showForAverageArraySize();
            case big:
                showForBigArraySize();
        }

    }

    private void showForSmallArraySize() {
    }

    private void showForAverageArraySize() {
    }

    private void showForBigArraySize() {
    }
}
