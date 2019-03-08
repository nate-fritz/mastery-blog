package org.wecancodeit.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.models.Author;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Resource
	AuthorRepository authorRepo;

	@Resource
	PostRepository postRepo;

	@GetMapping("")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/add";
	}

	@GetMapping("/{id}")
	public String getAuthor(@PathVariable Long id, Model model) {
		model.addAttribute("author", authorRepo.findById(id).get());
		model.addAttribute("allPosts", postRepo.findAll());
		return "/authors/company";
	}

	@PostMapping("/{authorId}/add")
	public String addPostToAuthor(@PathVariable Long authorId, Long postId) {
		Author authorToAddTo = authorRepo.findById(authorId).get();
		Post postToAdd = postRepo.findById(postId).get();
		authorToAddTo.addPostToPosts(postToAdd);
		authorRepo.save(authorToAddTo);
		return "redirect:/authors/" + authorId;
	}
}
