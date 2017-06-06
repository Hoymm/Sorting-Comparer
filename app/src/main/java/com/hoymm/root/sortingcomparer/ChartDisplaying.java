package com.hoymm.root.sortingcomparer;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by root on 05.06.17.
 */

public class ChartDisplaying {
    private boolean positiveCase, randomCase, negativeCase;
    private boolean selectionSort, insertionSort, mergeSort, quickSort;
    private ArraySize arraySize;

    private Activity activity;

    public ChartDisplaying(Activity activity) {
        this.activity = activity;
    }

    public void changeArraySize(ArraySize arraySize){
        switch (arraySize){
            case small:
                showChartForSmallArraySize();
            case average:
                showChartForAverageArraySize();
            case big:
                showChartForBigArraySize();
        }

    }

    public void showPositiveCaseOnChart(){

    }
    public void hidePositiveCaseOnChart(){

    }
    public void showNegativeCaseOnChart(){

    }
    public void hideNegativeCaseOnChart(){

    }
    public void showRandomCaseOnChart(){

    }
    public void hideRandomCaseOnChart(){

    }

    public void showSelectionSortOnChart(){}
    public void hideSelectionSortOnChar(){};
    public void showInsertionSortOnChart(){}
    public void hideInsertionSortOnChar(){};
    public void showMergeSortOnChart(){}
    public void hideMergeSortOnChar(){};
    public void showQuickSortOnChart(){}
    public void hideQuickSortOnChar(){};

    public void showChartForSmallArraySize() {
        Toast.makeText(activity, "SMALL", Toast.LENGTH_SHORT).show();
    }
    public void showChartForAverageArraySize() {
        Toast.makeText(activity, "AVERAGE", Toast.LENGTH_SHORT).show();
    }
    public void showChartForBigArraySize() {
        Toast.makeText(activity, "BIG", Toast.LENGTH_SHORT).show();
    }
}
