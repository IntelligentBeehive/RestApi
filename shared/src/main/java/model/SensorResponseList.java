package model;

import java.util.ArrayList;
import java.util.List;

public class SensorResponseList extends Response {
    private List<Sensor> SensorList = new ArrayList<>();

    public List<Sensor> getSensorList() {
        return SensorList;
    }

    public void setSensorList(List<Sensor> SensorList) {
        this.SensorList = SensorList;
    }

    public void addToResponseList(Sensor Sensor) {
        this.SensorList.add(Sensor);
    }
}
