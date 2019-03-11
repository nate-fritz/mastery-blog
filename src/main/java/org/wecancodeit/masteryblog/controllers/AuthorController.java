package org.wecancodeit.masteryblog.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblog.models.Author;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;
import org.wecancodeit.masteryblog.repositories.PostRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Resource
	PostRepository postRepo;

	@Resource
	AuthorRepository authorRepo;
	
	
	@GetMapping("/{id}")
	public String getAuthor(@PathVariable Long id, Model model) throws Exception {
		Optional<Author> author = authorRepo.findById(id);
		if (author.isPresent()) {
			model.addAttribute("authors", author.get());
		} else {
			throw new Exception("Author not found.");
		}
		return "authors/author";

	}


	
//	Allows linking to authors/add page
	@GetMapping("/")
	public String getAuthorForm(Model model) {
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/add";
	}
	
	@GetMapping("/all")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		return "authors/all";

	}

//	Allows creation of new author on "Submit" button
	@PostMapping("/")
	public String addAuthor(String author) {
		Author authorToAdd = authorRepo.findByAuthor(author);
		if (authorToAdd == null) {
			authorToAdd = authorRepo.save(new Author(author));
		}	
		return "redirect:/authors/" + authorToAdd.getId();
		
	}
		
	
}
