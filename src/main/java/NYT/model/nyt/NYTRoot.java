package NYT.model.nyt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// ignores unknown properties; if not in our class, it will ignore it. (Jackson above, is like an import technology)
@JsonIgnoreProperties(ignoreUnknown = true)

// pojo for response
public class NYTRoot {

    String status;
    String copyright;
    Response response;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    // needed to call in incoming connections for responses.
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
