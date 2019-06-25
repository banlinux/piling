package com.sil.calendar.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.sil.util.AjaxXMLStreamWriter;
import com.sil.util.CommonFunctionDao;

/**
 * 
 * @author Milan Dutta
 */
@Controller
@RequestMapping("/calendar.htm")
public class CalendarAjaxHandler extends AbstractController {
	
	private CommonFunctionDao commonFunctionDao;

	public CalendarAjaxHandler() {
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("In AJAX handler");

		HttpSession hs = request.getSession();

		String form = request.getParameter("form");

		if (form.compareTo("date") == 0) {
			response.setContentType("text/xml");

			AjaxXMLStreamWriter pw = new AjaxXMLStreamWriter(
					response.getWriter());

			pw.println("<?xml version=\"1.0\" ?>");
			pw.println("<root>");
			pw.println("<date>" + commonFunctionDao.getDateString(commonFunctionDao.getCurrentDate())
					+ "</date>");
			pw.println("</root>");
		} else {
			logger.info("AJAX - Unauthorized Access");
		}

		return (null);
	}

	/**
	 * @param commonFunctionDao
	 *            the commonFunctionDao to set
	 */
	@Autowired
	public void setCommonFunctionDao(CommonFunctionDao commonFunctionDao) {
		this.commonFunctionDao = commonFunctionDao;
	}
}
