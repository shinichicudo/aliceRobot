package com.sentence.domain;

public class HandlerSentence {
    public static Long robotNumber = 0L;
    private Long number;
    private String statement;

    public HandlerSentence(Long number, String statement) {
        this.number = number;
        this.statement = statement;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
