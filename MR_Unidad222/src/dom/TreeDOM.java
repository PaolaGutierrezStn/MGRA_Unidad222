package dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import model.Tree;

public class TreeDOM {
	private String pathFile = "C:\\Users\\Juan Bosco Carrillo\\eclipse-workspace\\MR_Unidad222\\src\\data\\trees.xml";
	public void add(Tree data) {
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element trees = document.getDocumentElement();
				
				
				
				Element tree = document.createElement("tree");
				//CREAR ID TAGG
				
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				tree.appendChild(id);
				// create name tag
				
				Element name = document.createElement("name");
				name.appendChild(document.createTextNode(data.getName()));
				tree.appendChild(name);
				
				Element type = document.createElement("type");
				type.appendChild(document.createTextNode(data.getType()));
				tree.appendChild(type);
				
				Element height = document.createElement("height");
				height.appendChild(document.createTextNode(String.valueOf(data.getHeight())));
				tree.appendChild(height);
				
				Element locations = document.createElement("locations");
				locations.appendChild(document.createTextNode(data.getLocations()));
				tree.appendChild(locations);
				
				Element units = document.createElement("units");
				units.appendChild(document.createTextNode(String.valueOf(data.getUnits())));
				tree.appendChild(units);
				trees.appendChild(tree);
				
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
			NodeList nodelist = document.getElementsByTagName("tree");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element tree = (Element)nodelist.item(i);
				if (tree.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					tree.getParentNode().removeChild(tree);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error, cachando valores SpecieDOM delete");
		}
	}
	
	public void update (Tree data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("tree");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element tree = (Element)nodelist.item(i);
				if (tree.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					tree.getElementsByTagName("name").item(0).setTextContent(data.getName());
					tree.getElementsByTagName("type").item(0).setTextContent(data.getType());
					tree.getElementsByTagName("height").item(0).setTextContent(String.valueOf(data.getHeight()));
					tree.getElementsByTagName("locations").item(0).setTextContent(data.getLocations());
					tree.getElementsByTagName("units").item(0).setTextContent(String.valueOf(data.getUnits()));
					
					
					
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
System.out.println("Error delete DOM");
		}
		
	}
	
	public Tree findById(String id) {
		Tree tree = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("tree");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					tree = new Tree();
					tree.setId(id);
					tree.setName(s.getElementsByTagName("name").item(0).getTextContent());
					tree.setType(s.getElementsByTagName("type").item(0).getTextContent());
					tree.setHeight(Integer.parseInt(s.getElementsByTagName("height").item(0).getTextContent()));
					tree.setLocations(s.getElementsByTagName("locations").item(0).getTextContent());
					tree.setUnits(Integer.parseInt(s.getElementsByTagName("units").item(0).getTextContent()));
					
					
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Método finById DOM");
		}
		return tree;
	}
	
	public  List<Tree> getTree(){
		
		List<Tree> trees = new ArrayList<Tree>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("tree");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Tree tree = new Tree();
			tree.setId(s.getElementsByTagName("id").item(0).getTextContent());
			tree.setName(s.getElementsByTagName("name").item(0).getTextContent());
			tree.setType(s.getElementsByTagName("type").item(0).getTextContent());
			tree.setHeight(Integer.parseInt(s.getElementsByTagName("height").item(0).getTextContent()));
			tree.setLocations(s.getElementsByTagName("locations").item(0).getTextContent());
			tree.setUnits(Integer.parseInt(s.getElementsByTagName("units").item(0).getTextContent()));
			
			trees.add(tree);
			
		}
		return trees;
		
	}

}
