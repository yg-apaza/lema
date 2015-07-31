package lema;

public class Converter
{
    private String number;
    
    public Converter(String number)
    {
        check(number);
    }
    
    private void check(String number)
    {
        this.number = (number.contains("x"))?number.substring(2):number.substring(1);
    }
    
    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        check(number);
    }
    
    private double change(int base)
    {
        double value = 0.0;
        int point = (number.contains("."))?number.indexOf("."):number.length();
        
        for(int i = 0;i < point;i++)
        {
            if(number.charAt(i) >= 65 && number.charAt(i) <= 70)
                value = value + (number.charAt(i)-55)*Math.pow(base, point-i-1);
            else
                value = value + (number.charAt(i)-48)*Math.pow(base, point-i-1);
        }
        
        for(int i = point+1;i < number.length();i++)
        {
            if(number.charAt(i) >= 65 && number.charAt(i) <= 70)
                value = value + (number.charAt(i)-55)*Math.pow(base, point-i);
            else
                value = value + (number.charAt(i)-48)*Math.pow(base, point-i);
        }
        
        return value;
    }
    
    public double hexToDouble() throws Exception
    {
        double value = change(16);
        if(value > 32767.9999)
            throw new Exception("Valor Fuera de Rango");
        
        return value;
    }
    
    public double octToDouble() throws Exception
    {
        double value = change(8);
        if(value > 32767.9999)
            throw new Exception("Valor Fuera de Rango");
        
        return value;
    }
    
    public int hexToInt() throws Exception
    {
        int value = (int) change(16);
        if(value > 32767)
            throw new Exception("Valor Fuera de Rango");
        
        return value;
    }
    
    public int octToInt() throws Exception
    {
        int value = (int) change(8);
        if(value > 32767)
            throw new Exception("Valor Fuera de Rango");
        
        return value;
    }
}
