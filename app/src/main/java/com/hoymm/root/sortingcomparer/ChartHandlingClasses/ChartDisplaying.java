package com.hoymm.root.sortingcomparer.ChartHandlingClasses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.hoymm.root.sortingcomparer.AxisClasses.XAxisSortingTypes;
import com.hoymm.root.sortingcomparer.AxisClasses.XYMarkerView;
import com.hoymm.root.sortingcomparer.AxisClasses.YAxisSortingTime;
import com.hoymm.root.sortingcomparer.R;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

/**
 * Created by root on 05.06.17.
 */

public class ChartDisplaying implements OnChartValueSelectedListener {
    public static final int[] BAR_COLORS = {
            rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c")
    };

    private boolean positiveCase, randomCase, negativeCase;
    private boolean selectionSort, insertionSort, mergeSort, quickSort;
    private ArraySize arraySize;
    private Context context;

    private BarChart barChart;

    private enum ArraySize {
        small, average, big;
    }

    public ChartDisplaying(Context context) {
        this.context = context;

        barChart = (BarChart) ((Activity)context).findViewById(R.id.staticComparsionBarChartID);
        barChart.setOnChartValueSelectedListener(this);

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);

        barChart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        barChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        barChart.setPinchZoom(false);

        barChart.setDrawGridBackground(false);
        // mChart.setDrawYLabels(false);

        IAxisValueFormatter xAxisFormatter = new XAxisSortingTypes(barChart);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Light.ttf"));
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(xAxisFormatter);

        IAxisValueFormatter custom = new YAxisSortingTime();

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Light.ttf"));
        leftAxis.setLabelCount(8, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
/*
        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setTypeface(mTfLight);
        rightAxis.setLabelCount(8, false);
        rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)*/

        Legend l = barChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        // l.setExtra(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
        // "def", "ghj", "ikl", "mno" });
        // l.setCustom(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
        // "def", "ghj", "ikl", "mno" });

        XYMarkerView mv = new XYMarkerView(context, xAxisFormatter);
        mv.setChartView(barChart); // For bounds control
        barChart.setMarker(mv); // Set the marker to the chart

        setData();

        // setting data
        /*mSeekBarY.setProgress(50);
        mSeekBarX.setProgress(12);

        mSeekBarY.setOnSeekBarChangeListener(this);
        mSeekBarX.setOnSeekBarChangeListener(this);
*/

        // mChart.setDrawLegend(false);
    }


    private void setData() {

        float start = 1f;

        ArryList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        // TODO
        for (int j = 0; j < 4; ++j) {
            for (int i = 0; i < 3; ++i) {
                yVals1.add(new BarEntry(j*4+i, (int)(100+j*i*Math.random()*1000)));
                if (i % 4 == 3)
                    ++i;
            }
        }

        BarDataSet set1;

        if (barChart.getData() != null &&
                barChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) barChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Sorting Types");

            set1.setDrawIcons(false);

            set1.setColors(BAR_COLORS);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setValueTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Light.ttf"));
            data.setBarWidth(0.9f);

            barChart.setData(data);
        }
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

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
    public void showMergeSortOnChart(){
    }
    public void hideMergeSortOnChar(){};
    public void showQuickSortOnChart(){}
    public void hideQuickSortOnChar(){};

    public void showChartForSmallArraySize() {
    }
    public void showChartForAverageArraySize() {
    }
    public void showChartForBigArraySize() {
    }
}
