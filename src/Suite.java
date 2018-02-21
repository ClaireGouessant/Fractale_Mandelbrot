import java.util.*;

public class Suite
{    
    public void suiteSomme()
    {   
        Complex somme = new Complex(0,0,true);
        int k=0;
        Scanner myKeyboard = new Scanner(System.in);

        System.out.print("\nveuillez rentrer un nombre entier : ");
        int n = myKeyboard.nextInt();
        myKeyboard.nextLine();

        while(k < n)
        {
            Complex tmp = new Complex(1,2*k*Math.PI/n, false);
            System.out.println("Pour k = " + k + " / tmp = " + Math.round(tmp.getReel()) + " + i" + Math.round(tmp.getImg()));
            somme = tmp.add(somme);
            k++;
        }
        
        System.out.println("\nSomme finale : " + Math.round(somme.getReel()) + " + i" + Math.round(somme.getImg()) + "\n");
        
    }
    
}
