package com.cristian.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){
       Actor actor = new Actor();
       Actor actor1 = new Actor();
       Actor actor2 = new Actor();
       actor.setName("Sandra Bullock");
       actor.setRealname("Sandra Mae Bullowski");
       actor1.setName("Leo diCaprio");
       actor1.setRealname("Leonardo diCaprio");
       actor2.setName("Will Smith");
       actor2.setRealname("Will Smith");

       Movie movie = new Movie();
       movie.setTitle("The Proposal Movie");
       movie.setYear(2009);

       Movie movie1 = new Movie();
       movie1.setTitle("Once Upon a Time in Hollywood");
       movie1.setYear(2019);

       Movie movie2 = new Movie();
       movie2.setTitle("Gemini Man");
       movie2.setYear(2019);

       Movie movie3 = new Movie();
       movie3.setTitle("I am a legend");
       movie3.setYear(2011);

       movie.setDescription("About The Proposal.....");
       Set<Movie> movies = new HashSet<Movie>();
       movies.add(movie);
       actor.setMovies(movies);

       Set<Movie> moviesCaprio = new HashSet<>();
       moviesCaprio.add(movie1);
       actor1.setMovies(moviesCaprio);

       Set<Movie> moviesSmith = new HashSet<>();
       moviesSmith.add(movie2);
       moviesSmith.add(movie3);
       actor2.setMovies(moviesSmith);

       actorRepository.save(actor);
       actorRepository.save(actor1);
       actorRepository.save(actor2);

       model.addAttribute("actors", actorRepository.findAll());
       return "index";
    }
}
