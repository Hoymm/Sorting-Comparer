package com.hoymm.root.sortingcomparer.ChartHandlingClasses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.Toast;

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

/**
 * Created by root on 05.06.17.
 */

public class ChartDisplaying implements OnChartValueSelectedListener {

    private OptionsConfiguration optionsConfiguration;
    private ArrayList<BarEntry> yVals1;
    private Context context;
    private BarChart barChart;

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
        configureChartApperanceAndBehavior();
    }

    private int currentXOSPositionToAdd;
    public void configureChartApperanceAndBehavior() {
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


        int[] VORDIPLOM_COLORS = {
                Color.GREEN, Color.YELLOW, Color.RED
        };

        ArrayList<Integer> BAR_COLORS = new ArrayList<>();
        if (optionsConfiguration.positiveCaseEnabled)
            BAR_COLORS.add(Color.GREEN);
        if (optionsConfiguration.randomCaseEnabled)
            BAR_COLORS.add(Color.YELLOW);
        if (optionsConfiguration.negativeCaseEnabled)
            BAR_COLORS.add(Color.RED);

        l.setExtra(VORDIPLOM_COLORS, new String[] {"Optymistyczny", "Losowy", "Pesymistyczny" });

        XYMarkerView mv = new XYMarkerView(context, xAxisFormatter);
        mv.setChartView(barChart); // For bounds control
        barChart.setMarker(mv); // Set the marker to the chart



        yVals1 = new ArrayList<>();

        /*
        if (optionsConfiguration.positiveCaseEnabled)
            addPositiveCaseData();
        if (optionsConfiguration.randomCaseEnabled)
            addRandomCaseData();
        if (optionsConfiguration.negativeCaseEnabled)
            addNegativeCaseData();
        */

        currentXOSPositionToAdd = 0;
        if (optionsConfiguration.selectionSortEnabled)
            addSortData(SortingTypes.Selection);
        if (optionsConfiguration.insertionSortEnabled)
            addSortData(SortingTypes.Insertion);
        if (optionsConfiguration.mergeSortEnabled)
            addSortData(SortingTypes.Merge);
        if (optionsConfiguration.quickSortEnabled)
            addSortData(SortingTypes.Quick);

        BarDataSet set1;



        if (barChart.getData() != null &&
                barChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) barChart.getData().getDataSetByIndex(0);

            set1.setValues(yVals1);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "");

            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setValueTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Light.ttf"));
            data.setBarWidth(0.9f);

            barChart.setData(data);
        }
        set1.setColors(BAR_COLORS);
        barChart.setDrawBarShadow(true);

        barChart.invalidate();
        barChart.animateY(1400);
    }

    private void addSortData(SortingTypes sortType) {
        switch (optionsConfiguration.arraySizeSelected){
            case small:
                if (optionsConfiguration.positiveCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.SmallArray.getPossitive(sortType)));
                if (optionsConfiguration.randomCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.SmallArray.getRandom(sortType)));
                if (optionsConfiguration.negativeCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.SmallArray.getNegative(sortType)));
                break;
            case average:
                if (optionsConfiguration.positiveCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.AverageArray.getPossitive(sortType)));
                if (optionsConfiguration.randomCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.AverageArray.getRandom(sortType)));
                if (optionsConfiguration.negativeCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.AverageArray.getNegative(sortType)));
                break;
            case big:
                if (optionsConfiguration.positiveCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.BigArray.getPossitive(sortType)));
                if (optionsConfiguration.randomCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.BigArray.getRandom(sortType)));
                if (optionsConfiguration.negativeCaseEnabled)
                    yVals1.add(new BarEntry(currentXOSPositionToAdd++, ChartData.BigArray.getNegative(sortType)));
                break;
        }
        ++currentXOSPositionToAdd;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    public void showPositiveCaseOnChart(){
        optionsConfiguration.positiveCaseEnabled = true;
        configureChartApperanceAndBehavior();
    }
    public void hidePositiveCaseOnChart(){
        optionsConfiguration.positiveCaseEnabled = false;
        configureChartApperanceAndBehavior();
    }
    public void showNegativeCaseOnChart(){
        optionsConfiguration.negativeCaseEnabled = true;
        configureChartApperanceAndBehavior();
    }
    public void hideNegativeCaseOnChart(){
        optionsConfiguration.negativeCaseEnabled = false;
        configureChartApperanceAndBehavior();
    }
    public void showRandomCaseOnChart(){
        optionsConfiguration.randomCaseEnabled = true;
        configureChartApperanceAndBehavior();
    }
    public void hideRandomCaseOnChart(){
        optionsConfiguration.randomCaseEnabled = false;
        configureChartApperanceAndBehavior();
    }

    public void showSelectionSortOnChart(){
        optionsConfiguration.selectionSortEnabled = true;
        configureChartApperanceAndBehavior();
    }
    public void hideSelectionSortOnChar(){
        optionsConfiguration.selectionSortEnabled = false;
        configureChartApperanceAndBehavior();
    }
    public void showInsertionSortOnChart(){
        optionsConfiguration.insertionSortEnabled = true;
        configureChartApperanceAndBehavior();
    }
    public void hideInsertionSortOnChar(){
        optionsConfiguration.insertionSortEnabled = false;
        configureChartApperanceAndBehavior();
    }
    public void showMergeSortOnChart(){
        optionsConfiguration.mergeSortEnabled = true;
        configureChartApperanceAndBehavior();
    }
    public void hideMergeSortOnChar(){
        optionsConfiguration.mergeSortEnabled = false;
        configureChartApperanceAndBehavior();
    }
    public void showQuickSortOnChart(){
        optionsConfiguration.quickSortEnabled = true;
        configureChartApperanceAndBehavior();
    }
    public void hideQuickSortOnChar(){
        optionsConfiguration.quickSortEnabled = false;
        configureChartApperanceAndBehavior();
    }

    public void showChartForSmallArraySize() {
        optionsConfiguration.arraySizeSelected = ArraySize.small;
        configureChartApperanceAndBehavior();
    }
    public void showChartForAverageArraySize() {
        optionsConfiguration.arraySizeSelected = ArraySize.average;
        configureChartApperanceAndBehavior();
    }
    public void showChartForBigArraySize() {
        optionsConfiguration.arraySizeSelected = ArraySize.big;
        configureChartApperanceAndBehavior();
    }
}
