package NYT.controller;


import NYT.model.db.DBSearch;
import NYT.model.db.WordCountObject;
import NYT.model.nyt.NYTRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import NYT.services.NYTService;

// RESTing API Controller
@RestController
// maps URL location
@RequestMapping("/nyt")
public class NYTController {

    // connected to bean in NYTService class
    @Autowired
    NYTService service;

    // searches NTY for string keyword via RequestParameters
    @RequestMapping("/search")
    public NYTRoot searchNYT(
            @RequestParam("keyword") String keyword,
            @RequestParam("persist") String persist) {

        NYTRoot response = service.searchNYT(keyword, persist);

        return response;
    }

    // searches NYT for string keyword via headline search in parameters
    @RequestMapping("/headlinesearch")
    public NYTRoot nytHeadlineSearch(
            @RequestParam("keyword") String keyword,
            @RequestParam("force") String force) {

        NYTRoot response = service.headlineNYTSearch(keyword, force);

        return response;
    }


    // Searches through database
    @RequestMapping("/searchDB")
    public DBSearch searchDB(
            @RequestParam("keyword") String keyword) {
        return service.dbSearch(keyword);
    }

    // displays word count information
    @RequestMapping("/wordcount")
    public WordCountObject wordCount(
            @RequestParam("keyword") String keyword,
            @RequestParam("terms") String[] terms) {
//          @RequestParam("useDB") String useDB)

        return service.wordCount(keyword, terms);
    }
}


// localhost:8080/nyc/search?keyword=Obama