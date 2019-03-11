package org.wecancodeit.masteryblog.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblog.models.Category;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;
import org.wecancodeit.masteryblog.repositories.PostRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Resource
	PostRepository postRepo;

	@Resource
	CategoryRepository categoryRepo;

	@GetMapping("/{id}")
	public String getCategory(@PathVariable Long id, Model model) throws Exception {
	Optional<Category> category = categoryRepo.findById(id);
	model.addAttribute("posts", postRepo.findAll());
	if(category.isPresent()) {
		model.addAttribute("categories", category.get());
	}
	else {
		throw new Exception("Category not found.");
	}
		return "posts/all";
	}
	
	@GetMapping("/")
	public String getCategoryForm(Model model) {
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories/add";
	}
	
	@GetMapping("/all")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		return "categories/all";
	}

	@PostMapping("/")
	public String addCategory(String category) {
		Category categoryToAdd = categoryRepo.findByCategory(category);
		if (categoryToAdd == null) {
			categoryToAdd = categoryRepo.save(new Category(category));
		}
		
		return "redirect:/categories/" + categoryToAdd.getId();	
	}
}
