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
import dom.TreeDOM;
import model.Specie;
import model.Tree;

/**
 * Servlet implementation class TreeContoller
 */
@WebServlet("/TreeContoller")
public class TreeContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Tree tree;
	private List<Tree> trees;
	private TreeDOM treeDOM;
	private List<String> ids = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TreeContoller() {
        super();
        tree = new Tree();
        trees = new ArrayList<Tree>();
        treeDOM = new TreeDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save")!= null) {
		tree.setName(request.getParameter("name"));
		tree.setType(request.getParameter("type"));
		
		try {
			
			tree.setHeight(Integer.parseInt(request.getParameter("height")));
		}catch(NumberFormatException e) {
			tree.setHeight(5);
		}
		tree.setLocations(request.getParameter("locations"));
try {
			
			tree.setUnits(Integer.parseInt(request.getParameter("units")));
		}catch(NumberFormatException e) {
			tree.setUnits(8);
		}

		
        
		if(tree.getId()=="") {
			int id = 1;
			String newId= "TRE"+String.format("%05d", 1);
			tree.setId(newId);;
			
			if (trees.size()>0) {
				ids.clear();
				for (Tree p: trees) {
					ids.add(p.getId());
				}
				for (int i=0; i<= ids.size(); i++){
					newId= "TRE"+ String.format("%05d", i+1);
					
					if (! ids.contains(newId)) {
					tree.setId(newId);
					break;
					}
				}
			}
			treeDOM.add(tree);
		}else {
			treeDOM.update(tree);
		}

		trees = treeDOM.getTree();
		request.setAttribute("trees", trees);
		request.getRequestDispatcher("trees_list.jsp").forward(request, response);
		
	}else if (request.getParameter("btn_new")!=null) {
		tree = new Tree();
		request.getRequestDispatcher("trees_form.jsp").forward(request, response);
	
	}else if(request.getParameter("btn_edit")!=null) {	
		try {
			String id = request.getParameter("id");
			tree = treeDOM.findById(id);
			
		}catch (Exception e) {
			
			tree = new Tree();
		}
		request.setAttribute("tree", tree );
		
		request.getRequestDispatcher("trees_form.jsp").forward(request, response);
		
	}else if(request.getParameter("btn_delete")!=null) {
	
		
		try {
		String id = request.getParameter("id");
		treeDOM.delete(id);
		trees= treeDOM.getTree();
		
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		request.setAttribute("trees", trees);
		request.getRequestDispatcher("trees_list.jsp").forward(request, response);
	}else {
		trees = treeDOM.getTree();
		request.setAttribute("trees", trees);
		request.getRequestDispatcher("trees_list.jsp").forward(request, response);
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
