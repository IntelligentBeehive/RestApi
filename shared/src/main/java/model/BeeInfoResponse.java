package model;

import java.util.ArrayList;
import java.util.List;

public class BeeInfoResponse extends Response {
    private List<BeeInfo> beeInfo;

    public BeeInfoResponse(List<BeeInfo> beeInfo) {
        this.beeInfo = beeInfo;
    }
    public BeeInfoResponse() {
        this.beeInfo = new ArrayList<>();
    }

    public List<BeeInfo> getBeeInfo() {
        return beeInfo;
    }

    public void setBeeInfo(List<BeeInfo> beeInfo) {
        this.beeInfo = beeInfo;
    }
}
