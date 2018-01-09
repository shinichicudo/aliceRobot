package com.context;

import com.sentence.handler.AimlSentenceHandler;
import com.sentence.handler.DbSentenceHandler;
import com.background.RobotProperty;
import com.sentence.handler.ISentenceHandler;

public class ChartManager {
    private static ChartContext chartContext = null;
    private static ChartManager instance = null;

    /**
     * 单例模式
     */
    private ChartManager() {

        chartContext = new ChartContext();

    }

    public static ChartManager getInstance() {
        if (instance == null) {
//            synchronized (ChartManager.class) { // 这个什么意思？？？
                instance = new ChartManager();
//            }
        }
        return instance;
    }

    public String response(String input) {
        return this.response(input,ChartContext.NOT_NEED_SITUATION,ChartContext.NOT_NEED_USER_ID);
    }
    public String response(String input,Long conversationId,Long inputUserId) {
        return chartContext.response(input,conversationId,inputUserId);
    }

}
