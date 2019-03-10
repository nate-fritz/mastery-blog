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
public class TagController {

	@Resource
	PostRepository postRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	AuthorRepository authorRepo;

	@GetMapping ("/tag/{id}")
	public String singleTag(@PathVariable Long id, Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("tag", tagRepo.findById(id).get());
		return "tag";
	}
}
