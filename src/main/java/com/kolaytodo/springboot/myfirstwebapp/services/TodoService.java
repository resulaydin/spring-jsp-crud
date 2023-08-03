package com.kolaytodo.springboot.myfirstwebapp.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.kolaytodo.springboot.myfirstwebapp.entities.Todo;

@Service
public class TodoService {

	public static List<Todo> todos = new ArrayList<>();

	private static int todoCount = 0;

	static {
		todos.add(new Todo(++todoCount, "resul", "Spring Boot Bitirilecek", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "resul", "Lear Full Stack Development", LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todoCount, "resul", "Learn DevOps Boot Bitirilecek", LocalDate.now().plusYears(2), false));
	};

	public List<Todo> getTodosByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, username, description, targetDate, isDone));
	}

	public void deleteTodoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo getTodoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo =todos.stream().filter(predicate).findFirst().get(); 
		return todo;
	}

	public void updateTodo(Todo todo) {
		deleteTodoById(todo.getId());
		todos.add(todo);
	}

}
