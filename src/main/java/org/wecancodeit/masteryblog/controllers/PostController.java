package org.wecancodeit.masteryblog.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblog.models.Author;
import org.wecancodeit.masteryblog.models.Category;
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

	@GetMapping("/{id}")
	public String getPost(@PathVariable Long id, Model model) throws Exception {
		Optional<Post> post = postRepo.findById(id);
		if(post.isPresent()) {
			model.addAttribute("posts", post.get());
		} else {
			throw new Exception("Post not found");
		}
		return "posts/post";
		
	}
	
//	Allows linking to posts/add page
	@GetMapping("/")
	public String getPostForm(Model model) {
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		return "posts/add";
	}
	
	@GetMapping("/all")
	public String getAllPosts(Model model) {
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		return "posts/all";
	}
	
//	Allows creation of new post on "Submit" button.
	@PostMapping("/")
	public String addPost(Model model, String title, String body, String time, String category, String author, String tags) {
		Category categoryForPost = categoryRepo.findByCategory(category);
		Author authorForPost = authorRepo.findByAuthor(author);
		Tag tagsForPost = tagRepo.findByTagLabel(tags);
		Post newPost = postRepo.save(new Post(title, body, time, categoryForPost, authorForPost, tagsForPost));
		return "redirect:/posts/" + newPost.getId();
	}
	
	
}

