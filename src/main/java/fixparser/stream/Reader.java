package fixparser.stream;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import fixparser.FixTag;

public class Reader {
//	private List<Integer> tags = new ArrayList<>();
//	private List<String> values = new ArrayList<>();
	private String str;
	
	public Reader(String str) {
		this.str = str;
	}
	
	public List<FixTag> tags() {
		List<FixTag> tags = new ArrayList<>();
		int tag;
		while ((tag = parseTag()) != -1) {
			tags.add(new FixTag(tag, parseValue()));
		}
		return tags;
	}
	
//	public Reader(List<Integer> tags, List<String> values) {
//		this.tags = tags;
//		this.values = values;
//	}
//	
//	public Reader subReader(int start, int end) {
//		return new Reader(tags.subList(start, end), values.subList(start, end));
//	}
//	
//	public int tag() {
//		return tags.get(i);
//	}
//	
//	public boolean next() {
//		i++;
//		return i < tags.size();
//	}
//	
//	public void back() {
//		i--;
//	}
//	
//	public String value() {
//		return values.get(i);
//	}
//	
//	public int findTag(int tag) {
//		for(int j = i; j < tags.size(); ++i) {
//			if(tags.get(j) == tag) {
//				return j;
//			}
//		}
//		return -1;
//	}
	
	private int parseTag() {
		String tagStr = StringUtils.substringBefore(str, "=");
		str = StringUtils.substringAfter(str, "=");
		if("".equals(str)) return -1;
		return Integer.parseInt(tagStr);
	}
	
	private String parseValue() {
		String tagStr = StringUtils.substringBefore(str, "|");
		str = StringUtils.substringAfter(str, "|");
		return tagStr;
	}	
}
