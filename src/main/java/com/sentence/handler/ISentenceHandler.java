package com.sentence.handler;

import com.sentence.domain.HandlerRequest;
import com.sentence.domain.HandlerResponse;
import com.sentence.domain.HandlerSituation;

/**
 * Created by jiangx on 2016/10/11.
 */
public interface ISentenceHandler {
    boolean CreateSentence(HandlerRequest request, HandlerResponse response, HandlerSituation situation);
}
