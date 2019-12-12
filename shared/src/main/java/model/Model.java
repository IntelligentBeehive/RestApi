package model;

/**
 * Inheritance model for every models
 *
 * @Author Hugo Mkandawire
 */
public abstract class Model {
    protected Integer id;
    protected String dateCreated;
    protected String url;

    public int getId() {
        return id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getUrl() {
        return url;
    }
}
