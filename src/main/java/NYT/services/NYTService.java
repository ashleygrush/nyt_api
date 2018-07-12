package NYT.services;

import NYT.Mappers.NYTMapper;
import NYT.model.db.Article;
import NYT.model.db.DBSearch;
import NYT.model.db.Headlines;
import NYT.model.db.WordCountObject;
import NYT.model.nyt.Docs;
import NYT.model.nyt.NYTRoot;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//THE BRAINS... BRAAAAAINS!!
// creates bean for services - Autowired into Controller
@Service
public class NYTService {

    // we can pull it directly because we made a bean out of the RestTemplate.
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    NYTMapper mapper;

    // my personal API Key for website
    private final String API_KEY = "780f0c17548a4c458ec0753c06107897";

    // GENERAL SEARCH API
    public NYTRoot searchNYT(String keyword, String persist) {
        // searches for keyword within the URL, add API Key at end to access
        String url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=" + keyword + "&api-key=" + API_KEY;

        // searches for object "keyword" in url via Response class.
        // restTemplet like myBatis - imports all sorts of code to map data to objects
        NYTRoot nytResponse = restTemplate.getForObject(url, NYTRoot.class);

        // keeps the search parameters NOT case sensitive
        if (persist.equalsIgnoreCase("true")) {
            // pushes results to Article values
            persistResults(nytResponse);
        }
        // returns response
        return nytResponse;
    }

    // HEADLINE SEARCH API
    public NYTRoot headlineNYTSearch(String keyword, String force) {
        // searches for keyword within the URL, add API Key at end to access
        String url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=" + keyword + "&api-key=" + API_KEY;

        // searches for object "keyword" in url via Response class.
        // restTemplet like myBatis - imports all sorts of code to map data to objects
        NYTRoot nytHLSearch = restTemplate.getForObject(url, NYTRoot.class);

        // keeps the search parameters NOT case sensitive
        if (force.equalsIgnoreCase("true")) {

            // pushes results to Headlines values
            headlineResults(nytHLSearch);
        }
        // returns response
        return nytHLSearch;
    }


    // SEARCH DATABASE FOR KEYWORD
    public DBSearch dbSearch(String keyword) {
        // import database
        DBSearch retVal = new DBSearch();
        // set keyword
        retVal.setKeyword(keyword);

        // searches for keyword in database
        String tempKey = "%" + keyword + "%";

        // return values to Array Articles
        retVal.setArticles(mapper.select_Keyword(tempKey));

        // establish articles array
        Article[] article = mapper.select_Keyword(keyword);

        // if no results in Database; search in web based API
        if (article.length < 1) {
            // use existing search method : enter parameters
            searchNYT(keyword, "true");
            // return values to Array Articles
            retVal.setArticles(mapper.select_Keyword(tempKey));
        }
        // return number of words in articles found.
        retVal.setArticles_With_Keyword(article.length);

        // initialize word counter
        int totalCount = 0;
        // count away!
        for (Article a : article) {
            if (a.getHeadline().contains(keyword))
                totalCount++;
            if (a.getSnippet().contains(keyword))
                totalCount++;
            return retVal.setKeyword_count(totalCount);
        }
        return retVal;
    }


    // COUNTS NUMBER OF WORDS
    public WordCountObject wordCount(String keyword, String[] terms){

        // get data from API without saving it
        NYTRoot root = searchNYT(keyword, "false");

        // saves data to pojo.
        WordCountObject retVal = new WordCountObject();

        // set keyword to retVal
        retVal.setKeyword(keyword);

        // set search terms to count
        retVal.setWordCountTerms(terms);

        // create variables to count
        int headlineCount, snippetCount, totalCount;

        // move through response; loop through docs
        for (Docs docs : root.getResponse().getDocs()) {
            for (String term : terms) {

                // set count variables
                headlineCount = StringUtils.countMatches(docs.getHeadline().getPrint_headline(), term);
                snippetCount = StringUtils.countMatches(docs.getSnippet(), term);
                totalCount = headlineCount + snippetCount;

                // add count variables to wordCountMap
                retVal.getWordCountMap().merge(term, totalCount, Integer::sum);

            }
            retVal.getArticle().add(new Article(docs.getHeadline().getPrint_headline(), docs.getSnippet(), docs.getWeb_url()));
        }
        // return values articles method to display
        return retVal;
    }


    // INSERTS SEARCH RESULTS INTO ARTICLES DATABASE
    private void persistResults(NYTRoot data) {

        // for each Doc element in the docs[] in response
        for (Docs docs : data.getResponse().getDocs()) {

            // create object to insert into DB
            Article a = new Article();

            // set Article values
            a.setHeadline(docs.getHeadline().getMain());
            a.setPub_date(docs.getPub_date());
            a.setSnippet(docs.getSnippet());
            a.setUrl(docs.getWeb_url());

            // insert article into DB
            mapper.insertRecord(a);
        }
    }

    // INSERTS HEADLINE SEARCH RESULTS INTO HEADLINE DATABASE
    private void headlineResults(NYTRoot data) {

        // pull from documents class
        for (Docs docs : data.getResponse().getDocs()) {

            // create object to put headlines info into database
            Headlines h = new Headlines();

            // set headline values
            h.setMain(docs.getHeadline().getMain());
            h.setKicker(docs.getHeadline().getKicker());
            h.setPrint_headline(docs.getHeadline().getPrint_headline());

            // insert headline data into database.
            mapper.insertHeadlineData(h);
        }
    }

}

// & means space, divider in urls