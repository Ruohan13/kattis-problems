import java.lang.Math;
import java.util.Scanner;

public class halfacookie {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double r, x, y, h, area_big, area_small, angle, area_tria, area_cookie;

        while(input.hasNext()){
            r = input.nextDouble();
            x = input.nextDouble();
            y = input.nextDouble();

            // cut through the line l that is perpendicular to the line that passes the origin and (x, y)
            // 1. find the distance from origin to l: h = sqrt(x^2 + y^2)
            //    if h > r, miss
            // 2. find angle = acos(h/r)
            // 3. find area of triangle = r * sin(angle) * h
            // 4. find area of the cookie = PI * r^2
            // 5. find area of the bigger half = (2PI - 2*angle)/(2PI) * area_cookie + area_triangle
            // 6. find area of the smaller half = area_cookie - area_big

            h = Math.hypot(x, y);
            if(h > r) {
                System.out.println("miss");
                continue;
            }

            angle = Math.acos(h/r);
            area_tria = r * Math.sin(angle) * h;
            area_cookie = Math.PI * Math.pow(r, (double)2);
            area_big = (2 * Math.PI - 2 * angle) / (2 * Math.PI) * area_cookie + area_tria;
            area_small = area_cookie - area_big;

            System.out.printf("%.6f %.6f\n", area_big, area_small);
        }
    }
}
