package com.company.back.post;

import com.company.back.user.User;

public class Downvote extends Score {
    public Downvote(User user) {
        super(user);
    }
    //downvote
    public static Downvote downvote(User user, Post post){
        Downvote downvote = new Downvote(user);
        post.addinteraction(downvote);
        return downvote;
    }
    //disDownvote :))
    public static void disdownvote(User user, Post post){

        for (Interaction interaction:post.getInteractions()){
            if (interaction instanceof Downvote){
                if (interaction.getUser().getUsername().equals(user.getUsername())){
                    post.getInteractions().remove(interaction);
                }
            }
        }

    }
    public static Downvote Cdownvote(User user, Comment comment){
        Downvote downvote = new Downvote(user);
        comment.addinteraction(downvote);
        return downvote;
    }
    //disDownvote :))
    public static void Cdisdownvote(User user,  Comment comment){

        for (Interaction interaction:comment.getInteractions()){
            if (interaction instanceof Downvote){
                if (interaction.getUser().getUsername().equals(user.getUsername())){
                    comment.getInteractions().remove(interaction);
                }
            }
        }

    }
}
