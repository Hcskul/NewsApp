package com.example.lukas.newsapp;

public class News {

    /**
     * String resource ID for section of the article
     */
    private String mSection;

    /**
     * String resource ID for author of the article
     */
    private String mAuthor;

    /**
     * String resource ID for the title of the article
     */
    private String mTitle;

    /**
     * String resource ID for the date and the time published for the article
     */
    private String mDate;

    /**
     * String resource ID for the url of the article
     */
    private String mUrl;


    /**
     * Create a new News object.
     *
     * @param section is String for the section of the article
     * @param title   is String for the title of the article
     * @param date    is the String for the date, when the article was published
     * @param url     is the String for the url, which contains the article
     */
    public News(String section, String author, String title, String date, String url) {
        mSection = section;
        mAuthor = author;
        mTitle = title;
        mDate = date;
        mUrl = url;
    }


    /**
     * Get the string for section of the article
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Get the string for section of the article
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Get the string for the title
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the string for the date of the article
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Get the string for the url of the EQ
     */
    public String getUrl() {
        return mUrl;
    }
}
