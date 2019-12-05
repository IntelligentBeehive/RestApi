package model;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Hugo Mkandawire
 */
public class PollenResponseList extends Response {
    private List<Pollen> pollenList = new ArrayList<>();

    public List<Pollen> getPollenList() {
        return pollenList;
    }

    public void setPollenList(List<Pollen> pollenList) {
        this.pollenList = pollenList;
    }

    public void addPollen(Pollen pollen) {
        this.pollenList.add(pollen);
    }
}
