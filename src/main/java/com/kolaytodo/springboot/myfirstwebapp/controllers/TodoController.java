package com.kolaytodo.springboot.myfirstwebapp.controllers;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kolaytodo.springboot.myfirstwebapp.entities.Todo;
import com.kolaytodo.springboot.myfirstwebapp.services.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoController {

	TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		model.put("todos", todoService.getTodosByUsername(username));
		return "listTodos";
	}


	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		Todo newTodo = new Todo(0, (String) model.get("username"), "", LocalDate.now().plusYears(3), false);
		model.put("todo", newTodo);
		return "todo";
	}

//	@RequestMapping(value="add-todo",method =RequestMethod.POST )
//	public String addNewTodo(@RequestParam String description, ModelMap model) {
//		todoService.addTodo((String)model.get("username"), description, LocalDate.now().plusYears(4) , false);
//		return "redirect:list-todos";
//	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result ) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo((String) model.get("username"), todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodoById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping("update-todo")
	public String showUpdateTodo(ModelMap model, @RequestParam int id) {
		model.addAttribute("todo",todoService.getTodoById(id));
		return "todo";
	}
	@RequestMapping(value="update-todo", method = RequestMethod.POST )
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = (String)model.get("username");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	
	
	
//	@RequestMapping("update-todo")
//	public String showUpdateTodo(ModelMap model, @RequestParam int id) {
//		model.addAttribute("todo",todoService.getTodoById(id));
//		System.out.println("update: "+id);
//		return "updateTodo";
//	}
//	@RequestMapping(value="update-todo", method = RequestMethod.POST )
//	public String updateTodo(ModelMap model, Todo todo) {
//		todoService.updateTodo(todo);
//		return "redirect:list-todos";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
