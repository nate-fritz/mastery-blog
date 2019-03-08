package org.wecancodeit.masteryblog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.models.Tag;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	PostRepository postRepo;

	@Resource
	TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		Tag funny = tagRepo.save(new Tag("funny"));
		Tag sad = tagRepo.save(new Tag("sad"));
		Tag epic = tagRepo.save(new Tag("epic"));

		postRepo.save(new Post("ItemOne", 2000, 145, "AuthorA",
				"Lorem ipsum dolor amet beard exercitation mixtape gluten-free kogi hexagon raclette selfies. Bitters vice nulla offal, farm-to-table pickled humblebrag kombucha. Chartreuse adipisicing enamel pin beard. Narwhal cold-pressed crucifix deserunt skateboard vice. Quinoa culpa fanny pack gastropub food truck church-key post-ironic."));
		postRepo.save(new Post("ItemTwo", 2001, 13, "AuthorB",
				"Nostrud franzen est fanny pack whatever nisi. Ugh eu tattooed gentrify flannel. Hoodie tilde gluten-free tbh shoreditch duis. Af tacos paleo authentic mixtape umami, gentrify next level jianbing mustache vexillologist yuccie messenger bag."));
		postRepo.save(new Post("ItemThree", 2002, 59, "AuthorA",
				"Ullamco meh poke swag everyday carry four loko retro enamel pin activated charcoal 3 wolf moon trust fund portland af chillwave commodo. Before they sold out anim adipisicing, roof party forage williamsburg celiac ramps literally la croix tumeric. Forage deep v godard in lorem chillwave. Duis cold-pressed chartreuse leggings, kombucha ea minim 3 wolf moon."));
		postRepo.save(new Post("ItemFour", 2000, 999, "AuthorC",
				"Deserunt kinfolk tumblr messenger bag banjo. Labore mumblecore whatever health goth id. Ea franzen intelligentsia flexitarian gochujang meditation knausgaard lorem keytar distillery duis raw denim health goth. Enim incididunt et microdosing poutine hashtag disrupt."));
		postRepo.save(new Post("ItemFive", 2018, 7, "AuthorD",
				"Dreamcatcher activated charcoal man braid ethical. Shabby chic salvia offal pabst, trust fund listicle non eu cliche. Mixtape letterpress jianbing, shoreditch ipsum bespoke helvetica man braid nostrud squid poutine enim succulents. Artisan woke viral, fingerstache pariatur glossier organic cold-pressed disrupt typewriter narwhal. In intelligentsia PBR&B pinterest beard fam succulents knausgaard la croix."));
		postRepo.save(new Post("ItemSix", 2005, 9, "AuthorB",
				"Lorem ipsum dolor amet exercitation scenester stumptown godard literally irure shabby chic fanny pack in slow-carb thundercats enim voluptate pitchfork single-origin coffee. Dolore poutine subway tile proident ipsum actually, anim ut organic chartreuse. Chicharrones authentic fashion axe neutra eu qui forage slow-carb. Butcher thundercats non austin laboris listicle. Chartreuse offal dolor iceland. Cloud bread blue bottle hashtag brunch, ullamco shabby chic subway tile fanny pack yuccie ad VHS sustainable roof party est fixie."));
		postRepo.save(new Post("ItemSeven", 2012, 13, "AuthorC", "Consequat pinterest anim retro occupy health goth banh mi adaptogen non hashtag vice. Lyft raclette freegan, ex ipsum beard YOLO gastropub migas. Officia small batch portland gochujang. Wolf consectetur crucifix, artisan tbh lyft poke iPhone single-origin coffee street art eu magna +1 irure. Freegan hashtag artisan, succulents trust fund everyday carry offal kale chips duis locavore kinfolk. Occupy ut ethical, health goth glossier pariatur helvetica selfies pok pok veniam ugh est. Tumblr organic vape 8-bit, woke keffiyeh adipisicing cardigan artisan umami four loko affogato pork belly."));
		postRepo.save(new Post("ItemEight", 2001, 2000, "AuthorB", "Do hella echo park lomo, ugh wayfarers jean shorts reprehenderit pok pok minim fam roof party freegan flannel. Copper mug slow-carb nulla fashion axe brunch fanny pack neutra cornhole vegan. In cillum keytar 3 wolf moon fixie occaecat. Quis readymade brunch, hoodie waistcoat semiotics gentrify tacos ut salvia lo-fi swag in neutra 3 wolf moon. Incididunt slow-carb qui XOXO, shaman cardigan snackwave. Pinterest flexitarian migas vinyl lorem ut drinking vinegar crucifix occaecat jianbing yuccie distillery four dollar toast laboris."));
		postRepo.save(new Post("ItemNine", 1983, 77, "AuthorE", "Tilde vexillologist crucifix banh mi coloring book, scenester hoodie tattooed. Laboris etsy kombucha, readymade mustache church-key tempor try-hard next level affogato art party synth godard proident. Blog lorem dolore intelligentsia gluten-free chicharrones fixie activated charcoal. Typewriter aliquip +1 unicorn, banjo tilde listicle. 90's eu ex, kickstarter +1 four dollar toast shabby chic letterpress edison bulb dolore."));
		postRepo.save(new Post("ItemTen", 1975, 75000, "AuthorA", "Tbh messenger bag roof party commodo slow-carb kinfolk. Tacos try-hard irure pug, af tote bag dreamcatcher gastropub portland hammock waistcoat artisan. Pickled thundercats whatever nulla live-edge fashion axe bushwick artisan woke. Consequat glossier jianbing chia. Lumbersexual YOLO shoreditch truffaut pop-up dreamcatcher. Banjo health goth ugh tumeric elit, stumptown ethical occaecat semiotics ramps poke whatever non PBR&B YOLO."));

	}
}
