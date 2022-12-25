package com.raghu.ParkingLotSpring.utility;

import java.util.List;
import java.util.stream.Collectors;

public class UtilityFunctions {
	public static <T> List<T> getNewList(List<T> list) {
		return list.stream().collect(Collectors.toList());
	}
}
