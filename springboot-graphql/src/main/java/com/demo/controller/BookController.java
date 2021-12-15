package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Book;
import com.demo.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/rest/books")
public class BookController {

	@Autowired
	GraphQLService graphQLService;

	@GetMapping("/data")
	public List<Book> get() {
		return graphQLService.get();
	}

	@PostMapping
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		System.out.println(query);
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);

		System.out.println("Request is coming");

		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

}
