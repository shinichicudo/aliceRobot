package com.sentence.domain;

import java.util.ArrayList;
import java.util.List;

public class HandlerSituation {
    private List<HandlerSentence> senList = new ArrayList<HandlerSentence>();

    public List<HandlerSentence> getSenList() {
        return senList;
    }

    public void setSenList(List<HandlerSentence> senList) {
        this.senList = senList;
    }

    public void addSentence(HandlerSentence handlerSentence) {
        senList.add(handlerSentence);
    }
}
