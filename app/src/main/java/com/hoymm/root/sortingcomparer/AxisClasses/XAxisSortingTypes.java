package com.hoymm.root.sortingcomparer.AxisClasses;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by root on 06.06.17.
 */

public class XAxisSortingTypes implements IAxisValueFormatter {
    protected String[] sortingTypes = new String[]{
            "Selection", "Insertion", "Merge", "Quick"
    };

    private BarLineChartBase<?> chart;

    public XAxisSortingTypes(BarLineChartBase<?> chart) {
        this.chart = chart;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return "XXXXXX";
    }
}
