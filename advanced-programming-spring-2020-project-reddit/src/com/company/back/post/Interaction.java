package com.company.back.post;

import com.company.back.user.User;

public abstract class Interaction {
    private User user;

    public Interaction(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
