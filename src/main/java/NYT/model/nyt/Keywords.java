package NYT.model.nyt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// linked to Docs class
@JsonIgnoreProperties(ignoreUnknown = true)
public class Keywords {

    String name;
    String value;
    int rank;
    String major;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
