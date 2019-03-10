package org.wecancodeit.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.models.Tag;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Resource
	PostRepository postRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	AuthorRepository authorRepo;

	@GetMapping("")
	public String post(Model model) {
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		return "posts/add";
	}
	
	@GetMapping("/{id}")
	public String singlePost(@PathVariable Long id, Model model) {
		model.addAttribute("post", postRepo.findById(id).get());
		model.addAttribute("category", categoryRepo.findAll());
		model.addAttribute("author", authorRepo.findAll());
		return "post";
	}

	
	@PostMapping("/{id}")
	public String submitTag(@PathVariable Long id, String tagLabel) {
		Tag tagToAdd = tagRepo.findByTagLabel(tagLabel);
		Post post = postRepo.findById(id).get();

		if (tagToAdd == null) {
			tagToAdd = tagRepo.save(new Tag(tagLabel));
		}
		post.addTagToTags(tagToAdd);
		postRepo.save(post);
		return "redirect:/post/" + id;
	}
	
	@GetMapping("/allposts")
	public String displayCategory(Model model) {
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "allposts";
	}

}

