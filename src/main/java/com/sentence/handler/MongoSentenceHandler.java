package com.sentence.handler;

import com.sentence.domain.HandlerRequest;
import com.sentence.domain.HandlerResponse;
import com.sentence.domain.HandlerSituation;
/**
 * mongo处理器
 */
public class MongoSentenceHandler extends AbstractSentenceHandler implements ISentenceHandler{
    public boolean CreateSentence(HandlerRequest request, HandlerResponse response, HandlerSituation situation) {
        return false;
    }
}
