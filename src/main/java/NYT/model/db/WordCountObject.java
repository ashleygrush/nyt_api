package NYT.model.db;

import java.util.ArrayList;
import java.util.HashMap;

// Array for word count
public class WordCountObject {

    String keyword;
    String[] wordCountTerms;
    HashMap<String, Integer> wordCountMap = new HashMap<>();
    ArrayList<Article> article = new ArrayList<>();

    // getters and setters
    public ArrayList<Article> getArticle() {
        return article;
    }

    public void setArticle(ArrayList<Article> article) {
        this.article = article;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String[] getWordCountTerms() {
        return wordCountTerms;
    }

    public void setWordCountTerms(String[] wordCountTerms) {
        this.wordCountTerms = wordCountTerms;
    }

    public HashMap<String, Integer> getWordCountMap() {
        return wordCountMap;
    }

    public void setWordCountMap(HashMap<String, Integer> wordCountMap) {
        this.wordCountMap = wordCountMap;
    }
}
