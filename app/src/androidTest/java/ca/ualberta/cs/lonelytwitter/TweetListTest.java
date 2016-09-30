package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Arjun on 2016-09-29.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDelete() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.addTweet(tweet);
        assertTrue(tweets.contains(tweet));
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.addTweet(tweet);
        tweets.addTweet(tweet);
        tweets.addTweet(tweet);
        assertTrue(tweets.getCount() == 3);
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.addTweet(tweet);
        assertTrue(tweets.getTweet(tweet) == 0);
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testAddTweetThrowsException() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        list.addTweet(tweet);
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        Tweet tweet1 = new NormalTweet("test");
        Tweet tweet2 = new NormalTweet("test");
        Tweet tweet3 = new NormalTweet("test");

        // need to set the date otherwise evil
        tweet1.setDate(new Date(2016, 01, 01));
        tweet2.setDate(new Date(2017, 01, 01));
        tweet3.setDate(new Date(2018, 01, 01));

        list.addTweet(tweet3);
        list.addTweet(tweet2);
        list.addTweet(tweet1);

        List<Tweet> expectedTweets = Arrays.asList(tweet1, tweet2, tweet3);
        List<Tweet> actualTweets = list.getTweets();

        assertEquals(tweet1, actualTweets.get(0));
        assertEquals(expectedTweets, actualTweets);
    }
}
