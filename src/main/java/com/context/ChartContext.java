package com.context;

import com.sentence.domain.HandlerRequest;
import com.sentence.domain.HandlerResponse;
import com.sentence.domain.HandlerSentence;
import com.sentence.domain.HandlerSituation;
import com.sentence.handler.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 聊天上下文
 *
 */
public class ChartContext{
	private Map<Long, HandlerSituation> situationMap = new HashMap<>();

	public static Long NOT_NEED_SITUATION = -1L;

	public static Long NOT_NEED_USER_ID = -1L;

	private AbstractSentenceHandler first = null;




	/**
	 * 生成责任链
	 */
	public ChartContext() {


		this.addHandler(new AimlSentenceHandler());
//		this.addHandler(new DbSentenceHandler());
//		this.addHandler(new MongoSentenceHandler());
		this.addHandler(new LastSentenceHandler());


	}

	public void addHandler(AbstractSentenceHandler sentenceHandler) {
		if (first == null) {
			first = sentenceHandler;
			return;
		}
		AbstractSentenceHandler handle = first;
		while (handle.getHandler() != null) {
			handle = handle.getHandler();
		}
		handle.setHandler(sentenceHandler);
	}

	/**
	 * 责任链模式处理请求。
	 */
	public String response(String input,Long conversationId,Long inputUserId) {
		HandlerSituation situation = this.getSituation(conversationId);
		if (situation == null) {
			this.createSituation(conversationId);
		}
		boolean success = false;
		AbstractSentenceHandler handler = first;
		HandlerRequest request = new HandlerRequest(input,inputUserId);
		HandlerResponse response = new HandlerResponse();
		while (!success) {
			/**
			 * 处理代码
			 */
			success = handler.CreateSentence(request, response, situation);
			handler = handler.getHandler();
		}
		/**
		 * 将用户语句及机器回复语句添加进会话上下文
		 */
		if(conversationId != NOT_NEED_SITUATION) {
			HandlerSentence requestSentence = new HandlerSentence(inputUserId, input);
			HandlerSentence responseSentence = new HandlerSentence(HandlerSentence.robotNumber, response.getResponseSentence());
			situation.addSentence(requestSentence);
			situation.addSentence(responseSentence);
		}
		return response.getResponseSentence();
//		String responseFromAIML = askToAIML.response(input);
//		// 替换文本中的空格字符串
//        // 判断是中文还是英文,中文需要去掉空格。
////        if(isContainChinese(responseFromAIML)){
////            responseFromAIML = responseFromAIML.replace(" ", "");
////        }
//		return translate(input, responseFromAIML);
	}
	public HandlerSituation getSituation(Long conversationId) {
		HandlerSituation handlerSituation = situationMap.get(conversationId);
		return handlerSituation;
	}

	public void createSituation(Long conversationId) {
		situationMap.put(conversationId, new HandlerSituation());
	}


    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }





}
