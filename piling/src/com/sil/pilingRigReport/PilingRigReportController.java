package com.sil.pilingRigReport;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sil.pilingRigProgress.PilingRigProgressForm;
import com.sil.pilingRigProgress.PilingRigProgressLogic;
@Controller
@RequestMapping("/rigProgressReport")
@SessionAttributes("pilingRigReportBean")
public class PilingRigReportController {







	    private PilingRigReportLogic pilingRigReportLogic;
		@Autowired
		public void setPilingRigReportLogic(PilingRigReportLogic pilingRigReportLogic) {
			this.pilingRigReportLogic = pilingRigReportLogic;
		}
		@RequestMapping(method=RequestMethod.GET)
		public String getInitialPage(HttpServletRequest request,Map map){
			HttpSession session = request.getSession(true);
			PilingRigReportBean bean = new PilingRigReportBean();
			map.put("pilingRigReportBean", bean);
			return  "report/PilingRigProgressReportForm";
		}


/*	    @RequestMapping(method={RequestMethod.GET})
	    public ModelAndView initPage() {
	        ModelAndView model = new ModelAndView();
	        PilingRigReportBean bean = new PilingRigReportBean();
	        System.out.println("XXXXXXXXXXXX");
//	        bean.setZoneDetails(this.pilingRigReportLogic.getContractDetails());
	        model.addObject("pilingRigReportLogicBean", (Object)bean);
	        model.setViewName("pilingRigReport");
	        return model;
	    }
*/
	    @RequestMapping(method={RequestMethod.POST})
	    public ModelAndView onSubmit(@ModelAttribute(value="pilingRigReportLogicBean") PilingRigReportBean bean, HttpServletRequest request) {
	        ModelAndView model = new ModelAndView();
	        HashMap<String, String> map = new HashMap<String, String>();
	        String res = this.pilingRigReportLogic.generateReport(bean, request);
	        map.put("fileName", res);
	        System.out.println("Result==" + res);
	        if (res != null) {
	            map.put("messg", "Successfully Generated");
	        } else {
	            map.put("messg", "Not Generated");
	        }
	        return new ModelAndView("pilingRigReportSuccess", map);
	    }

	    @Autowired
	    public void setSupplierChragedRegister(PilingRigReportLogic pilingRigReportLogic) {
	        this.pilingRigReportLogic = pilingRigReportLogic;
	    }
	}
