package org.wecancodeit.masteryblog.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblog.models.Tag;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Controller
@RequestMapping("/tags")
public class TagController {

	@Resource
	PostRepository postRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	AuthorRepository authorRepo;

	@GetMapping("/tag/{id}") 
	public String getTag(@PathVariable Long id, Model model) throws Exception {
		Optional<Tag> tag = tagRepo.findById(id);
		if (tag.isPresent()) {
			model.addAttribute("tags", tag.get());
		} else {
			throw new Exception("Tag not found.");
		}

		return "tags/tag";
	}
	
	@GetMapping("/")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags/tags";
		
		
	}
	
	@PostMapping("/")
	public String addTag(String name) {
		Tag tagToAdd = tagRepo.findByTagLabel(name);
		if (tagToAdd == null) {
			tagToAdd = tagRepo.save(new Tag(name));
		}
		
		return "redirect:/tags/";
		
	}
}

