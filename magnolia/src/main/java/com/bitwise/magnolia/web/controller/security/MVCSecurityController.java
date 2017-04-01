package com.bitwise.magnolia.web.controller.security;
/**
 *  
 * @author Sika Kay
 * @date 31/03/17
 *
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.service.security.PermissionService;
import com.bitwise.magnolia.service.security.RoleService;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCSecurityController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	/*@Autowired
	private MessageSource messageSource;*/
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/roles/add", method=RequestMethod.GET)
	public String requestAddRole(ModelMap model) {
		return "roles/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/permissions/add", method=RequestMethod.GET)
	public String requestAddPermission(ModelMap model) {
		return "permissions/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/roles/list", method=RequestMethod.GET)
	public String requestRolesPage(ModelMap model) {
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "roles/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/permissions/list", method=RequestMethod.GET)
	public String requestPermissionsPage(ModelMap model) {
		List<Permission> permissions = permissionService.findAll();
		model.addAttribute("permissions", permissions);
		return "permissions/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/roles/edit/{id}", method={RequestMethod.GET})
	public String requestEditRole(@PathVariable Long id, @ModelAttribute Role role, ModelMap model, HttpServletRequest request) {
		role = roleService.findById(id);
		model.addAttribute("role", role);
		List<Permission> permissions = permissionService.findAll();
		model.addAttribute("permissions", permissions);
		return "roles/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/roles/edit/{id}", method={RequestMethod.PUT})
	public String editRole(@ModelAttribute Role role, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.roleService.update(role);
			return "redirect:/roles/edit/" + UrlUtil.encodeUrlPathSegment(role.getId().toString(), request);
		} else {
			return "redirect:/roles/edit/" + UrlUtil.encodeUrlPathSegment(role.getId().toString(), request);
		}
	}
}
