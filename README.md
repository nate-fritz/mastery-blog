# mastery-blog
# Blog Platform
# Objective

Students will employ good software design and testing principles in order to create a full-stack, server-side-rendered, web application.
Students will build the front-end portion using HTML, Thymeleaf, and CSS. (No frameworks, No JS… at all)
Students will build the back-end portion using Spring Boot with the following dependencies: DevTools, Web, Thymeleaf, JPA, H2

# The Scenario
We've been hired to build a Proof of Concept (PoC) application for a company looking to make the next new hot blogging platform! This being a PoC app, we don't (yet) have to worry about all of the security and user management concerns that we would have in a fully functional application. All our client wants from us are the beginnings of the actual User Experience (UX). Our client also wants an in depth and COMPLETE look at our applications User Interface (UI), so let's make it look good.

# Model Components
Post
We can't very well have a blog without some posts. Each post should include:

Title
Body
Authors
Publish Date (Look into LocalDateTime for this)
Genre or Category (each Post should have only one)
Tags
Author
We'll also need to be able to make Authors. Each Author should have:

Name
Posts
Genre or Category
Name
Posts
Tag
Each Tag should have:

Name
Posts
Views
We need View templates to display all of our Posts. But we should also be able to view our content based on the other identifying components we have. So each of our entities should be viewable in their own templates. We should have templates that display the collections of all entities as well as an individual instance of an entity. We also need a landing (home) page that welcomes the user to our application. We should have navigation very clearly presented on all pages so that the user is able to navigate through our application.

Users should be able to add an instance of ANY entity from it's collections page. For example, a user should be able to create a new Tag from the all Tags page. Our users should also be able to add a new Post to the all Posts page. However, the users should not be able to CREATE Authors, Genres, or Tags from the Post creation. Our users should have to SELECT those options from existing options. (Think about the types of inputs that would allow this behavior)

Make sure all collections are organized with proper containing elements (i.e. ol or ul for list items, fieldset for inputs)

Controllers
Last, we need to direct traffic efficiently. All of our entities should be managed by their own Controller. For example, all interaction with Posts should be isolated to one Controller. You may have to ACCESS other entities in your Controllers. But the main entities that Controller is meant to direct should be well organized.
