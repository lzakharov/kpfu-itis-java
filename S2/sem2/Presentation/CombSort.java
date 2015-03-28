public static int[] combSort(int[] a) {
    int gap = a.length;
    boolean swapped = true;

    while (gap > 1 || swapped) {
        if (gap > 1.247330950103979) {
            gap = (int)(gap / 1.247330950103979);
        }

        int i = 0;
        swapped = false;

        while (i + gap < a.length) {
            if (a[i] > a[i + gap]) {
                int k = a[i];
                a[i] = a[i + gap];
                a[i + gap] = k;
                swapped = true;
            }

            i++;
        }
    }

    return a;
}