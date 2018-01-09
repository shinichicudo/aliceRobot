package com.sentence.handler;

import java.util.List;

import com.sentence.handler.db.IndexSearchService;
import com.sentence.domain.HandlerRequest;
import com.sentence.domain.HandlerResponse;
import com.sentence.domain.HandlerSituation;
import org.apache.lucene.document.Document;

/**
 * 数据库处理器
 */
public class DbSentenceHandler extends AbstractSentenceHandler implements ISentenceHandler {
	private IndexSearchService searchService = null;

	public DbSentenceHandler() {
		searchService = new IndexSearchService();
		searchService.indexTaskSetup();
	}

	public String response(String input) {
		// StringBuffer sb = new StringBuffer(""); // 这里每次都new，肯定有问题！！！
		List<Document> list = null;
		try {
			list = searchService.search(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// for (Document doc : list) {
		// sb.append("[问题]-->").append(doc.get("question")).append("||")
		// .append("[答案]-->").append(doc.get("replay"));
		// sb.append("\n");
		// }
		if (list.size() > 0)
			return list.get(0).get("replay");
		else
			return "";
	}
	public boolean CreateSentence(HandlerRequest request, HandlerResponse response, HandlerSituation situation) {
		String DBresponseSentence = this.response(request.getRequestSentence());
		if (DBresponseSentence != null) {
			response.setResponseSentence(DBresponseSentence);
			return true;
		}
		else
			return false;
	}
}
