package com.company.back.post;

import com.company.back.user.User;

import java.util.ArrayList;

public class Comment extends Interaction {

    private String text;
    private ArrayList<Interaction> interactions;

    public Comment(User user, String text) {
        super(user);
        this.text = text;
        interactions = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public static Comment comment (User user, Post post ,String text){
        Comment comment = new Comment(user, text);
        post.addinteraction(comment);
        return comment;
    }
    public static Comment reply(User user, Comment comment ,String text){
        Comment reply = new Comment(user, text);
        comment.addinteraction(reply);
        return reply;

    }
    //add interaction
    public void addinteraction(Interaction interaction) {
        getInteractions().add(interaction);

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

    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(ArrayList<Interaction> interactions) {
        this.interactions = interactions;
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
    public void showcomment(){
        System.out.println(getUser().getUsername() + " says: " + text);
        System.out.println();
        System.out.println("Score : "+this.score()+" Comments : "+this.countcomments());
    }
}
