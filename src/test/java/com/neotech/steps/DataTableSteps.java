package com.neotech.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {


@When("I login to the HRMS")
public void i_login_to_the_hrms() {
    
	System.out.println("Login");
	
}

@When("I want to add employees")
public void i_want_to_add_employees(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //

	//List of maps - recap??
	
	/*
	 * Map<String, String> map1 = new HashedMap<>(); map1.put("FN", "Kamer");
	 * map1.put("MN", "Can"); map1.put("LN", "Akarsu");
	 * 
	 * Map<String, String> map2 = new HashedMap<>(); map2.put("FN", "Brian");
	 * map2.put("LN", "Smith");
	 * 
	 * Map<String, String> map3 = new HashedMap<>(); map3.put("FN", "Tuba");
	 * map3.put("LN", "Kutlu");
	 * 
	 * List<Map<String, String>> lm = new ArrayList<>(); lm.add(map1); lm.add(map2);
	 * lm.add(map3);
	 */	
	
	
	List<Map<String, String>> listOfMaps = dataTable.asMaps();
	
	for (Map<String, String> map: listOfMaps)
	{
		System.out.println(map);
	}
	
	
	
}

@Then("I validate employee added")
public void i_validate_employee_added() {
System.out.println("Validate employee added");
}
	
	
	
	
}
