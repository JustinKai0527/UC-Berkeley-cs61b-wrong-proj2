
public class NBody{
    public static double readRadius(String planet){

        In in = new In(planet);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readBodies(String planet){
        In in = new In(planet);
        int numbers = in.readInt();
        Planet[] b_arr = new Planet[numbers];
        in.readDouble();

        for(int i=0; i<numbers; i++){
            b_arr[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),in.readDouble() , in.readString());
        }
        
        return b_arr;
    }

    public static void main(String[] args){

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] bodies = readBodies(filename);
        
        // Drawing the Background
        String imageToDraw = "images/starfield.jpg";
        
        /** Sets up the universe so it goes from 
             * -100, -100 up to 100, 100 */
        StdDraw.setScale(-radius, radius);


        /* Shows the drawing to the screen, and waits 2000 milliseconds. */

        StdDraw.enableDoubleBuffering();


        /*Creating an Animation */

        for(int time=0; time<=T; time+=dt){
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];

            for(int i=0; i<bodies.length; i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for(int i=0; i<bodies.length; i++){
                bodies[i].update(dt,xForces[i],yForces[i]);
            }

            /* Clears the drawing window. */
            StdDraw.clear();
            /*Draw Start */
            StdDraw.picture(0, 0, imageToDraw);
            for(int i=0; i<bodies.length; i++){
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(1);	
        }

        /*print final state */
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                        bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
    }
}
