package com.ironyard.controller;

import com.ironyard.data.Movie;
import com.ironyard.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jasonskipper on 2/7/17.
 */
@Controller
public class MovieController {

    @Autowired
    MovieRepo movieRepo;

    @RequestMapping(path = "/secure/movies")
    public String listMovies(Model xyz){
        String destination = "home";
        Iterable found = movieRepo.findAll();

        // convert to lists because i like them
        Iterator<Movie> itr = found.iterator();
        List<Movie> data = new ArrayList();
        while(itr.hasNext()){
            data.add(itr.next());
        }

        // put list into model
        xyz.addAttribute("mList", data);

        // go to jsp
        return destination;
    }
}
