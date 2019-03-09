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
@RequestMapping("/category")
public class CategoryController {

	@Resource
	PostRepository postRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	AuthorRepository authorRepo;

	@GetMapping("")
	public String displayCategory(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "/category";
	}
	
	@GetMapping("/{id}")
	public String displaySingleCategory (@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		return "category";
	}
}
