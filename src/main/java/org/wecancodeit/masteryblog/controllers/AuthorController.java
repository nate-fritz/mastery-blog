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
import org.wecancodeit.masteryblog.repositories.CategoryRepository;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Resource
	PostRepository postRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	AuthorRepository authorRepo;
	
	
	@GetMapping("/author/{id}")
	public String getAuthor(@PathVariable Long id, Model model) throws Exception {
		Optional<Author> author = authorRepo.findById(id);
		if (author.isPresent()) {
			model.addAttribute("authors", author.get());
		} else {
			throw new Exception("Author not found.");
		}

		return "authors/author";

	}
	
	@GetMapping("/")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/authors";
		
		
	}

	@PostMapping("/")
	public String addAuthor(String name) {
		Author authorToAdd = authorRepo.findByAuthorName(name);
		if (authorToAdd == null) {
			authorToAdd = authorRepo.save(new Author(name));
		}
		
		return "redirect:/authors/";
		
	}
		
	
}
