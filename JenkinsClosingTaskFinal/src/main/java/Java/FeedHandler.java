package Java;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
    the class responsible for handling feeds
 */
public class FeedHandler {

    // HTML string param
    private static String parsedFeed= "<title> Ynet</title>"+"<table>"+"<tr align=\"right\">"
            +"<th>Article</th>"
            + "<th>Description and picture</th>"
            +"<th>Date</th>"
            +"<th>Read More </th>"
            +" </tr>";

    /*
    the function reads  Xml  Feeds from the URL calls the parsefeeds and change it from xml to html and returns the html string.
     */
    public static String ReadFeeds() {


        try {
            URL givenURL = new URL("http://www.ynet.co.il/Integration/StoryRss2.xml");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(givenURL));
            ParseFeeds(feed);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return parsedFeed;
        }


    }
    /*
      The function gets the feed in xml format and converts the data into parsedFeed param in an HTML format.
       */
    public static void ParseFeeds(SyndFeed feed) {

        for(Object o: feed.getEntries()) { //iterate over the entries in the RSS feed file
            SyndEntry entry = (SyndEntry) o;
            parsedFeed += "<title> Ynet</title>";
            parsedFeed +=
                    "<tr align=\"right\">"
                            + "<th>" + entry.getTitle() + "</th>"
                            + "<td>" + entry.getDescription().getValue() + "</td>"
                            +"<td>" + entry.getPublishedDate() + "</td>"
                            + "<td>" + "<a href=" + entry.getLink() + ">" + "Read More.." + "</a>" + "</td>";

        }
        parsedFeed+= "</table>";



    }




}
