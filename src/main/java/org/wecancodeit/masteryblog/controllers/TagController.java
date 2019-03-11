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
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Controller
@RequestMapping("/tags")
public class TagController {

	@Resource
	PostRepository postRepo;

	@Resource
	TagRepository tagRepo;

	@GetMapping("/{id}")
	public String getTag(@PathVariable Long id, Model model) throws Exception {
		Optional<Tag> tag = tagRepo.findById(id);
		if (tag.isPresent()) {
			model.addAttribute("tags", tag.get());
		} else {
			throw new Exception("Tag not found.");
		}
		return "tags/tag";
	}

//	Allows linking to tags/add page
	@GetMapping("/")
	public String getTagForm(Model model) {
<<<<<<< HEAD
		model.addAttribute("posts", postRepo.findAll());
=======
	
>>>>>>> f03684c748a4e54e9d6d07508cd8586d70e01d40
		model.addAttribute("tags", tagRepo.findAll());
		return "tags/add";
	}

	@GetMapping("/all")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		return "tags/all";
	}

//	Allows creation of new tag on "Submit" button
	@PostMapping("/")
	public String addTag(String tag) {
		Tag tagToAdd = tagRepo.findByTagLabel(tag);
		if (tagToAdd == null) {
			tagToAdd = tagRepo.save(new Tag(tag));
		}
		return "redirect:/tags/" + tagToAdd.getTagId();
	}
}