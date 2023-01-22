public class Fraction{

    private double numerator, denominator;
    private boolean validFraction;

    public Fraction(){ // no arg constructor
       
    }

    private double GCD(double num, double den){ // euclid GCD algorithm method
        if(num == 0){
            return den;
        }

        return GCD(den%num, num);
    }


    private void validate(double num, double den){
        if(den == 0){

            validFraction = false;
        }

        else{
            validFraction = true;
        }
        
    }

    public boolean isValid(){
        return validFraction;
    }
       
    // constructor to split fractions from the file and store in seperate
    // variables in most simplified version
    public Fraction(String fraction){ 
        //System.out.println("here");
        
        if(fraction.isBlank()) 
        {
            validFraction = false;
            return;
        } 
        String [] parts = fraction.split("/");

        double tempNum = Double.parseDouble(parts[0]);
        double tempDen = Double.parseDouble(parts[1]);
        validate(tempNum,tempDen);
        if(!validFraction){
            return;
        }
        if(numerator < 0 || denominator < 0){
            validFraction = false;
            return;
        }

        double GCD = GCD(tempNum, tempDen);
        numerator = (double)tempNum/(double)GCD;
        denominator = (double)tempDen/(double)GCD;

       
    }

        
    // constructor to turn ints to doubles
    public Fraction(int num, int den){
        numerator = (double) num;
        denominator = (double) den;
    }

    // constructor 
    public Fraction(double num, double den){
        this.numerator = num;
        this.denominator = den;
    }

    boolean equals(Fraction other){
        if((this.numerator == other.numerator) && (this.denominator == other.denominator)){
            return true;
        }

        else{
            return false;
        }
    }

    public String toString(){
        return (int)numerator + "/" + (int)denominator;
    }

    double getNumerator(){
        return numerator;
    }

    double getDenominator(){
        return denominator;
    }

    void setFraction(int nN, int nD){
        numerator = nN;
        denominator = nD;
    }

    void setFraction(double xN, double xD){
        numerator = xN;
        denominator = xD;
    }

    



}