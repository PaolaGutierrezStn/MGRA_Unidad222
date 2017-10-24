package model;

public class Tree {
	private String id;
	private String name;
	private String type;
	private int height;
	private String locations;
	private int units;
	public Tree(String id, String name, String type, int height, String locations, int units) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.height = height;
		this.locations = locations;
		this.units = units;
	}
	public Tree() {
		this("","","",0,"",0);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}


}
