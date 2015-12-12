package hakaton.mljfs.helperservlets;

import java.util.Arrays;
import java.util.List;

import hakaton.mljfs.messenger.dao.BuildingDao;
import hakaton.mljfs.messenger.dao.ProfileDao;
import hakaton.mljfs.messenger.model.Building;
import hakaton.mljfs.messenger.model.Profile;

public class TestClass {
	public static void main(String[] args) {
		System.out.println(BuildingDao.containsAllFeatures(new String[]{"1","2","3","4","5"}, Arrays.asList(new Integer[]{1,2,4,5})));
		Building b = BuildingDao.getBuilding(2);
		System.out.println(b.getDescription());
		List<Profile> lp = ProfileDao.getAllProfiles();
		for (int i = 0; i < lp.size(); i++) {
			Profile p = lp.get(i);
			System.out.println(p.getCity());
			System.out.println(p.getEmail());
			System.out.println(p.getEmail());
			System.out.println(p.getId());
			System.out.println(p.getPassword());
			System.out.println(p.getPhone());
			System.out.println(p.getState());
		}
			
	}
}
