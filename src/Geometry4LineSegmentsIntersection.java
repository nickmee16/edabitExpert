import java.awt.geom.Line2D;

public class Geometry4LineSegmentsIntersection {

    public static void main(String[] args) {
        int[][] arr = new int[4][2];
        arr[0][0] = 2;
        arr[0][1] = 4;
        arr[1][0] = 5;
        arr[1][1] = 1;
        arr[2][0] = 4;
        arr[2][1] = 1;
        arr[3][0] = 4;
        arr[3][1] = 4;
        System.out.println(intersection(arr));
    }

    public static boolean intersection(int[][] point) {
        Line2D line1 = new Line2D.Float(point[0][0], point[0][1], point[1][0], point[1][1]);
        Line2D line2 = new Line2D.Float(point[2][0], point[2][1], point[3][0], point[3][1]);

        return line2.intersectsLine(line1);
    }
}
