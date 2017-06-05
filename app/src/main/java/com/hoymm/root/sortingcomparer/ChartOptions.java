package com.hoymm.root.sortingcomparer;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.RadioGroup;

/**
 * Created by root on 05.06.17.
 */

public class ChartOptions {
    private ChartDisplaying chartDisplaying;
    private CheckBox positiveSortedCase, negativeSortedCase, randomSortedCase;
    private CheckBox selectionSort, insertionSort, mergeSort, quickSort;
    private RadioGroup arraySizeRadioGroup;
    private Activity activity;

    public ChartOptions(Activity activity) {
        this.activity = activity;
        initChartDisplayingClass();
        linkLocalObjectsWithXML();
        setFunctinalityForLocalObjectsConnectedToXML();

    }

    private void initChartDisplayingClass() {
        chartDisplaying = new ChartDisplaying(activity);
    }

    private void linkLocalObjectsWithXML() {
        positiveSortedCase = (CheckBox) activity.findViewById(R.id.positiveCaseCB_ID);
        negativeSortedCase = (CheckBox) activity.findViewById(R.id.negativeCaseCB_ID);
        randomSortedCase = (CheckBox) activity.findViewById(R.id.randomCaseCB_ID);

        selectionSort = (CheckBox) activity.findViewById(R.id.selectionSortCB_ID);
        insertionSort = (CheckBox) activity.findViewById(R.id.insertionSortCB_ID);
        mergeSort = (CheckBox) activity.findViewById(R.id.mergeSortCB_ID);
        quickSort = (CheckBox) activity.findViewById(R.id.quickSortCB_ID);

        arraySizeRadioGroup = (RadioGroup) activity.findViewById(R.id.arraySizeRG_ID);
    }

    private void setFunctinalityForLocalObjectsConnectedToXML() {
        setFunctionalityForObjects();
    }

    private void setFunctionalityForObjects() {

    }
}
