package com.sikho.JobListing.Repository;

import com.sikho.JobListing.model.Post;

import java.util.List;

public interface SearchPost {

    List<Post> findBytext(String text);
}
