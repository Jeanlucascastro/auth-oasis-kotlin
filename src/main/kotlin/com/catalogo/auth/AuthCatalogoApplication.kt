package com.catalogo.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthCatalogoApplication

fun main(args: Array<String>) {
	runApplication<AuthCatalogoApplication>(*args)
}
