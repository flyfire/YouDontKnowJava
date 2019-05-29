package com.solarexsoft.test.testprotected.threepoints;

import com.solarexsoft.test.testprotected.points.Point;

/**
 * Created by houruhou on 2019/5/29.
 * Desc: https://docs.oracle.com/javase/specs/jls/se7/html/jls-6.html jls 6.6.2
 */
public class Point3d {
    protected int z;
    public void delta(Point point) {
        point.x += this.x; // compile-time error: cannot resolve symbol 'x'
        point.y += this.y; // compile-time error: cannot resolve symbol 'y'
    }

    public void delta3d(Point3d q) {
        q.x += this.x; // compile-time error: cannot resolve symbol 'x'
        q.y += this.y; // compile-time error: cannot resolve symbol 'y'
        q.z += this.z;
    }
}
