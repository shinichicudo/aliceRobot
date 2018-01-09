package com.sentence.domain;

public class HandlerRequest {
    private String requestSentence;

    private Long requestUserId;

    public HandlerRequest(String requestSentence, Long requestUserId) {
        this.requestSentence = requestSentence;
        this.requestUserId = requestUserId;
    }

    public Long getRequestUserId() {
        return requestUserId;
    }

    public void setRequestUserId(Long requestUserId) {
        this.requestUserId = requestUserId;
    }

    public String getRequestSentence() {
        return requestSentence;
    }

    public void setRequestSentence(String requestSentence) {
        this.requestSentence = requestSentence;
    }
}
