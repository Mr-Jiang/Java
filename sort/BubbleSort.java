package sort;

/**
 * Java冒泡排序 -- 算法思想：将数组内的元素从头到尾进行两两相比，把比对结果相互交换位置，直到元素全部比对完毕
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = new int[] { -12, 3, 2, 34, 5, 8, 1 };

		for (int i = 0; i < arr.length - 1; i++) {
			// 内循环
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// 从小到大用 > 符号
				// 从大到小用 < 符号
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		// 遍历输出
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				buf.append(arr[i] + "");
			else
				buf.append(arr[i] + " , ");
		}
		System.out.println(buf.toString());

	}
}
