package com.company;

import java.util.Arrays;

/**
 * @author tdx
 */
public class Region {
    /**
     * Points that make up region
     * Condition: no point appears twice
     */
    private final Point[] points;

    public Region(Point[] points) {
        this.points = points;
    }

    /**
     * Check if a point is inside of region or not
     * @param p point to check
     * @return true if p is INSIDE region (including lying in region border), false otherwise
     */
    public boolean contains(Point p) {
        boolean result = false;

        for (int i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i].getLon() > p.getLon()) != (points[j].getLon() > p.getLon()) &&
                    (p.getLat() < (points[j].getLat() - points[i].getLat()) * (p.getLon() - points[i].getLon())
                            / (points[j].getLon() - points[i].getLon()) + points[i].getLat())) {
                result = !result;
            }
        }

        if (result) {
            return true;
        }

        for (int i = 0, j = points.length - 1; i < points.length; j = i++) {
            if (isBetween(p, points[i], points[j])) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if a point is in a segment
     * @param p point to check
     * @param start a head of segment
     * @param end another ehad of segment
     * @return true if p, start, end are linear and p is between start & end
     */
    static boolean isBetween(Point p, Point start, Point end) {
        double eps = 1e-10;
        Double crossProduct = (p.getLon() - start.getLon()) * (end.getLat() - start.getLat())
                - (p.getLat() - start.getLat()) * (end.getLon() - start.getLon());

        if (Math.abs(crossProduct) > eps) {
            return false;
        }

        return p.getLat() <= Math.max(start.getLat(), end.getLat()) && p .getLat() >= Math.min(start.getLat(), end.getLat())
                && p.getLon() <= Math.max(start.getLon(), end.getLon()) && p.getLon() >= Math.min(start.getLon(), end.getLon());
    }

    @Override
    public String toString() {
        return "Region{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
