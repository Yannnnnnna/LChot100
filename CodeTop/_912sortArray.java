import java.util.Random;

import static java.lang.StrictMath.random;



/**
 * @author wyr on 2026/2/23
 */
public class _912sortArray {
    public int[] sortArray(int[] nums) {
        //手撕快排
//        quickSort(nums, 0, nums.length - 1);
        //归并排序
//        int[] tmp = new int[nums.length];
//        mergeSort(nums,0,nums.length - 1, tmp);
        //堆排序
        heapSort(nums);
        return nums;
    }
    //堆排序
    private void heapSort(int[] nums){
        int n = nums.length;
        //构建堆
        for (int i = n / 2 -1; i >= 0 ; i--) {
            heapify(nums, n, i);
        }
        //从堆顶逐个弹出
        for (int i = n -1; i > 0 ; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }

    }
    private void heapify(int[] nums, int heapSize, int i){
        int max = i;
        int left = 2*i +1;
        int right = 2 * i +2;
        //判断左子树是不是比根小
        if (left < heapSize && nums[left] > nums[max]){
            max = left;
        }
        //判断右子树是不是比根小
        if (right < heapSize && nums[right] > nums[max]){
            max = right;
        }
        //递归剩余子树
        if (max != i){
            swap(nums, max,i);
            heapify(nums, heapSize, max);
        }

    }
    //归并排序
    public void mergeSort(int[] nums, int left, int right, int[] tmp){

        if(right-left <= 0){
            return;
        }
        //递归左右两部分
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid,tmp);
        mergeSort(nums, mid + 1, right, tmp);
        //合并
        // 复制子数组到临时数组（保持原数组不变）
        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right){
            if (tmp[i] <= tmp[j]){
                nums[k++] = tmp[i++];
            }else {
                nums[k++] = tmp[j++];
            }
        }
        //处理剩余元素
        while (i <= mid){
            nums[k++] = tmp[i++];
        }
        while (j <= right){
            nums[k++] = tmp[j++];
        }

    }
    //快速排序
    public void quickSort(int[] arr, int left, int right) {
        if (left < right){
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid -1);
            quickSort(arr, mid + 1, right);
        }

    }
    /*Lomuto 单指针法*/
    private int partition(int[] arr, int left, int right) {
        // 1. 随机选择 pivot 索引（正确方式！）
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        // 2. 将 pivot 交换到数组末尾（right 位置）
        swap(arr, pivotIndex, right);
        int pivot = arr[right]; // pivot 值
        //指向小于pivot区域末尾
        int i= left -1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot){
                //扩大区域
                i++;
                swap(arr, i, j);
            }
        }
        //放回原位
        swap(arr, i + 1, right);
        return i + 1;
    }
//    /*Hoare 双指针法*/
//    public int partition(int[] arr, int left, int right) {
//        int mid = new Random().nextInt(right - left + 1) + left;
//        int pivot = arr[mid];
//        //交换，方便分区
//        swap(arr, left, mid);
//        while (left < right){
//            while (left < right && arr[right] >= pivot){
//                right--;
//            }
//            arr[left] = arr[right];
//            while (left < right && arr[left] <= pivot){
//                left++;
//            }
//            arr[right] = arr[left];
//        }
//        arr[left] = pivot;
//        return left;
//    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
