package fixparser.adapter;

import java.util.List;

import fixparser.FixTag;
import fixparser.stream.Writer;

public interface Adapter<T> {
	
	T read(List<FixTag> tags);
	void write(Writer writer, T t);
}
