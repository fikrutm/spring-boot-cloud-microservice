package com.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.demo.datafetcher.AllBooksDataFetcher;
import com.demo.datafetcher.BookDataFetcher;
import com.demo.model.Book;
import com.demo.repository.BookRepository;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

	public GraphQLService() {

	}

	@Autowired
	BookRepository bookRepository;

	private GraphQL graphQL;
	@Autowired
	private AllBooksDataFetcher allBooksDataFetcher;
	
	

    @Value("classpath:books.graphql")
    Resource resource;
    
    
	@Autowired
	private BookDataFetcher bookDataFetcher;

	public GraphQL getGraphQL() {
		return graphQL;
	}

	// load schema at application start up
	@PostConstruct
	private void loadSchema() throws IOException {

		// Load Books into the Book Repository
		loadDataIntoHSQL();
		// get the schema
		File schemaFile = resource.getFile();
		// parse schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();

	}

	private void loadDataIntoHSQL() {
		Stream.of(new Book("123", "Book of Clouds", "Kindle Edition", new String[] { "Chloe Aridjis" }, "Nov 2017"),
				new Book("124", "Cloud Arch & Engineering", "Orielly", new String[] { "Peter", "Sam" }, "Jan 2015"),
				new Book("125", "Java 9 Programming", "Orielly", new String[] { "Venkat", "Ram" }, "Dec 2016"))
				.forEach(book -> {
					bookRepository.save(book);
				});
		
	}

	public List<Book> get() {

		return bookRepository.findAll();

	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring().type("Query", typeWiring -> typeWiring
				.dataFetcher("allBooks", allBooksDataFetcher).dataFetcher("book", bookDataFetcher)).build();
	}

}
