package com.lody.virtual.helper.utils;

import com.lody.virtual.helper.compat.ObjectsCompat;

/**
 * @author Lody
 *
 */
public class ArrayUtils {

	public static <T> boolean contains(T[] array, T value) {
		return indexOf(array, value) != -1;
	}
	public static boolean contains(int[] array, int value) {
		if (array == null) return false;
		for (int element : array) {
			if (element == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return first index of {@code value} in {@code array}, or {@code -1} if
	 * not found.
	 */
	public static <T> int indexOf(T[] array, T value) {
		if (array == null) return -1;
		for (int i = 0; i < array.length; i++) {
			if (ObjectsCompat.equals(array[i], value)) return i;
		}
		return -1;
	}

	public static int indexOfFirst(Object[] array, Class<?> type) {
		if (!isEmpty(array)) {
			int N = -1;
			for (Object one : array) {
				N++;
				if (one != null && type == one.getClass()) {
					return N;
				}
			}
		}
		return -1;
	}

	public static int indexOfObject(Object[] array, Class<?> type, int sequence) {
		if (array == null) {
			return -1;
		}
		while (sequence < array.length) {
			if (type.isInstance(array[sequence])) {
				return sequence;
			}
			sequence++;
		}
		return -1;
	}
	public static int indexOf(Object[] array, Class<?> type, int sequence) {
		if (!isEmpty(array)) {
			int N = -1;
			for (Object one : array) {
				N++;
				if (one != null && one.getClass() == type) {
					if (--sequence <= 0) {
						return N;
					}
				}
			}
		}
		return -1;
	}

	public static int indexOfLast(Object[] array, Class<?> type) {
		if (!isEmpty(array)) {
			for (int N = array.length; N > 0; N--) {
				Object one = array[N - 1];
				if (one != null && one.getClass() == type) {
					return N - 1;
				}
			}
		}
		return -1;
	}

	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getFirst(Object[] args, Class<?> clazz) {
		int index = indexOfFirst(args, clazz);
		if (index != -1) {
			return (T) args[index];
		}
		return null;
	}
}
