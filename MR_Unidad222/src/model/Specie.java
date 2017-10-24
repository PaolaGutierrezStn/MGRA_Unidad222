package model;

public class Specie {
	
	private String id;
	private String name;
	private String genus;
	private String species;
	private String value;
	
	
	
	public Specie(String id, String name, String genus,String species, String value) {
		super();
		this.id = id;
		this.name = name;
		this.genus=genus;
		this.species=species;
		this.value=value;
	}
	
	public Specie() {
		this("","","","","");
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

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	


}
