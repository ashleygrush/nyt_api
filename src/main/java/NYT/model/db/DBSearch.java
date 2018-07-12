package NYT.model.db;

// displays results
public class DBSearch {

    // set the keyword so we can see it in the response
    String keyword;

    // the number of articles (rows from the db) that contain the keyword
    int articles_With_Keyword;

    // BONUS: the total number of times that keyword is found in the DB
    int keyword_count;

    // an array of article objects that contain the keyword
    // (you can return 1 or all the columns from the table/object - up to you)
    // for instance, you could just select & set the article headline
    Article[] articles;

    // getters and setters


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getArticles_With_Keyword() {
        return articles_With_Keyword;
    }

    public void setArticles_With_Keyword(int articles_With_Keyword) {
        this.articles_With_Keyword = articles_With_Keyword;
    }

    public int getKeyword_count() {
        return keyword_count;
    }

    public DBSearch setKeyword_count(int keyword_count) {
        this.keyword_count = keyword_count;
        return null;
    }

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }
}
