package com.bitwise.magnolia.web.controller.common;
import java.util.List;
/**
 *  
 * @author Sika Kay
 * @date 01/05/17
 *
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.service.common.StudyProgrammeCategoryService;
import com.bitwise.magnolia.validation.ProgrammeCategoryValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCProgrammeCategoryController {

	@Autowired
	private StudyProgrammeCategoryService categoryService;
	
	@InitBinder("category")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new ProgrammeCategoryValidator());
	}
	
	@RequestMapping(value="/programme/categories/list", method={RequestMethod.GET})
	public String requestProgrammeCategories(ModelMap model) {
		List<StudyProgrammeCategory> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		return "programme/categories/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/programme/categories/add", method={RequestMethod.GET})
	public String requestAddProgrammeCategory(ModelMap model) {
		return "programme/categories/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/programme/categories/edit/category/{id}", method={RequestMethod.GET})
	public String requestEditProgrammeCategory(@PathVariable("id") Long id, @ModelAttribute StudyProgrammeCategory category, ModelMap model, HttpServletRequest request) {
		category = categoryService.findById(id);
		model.addAttribute("category", category);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = category.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "programme/categories/edit/category";
	}
	
	@RequestMapping(value="/programme/categories/show/category/{id}", method={RequestMethod.GET})
	public String requestShowCategory(@PathVariable("id") Long id, @ModelAttribute StudyProgrammeCategory category, ModelMap model, HttpServletRequest request) {
		category = categoryService.findById(id);
		model.addAttribute("category", category);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = category.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "programme/categories/show/category";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/programme/categories/edit/category/{id}", method={RequestMethod.PUT})
	public String editCategory(@Valid @ModelAttribute StudyProgrammeCategory category, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.categoryService.update(category);
			return "redirect:/programme/categories/edit/category/" + UrlUtil.encodeUrlPathSegment(category.getId().toString(), request);
		} else {
			return "redirect:/programme/categories/edit/category/" + UrlUtil.encodeUrlPathSegment(category.getId().toString(), request);
		}
	}
}
