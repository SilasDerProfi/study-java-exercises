package de.dhbwka.database.datawarehouse.lloyd;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
	private List<Point> points = new ArrayList<>();
	private Point center = new Point(0, 0);
	private boolean centerChanged;

	public void addPoint(Point point) {
		this.points.add(point);
	}

	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		if (center == null)
			throw new IllegalArgumentException("null is not a valid value for the center Point");

		centerChanged |= center.equals(this.center);
		this.center = center;
	}

	public boolean getCenterChanged() {
		return centerChanged;
	}

	public void clear() {
		centerChanged = false;
		points.clear();
	}

	public void updateCenter() {
		var x = points.stream().mapToDouble(Point::getX).average().getAsDouble();
		var y = points.stream().mapToDouble(Point::getY).average().getAsDouble();
		setCenter(new Point(x, y));
	}

	@Override
	public String toString() {
		return String.format("%s: %s", center, points);
	}
}
