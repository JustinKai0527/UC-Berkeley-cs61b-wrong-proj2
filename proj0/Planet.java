// import java.lang.FdLibm.Pow;

public class Body {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    private static final double G = 6.67e-11;
    /*Constructor */
    public Body(double xP, double yP, double xV,double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }    

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    /*method */

    
    public double calcDistance(Body b){
        double delta_X = Math.abs(xxPos - b.xxPos);
        double delta_Y = Math.abs(yyPos - b.yyPos);
        double dis = Math.pow(delta_X,2) + Math.pow(delta_Y,2);
        dis = Math.sqrt(dis);
        return dis;
    }
    
    public double calcForceExertedBy(Body b){
        double F = (G * mass * b.mass) / Math.pow(calcDistance(b),2);
        return F;
    }

    public double calcForceExertedByX(Body b){
        double cos = (b.xxPos - xxPos) / calcDistance(b);
        return calcForceExertedBy(b) * cos;
    }

    public double calcForceExertedByY(Body b){
        double sin = (b.yyPos - yyPos) / calcDistance(b);
        return calcForceExertedBy(b) * sin;
    }

    public double calcNetForceExertedByX(Body[] b_arr){
        double Force_net = 0;
        int size = b_arr.length; 
        for(int i=0; i<size; i++){
            if(!equals(b_arr[i])){
                Force_net += calcForceExertedByX(b_arr[i]);
            }
        }
        return Force_net;
    }

    public double calcNetForceExertedByY(Body[] b_arr){
        double Force_net = 0;
        int size = b_arr.length; 
        for(int i=0; i<size; i++){
            if(!equals(b_arr[i])){
                Force_net += calcForceExertedByY(b_arr[i]);
            }
        }
        return Force_net;
    }

    public void update(double dt, double force_x, double force_y){
        double a_x = force_x/mass;
        double a_y = force_y/mass;
        xxVel += (a_x * dt);
        yyVel += (a_y * dt);
        xxPos += (xxVel * dt);
        yyPos += (yyVel * dt);

    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"/images/"+imgFileName);
    }
}


