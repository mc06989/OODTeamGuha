package edu.georgasouthern.oodteamguha;

import android.widget.TextView;

import java.util.List;

//Use to implement composite pattern

public interface Scraper {

    //Every scraper will need a list of data entries
    public List getEntries();

    //We use a string builder to append text into a text view for the current page
    public StringBuilder getBuilder();

    //Every scraper needs a website
    public String getWebsite();

    //Every scraper needs an identifier
    public String getCssClassIdentifier();

    //Must be able to get a text view at a minimum for the scraped data (may not always be a graph)
    public TextView getResult();

}
