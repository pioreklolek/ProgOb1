
public class Segment {

    private Point startPoint;
    private Point endPoint;

    public Segment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public double length() {
        return Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) + Math.pow(endPoint.y - startPoint.y, 2));

    }
    public  String toSvg(){
         return  "<line x1='" + startPoint.x + "' y1= '" + startPoint.y +"' x2= '" +  endPoint.x + "'  y2= '" + endPoint.y + "stroke=\"black\" />";
    }

    public static Segment[] perpendicularSegments(Segment segment, Point point) {
        double dx = (segment.startPoint.x - segment.endPoint.x);
        double dy = (segment.startPoint.y - segment.endPoint.y);

        double perpDx1 = -dy;
        double perpDy1 = dx;

        double perpDx2 = dy;
        double perpDy2 = -dx;

       Point endPoint   = new Point(point.x +perpDx1, point.y + perpDy1);
       Point endPoint2  = new Point(point.x +perpDx2, point.y + perpDy2);


        Segment segment1 = new Segment(point,endPoint);
        Segment segment2 = new Segment(point,endPoint2);

        return new Segment[]{segment1,segment2};
    }
}