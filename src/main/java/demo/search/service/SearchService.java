package demo.search.service;

import java.util.Map;

public interface SearchService {
	public Map<String, Object> searchByTitleOrContent(String key, int offset,
			int max, String sort, boolean isAsc);
}
