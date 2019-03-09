package org.wecancodeit.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Controller
public class HomeController {

	@Resource
	PostRepository postRepo;
	
	@Resource
	CategoryRepository categoryRepo;
	
	@Resource
	TagRepository tagRepo;
	
	@Resource
	AuthorRepository authorRepo;
	
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		return "home";
	}
	
	@GetMapping("/{id}")
	public String postOfCategoryName(@PathVariable Long id, Model model) {
		model.addAttribute("posts", postRepo.findAll());
		return "category";
	}
	
	

}
