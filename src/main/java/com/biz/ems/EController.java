package com.biz.ems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.ems.model.EVO;
import com.biz.ems.service.EService;

@Controller
@SessionAttributes("evo")
public class EController {
	@Autowired
	EService eService;

	@ModelAttribute("evo")
	public EVO newEVO() {
		return new EVO();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		List<EVO> eList = eService.selectAll();
		model.addAttribute("MAILS", eList);
		return "home";
	}

	@RequestMapping(value = "mail", method = RequestMethod.POST)
	public String mail(@ModelAttribute("evo") EVO evo, BindingResult result, Model model, SessionStatus session) {

		int ret = eService.insert(evo);
		session.setComplete();
		return "redirect:/";

	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view(@RequestParam long id, Model model) {

		EVO evo = eService.findById(id);
		model.addAttribute("mail", evo);

		return "mail_view";

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(@ModelAttribute EVO evo, Model model) {

		long id=evo.getId();
		EVO evo = eService.findById(id);
		model.addAttribute("evo", evo);
		return "mail_write";

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute EVO evo, Model model, SessionStatus session) {

		int ret = eService.update(evo);
		session.setComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(long id) {

		eService.delete(id);
		return "redirect:/";

	}
}
