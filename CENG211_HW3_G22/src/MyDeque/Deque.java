package MyDeque;

public class Deque<T> implements IDeque<T> {
	private static final int capacity = 500;
	private T[] items;
	private int numberOfItems;
	private T[] tempitems;

	public Deque() {
		this(capacity);
	}

	public Deque(int size) {
		items = (T[]) new Object[size];
		numberOfItems = 0;

	}

	public T getObjectIndex(int index) {

		if (index > numberOfItems) {
			throw new IllegalStateException("The index is out of bound");

		}
		if (isEmpty()) {
			throw new IllegalStateException("The index is out of bound");
		} else {
			return items[index];
		}
	}

	public T removeIndex(int index) {

		tempitems = (T[]) new Object[items.length - 1];

		if (index > numberOfItems) {
			throw new IllegalStateException("The index is out of bound");

		}
		if (isEmpty()) {
			throw new IllegalStateException("The index is out of bound");
		} else {

			tempitems = items;
			tempitems[index] = null;

			for (int i = 0; i < index; i++) {
				tempitems[i] = items[i];

			}
			for (int i = index + 1; i < numberOfItems; i++) {
				tempitems[i - 1] = items[i];

			}

			for (int i = 0; i < numberOfItems - 1; i++) {
				items[i] = tempitems[i];

			}

			numberOfItems--;

		}
		return items[index];
	}

	@Override
	public void addFront(T item) {

		if (numberOfItems == items.length) {
			increaseCapacity();
		}

		else {
			tempitems = (T[]) new Object[items.length + 1];
			for (int i = 0; i < numberOfItems; i++) {
				tempitems[i + 1] = items[i];
			}

			tempitems[0] = item;
			numberOfItems++;
			items = tempitems;

		}
	}

	@Override
	public void addLast(T item) {
		if (numberOfItems == items.length) {
			increaseCapacity();
		} else {
			items[numberOfItems] = item;
			numberOfItems++;
		}

	}

	@Override
	public T removeFront() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque is empty");

		} else {
			T[] tempItems = items;
			items[0] = null;
			for (int i = 0; i < numberOfItems; i++) {
				items[i] = tempItems[i + 1];
			}
			numberOfItems--;
			return tempItems[0];
		}

	}

	@Override
	public T removeLast() {

		if (isEmpty()) {
			throw new IllegalStateException("Deque is empty");

		} else {
			T item = items[numberOfItems];

			items[numberOfItems] = null;

			numberOfItems--;
			return item;
		}

	}

	@Override
	public T getFront() {

		return items[0];
	}

	@Override
	public T getLast() {

		return items[numberOfItems];
	}

	@Override
	public boolean isEmpty() {

		return numberOfItems == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < numberOfItems; i++) {
			items[i] = null;
		}
		numberOfItems = 0;

	}

	public void increaseCapacity() {
		T[] newItems = (T[]) new Object[numberOfItems * 2];
		for (int i = 0; i < numberOfItems; i++) {
			newItems[i] = items[i];
		}

	}

	public String toString() {
		String result = "";

		if (isEmpty()) {
			throw new IllegalStateException("The deque is empty");
		}

		else {
			for (int i = 0; i < numberOfItems; i++)
				result = result + items[i].toString() + " ";

			return result;
		}
	}

	public int getNumberOfItems() {
		// TODO Auto-generated method stub
		return numberOfItems;
	}

}
