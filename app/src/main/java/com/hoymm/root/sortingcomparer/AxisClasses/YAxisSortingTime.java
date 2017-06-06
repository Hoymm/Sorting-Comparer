package com.hoymm.root.sortingcomparer.AxisClasses;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by root on 06.06.17.
 */

public class YAxisSortingTime implements IAxisValueFormatter {


    public YAxisSortingTime() {
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return (value/1000) + "s";
    }
}
