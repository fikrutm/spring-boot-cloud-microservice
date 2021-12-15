package com.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import zipkin2.server.internal.EnableZipkinServer;



@SpringBootApplication
@EnableZipkinServer
@ComponentScan(basePackages =  "com.demo.zipkin.ZipkinServiceApplication")
public class ZipkinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServiceApplication.class, args);
	}

}
