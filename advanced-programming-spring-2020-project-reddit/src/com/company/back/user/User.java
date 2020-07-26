package com.company.back.user;

import com.company.back.Subreddit.Subreddit;
import com.company.back.Subreddit.Usertosubreddit;
import com.company.back.post.Post;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;
    private ArrayList<UserRelation> userRelations;

    public ArrayList<Usertosubreddit> getSubscribed_subreddits() {
        return subscribed_subreddits;
    }

    public void setSubscribed_subreddits(ArrayList<Usertosubreddit> subscribed_subreddits) {
        this.subscribed_subreddits = subscribed_subreddits;
    }

    public static ArrayList<User> getUserdatabase() {
        return userdatabase;
    }

    public static void setUserdatabase(ArrayList<User> userdatabase) {
        User.userdatabase = userdatabase;
    }

    private ArrayList<Usertosubreddit> subscribed_subreddits;
    private ArrayList<Post> posts;

    private static ArrayList<User> userdatabase = new ArrayList<>();

    private User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRelations = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.subscribed_subreddits= new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<UserRelation> getUserRelations() {
        return userRelations;
    }

    public void setUserRelations(ArrayList<UserRelation> userRelations) {
        this.userRelations = userRelations;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    //create user
    public static User createuser(String username, String password, String email) {
        return new User(username, password, email);
    }

    // login
    public static User login(String username, String password) {
        for (User user : userdatabase) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;

        }
        return null;
    }

    // sign up
    public static User signup(String username, String password, String email) {

        for (User user : userdatabase) {
            if (user.getUsername().equals(username)) {
                return null;
            }

        }


        User newuser = User.createuser(username, password, email);
        userdatabase.add(newuser);
        return newuser;
    }
    //search
    public static User searchuser(String username){
        for (User user : userdatabase) {
            if (user.getUsername().equals(username)) {
                return user;
            }

        }
        return null;
    }
    //follow
    public void follow(String username){
        User user = User.searchuser(username);
        UserRelation newrelaion = new UserRelation(user);
        userRelations.add(newrelaion);
    }
    //unfollow
    public void unfollow(String username){
        for (UserRelation relation : userRelations){
            if (relation.getUser().getUsername().equals(username))
                userRelations.remove(relation);
        }
    }

    // post
    public void post(String title, String text , String subreddit_title){

        Post post = new Post(title ,text);
        posts.add(post);
        for (Usertosubreddit relation:subscribed_subreddits){
            if(relation.getSubreddit().getName().equals(subreddit_title.toLowerCase())){
                relation.getSubreddit().addpost(post);
            }

        }



    }
    //post for subredit
    public void sub_post(String title, String text , String subreddit_title,Subreddit sub) {

        Post post = new Post(title, text, sub);
        posts.add(post);
        sub.addpost(post);
        for (Usertosubreddit relation : subscribed_subreddits) {
            if (relation.getSubreddit().getName().equals(subreddit_title.toLowerCase())) {
                relation.getSubreddit().addpost(post);
            }

        }
    }
    // has followed
    public boolean hasfollowed(User user) {

        for(UserRelation userRelation : userRelations){
            if (userRelation.getUser().getUsername().equals(user.getUsername())){
                return true;
            }
        }

        return false;
    }
    // has subscribed
    public boolean hassubscribed(Subreddit subreddit) {

        for(Usertosubreddit usertosubreddit:subscribed_subreddits){
            if (usertosubreddit.getSubreddit().equals(subreddit)){
                return true;
            }
        }

        return false;
    }
    // make subreddit
    public void makesubreddit(String name ,String title){
        Subreddit.create_subreddit(name ,title ,this);// beporsam


    }


}


