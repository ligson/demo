package org.ligson.designmode.creation.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhongbing 建造者模式
 */
public class Farm5 {
	private List<Animal> list = new ArrayList<Animal>();

	public void producePig(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new Pig());
		}
	}

	public void produceChicken(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new Chicken());
		}
	}

	public void produceCattle(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new Cattle());
		}
	}

	public void produceSheep(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new Sheep());
		}
	}
	
	public int sum() {
		int money = 0;
		for(Animal animal:list) {
			money += animal.sale();
		}
		return money;
	}
}
