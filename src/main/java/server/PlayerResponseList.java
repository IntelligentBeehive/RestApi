package server;

import java.util.ArrayList;
import java.util.List;

public class PlayerResponseList {
    private String operation = "";
    private String expression = "";
    private String result = "";
    private List<Player> playerList = new ArrayList<>();

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void addToResponseList(Player player) {
        this.playerList.add(player);
    }
}
