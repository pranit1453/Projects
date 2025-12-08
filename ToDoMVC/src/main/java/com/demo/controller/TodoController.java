package com.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.beans.Todos;
import com.demo.beans.Users;
import com.demo.services.TodoServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private TodoServices todoservices;

	@GetMapping({ "/todoslist" })
	public String list(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			// Redirect to login page if not logged in
			return "redirect:/login/loginuser";
		} else {
			List<Todos> todos = todoservices.getList(user.getUserid());
			if (todos == null) {
				todos = Collections.emptyList();
			}
			model.addAttribute("todos", todos);
			return "todospage";
		}
	}

	@GetMapping("/dashboard")
	public String showDashboard(RedirectAttributes redirectAttributes, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			// If not logged in, set flash message and redirect to login
			redirectAttributes.addFlashAttribute("error", "Please Login First");
			return "redirect:/login/loginuser";
		} else {
			redirectAttributes.addFlashAttribute("message", "Welcome User....");
			return "redirect:/todos/todoslist";
		}
	}

	@PostMapping("/add")
	public String todoAdd(RedirectAttributes redirectAttributes, HttpSession session,
			@RequestParam("title") String title, @RequestParam("description") String description) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			// If not logged in, set flash message and redirect to login
			redirectAttributes.addFlashAttribute("error", "Please Login First");
			return "redirect:/login/loginuser";
		} else {
			boolean status = todoservices.addToDo(user.getUserid(), title, description);
			if (status) {
				redirectAttributes.addFlashAttribute("message", "Task Added Successfully...");
			} else {
				redirectAttributes.addFlashAttribute("error", "Failed to add task.");
			}
			return "redirect:/todos/todoslist";
		}
	}

	@GetMapping("/toggle/{id}")
	public String toggleTask(@PathVariable("id") int id, HttpSession session, RedirectAttributes redirectAttributes) {
		Users user = (Users) session.getAttribute("user");

		if (user == null) {
			redirectAttributes.addFlashAttribute("error", "Please login first.");
			return "redirect:/login/loginuser";
		}

		boolean updated = todoservices.toogleStatus(id, user.getUserid());

		if (!updated) {
			redirectAttributes.addFlashAttribute("error", "Unable to update task status.");
		}

		return "redirect:/todos/todoslist";
	}
}
