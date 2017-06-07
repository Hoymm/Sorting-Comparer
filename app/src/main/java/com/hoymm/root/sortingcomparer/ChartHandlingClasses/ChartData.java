package com.hoymm.root.sortingcomparer.ChartHandlingClasses;

/**
 * Created by root on 07.06.17.
 */

public class ChartData {
    static class SmallArray {
        static class positive{
            static int selection = 56;
            static int insertion = 0;
            static int merge = 1;
            static int quick = 1;
        }
        static class negative{
            static int selection = 64;
            static int insertion = 70;
            static int merge = 1;
            static int quick = 150;
        }
        static class random{
            static int selection = 46;
            static int insertion = 36;
            static int merge = 2;
            static int quick = 1;
        }
    }

    static class AverageArray {
        static class positive{
            static int selection = 4391;
            static int insertion = 1;
            static int merge = 15;
            static int quick = 10;
        }
        static class negative{
            static int selection = 4771;
            static int insertion = 6865;
            static int merge = 17;
            static int quick = 11812;
        }
        static class random{
            static int selection = 4470;
            static int insertion = 3488;
            static int merge = 19;
            static int quick = 11;
        }
    }

    static class BigArray {
        static class positive{
            static int selection = 20186;
            static int insertion = 1;
            static int merge = 34;
            static int quick = 22;
        }
        static class negative{
            static int selection = 22248;
            static int insertion = 32123;
            static int merge = 33;
            static int quick = 53175;
        }
        static class random{
            static int selection = 21015;
            static int insertion = 16552;
            static int merge = 41;
            static int quick = 29;
        }
    }

}
