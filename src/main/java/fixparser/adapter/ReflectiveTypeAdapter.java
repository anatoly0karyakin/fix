package fixparser.adapter;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import fixparser.FixTag;
import fixparser.stream.Writer;

public class ReflectiveTypeAdapter<T> implements Adapter<T> {
	private final Class<T> clazz;
	private Map<Integer, Field> fields = new HashMap<>();
	private static Map<String, Integer> fieldToTag = new HashMap<>();
	
	static {
		fieldToTag.put("BeginString", 8);
		fieldToTag.put("BodyLength", 9);
		fieldToTag.put("SenderCompID", 49);
		fieldToTag.put("TargetCompID", 56);
		fieldToTag.put("NoMDEntries", 268);
		fieldToTag.put("MsgSeqNum", 34);
		
		fieldToTag.put("Symbol", 55);
		
		fieldToTag.put("MDEntryType", 269);
		fieldToTag.put("MDEntryPx", 270);
		fieldToTag.put("MDEntrySize", 271);
		fieldToTag.put("MDEntryDate", 272);
		fieldToTag.put("MDEntryTime", 273);
		
		fieldToTag.put("mDReqID", 262);
	}

	public ReflectiveTypeAdapter(Class<T> clazz) {
		this.clazz = clazz;
		for(Field field: FieldUtils.getAllFieldsList(clazz)) {
			fields.put(fieldToTag.get(StringUtils.capitalize(field.getName())), field);
			field.setAccessible(true);
		}
	}
	
	@Override
	public T read(List<FixTag> tags) {
		T t;
		try {
			t = clazz.newInstance();
//			for(FixTag fixTag: tags) {
			for(int i = 0; i < tags.size(); ++i) {
				int tag = tags.get(i).getTag();
				Field field = fields.get(tag);
				String value = tags.get(i).getValue();
				if(field == null) continue;
				if(char.class == field.getType()) {
					field.setChar(t, value.charAt(0));
				} else if(String.class == field.getType()) {
					field.set(t, value);
				} else if(double.class == field.getType()) {
					field.set(t, Double.parseDouble(value));
				} else if (int.class == field.getType()) {
					field.setInt(t, Integer.parseInt(value));
				} else if(List.class.isAssignableFrom(field.getType())) {
					field.set(t, getListAdapter(field).read(tags.subList(i, tags.size())));
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return t;
	}
	
	private ListAdapter getListAdapter(Field field) {
		return new ListAdapter((ParameterizedType) field.getGenericType());
	}

	@Override
	public void write(Writer writer, T t) {
		// TODO Auto-generated method stub
		
	}
}
