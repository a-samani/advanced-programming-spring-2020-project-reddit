package com.company.back.Subreddit;

import com.company.back.post.Post;
import com.company.back.user.User;
import com.company.back.user.UserRelation;

import java.util.ArrayList;

public class Subreddit {
    private String name;
    private String description;
    private User manager;


    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public static ArrayList<Subreddit> getSubreddits_database() {
        return subreddits_database;
    }

    public static void setSubreddits_database(ArrayList<Subreddit> subreddits_database) {
        Subreddit.subreddits_database = subreddits_database;
    }

    private ArrayList<Post> subreddit_posts;

    private static ArrayList<Subreddit> subreddits_database = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Post> getSubreddit_posts() {
        return subreddit_posts;
    }

    public void setSubreddit_posts(ArrayList<Post> subreddit_posts) {
        this.subreddit_posts = subreddit_posts;
    }

    public Subreddit(String name, String description ,User manager) {
        this.name = name.toLowerCase();
        this.description = description;
        this.manager=manager;
        this.subreddit_posts = subreddit_posts = new ArrayList<>();
    }
    // add post
    public void addpost(Post post){
        this.subreddit_posts.add(post);
    }
    public static Subreddit create_subreddit(String name ,String description, User manager){
        for (Subreddit sub:subreddits_database){
            if (sub.getName().equals(name.toLowerCase())){
                return null;
            }
        }
        Subreddit subreddit= new Subreddit(name ,description, manager);
        subreddits_database.add(subreddit);
        return subreddit;

    }
    //sub post for user
    private static ArrayList<Post> subpostsforuser(User user) {

        ArrayList<Post> subpostsforuser = new ArrayList<>(user.getPosts());
        for (Usertosubreddit usertosubreddit :user.getSubscribed_subreddits()){
            subpostsforuser.addAll(usertosubreddit.getSubreddit().getSubreddit_posts());
        }

        return subpostsforuser;
    }
}
