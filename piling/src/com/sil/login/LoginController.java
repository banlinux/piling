/**
 * 
 */
package com.sil.login;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sil.util.PropertyManager;





@Controller
@RequestMapping("index.htm")
public class LoginController {
	static Logger log = Logger.getLogger(LoginController.class.getName());
	private Login login;
	
	@Autowired
	public void setLogin(Login login) {
	 this.login=login;
	// TODO Auto-generated constructor stub
}
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView getInit (HttpServletRequest request,
        HttpServletResponse response)
        throws Exception
    {
		HttpSession hs = request.getSession ();
		hs.setAttribute ("sessUserID", "none");
		return new ModelAndView("login/login");
    }
  
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView getPost (HttpServletRequest request,
        HttpServletResponse response)
        throws Exception
    {
    	
    	HttpSession hs = request.getSession ();
        String sessUserID = (String) hs.getAttribute ("sessUserID");
        String first_login = (String) hs.getAttribute ("firstLogin");
        String uname = request.getParameter ("uname");
        String passwd = request.getParameter ("passwd");
        
        String position=request.getParameter("position");
        String jobcode=request.getParameter("jobcode");
       
        log.info("Inside login controller user id="+uname);
        
        if (hs != null && sessUserID != null && // Session Exists and user 
            sessUserID.compareTo ("none") != 0 &&   // already logged in and not 
            first_login != null && // setting his/her password during first time login
            first_login.compareTo ("0") == 0) 
        {
            
            return (new ModelAndView ("login"));    // Return User to main page
        }
        else
        {
            if (uname != null)  // User has entered login/password -- Submit action or has entered new password
            {
                String remote_host = request.getRemoteAddr ();

                List<LoginBean> details = login.canLogin (uname, passwd);               
                

                Iterator <LoginBean>i = details.iterator ();

                if (i.hasNext ())
                {           
                	LoginBean bean=i.next();
                    hs.setAttribute ("sessUserID", bean.getUserId());
                    hs.setAttribute ("sessUserName", bean.getUserName());
                    hs.setAttribute ("sessUserType", "sessionType");
                    hs.setAttribute ("sessID", "Sumanta");
                    hs.setAttribute("contractCode", bean.getContractCode());
                 //   hs.setAttribute("locationCode", bean.getLocationCode());

                    first_login = "6";
                    String person_id=bean.getUserId();
                    hs.setAttribute ("personId", person_id);
                    hs.setAttribute ("firstLogin", first_login);

                    ModelAndView mav = new ModelAndView ("login/login");
                    mav.addObject("jobcode", jobcode);
                    mav.addObject("position", position);

                    if (first_login.compareTo ("1") == 0)
                    {
                        mav.addObject ("message", "<b>" +
                            PropertyManager.getProperty ("loginForm.passwordMessage") + "</b>");
                    }
System.out.println("back");
                    return (mav);
                }
                else
                {
                    
                    hs.setAttribute ("sessUserID", "none");

                    ModelAndView mav = new ModelAndView ("login/login");

                    mav.addObject ("message", "<b><font color='#FF0000'>" +
                        PropertyManager.getProperty ("loginForm.invalidLogin") +
                        "</font></b>");
                    
                    return (mav);
                }
            }
            else    // Page getting displayed for the first time. OR Password setting for first login
            {
                if (first_login == null)    // Page Getting displayed for the first time.
                {
                                 
                    hs.setAttribute ("sessUserID", "none");

                    ModelAndView mav = new ModelAndView ("login/login");

                    mav.addObject ("message",
                        PropertyManager.getProperty ("loginForm.loginMessage"));

                    return (mav);
                }
                else    // If we come here then it means this is from first login.
                {           
                    
                    String user_id = (String) hs.getAttribute ("sessUserID");
                    String old_password = request.getParameter ("old_password");
                    String new_password = request.getParameter ("new_password");
                    String new_password_confirm = request.getParameter ("new_password_confirm");

                    if (old_password == null ||
                        new_password == null ||
                        new_password_confirm == null)   // User must have clicked the refresh button
                    {            
                        
                        hs.invalidate ();

                        return (new ModelAndView ("login/logout"));
                    }
                    else
                    {            
                        String message = " ";
                        ModelAndView mav = new ModelAndView ("login/login");

                        mav.addObject ("message", message);

                        return (mav);
                    }
                }
            }
        }
        
    }
    

}
