package NYT.model.nyt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// linked to Reponse class
@JsonIgnoreProperties(ignoreUnknown = true)
public class Docs {

    String web_url;
    String snippet;
    String print_page;
    String source;

    Headline Headline;
    Multimedia [] multimedia;


    Keywords [] keywords;
    String pub_date;
    String document_type;
    String news_desk;

    Byline byline;

    String organization;
    String type_of_material;
    String _id;

    int word_count;

    double score;
    String uri;

    public Multimedia[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia[] multimedia) {
        this.multimedia = multimedia;
    }

    public Keywords[] getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords[] keywords) {
        this.keywords = keywords;
    }

    public NYT.model.nyt.Headline getHeadline() {
        return Headline;
    }

    public void setHeadline(NYT.model.nyt.Headline headline) {
        Headline = headline;
    }

    public Byline getByline() {
        return byline;
    }

    public void setByline(Byline byline) {
        this.byline = byline;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getPrint_page() {
        return print_page;
    }

    public void setPrint_page(String print_page) {
        this.print_page = print_page;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getNews_desk() {
        return news_desk;
    }

    public void setNews_desk(String news_desk) {
        this.news_desk = news_desk;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getType_of_material() {
        return type_of_material;
    }

    public void setType_of_material(String type_of_material) {
        this.type_of_material = type_of_material;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getWord_count() {
        return word_count;
    }

    public void setWord_count(int word_count) {
        this.word_count = word_count;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
