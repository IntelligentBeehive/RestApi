package model;

/**
 * Inheritance response for every responses
 *
 * @Author Hugo Mkandawire
 */
public abstract class Response {
    protected String operation = "";
    protected String expression = "";
    protected String result = "";

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
