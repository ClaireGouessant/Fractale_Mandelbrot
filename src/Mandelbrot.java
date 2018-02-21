import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.Scanner;
//import java.awt.image.*;

public class Mandelbrot 
{
    public void graphique()
    {
        double x1, x2, y1, y2;
        Scanner myKeyboard1 = new Scanner(System.in);
        int choixMenu; 
        do
        {
            System.out.println("Quel dymensions voulez-vous ?");
            System.out.println("1 - x: -2.1 - 0.6 / y: -1.2 - 1.2");
            System.out.println("2 - x: -1.8 - -1.725 / y: -0.025 - 0.025");
            System.out.println("3 - x: -0.7 - -0.6 / y: -0.5 - -0.4");
            System.out.println("4 - x: -0.8 - -0.1 / y: 0.2 - 0.8");
            System.out.print("Faites votre choix : ");
            
            choixMenu = myKeyboard1.nextInt();
            myKeyboard1.nextLine();
        }while(choixMenu != 1 && choixMenu !=2 && choixMenu !=3 && choixMenu !=4);
        
        x1 = -2.1;
        x2 = 0.1;
        y1 = -1.2;
        y2 = 0.0;
        
        if(choixMenu == 1)
        {
            x1 = -2.1;
            x2 = 0.6;
            y1 = -1.2;
            y2 = 1.2;
        }
        if(choixMenu == 2)
        {
            x1 = -1.8;
            x2 = -1.725;
            y1 = -0.025;
            y2 = 0.025; 
        }
        if(choixMenu == 3)
        {
            x1 = -0.7;
            x2 = -0.6;
            y1 = -0.5;
            y2 = -0.4; 
        }
        if(choixMenu == 4)
        {
            x1 = -0.8;
            x2 = -0.1;
            y1 = 0.2;
            y2 = 0.8; 
        }
        ensemble(x1, x2, y1, y2);
    }
    
    public void ensemble(Double x1, double x2, double y1, double y2)
    {        
        int iteration_max = 76;
        int taillex = 2700;
        int tailley = 2400;
        double zoomx = (x2-x1)/taillex;
        double zoomy = (y2-y1)/tailley;
        BufferedImage image = new BufferedImage(taillex, tailley, BufferedImage.TYPE_INT_RGB);
        int i, x, y;
        try
        {
            for(x=0; x<=taillex; x++)
            {
                for(y=0; y<=tailley; y++)
                {
                    Complex Z = new Complex(0, 0, true);
                    i = 0;
                    Complex C = new Complex(((x*(x2-x1))/taillex) + x1, ((y*(y2-y1))/tailley) + y1, true);
                    while(Z.getMod()<2 && i<iteration_max)
                    {
                        //Z = C.add(Z.multcard(Z));                        
                        /*Complex tmp = new Complex();
                        tmp.setComplex(Z.getArg()+Z.getArg(), 3);
                        tmp.setComplex(Z.getMod()*Z.getMod(), 2);
                        tmp = C.add(tmp);
                        Z = tmp;*/
                        /*Z.setComplex((Z.getReel()*Z.getReel())-(Z.getImg()*Z.getImg()) + (C.getReel()), 0);
                        Z.setComplex((2*Z.getReel()*Z.getImg())+C.getImg(), 1);*/
                        //Z = C.add(Z.mult(Z));
                        Z.Carre();
                        Z.Addition(Z, C);
                        Z.convert(true);
                        i++;
                    }
                    
                    if(i>2)//==iteration_max)
                    {
                        Color color = new Color(255, 0, 0);
                        if(x>=0 && x<taillex && y>=0 && y<tailley)
                        {
                        image.setRGB(x, y, color.getRGB());
                        }
                    }
                    
                    if(i>5)//==iteration_max)
                    {
                        Color color = new Color(255, 50, 0);
                        if(x>=0 && x<taillex && y>=0 && y<tailley)
                        {
                        image.setRGB(x, y, color.getRGB());
                        }
                    }
                    
                    if(i>10)//==iteration_max)
                    {
                        Color color = new Color(255, 100, 0);
                        if(x>=0 && x<taillex && y>=0 && y<tailley)
                        {
                        image.setRGB(x, y, color.getRGB());
                        }
                    }
                    
                    if(i>25)//==iteration_max)
                    {
                        Color color = new Color(255, 150, 0);
                        if(x>=0 && x<taillex && y>=0 && y<tailley)
                        {
                        image.setRGB(x, y, color.getRGB());
                        }
                    }
                    
                    if(i>50)//==iteration_max)
                    {
                        Color color = new Color(255, 200, 0);
                        if(x>=0 && x<taillex && y>=0 && y<tailley)
                        {
                        image.setRGB(x, y, color.getRGB());
                        }
                    }
                    
                    if(i>75)//==iteration_max)
                    {
                        Color color = new Color(255, 255, 0);
                        if(x>=0 && x<taillex && y>=0 && y<tailley)
                        {
                        image.setRGB(x, y, color.getRGB());
                        }
                    }
                }
            }
        
            File f = new File("MandelbrotZoom.png");

            if (!ImageIO.write(image, "PNG", f)) 
            {
            throw new RuntimeException("Unexpected error writing image");
            }
        }
        catch(IOException e)
        {
             throw new RuntimeException("Unexpected error writing image 2");    
        }
    System.out.println("MandelbrotZoom.png créé");
    }

}