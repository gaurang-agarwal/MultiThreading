package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinumumPlatform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arrivalList = Arrays.asList(1668,1535,101,2370,1325,1879,559,563,465,906,1746,1682,28,362,492,596,2343,28,637,1192,205,1503,154,293,383,622,1917,519,696,648,127,372,1939,1870,713,1668,2300,236,295,2304,2212,123);
		List<Integer> departureList = Arrays.asList(1534,874,2265,742,512,1854,2069,1548,1245,1463,1558,838,860,1524,142,1130,779,317,636,591,1843,289,1307,1841,1743,65,1049,1047,2206,1491,1930,371,951,607,2302,394,1149,430,624,85,755,1957);
		List<Integer> station = new ArrayList<>();
		Collections.sort(arrivalList);
		Collections.sort(departureList);
		station.add(departureList.get(0));
		int maxPlatformNeeded =1;
		for(int i=1;i<arrivalList.size();i++)
		{
			System.out.println(station);
			for(int j=0;j<station.size();j++)
			{
				if(station.get(j)<arrivalList.get(i))
					station.remove(j);
			}
			
			station.add(departureList.get(i));
			
			if(station.size()>maxPlatformNeeded)
				maxPlatformNeeded=station.size();
		}
		System.out.println(maxPlatformNeeded);
		
	}
	
	

}
