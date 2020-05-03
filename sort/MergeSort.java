package sort;

/**
 * Java归并排序 -- 算法思想：分治，把数组一分为二，依次继续向下对比，分成不同的子数组，最后再进行合并
 */
public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { -12, 3, 2, 34, 5, 8, 1 };

		int[] tmp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, tmp);

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				buf.append(arr[i] + "");
			else
				buf.append(arr[i] + " , ");
		}
		System.out.println(buf.toString());
	}

	public static void merge(int[] arr, int low, int mid, int high, int[] tmp) {

		int i = 0;

		// 左边序列和右边序列起始索引
		int j = low, k = mid + 1;

		while (j <= mid && k <= high) {
			if (arr[j] < arr[k]) {
				tmp[i++] = arr[j++];
			} else {
				tmp[i++] = arr[k++];
			}
		}

		// 若左边序列还有剩余，则将其全部拷贝进tmp[]中
		while (j <= mid) {
			tmp[i++] = arr[j++];
		}

		while (k <= high) {
			tmp[i++] = arr[k++];
		}

		for (int t = 0; t < i; t++) {
			arr[low + t] = tmp[t];
		}
	}

	public static void mergeSort(int[] arr, int low, int high, int[] tmp) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid, tmp); // 对左边序列进行归并排序
			mergeSort(arr, mid + 1, high, tmp); // 对右边序列进行归并排序
			merge(arr, low, mid, high, tmp); // 合并两个有序序列
		}
	}

}
