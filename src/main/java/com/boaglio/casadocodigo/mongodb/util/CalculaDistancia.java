package com.boaglio.casadocodigo.mongodb.util;

/*
 * Fonte original (rotina modificada)
 * http://www.geodatasource.com
 */
public class CalculaDistancia {

	public static final Double KILOMETER = 111.0d;

	public static double distance(double lon1,double lat1,double lon2,double lat2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		return dist;
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double deg2rad(double deg) {
		return deg * Math.PI / 180.0;
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double rad2deg(double rad) {
		return rad * 180 / Math.PI;
	}

	public static Double getInKilometer(Double maxdistance) {
		return maxdistance / KILOMETER;
	}

}
