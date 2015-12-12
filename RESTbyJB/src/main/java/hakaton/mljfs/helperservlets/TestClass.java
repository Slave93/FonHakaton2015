package hakaton.mljfs.helperservlets;

import java.util.Arrays;

import hakaton.mljfs.messenger.dao.BuildingDao;

public class TestClass {
	public static void main(String[] args) {
		System.out.println(BuildingDao.containsAllFeatures(new String[]{"1","2","3","4","5"}, Arrays.asList(new Integer[]{1,2,4,5})));
	}
}
