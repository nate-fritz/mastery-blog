package org.wecancodeit.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Resource
	PostRepository postRepo;

	@Resource
	TagRepository tagRepo;

	@GetMapping("")
	public String getPostForm(Model model) {
		model.addAttribute("posts", postRepo.findAll());
		return "posts/add";
	}
	
	@GetMapping("/all")
	public String getPostsAll(String post, Model model) {
		model.addAttribute("posts", postRepo.findAll());
		return "/posts/all";
	}

	@GetMapping("/{id}")
	public String getPost(@PathVariable Long id, Model model) {
		model.addAttribute("post", postRepo.findById(id).get());
		return "/posts/item";
	}

	@PostMapping("/add")
	public String addPost(String name, int year, int price, String publisher, String content) {
		postRepo.save(new Post(name, year, price, publisher, content));
		return "redirect:/posts";
	}
}
