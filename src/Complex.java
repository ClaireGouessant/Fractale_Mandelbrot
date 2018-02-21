public class Complex 
{
    private double reel;
    private double img;
    private double mod;
    private double arg;
    
    Complex()
    {
        reel = 0.0;
        img = 0.0;
        mod = 0.0;
        arg = 0.0;
    }

    Complex(double x, double y, boolean b)
    {
        if(b)
        {
            reel = x;
            img = y;
            convert(b);
        }
        else
        { 
            mod = x;
            arg = y;
            convert(b);
        }
    }

    void convert(boolean b)
    {
        if(b)
        {
            mod = Math.sqrt(reel*reel+img*img);
            if(reel != 0)
                arg = Math.tan(img/reel);
            else if (img == 0)
                arg = 0.0;
            else if(img < 0)
                arg = -Math.PI/2;
            else
                arg = Math.PI/2;
        }
        else
        {
            reel = mod*Math.cos(arg);
            img = mod*Math.sin(arg);
        }
    }
    
    public void setComplex(double x, int y)
    {
        if(y == 0)
        {
            reel = x;
            convert(true);
        }
        else if(y == 1)
        { 
            img = x;
            convert(true);
        }
        else if(y == 2)
        {
            mod = x;
            convert(false);
        }
        else if(y == 3)
        {
            arg = x;
            convert(false);
        }
        else System.out.println("Erreur : y<0 ou y>3");
    }
 
    public double getReel()
    {
        return reel;
    }
    
    public double getImg()
    {
        return img;
    }
    
    public double getMod()
    {
        return mod;
    }
    
    public double getArg()
    {
        return arg;
    }
    
    public String getCart()
    {
        if(getImg() < 0) 
        {
            return getReel() + " - " + -1*getImg() + " i";
        }
        else
        {
            return getReel() + " + " + getImg() + " i";
        }
    }
    
    public String getPol()
    {
            return getMod() + " e^(" + getArg() + "*i)";
    }
    
    public Complex add(Complex a)
    {
        double sommeReel = this.reel + a.reel;
        double sommeImg = this.img + a.img;
        Complex somme = new Complex(sommeReel, sommeImg, true);
        return somme;
    }
    
    public void Addition (Complex a, Complex b)
    {
        reel = a.reel + b.reel;
        img = a.img + b.img;
        convert(true);
    }
    
    public Complex sub(Complex a)
    {
        double sousReel = this.reel - a.reel;
        double sousImg = this.img - a.img;
        Complex soustraction = new Complex(sousReel, sousImg, true);
        return soustraction;
    }
    
    public Complex mult(Complex a)
    {
        double multMod = this.mod * a.mod;
        double multArg = this.arg + a.arg;
        Complex multiplication = new Complex(multMod, multArg, false);
        return multiplication;
    }
    
    public Complex div(Complex a)
    {
        double multMod = this.mod / a.mod;
        double multArg = this.arg - a.arg;
        Complex division = new Complex(multMod, multArg, false);
        return division;
    }
    
    public void Carre()
    {
        double r = reel;
        double i = img;
        reel = (r*r) - (i*i);
        img = (i*r) + (r*i);
    }
}


