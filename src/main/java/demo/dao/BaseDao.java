package demo.dao;

import java.util.List;

public interface BaseDao<T> {
	public String add(T t);
	public void saveOrUpdate(T t);

	public void delete(T t);

	public void update(T t);

	public void updateProperty(String property, String propertyValue, String id);

	public T getById(String id);

	public T findBy(String propertyName, Object propertyValue);

	public T findByAnd(List<String> propertyNames, List<Object> propertyValues);

	public List<T> findAllBy(String propertyName, Object propertyValue);

	public List<T> findAllBy(String propertyName, Object propertyValue,
			String orderProperty);

	public List<T> findAllBy(String propertyName, Object propertyValue,
			int offset, int max);

	public List<T> findAllBy(String propertyName, Object propertyValue,
			int offset, int max, String orderProperty);

	public long countBy(String propertyName, Object propertyValue);

	public boolean propertyIsUnique(String property, Object propertyValue);
}
