package sort;

/**
 * Java插入排序 -- 算法思想：以第一个元素为参考，从第二个元素开始，依次向右跟左边元素进行对比，
 * 如果右边的元素满足条件，则把元素进行插入
 */
public class InsertSort {

	public static void main(String[] args) {

		int[] arr = new int[] { -12, 3, 2, 34, 5, 8, 1 };
		insertSort(arr);
		
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				buf.append(arr[i] + "");
			else
				buf.append(arr[i] + " , ");
		}
		System.out.println(buf.toString());
	}

	public static int[] insertSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			int temp = arr[i];
			// 从小到大用 < 符号
			// 从大到小用 > 符号 -- 待改良
			for (int j = i; temp < arr[j - 1] && j > 0; j--) {
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		return arr;
	}
}
