package fixparser.adapter;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import fixparser.FixTag;
import fixparser.stream.Reader;
import fixparser.stream.Writer;

public class ListAdapter<TT> implements Adapter<List<TT>> {
	
	private final Class<TT> clazz;
	
	public ListAdapter(ParameterizedType type) {
		clazz = (Class<TT>) type.getActualTypeArguments()[0]; 
	}

	@Override
	public List<TT> read(List<FixTag> tags) {
		int size = Integer.parseInt(tags.get(0).getValue());
		List<TT> list = new ArrayList<>(size);
		Adapter<TT> adapter = getAdapter();
		int startTag = tags.get(1).getTag();
		int j = 1;
		for(int i = 0; i < size; ++i) {
			List<FixTag> group = tags.subList(j, findNext(startTag, tags, j + 1));
			list.add(adapter.read(group));
			j += group.size();
		}
		return list;
	}
	
	private int findNext(int tag, List<FixTag> tags, int currentIndex) {
		for(int i = currentIndex; i < tags.size(); ++i) {
			if(tags.get(i).getTag() == tag) {
				return i;
			}
		}
		return tags.size();
	}
	
	private ReflectiveTypeAdapter<TT> getAdapter() {
		return new ReflectiveTypeAdapter<>(clazz);
	}

	@Override
	public void write(Writer writer, List<TT> t) {
		// TODO Auto-generated method stub
		
	}

}
