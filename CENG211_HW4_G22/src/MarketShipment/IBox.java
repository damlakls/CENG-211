package MarketShipment;
// we create an interface  to write Box's methods
public interface IBox<T> {
	
	public boolean isFull();
	public boolean isEmpty();
	public boolean add(T item, int itemNumber, double itemVolume, String itemCode, String boxName);
	public T[] toArray();
	public T remove();
	public boolean remove(T item, int itemNumber, double itemVolume);
	public void clear();
	public boolean contains(T item);
	public int getCurrentSize();
	
}
