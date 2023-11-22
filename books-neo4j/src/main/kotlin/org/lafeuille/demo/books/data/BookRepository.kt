package org.lafeuille.demo.books.data

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository

interface BookRepository : ReactiveNeo4jRepository<Book, String>