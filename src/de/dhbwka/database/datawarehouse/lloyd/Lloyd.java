package de.dhbwka.database.datawarehouse.lloyd;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Lloyd {

    static final int K = 3;
    static final Path POINT_FILE_PATH = Paths.get("io/lloyd_points.csv");

    public static void main(String[] args) throws IOException {
        // read Points from the File
        List<Point> points = Arrays.stream(java.nio.file.Files.readString(POINT_FILE_PATH).split(";"))
                .map(pointString -> {
                    var pointData = pointString.split(",");
                    return new Point(Integer.parseInt(pointData[0]), Integer.parseInt(pointData[1]));
                }).collect(Collectors.toList());

        // init Cluster
        var cluster = IntStream.range(0, K).mapToObj(i -> new Cluster()).collect(Collectors.toList());
        for (int i = 0; i < cluster.size(); i++)
            cluster.get(i).setCenter(points.get(i));

        boolean anyClusterChanged;
        do {
            anyClusterChanged = false;

            // add all points to the cluster with the min center distance
            points.forEach(p -> cluster.stream()
                    .min((a, b) -> Double.compare(p.distanceTo(a.getCenter()), p.distanceTo(b.getCenter()))).get()
                    .addPoint(p));

            // recalculate the center cells and clear cluster
            for (var c : cluster) {
                c.updateCenter();
                anyClusterChanged |= c.getCenterChanged();
                System.out.println(c);
                c.clear();
            }

            System.out.println();

            // iterate until no cluster changed
        } while (anyClusterChanged);
    }
}
