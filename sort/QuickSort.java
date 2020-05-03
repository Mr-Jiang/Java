package sort;

/**
 * Java快速排序 -- 算法思想：选择一个基准值，不断与
 */
public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { -12, 3, 2, 34, 5, 8, 1 };
		quickSort(arr, 0, arr.length - 1);

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				buf.append(arr[i] + "");
			else
				buf.append(arr[i] + " , ");
		}
		System.out.println(buf.toString());
	}

	public static void quickSort(int[] arr, int left, int right) {

		int i, j, temp, t;

		if (left > right) {
			return;
		}

		i = left;
		j = right;

		// temp就是基准位
		temp = arr[left];

		while (i < j) {

			// 先看右边，依次往左递减
			while (temp <= arr[j] && i < j) {
				j--;
			}
			// 再看左边，依次往右递增
			while (temp >= arr[i] && i < j) {
				i++;
			}
			// 如果满足条件则交换
			if (i < j) {
				t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}

		}

		// 最后将基准为与i和j相等位置的数字交换
		arr[left] = arr[i];
		arr[i] = temp;

		// 递归调用左半数组
		quickSort(arr, left, j - 1);
		// 递归调用右半数组
		quickSort(arr, j + 1, right);
	}

}
