package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.SpecieDOM;
import model.Specie;

/**
 * Servlet implementation class SpecieController
 */
@WebServlet("/SpecieController")
public class SpecieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Specie specie;
	private List<Specie> species;
	private SpecieDOM specieDOM;
	private List<String> ids = new ArrayList<String>();
	

    /**
     * Default constructor. 
     */
    public SpecieController() {
    	super();
      
       specie = new Specie();
        species = new ArrayList<Specie>();
        specieDOM = new SpecieDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			specie.setName(request.getParameter("name"));
			specie.setGenus(request.getParameter("genus"));
			specie.setSpecies(request.getParameter("species"));
			specie.setValue(request.getParameter("value"));
			
			
			
			
            
			if(specie.getId()=="") {
				int id = 1;
				String newId= "SPE"+String.format("%05d", 1);
				specie.setId(newId);;
				
				if (species.size()>0) {
					ids.clear();
					for (Specie p: species) {
						ids.add(p.getId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "SPE"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
						specie.setId(newId);
						break;
						}
					}
				}
				specieDOM.add(specie);
			}else {
				specieDOM.update(specie);
			}

			species = specieDOM.getSpecie();
			request.setAttribute("species", species);
			request.getRequestDispatcher("species_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			specie = new Specie();
			request.getRequestDispatcher("species_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				specie = specieDOM.findById(id);
				
			}catch (Exception e) {
				
				specie = new Specie();
			}
			request.setAttribute("specie", specie );
			
			request.getRequestDispatcher("species_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			specieDOM.delete(id);
			species= specieDOM.getSpecie();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("species", species);
			request.getRequestDispatcher("species_list.jsp").forward(request, response);
		}else {
			species = specieDOM.getSpecie();
			request.setAttribute("species", species);
			request.getRequestDispatcher("species_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
