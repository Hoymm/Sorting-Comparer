package com.hoymm.root.sortingcomparer.ChartHandlingClasses;

/**
 * Created by root on 07.06.17.
 */

public class ChartData {
    static class SmallArray {
        private static class positive {
            static int selection = 56;
            static int insertion = 0;
            static int merge = 1;
            static int quick = 1;
        }

        private static class negative {
            static int selection = 64;
            static int insertion = 70;
            static int merge = 1;
            static int quick = 150;
        }

        private static class random {
            static int selection = 46;
            static int insertion = 36;
            static int merge = 2;
            static int quick = 1;
        }

        static float getPossitive(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return positive.selection;
                case Insertion:
                    return positive.insertion;
                case Merge:
                    return positive.merge;
                case Quick:
                    return positive.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
        static float getNegative(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return negative.selection;
                case Insertion:
                    return negative.insertion;
                case Merge:
                    return negative.merge;
                case Quick:
                    return negative.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
        static float getRandom(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return random.selection;
                case Insertion:
                    return random.insertion;
                case Merge:
                    return random.merge;
                case Quick:
                    return random.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
    }


    static class AverageArray {
        private static class positive{
            static int selection = 4391;
            static int insertion = 1;
            static int merge = 15;
            static int quick = 10;
        }
        private static class negative{
            static int selection = 4771;
            static int insertion = 6865;
            static int merge = 17;
            static int quick = 11812;
        }
        private static class random{
            static int selection = 4470;
            static int insertion = 3488;
            static int merge = 19;
            static int quick = 11;
        }

        static float getPossitive(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return positive.selection;
                case Insertion:
                    return positive.insertion;
                case Merge:
                    return positive.merge;
                case Quick:
                    return positive.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
        static float getNegative(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return negative.selection;
                case Insertion:
                    return negative.insertion;
                case Merge:
                    return negative.merge;
                case Quick:
                    return negative.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
        static float getRandom(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return random.selection;
                case Insertion:
                    return random.insertion;
                case Merge:
                    return random.merge;
                case Quick:
                    return random.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
    }

    static class BigArray {
        private static class positive{
            static int selection = 20186;
            static int insertion = 1;
            static int merge = 34;
            static int quick = 22;
        }
        private static class negative{
            static int selection = 22248;
            static int insertion = 32123;
            static int merge = 33;
            static int quick = 53175;
        }
        private static class random{
            static int selection = 21015;
            static int insertion = 16552;
            static int merge = 41;
            static int quick = 29;
        }

        static float getPossitive(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return positive.selection;
                case Insertion:
                    return positive.insertion;
                case Merge:
                    return positive.merge;
                case Quick:
                    return positive.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
        static float getNegative(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return negative.selection;
                case Insertion:
                    return negative.insertion;
                case Merge:
                    return negative.merge;
                case Quick:
                    return negative.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
        static float getRandom(SortingTypes sortType) {
            switch (sortType) {
                case Selection:
                    return random.selection;
                case Insertion:
                    return random.insertion;
                case Merge:
                    return random.merge;
                case Quick:
                    return random.quick;
                default:
                    return Float.parseFloat(null);
            }
        }
    }

}
