package org.wecancodeit.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/add")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "add";
	}

	
	@GetMapping("/{id}")
	public String getAuthor(@PathVariable Long id, Model model) {
		model.addAttribute("author", authorRepo.findById(id).get());
		model.addAttribute("allAuthors", authorRepo.findAll());
		return "author";
	}


	
		
	
}
