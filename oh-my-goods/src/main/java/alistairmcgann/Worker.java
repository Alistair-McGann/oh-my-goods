package alistairmcgann;

public class Worker {

	public  boolean isProductive;
	private  double cost;
	private  boolean sun;
	public final Resource resource;
	
	public Worker() {
		resource = Resource.ORE;
	}
	
	public double getCost() {
		return cost;
	}
	
}
