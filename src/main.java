import java.util.*;

public class main 
{
    public static void main (String args[])
    {
        do
        {   
            Scanner myKeyboard1 = new Scanner(System.in);
            int choixMenu; 

            do
            {
                System.out.println("Quel exercice souhaitez-vous traiter ?");
                System.out.println("1 - Opérations sur les complexes");
                System.out.println("2 - Les suites");
                System.out.println("3 - Fractales de Mandelbrot");
                System.out.println("4 - Quitter le programme");
                System.out.print("Faites votre choix : ");

                choixMenu = myKeyboard1.nextInt();
                myKeyboard1.nextLine();
            }
            while(choixMenu != 1 && choixMenu !=2 && choixMenu !=3 && choixMenu !=4);

            switch(choixMenu)
            {
                //******************************EXERCICE SUR LES COMPLEXES*********************************************************************
                case 1 :
                    Scanner myKeyboard = new Scanner(System.in);
                    String choixAffichage = new String();
                    do
                    {
                        System.out.print("\nQuel affichage souhaitez vous ? C (cartésien) P(polaire) ");
                        choixAffichage = myKeyboard.nextLine();
                    }
                    while(!choixAffichage.equals("C") && !choixAffichage.equals("c") && !choixAffichage.equals("P") && !choixAffichage.equals("p"));

                    if (choixAffichage.equals("C") || choixAffichage.equals("c"))
                    {
                        //Affichage complexe 1
                        Complex complex1 = new Complex();
                        System.out.println("\nentrez les coordonnées cartésiennes du 1er complexe:");
                        double tmp;
                        System.out.print("partie réelle :");
                        tmp = myKeyboard.nextDouble();
                        complex1.setComplex(tmp, 0);
                        System.out.print("partie imaginaire :");
                        tmp = myKeyboard.nextDouble();
                        complex1.setComplex(tmp, 1);
                        System.out.print("Votre nombre complexe est le suivant :" + complex1.getCart());

                        //Affichage complexe 2
                        Complex complex2 = new Complex();
                        System.out.println("\n\nentrez les coordonnées cartésiennes du 2ème complexe:");
                        System.out.print("partie réelle :");
                        tmp = myKeyboard.nextDouble();
                        complex2.setComplex(tmp, 0);
                        System.out.print("partie imaginaire :");
                        tmp = myKeyboard.nextDouble();
                        complex2.setComplex(tmp, 1);
                        System.out.print("Votre nombre complexe est le suivant :" + complex2.getCart());

                        complex1.convert(true);

                        System.out.print("\n\nOPERATION SUR LES COMPLEXES : ");
                        //Affichage addition
                        Complex somme = new Complex();
                        somme = complex1.add(complex2);
                        System.out.println("\nAddition : " + somme.getCart());

                        //Affichage soustraction
                        Complex soustraction = new Complex();
                        soustraction = complex1.sub(complex2);
                        System.out.println("Soustraction : " + soustraction.getCart());

                        //affichage multiplication
                        Complex multiplication = new Complex();
                        multiplication = complex1.mult(complex2);
                        System.out.println("Multiplication : " + multiplication.getCart());

                        //affichage division
                        Complex division = new Complex();
                        division = complex1.div(complex2);
                        System.out.println("division : " + division.getCart()+ "\n");
                    }
                    else
                    {
                        //Affichage complexe 1
                        Complex complex1 = new Complex();
                        System.out.println("\nentrez les coordonnées Polaires du 1er complexe:");
                        double tmp;
                        System.out.print("Module :");
                        tmp = myKeyboard.nextDouble();
                        complex1.setComplex(tmp, 2);
                        System.out.print("Argument :");
                        tmp = myKeyboard.nextDouble();
                        complex1.setComplex(tmp, 3);
                        System.out.print("Votre nombre complexe est le suivant :" + complex1.getPol());

                        //Affichage complexe 2
                        Complex complex2 = new Complex();
                        System.out.println("\n\nentrez les coordonnées polaires du 2ème complexe:");
                        System.out.print("module :");
                        tmp = myKeyboard.nextDouble();
                        complex2.setComplex(tmp, 2);
                        System.out.print("Argument :");
                        tmp = myKeyboard.nextDouble();
                        complex2.setComplex(tmp, 3);
                        System.out.println("Votre nombre complexe est le suivant :" + complex2.getPol());

                        complex1.convert(true);

                        System.out.print("\nOPERATION SUR LES COMPLEXES : ");
                        //Affichage addition
                        Complex somme = new Complex();
                        somme = complex1.add(complex2);
                        System.out.println("\nAddition : " + somme.getPol());

                        //Affichage soustraction
                        Complex soustraction = new Complex();
                        soustraction = complex1.sub(complex2);
                        System.out.println("Soustraction : " + soustraction.getPol());

                        //affichage multiplication
                        Complex multiplication = new Complex();
                        multiplication = complex1.mult(complex2);
                        System.out.println("Multiplication : " + multiplication.getPol());

                        //affichage division
                        Complex division = new Complex();
                        division = complex1.div(complex2);
                        System.out.println("division : " + division.getPol() + "\n");
                    }
                break;

                //******************************EXERCICE SUR LES SUITES*********************************************************************
                case 2 :
                    Suite suite = new Suite();
                    suite.suiteSomme();

                break;

                //******************************EXERCICE SUR LES FRACTALES DE MANDELBROT*********************************************************************
                case 3 :
                    Mandelbrot mandelbrot = new Mandelbrot();
                    System.out.print("\nVeuillez patienter.");
                    mandelbrot.graphique();
                break;

                //******************************QUITTER LE PROGRAMME*********************************************************************
                case 4:
                    System.exit(0);
                break;

                // SI UN AUTRE CARACTERE QUE CEUX DEMANDER EST ENTRÉ -> ALORS ON REBOUCLE
                default:
                    System.out.println("\nERREUR 404, NOT FOUND !!!" );
                break;
            }
        }
        while(true);
    }
}
