package pl.coderslab.dao;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

	
	public static List<String> addClientList(String name, String lastName, String dateofBirth) {
		
		List<String> attributes = new ArrayList<>();
		
		attributes.add(name);
		attributes.add(lastName);
		attributes.add(dateofBirth);
		
		return attributes;
	}
	
}
