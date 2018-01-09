package com.sentence.handler;

import java.io.IOException;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;
import com.sentence.handler.aiml.GossipLoad;
import com.sentence.domain.HandlerRequest;
import com.sentence.domain.HandlerResponse;
import com.sentence.domain.HandlerSituation;

/**
 * aiml处理器
 */
public class AimlSentenceHandler extends AbstractSentenceHandler implements ISentenceHandler {


	private final String NULLSIGN = "#"; // 这个标志是用来表示，当查询AIML的时候，匹配到了*。

	private final String USEFULSIGN = "$";// 这个标志是用来表示，当查询AIML的时候匹配到了专业问题的模式。

	private static AliceBotMother mother = null;
	private static AliceBot bot = null;
	private static GossipLoad gossipLoad = null;

	public AimlSentenceHandler() {
		gossipLoad = new GossipLoad();
		try {
			gossipLoad.load();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			gossipLoad.clean();
		}
		mother = new AliceBotMother();
		mother.setUp();
		try {
			bot = mother.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String response(String input) {
		return bot.respond(input);
	}

	public boolean CreateSentence(HandlerRequest request, HandlerResponse response, HandlerSituation situation) {
		String responseFromAIML = this.response(request.getRequestSentence());
		if (-1 == responseFromAIML.indexOf(NULLSIGN) && -1 == responseFromAIML.indexOf(USEFULSIGN)||responseFromAIML.equals("")) {
			response.setResponseSentence(responseFromAIML);
			return true;
		} else {
			return false;
		}

	}

//	/**
//	 * 从数据库中查询
//	 * （处理无法回复的回复）
//	 *
//	 * @param originInput 原来输入的内容
//	 * @param aimlReplay 回答的内容
//	 * @return
//	 */
//	private String translate(String originInput, String aimlReplay) {
//		String asDBInput = "";
//		if (-1 != aimlReplay.indexOf(NULLSIGN)) {
//			asDBInput = originInput;
//		} else if (-1 != aimlReplay.indexOf(USEFULSIGN)) {
//			asDBInput = aimlReplay.replaceAll(USEFULSIGN, "");
//		} else
//			return aimlReplay;
//
//
//		aimlReplay = aimlReplay.replaceFirst("#","");
//
//
//		String dbReplay = askToDB.response(aimlReplay);
//		if (0 == dbReplay.length()) {
//			return getRandomResponse();
//		} else
//			return dbReplay;
//	}
}
