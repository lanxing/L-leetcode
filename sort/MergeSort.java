package lalgorithm.sort;

/**
 * @author gaofan
 * @version 1.0
 * @date 2019-03-15 16:24
 * @desc 归并排序
 */
public class MergeSort {
    void mergearray(int a[], int first, int mid, int last) {
        int i = first, j = mid + 1;
        int m = mid,   n = last;
        int k = 0;
        int[] temp = new int[last - first + 1];

        while (i <= m && j <= n) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];
        for (i = first, k = 0; i <= last; ++i){
            a[i] = temp[k++];
        }
    }

    void mergesort(int a[], int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergesort(a, first, mid);    //左边有序
            mergesort(a, mid + 1, last); //右边有序
            mergearray(a, first, mid, last); //再将二个有序数列合并
        }
    }
}
