package com.sentence.handler;

import com.sentence.domain.HandlerRequest;
import com.sentence.domain.HandlerResponse;
import com.sentence.domain.HandlerSituation;

/**
 * 兜底处理器
 */
public class LastSentenceHandler extends AbstractSentenceHandler implements ISentenceHandler {
    public boolean CreateSentence(HandlerRequest request, HandlerResponse response, HandlerSituation situation) {
        response.setResponseSentence(getRandomResponse());
        return true;
    }

    /**
     * 随机回复
     * @return
     */
    private final String[] NULLREPLAY = {
            "对不起，我还不能回答您的这个问题。",
            "唔，主人还没有教会我这个问题呢。",
            "我暂时还回答不了这个问题呢？",
            "我好像不明白。",
    };
    private String getRandomResponse() {
        return NULLREPLAY[getRandomNum()];
    }

    private int getRandomNum() {
        return (int) (Math.random() * NULLREPLAY.length);
    }
}
