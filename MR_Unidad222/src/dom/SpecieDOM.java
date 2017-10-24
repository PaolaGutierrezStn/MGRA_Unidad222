package dom;


import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Specie;

public class SpecieDOM {
	private String pathFile = "C:\\Users\\Juan Bosco Carrillo\\eclipse-workspace\\MR_Unidad222\\src\\data\\species.xml";
	public void add(Specie data) {
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element species = document.getDocumentElement();
				
				
				
				Element specie = document.createElement("specie");
				//CREAR ID TAGG
				
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				specie.appendChild(id);
				// create name tag
				
				Element name = document.createElement("name");
				name.appendChild(document.createTextNode(data.getName()));
				specie.appendChild(name);
				
					
				
				Element genus = document.createElement("genus");
				genus.appendChild(document.createTextNode(data.getGenus()));
				specie.appendChild(genus);
				
				
				
				Element speciess = document.createElement("species");
				speciess.appendChild(document.createTextNode(data.getSpecies()));
				specie.appendChild(speciess);
	
				Element value = document.createElement("value");
				value.appendChild(document.createTextNode(data.getValue()));
				specie.appendChild(value);
				
				species.appendChild(specie);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
				System.out.println("Error, cachando valores SpeciDOM");
			
		}
	}
	
	public void delete (String id ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("specie");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element specie = (Element)nodelist.item(i);
				if (specie.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					specie.getParentNode().removeChild(specie);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error, cachando valores SpecieDOM delete");
		}
	}
	
	public void update (Specie data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("specie");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element specie = (Element)nodelist.item(i);
				if (specie.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					specie.getElementsByTagName("name").item(0).setTextContent(data.getName());
					specie.getElementsByTagName("genus").item(0).setTextContent(data.getGenus());
					specie.getElementsByTagName("species").item(0).setTextContent(data.getSpecies());
					specie.getElementsByTagName("value").item(0).setTextContent(data.getValue());
					
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
System.out.println("Error delete DOM");
		}
		
	}
	
	public Specie findById(String id) {
		Specie specie = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("specie");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					specie = new Specie();
					specie.setId(id);
					specie.setName(s.getElementsByTagName("name").item(0).getTextContent());
					specie.setGenus(s.getElementsByTagName("genus").item(0).getTextContent());
					specie.setSpecies(s.getElementsByTagName("species").item(0).getTextContent());
					specie.setValue(s.getElementsByTagName("value").item(0).getTextContent());
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Método finById DOM");
		}
		return specie;
	}
	
	public  List<Specie> getSpecie(){
		
		List<Specie> species = new ArrayList<Specie>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("specie");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Specie specie = new Specie();
			specie.setId(s.getElementsByTagName("id").item(0).getTextContent());
			specie.setName(s.getElementsByTagName("name").item(0).getTextContent());
			specie.setGenus(s.getElementsByTagName("genus").item(0).getTextContent());
			specie.setSpecies(s.getElementsByTagName("species").item(0).getTextContent());
			specie.setValue(s.getElementsByTagName("value").item(0).getTextContent());
			
			species.add(specie);
			
		}
		return species;
		
	}

}
