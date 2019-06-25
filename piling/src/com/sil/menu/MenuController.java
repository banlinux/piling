/**
 * 
 */
package com.sil.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("mainMenu.htm")
public class MenuController {
	private MenuLogic menuLogic;
	@RequestMapping(method=RequestMethod.GET)
	public String getInit(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		response.setHeader("Cache-Control","no-cache"); 
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma","no-cache"); 
		PrintWriter out=response.getWriter();
		HttpSession hs=request.getSession();	
		generateJSP(request,response);
		System.out.println("***User Name===="+hs.getAttribute("sessUserName"));
		if(hs.getAttribute("sessUserName")==null){
			return "redirect:index.htm";
		}
		return "menu/menu";

	}
	
	
	private void setHeader(PrintWriter out){	
			out.println("<div id=\"menu\">"+
			"<ul class=\"tabs\">	");
	}
	
	private void setEndElement(PrintWriter out,HttpSession hs ){
		out.println("<li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>"+
					"<li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>"+
					"<li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>"+
					"<li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>"+
					//"Welcome  "+hs.getAttribute("sessUserName")+"</li>"+
					"Welcome  "+hs.getAttribute("sessUserName")+"</li>"+
					"	</div>");
			
	}

	/**
	 * @param menuLogic the menuLogic to set
	 */
	@Autowired
	public void setMenuLogic(MenuLogic menuLogic) {
		this.menuLogic = menuLogic;
	}
	
	private void generateJSP(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession hs = request.getSession ();
		if (hs.getAttribute ("sessUserID") != "none")
        {
			StringBuilder abspath = new StringBuilder (getClass ().getResource ("/ehcache.xml").toString ());
			
            abspath.delete (abspath.indexOf ("WEB"), abspath.length ());
            
            StringBuilder xmlPath = new StringBuilder (abspath);
            
            abspath.delete (0, 5);

            StringBuilder jspPath = abspath;
           
            String menuname = "menu" + hs.getAttribute ("sessUserID") + ".jsp";
           
           
            jspWrite(jspPath+"WEB-INF/jsp/"+menuname,request);
        }
		
		
	}
	
	private void jspWrite(String jspFile , HttpServletRequest request){
		
		try {
			HttpSession hs=request.getSession();
			String userId=hs.getAttribute("sessUserID").toString();
			MenuBean bean=menuLogic.getUserPermission(userId);
			Writer jspWriter=new PrintWriter (new File (jspFile));
			jspWriter.write("<div id=\"menu\">"+
			"<ul class=\"tabs\">	");
			if(bean!=null){
				if(bean.getM_permission().compareTo("Y")==0){
					jspWriter.write("	<li class=\"hasmore\"><a href=\"#\"><span>Admin</span></a>"+
							"		<ul class=\"dropdown\">");

					if(bean.getM_permission().compareTo("Y")==0)
						jspWriter.write("<li><a href=\"userPermission.htm\" onclick='addRandom (this) ;'>User  Permission</a></li>");
						jspWriter.write("		</ul>");
						jspWriter.write("	</li>");
				}	
				if( bean.getM_site().compareTo("Y")==0 || bean.getM_contract().compareTo("Y")==0 || bean.getM_rig().compareTo("Y")==0 || bean.getM_pile().compareTo("Y")==0 ){
					jspWriter.write("	<li class=\"hasmore\"><a href=\"#\"><span>Master</span></a>");
					jspWriter.write("		<ul class=\"dropdown\">");

					if(bean.getM_site().compareTo("Y")==0)
						jspWriter.write("			<li><a href=\"site.htm\">Site Detail</a></li>");
					if(bean.getM_site().compareTo("Y")==0)
						jspWriter.write("			<li><a href=\"rigMaster.htm\" onclick='addRandom (this) ;'>Rig Detail</a></li>");
					if(bean.getM_site().compareTo("Y")==0)
						jspWriter.write("			<li><a href=\"pileMaster.htm\" onclick='addRandom (this) ;'>Pile Detail</a></li>");
					if(bean.getM_contract().compareTo("Y")==0)
						jspWriter.write("			<li><a href=\"contract.htm\">Contract</a></li>");
						jspWriter.write("		</ul>");
						jspWriter.write("	</li>");
						jspWriter.write("	");
				}
				if(bean.getF_rig_progress().compareTo("Y")==0 ){	
					jspWriter.write("	<li class=\"hasmore\"><a href=\"#\"><span>Forms</span></a>");
					jspWriter.write("		<ul class=\"dropdown\">");
					if(bean.getF_rig_progress().compareTo("Y")==0)
						jspWriter.write("			<li><a href=\"pilingRigProgressForm.htm\" onclick='addRandom (this) ;'>Rig Progress Form</a></li>");
					jspWriter.write("		</ul>");
					jspWriter.write("	</li>");
					jspWriter.write("	");
				}
				if(bean.getR_rig_progress().compareTo("Y")==0 ){	
					jspWriter.write("	<li class=\"hasmore\"><a href=\"#\"><span>Reports</span></a>");
					jspWriter.write("		<ul class=\"dropdown\">");
					if(bean.getR_rig_progress().compareTo("Y")==0)
						jspWriter.write("			<li><a href=\"rigProgressReport.htm\" onclick='addRandom (this) ;'>Rig Progress Report</a></li>");
					jspWriter.write("			");
					jspWriter.write("		</ul>");
					jspWriter.write("	</li>");
				}
				
	
			}
				jspWriter.write("<li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>"+
						"<li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>"+
						"<li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>&nbsp&nbsp&nbsp&nbsp&nbsp</li><li>"+
						
						//"Welcome  "+hs.getAttribute("sessUserName")+"</li>"+
						"Welcome  "+hs.getAttribute("sessUserName")+"</li>");
				
				jspWriter.write("	 <li><a href=\"logout.htm\"><span>Logout</span></a></li>"+
						"	</div>");
		
				jspWriter.flush ();

				jspWriter.close ();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
