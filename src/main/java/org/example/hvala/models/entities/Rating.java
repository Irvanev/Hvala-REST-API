package org.example.hvala.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity {
    private User user;
    private int ratingCount;
    private int ratingSum;

    protected Rating() {}

    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "rating_count")
    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    @Column(name = "rating_sum")
    public int getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(int ratingSum) {
        this.ratingSum = ratingSum;
    }
}
