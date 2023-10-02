package MarketShipment;

import RuleExceptions.ContainerCapacityException;
import RuleExceptions.ContainerShippedException;

public class Container<T> {
	private T[] container;
	private String containerCode;
	private int volume;
	private String serialNumber;

	private double totalVolume; 
	private int entries;
	private boolean isShipped;  
	private int shipCount = 0;

	public Container() {
		this(null, 0, null);
	}
	
	public Container(String containerCode, int volume, String serialNumber) {
		this.containerCode = containerCode;
		this.volume = volume;
		this.serialNumber = serialNumber;
		entries = 0;
		isShipped = false;
		container = (T[]) new Box[2];
	}
	
	public Container(Container<T> container) {
		containerCode = container.containerCode;
		volume = container.volume;
		serialNumber = container.serialNumber;
	}


	public boolean isFull() {
		return ((int)totalVolume==volume);
	}


	public boolean isEmpty() {
		return ((int)totalVolume!=volume);
	}

	
	public boolean add(Box box, double boxVolume) {
		boolean result = true;
		
		try {
			if(isShipped())
				throw new ContainerShippedException();
			if(isFull()){
				result=false;
				throw new ContainerCapacityException();
				
			}else if(box==null || boxVolume<0){
				throw new NullPointerException();
			}else{
				container[entries] = (T) box;
				entries++;
				totalVolume += boxVolume;
				System.out.println("Box "+box.getSerialNumber()+" has been placed to the container "+serialNumber);
			}
		} catch (ContainerCapacityException | ContainerShippedException e) {
			e.getMessage();
		}return result;
	}

	
	public boolean remove(Object box, double itemVolume) {
		boolean found = false;
			
		for(int i=0; !found && (i<entries); i++) {
			if(box.equals(container[i])) {
				found = true;
				
				container[i] = container[entries-1];
				container[entries-1] = null;
				entries--;
				totalVolume -=itemVolume;
			}
		}return found;
	}
	
	
	public T remove() {
		T lastItem = null;
		if(!isEmpty()) {
			lastItem = container[entries-1];
			container[entries-1] = null;
			entries--;
		}return lastItem;
	}


	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}


	public boolean contains(Object box) {
		boolean found = false;
		int index = 0;
		while(!found && index<entries) {
			if(box.equals(container[index]))
				found = true;
			else
				index++;
		}return found;
	}
	

	public int getCurrentSize() {
		return entries;
	}
	
	
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] tempContainer = (T[]) new Object[2];
		for(int i=0; i<tempContainer.length; i++)
			tempContainer[i] = container[i];
		return tempContainer;
	}

	public boolean isShipped(){
		return isShipped;
  }

  public void setIsShipped(){
	  if(shipCount==0){
		  shipCount++;
		  isShipped = true;
		  System.out.println("Container "+serialNumber+" has been shipped!");
	  }
  }

	public String getContainerCode() {
		return containerCode;
	}

	public int getVolume() {
		return volume;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	
}