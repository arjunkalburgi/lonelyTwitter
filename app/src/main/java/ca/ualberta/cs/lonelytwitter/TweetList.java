package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import static java.util.Collections.sort;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Arjun on 2016-09-29.
 */
public class TweetList extends ArrayList<Tweet> {

    /**
     * Has tweet boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean hasTweet(Tweet t) {
        return this.contains(t);
    }

    /**
     * Add tweet.
     *
     * @param t the t
     */
    public void addTweet(Tweet t) {
        if (this.contains(t)) {
            throw new IllegalArgumentException();
        }
        this.add(t);
    }

    /**
     * Gets tweets.
     *
     * @return the tweets
     */
    public TweetList getTweets() {
        TweetList l = this;
        Collections.sort(l, new tweetDateCompare());
        return l;
    }

    /**
     * Gets tweet.
     *
     * @param t the t
     * @return the tweet
     */
    public int getTweet(Tweet t) {
        return this.indexOf(t);
    }

    /**
     * Delete boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean delete(Tweet t) {
        return this.remove(t);
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return this.size();
    }
}

/**
 * The type Tweet date compare.
 */
class tweetDateCompare implements Comparator<Tweet> {
    public int compare(Tweet t1, Tweet t2) {
        return t1.getDate().compareTo(t2.getDate());
    }
}
