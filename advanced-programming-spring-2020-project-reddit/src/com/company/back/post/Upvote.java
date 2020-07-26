package com.company.back.post;

import com.company.back.user.User;

public class Upvote extends Score {
    public Upvote(User user) {
        super(user);
    }
    //upvote
    public static Upvote upvote(User user, Post post){
        Upvote upvote = new Upvote(user);
        post.addinteraction(upvote);
        return upvote;
    }
    //disUpvote :))
    public static void disupvote(User user, Post post){

        for (Interaction interaction:post.getInteractions()){
            if (interaction instanceof Upvote){
                if (interaction.getUser().getUsername().equals(user.getUsername())){
                    post.getInteractions().remove(interaction);
                }
            }
        }

    }
    public static Upvote Cupvote(User user, Comment comment){
        Upvote upvote = new Upvote(user);
        comment.addinteraction(upvote);
        return upvote;
    }
    //disUpvote :))
    public static void Cdisupvote(User user,  Comment comment){

        for (Interaction interaction:comment.getInteractions()){
            if (interaction instanceof Upvote){
                if (interaction.getUser().getUsername().equals(user.getUsername())){
                    comment.getInteractions().remove(interaction);
                }
            }
        }

    }
}
