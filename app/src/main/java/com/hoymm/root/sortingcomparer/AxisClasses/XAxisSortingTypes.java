package com.hoymm.root.sortingcomparer.AxisClasses;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by root on 06.06.17.
 */

public class XAxisSortingTypes implements IAxisValueFormatter {
    protected String[] sortingTypes = new String[]{
            "Wybor", "Wstawianie", "Scalanie", "Szybkie"
    };

    private BarLineChartBase<?> chart;

    public XAxisSortingTypes(BarLineChartBase<?> chart) {
        this.chart = chart;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        String result = "";

        if (value < 3)
            result = "WY:";
        else if (value < 7)
            result = "WS:";
        else if (value < 11)
            result = "SC:";
        else if (value < 15)
            result = "SZ:";

        switch ((int)value%4){
            case 0:
                return result + "O";
            case 1:
                return result + "L";
            case 2:
                return result + "P";
            default:
                return String.valueOf(value);
        }
    }
}
