package main.java.com.grfc.expert;

import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonBuilder {
	
	public static String confirm () {
		JSONObject focus = new JSONObject();
		focus.put("status", "sent_to_confirm");
		focus.put("violations", plusViolations());
		focus.put("text", plusText());
		return focus.toJSONString();
	}
	
	public static String all () {
		JSONObject focus = new JSONObject();
		focus.put("status", "send_to_manager");
		focus.put("violations", plusViolations());
		focus.put("text", plusText());
		return focus.toJSONString();
	}
	
	public static String approve () {
		JSONObject focus = new JSONObject();
		focus.put("status", "approved");
		focus.put("violations", plusViolations());
		focus.put("text", plusText());
		return focus.toJSONString();
	}
	
	public static String rework () {
		JSONObject upd = new JSONObject();
		upd.put("status", "rework");
		upd.put("rework_comment", "test" + Tools.timeStamp("yyyyMMddHHmmss"));
		return upd.toJSONString();
	}	

	public static String update () {
		JSONObject upd = new JSONObject();
		upd.put("violations", plusViolations());
//		upd.put("text", plusText());
		upd.put("edit_blocker", "update");
		return upd.toJSONString();
	}
	
		public static String opinion () {
		JSONObject upd = new JSONObject();
		JSONObject opinion = new JSONObject();
		opinion.put("violations", plusViolations());
		opinion.put("is_decided", true);
		opinion.put("comment", "Комментарий");
		opinion.put("coauthor", 113);
		upd.put("coauthor_opinion", opinion);
		upd.put("edit_blocker", "update");
		return upd.toJSONString();
	}
	
	public static String editBlockerBody (String type) {
		JSONObject obj = new JSONObject();
		obj.put("edit_blocker", type);
		return obj.toJSONString();
	}
	
	public static JSONArray plusViolations () {
		JSONObject violation1 = new JSONObject();
		violation1.put("pk", 29);
		violation1.put("violation__name", "Гос. тайна");
		violation1.put("violation__name_for_print", "признаками <b>распространения</b> в СМИ <b>информации</b>, за распространение которой предусмотрена административная или уголовная ответственность <b>(сведения, разглашающие государственную или иную специально охраняемую законом тайну)</b>");
		violation1.put("decision", true);
		
		JSONObject violation2 = new JSONObject();
		violation2.put("pk", 52);
		violation2.put("violation__name", "Детская порнография");
		violation2.put("violation__name_for_print", "признаками <b>детской порнографии</b>");
		violation2.put("decision", true);
		
		JSONArray viols = new JSONArray();
		viols.add(violation1);
		viols.add(violation2);
		
		return viols;
	}
	
	public static JSONObject plusText () {
		JSONObject block1 = new JSONObject();
		block1.put("edit", false);
		block1.put("enabled", false);
		block1.put("text", "Исследуемая статья носит информационный характер и не относится к категории материалов, содержащих научную, научно-техническую, статистическую информацию и (или) имеющих значительную историческую, художественную или иную культурную ценность для общества.");
		
		JSONObject block2 = new JSONObject();
		block2.put("edit", true);
		block2.put("enabled", true);
		block2.put("text", "<p>test" + Tools.timeStamp("yyyyMMddHHmmss") + "test</p>");
		
		JSONObject block3 = new JSONObject();
		block3.put("edit", false);
		block3.put("enabled", true);
		block3.put("text", "<p><strong>Вывод:</strong> Результаты проведенного исследования видеоматериала в материале lool \"" + Tools.timeStamp("yyyyMMddHHmmss") + "\", опубликованного в электронном периодическом издании \"Труд\" (http://www.trud.ru/), показали</p>");
		
		JSONObject block4 = new JSONObject();
		block4.put("edit", true);
		block4.put("enabled", true);
		block4.put("text", "<p>test" + Tools.timeStamp("yyyyMMddHHmmss") + "test</p>");
		
		JSONObject text = new JSONObject();
		text.put("block2", block2);
		text.put("block4", block4);
		text.put("block1", block1);
		text.put("block3", block3);
		
		return text;
	}
	
	public static JSONObject sendManager () {
		JSONObject obj = new JSONObject();
		obj.put("status", "send_to_manager");
		return obj;
	}
}
