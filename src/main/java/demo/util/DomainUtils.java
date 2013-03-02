package demo.util;

import java.lang.reflect.Field;

public class DomainUtils {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Class class1 = this.getClass();
		Field[] fields = class1.getFields();
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for(Field field:fields){
			try {
				sb.append(field.getName()+":"+field.get(this));
			} catch (Exception e) {
				sb.append(field.getName()+":null");
			}
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
}
