package com.hoymm.root.sortingcomparer.ChartHandlingClasses;

/**
 * Created by root on 05.06.17.
 */

public class OptionsState {
    public boolean possitiveCase, negativeCase, randomCase;
    public boolean selectionSort, insertionSort, mergeSort, quickSort;

    private static final OptionsState ourInstance = new OptionsState();

    public static OptionsState getInstance() {
        return ourInstance;

        // TODO get last options configuration from SharedPreferences
    }

    private OptionsState() {
        possitiveCase = negativeCase = randomCase = selectionSort = insertionSort = mergeSort = quickSort = false;
    }
}
