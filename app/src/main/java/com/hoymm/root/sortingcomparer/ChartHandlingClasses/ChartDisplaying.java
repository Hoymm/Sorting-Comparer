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

    private class OptionsConfiguration{
        boolean positiveCaseEnabled, randomCaseEnabled, negativeCaseEnabled;
        boolean selectionSortEnabled, insertionSortEnabled, mergeSortEnabled, quickSortEnabled;
        ArraySize arraySizeSelected;

        public OptionsConfiguration(){
            positiveCaseEnabled = randomCaseEnabled = negativeCaseEnabled = false;
            selectionSortEnabled = insertionSortEnabled = mergeSortEnabled = quickSortEnabled = false;
            arraySizeSelected = ArraySize.average;
        }
    }

    private OptionsConfiguration optionsConfiguration;
    private ArrayList<BarEntry> yVals1;

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
        optionsConfiguration = new OptionsConfiguration();
        configureChartApperanceAndBehavior(context);
    }

    private void configureChartApperanceAndBehavior(Context context) {
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

        refreshChart();

        // setting data
        /*mSeekBarY.setProgress(50);
        mSeekBarX.setProgress(12);

        mSeekBarY.setOnSeekBarChangeListener(this);
        mSeekBarX.setOnSeekBarChangeListener(this);
*/

        // mChart.setDrawLegend(false);
    }


    public void refreshChart() {

        yVals1 = new ArrayList<>();

        if (optionsConfiguration.positiveCaseEnabled)
            addPositiveCaseData();
        if (optionsConfiguration.randomCaseEnabled)
            addRandomCaseData();
        if (optionsConfiguration.negativeCaseEnabled)
            addNegativeCaseData();

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
        barChart.invalidate();
    }

    private void addPositiveCaseData() {
        switch (optionsConfiguration.arraySizeSelected){
            case small:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(0, ChartData.SmallArray.positive.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(4, ChartData.SmallArray.positive.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(8, ChartData.SmallArray.positive.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(12, ChartData.SmallArray.positive.quick));
                break;
            case average:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(0, ChartData.AverageArray.positive.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(4, ChartData.AverageArray.positive.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(8, ChartData.AverageArray.positive.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(12, ChartData.AverageArray.positive.quick));
                break;
            case big:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(0, ChartData.BigArray.positive.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(4, ChartData.BigArray.positive.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(8, ChartData.BigArray.positive.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(12, ChartData.BigArray.positive.quick));
                break;
        }
    }

    private void addRandomCaseData() {
        switch (optionsConfiguration.arraySizeSelected){
            case small:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(1, ChartData.SmallArray.random.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(5, ChartData.SmallArray.random.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(9, ChartData.SmallArray.random.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(13, ChartData.SmallArray.random.quick));
                break;
            case average:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(1, ChartData.AverageArray.random.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(5, ChartData.AverageArray.random.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(9, ChartData.AverageArray.random.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(13, ChartData.AverageArray.random.quick));
                break;
            case big:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(1, ChartData.BigArray.random.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(5, ChartData.BigArray.random.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(9, ChartData.BigArray.random.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(13, ChartData.BigArray.random.quick));
                break;
        }
    }

    private void addNegativeCaseData() {
        switch (optionsConfiguration.arraySizeSelected){
            case small:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(2, ChartData.SmallArray.negative.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(6, ChartData.SmallArray.negative.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(10, ChartData.SmallArray.negative.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(14, ChartData.SmallArray.negative.quick));
                break;
            case average:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(2, ChartData.AverageArray.negative.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(6, ChartData.AverageArray.negative.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(10, ChartData.AverageArray.negative.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(14, ChartData.AverageArray.negative.quick));
                break;
            case big:
                if (optionsConfiguration.selectionSortEnabled)
                    yVals1.add(new BarEntry(2, ChartData.BigArray.negative.selection));
                if (optionsConfiguration.insertionSortEnabled)
                    yVals1.add(new BarEntry(6, ChartData.BigArray.negative.insertion));
                if (optionsConfiguration.mergeSortEnabled)
                    yVals1.add(new BarEntry(10, ChartData.BigArray.negative.merge));
                if (optionsConfiguration.quickSortEnabled)
                    yVals1.add(new BarEntry(14, ChartData.BigArray.negative.quick));
                break;
        }
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    public void showPositiveCaseOnChart(){
        optionsConfiguration.positiveCaseEnabled = true;
        refreshChart();
    }
    public void hidePositiveCaseOnChart(){
        optionsConfiguration.positiveCaseEnabled = false;
        refreshChart();
    }
    public void showNegativeCaseOnChart(){
        optionsConfiguration.negativeCaseEnabled = true;
        refreshChart();
    }
    public void hideNegativeCaseOnChart(){
        optionsConfiguration.negativeCaseEnabled = false;
        refreshChart();
    }
    public void showRandomCaseOnChart(){
        optionsConfiguration.randomCaseEnabled = true;
        refreshChart();
    }
    public void hideRandomCaseOnChart(){
        optionsConfiguration.randomCaseEnabled = false;
        refreshChart();
    }

    public void showSelectionSortOnChart(){
        optionsConfiguration.selectionSortEnabled = true;
        refreshChart();
    }
    public void hideSelectionSortOnChar(){
        optionsConfiguration.selectionSortEnabled = false;
        refreshChart();
    }
    public void showInsertionSortOnChart(){
        optionsConfiguration.insertionSortEnabled = true;
        refreshChart();
    }
    public void hideInsertionSortOnChar(){
        optionsConfiguration.insertionSortEnabled = false;
        refreshChart();
    }
    public void showMergeSortOnChart(){
        optionsConfiguration.mergeSortEnabled = true;
        refreshChart();
    }
    public void hideMergeSortOnChar(){
        optionsConfiguration.mergeSortEnabled = false;
        refreshChart();
    }
    public void showQuickSortOnChart(){
        optionsConfiguration.quickSortEnabled = true;
        refreshChart();
    }
    public void hideQuickSortOnChar(){
        optionsConfiguration.quickSortEnabled = false;
        refreshChart();
    }

    public void showChartForSmallArraySize() {
        optionsConfiguration.arraySizeSelected = ArraySize.small;
        refreshChart();
    }
    public void showChartForAverageArraySize() {
        optionsConfiguration.arraySizeSelected = ArraySize.average;
        refreshChart();
    }
    public void showChartForBigArraySize() {
        optionsConfiguration.arraySizeSelected = ArraySize.big;
        refreshChart();
    }
}
