package NYT.model.nyt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// leads responses
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    // docs array on web page (part of Root)
    Docs [] docs;
    Meta meta;

    public Docs[] getDocs() {
        return docs;
    }

    public void setDocs(Docs[] docs) {
        this.docs = docs;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
