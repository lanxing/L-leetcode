package lalgorithm.sort;

/**
 * @author gaofan
 * @version 1.0
 * @date 2019-07-18 20:14
 * @desc 功能描述
 */
public class QuickSort {
	private void quickSort(int[] nums, int i, int j){
		if (i > j){
			return;
		}
		int start = i, end = j;
		int target = start;
		while (start < end){
			while (start < end && nums[end] >= nums[target]){
				end--;
			}
			while (start < end && nums[start] <= nums[target]){
				start++;
			}
			if (start < end){
				swap(nums, start, end);
			}
		}
		swap(nums, start, target);
		quickSort(nums, i, start - 1);
		quickSort(nums, start + 1, j);
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
