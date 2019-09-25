package com.solarexsoft.test.testprotected.points;

import com.solarexsoft.test.testprotected.threepoints.Point3d;

/**
 * Created by houruhou on 2019/5/29.
 * Desc:https://docs.oracle.com/javase/specs/jls/se7/html/jls-6.html jls 6.6.2
 */
public class Point {
    protected int x, y;
    void wrap(Point3d point3d) {
        /*
        if (point3d.z > 0) { // z has protected access in threepoints.Point3d
            point3d.delta(this);
        }
        */
    }
}
