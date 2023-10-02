package MarketShipment;

//we create an interface  to write Container's methods
public interface IContainer<T> {
	public boolean isFull() ;
	public boolean isEmpty();
	public boolean add(Object box, double boxVolume);
	public boolean remove(Object box, double itemVolume);
	public T remove();
}
