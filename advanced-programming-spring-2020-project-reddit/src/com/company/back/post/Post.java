package com.company.back.post;

import com.company.back.Subreddit.Subreddit;
import com.company.back.user.User;
import com.company.back.user.UserRelation;

import java.util.ArrayList;

public class Post {
    private String title;
    private String text;
    private ArrayList<Interaction> interactions;
    private Subreddit sub;
    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(ArrayList<Interaction> interactions) {
        this.interactions = interactions;
    }

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
        this.interactions = new ArrayList<>();
    }
    public Post(String title, String text,Subreddit sub) {
        this.title = title;
        this.text = text;
        this.interactions = new ArrayList<>();
        this.sub = sub;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //show post
    public void showpost() {
        System.out.println("Title : \n " + this.title + "\n\t" + this.text);
        System.out.println("Score : "+this.score()+" Comments : "+this.countcomments());
    }

    //add interaction
    public void addinteraction(Interaction interaction) {
        getInteractions().add(interaction);

    }

    //post for user
    private static ArrayList<Post> postsforuser(User user) {

        ArrayList<Post> postsforuser = new ArrayList<>(user.getPosts());
        for (UserRelation userRelation :user.getUserRelations()){
            postsforuser.addAll(userRelation.getUser().getPosts());
        }

        return postsforuser;
    }

    //user post
    public static ArrayList<Post> userPosts(User user) {

        ArrayList<Post> userpost = new ArrayList<>(user.getPosts());

        return userpost;
    }
    // Show Post for User
    public static void showPostForUser(User user) {

        ArrayList<Post> userPosts = postsforuser(user);

        if (userPosts.isEmpty()){
            System.out.println("No Posts yet!");
        }

        else {
            int count = 1;
            for(Post post: userPosts) {
                System.out.print(count + ". ");
                post.showpost();
                System.out.println();
                ++count;
            }

        }


    }


    // Show User Posts
    public static void showUserPosts(User user) {

        ArrayList<Post> userPosts = userPosts(user);


        if (userPosts.isEmpty()){
            System.out.println("No Posts yet!");
        }

        else {
            int count = 1;
            for(Post post: userPosts){
                System.out.print(count + ". ");
                post.showpost();
                System.out.println();
                ++count;
            }
        }

    }
    // count comment
    public int countcomments(){
        int count =0;
        for (Interaction interaction : interactions){
            if (interaction instanceof Comment){
                count++;

            }
        }
        return count;
    }
    // score
    public int score(){
        int score = 0;
        for (Interaction interaction : interactions){
            if (interaction instanceof Upvote){
                ++score;

            }
            else if (interaction instanceof Downvote) {
                --score;
            }
        }
        return score;
    }
}
