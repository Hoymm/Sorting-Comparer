package com.hoymm.root.sortingcomparer.ChartHandlingClasses;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hoymm.root.sortingcomparer.R;

/**
 * Created by root on 05.06.17.
 */

public class ChartOptionsAndDisplaying {
    private ChartDisplaying chartDisplaying;
    private CheckBox positiveSortedCase, negativeSortedCase, randomSortedCase;
    private CheckBox selectionSort, insertionSort, mergeSort, quickSort;
    private RadioGroup arraySizeRadioGroup;
    private Context context;


    public ChartOptionsAndDisplaying(Context context) {
        this.context = context;
        initChartDisplayingClass();
        linkLocalObjectsWithXML();
        setFunctinalityForLocalObjectsConnectedToXML();

    }

    private void initChartDisplayingClass() {
        chartDisplaying = new ChartDisplaying(context);
    }

    private void linkLocalObjectsWithXML() {
        positiveSortedCase = (CheckBox) ((Activity)context).findViewById(R.id.positiveCaseCB_ID);
        negativeSortedCase = (CheckBox) ((Activity)context).findViewById(R.id.negativeCaseCB_ID);
        randomSortedCase = (CheckBox) ((Activity)context).findViewById(R.id.randomCaseCB_ID);

        selectionSort = (CheckBox) ((Activity)context).findViewById(R.id.selectionSortCB_ID);
        insertionSort = (CheckBox) ((Activity)context).findViewById(R.id.insertionSortCB_ID);
        mergeSort = (CheckBox) ((Activity)context).findViewById(R.id.mergeSortCB_ID);
        quickSort = (CheckBox) ((Activity)context).findViewById(R.id.quickSortCB_ID);

        arraySizeRadioGroup = (RadioGroup) ((Activity)context).findViewById(R.id.arraySizeRG_ID);
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
                chartDisplaying.configureChartApperanceAndBehavior();
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
