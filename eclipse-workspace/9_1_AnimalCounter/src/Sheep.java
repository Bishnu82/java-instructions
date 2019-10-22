
public class Sheep extends Animal implements Cloneable {
	
	private String name;

	public Sheep() {
		super();
	}
	

	public Sheep(String name) {
		super();
		this.name = name;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	


	@Override
	public String toString() {
		return "Sheep [name=" + name + "]";
	}


	@Override
	public void incrementCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCountString() {
		// TODO Auto-generated method stub
		return null;
	}

}
 