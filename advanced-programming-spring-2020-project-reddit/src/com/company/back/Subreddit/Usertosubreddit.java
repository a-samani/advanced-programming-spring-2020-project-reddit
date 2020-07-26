package com.company.back.Subreddit;

public class Usertosubreddit {
    private Subreddit subreddit;

    public Subreddit getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(Subreddit subreddit) {
        this.subreddit = subreddit;
    }

    public Usertosubreddit(Subreddit subreddit) {
        this.subreddit = subreddit;
    }
}
