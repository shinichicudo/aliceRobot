package com.sentence.handler;

/**
 * Created by jiangx on 2016/10/11.
 */
public abstract class AbstractSentenceHandler implements ISentenceHandler{

    private AbstractSentenceHandler handler = null;

    public AbstractSentenceHandler getHandler() {
        return handler;
    }

    public void setHandler(AbstractSentenceHandler handler) {
        this.handler = handler;
    }

}
