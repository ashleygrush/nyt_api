package NYT.model.nyt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// linked to Docs class
@JsonIgnoreProperties(ignoreUnknown = true)
public class Byline {

    String original;
    // Person array - class
    Person [] person;
    String organization;

    public Person[] getPerson() {
        return person;
    }

    public void setPerson(Person[] person) {
        this.person = person;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
