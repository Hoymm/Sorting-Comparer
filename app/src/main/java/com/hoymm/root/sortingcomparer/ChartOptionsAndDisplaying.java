package com.hoymm.root.sortingcomparer;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

/**
 * Created by root on 05.06.17.
 */

public class ChartOptionsAndDisplaying {
    private ChartDisplaying chartDisplaying;
    private CheckBox positiveSortedCase, negativeSortedCase, randomSortedCase;
    private CheckBox selectionSort, insertionSort, mergeSort, quickSort;
    private RadioGroup arraySizeRadioGroup;
    private Activity activity;


    public ChartOptionsAndDisplaying(Activity activity) {
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
        setArraySortedWayCaseCheckBoxAction();
        setSortingTypeCheckBoxAction();
        setArraySizeToDisplayRadioButtonAction();
    }

    private void setArraySortedWayCaseCheckBoxAction() {
        setPositiveCaseCheckBoxAction();
        setNegativeCaseCheckBoxAction();
        setRandomCaseCheckBoxAction();
    }

    private void setPositiveCaseCheckBoxAction() {
        positiveSortedCase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    chartDisplaying.showPositiveCaseOnChart();
                else
                    chartDisplaying.hidePositiveCaseOnChart();
            }
        });
    }
    private void setNegativeCaseCheckBoxAction() {
        negativeSortedCase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    chartDisplaying.showNegativeCaseOnChart();
                else
                    chartDisplaying.hideNegativeCaseOnChart();
            }
        });

    }
    private void setRandomCaseCheckBoxAction() {
        randomSortedCase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    chartDisplaying.showRandomCaseOnChart();
                else
                    chartDisplaying.hideRandomCaseOnChart();
            }
        });
    }


    private void setSortingTypeCheckBoxAction() {
        setSelectionSortCheckBoxAction();
        setInsertionSortCheckBoxAction();
        setMergeSortCheckBoxAction();
        setQuickSortCheckBoxAction();
    }

    private void setSelectionSortCheckBoxAction() {
        selectionSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    chartDisplaying.showSelectionSortOnChart();
                else
                    chartDisplaying.hideSelectionSortOnChar();
            }
        });
    }
    private void setInsertionSortCheckBoxAction() {
        insertionSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    chartDisplaying.showInsertionSortOnChart();
                else
                    chartDisplaying.hideInsertionSortOnChar();
            }
        });
    }
    private void setMergeSortCheckBoxAction() {
        mergeSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    chartDisplaying.showMergeSortOnChart();
                else
                    chartDisplaying.hideMergeSortOnChar();
            }
        });
    }
    private void setQuickSortCheckBoxAction() {
        quickSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    chartDisplaying.showQuickSortOnChart();
                else
                    chartDisplaying.hideQuickSortOnChar();
            }
        });
    }


    private void setArraySizeToDisplayRadioButtonAction(){
        arraySizeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch(checkedId){
                    case R.id.smallArrayRB_ID:
                        chartDisplaying.showChartForSmallArraySize();
                        break;
                    case R.id.averageArrayRB_ID:
                        chartDisplaying.showChartForAverageArraySize();
                        break;
                    case R.id.bigArrayRB_ID:
                        chartDisplaying.showChartForBigArraySize();
                        break;
                }
            }
        });

    }
}
