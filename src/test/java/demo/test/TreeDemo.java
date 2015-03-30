package demo.test;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import demo.domain.User;

public class TreeDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add(0, "3333");
		list.add(0, "22222");
		list.add(0, "11111");
		System.out.println(list);
	}
}
