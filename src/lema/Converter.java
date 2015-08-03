package lema.analizadorSemantico;

public class Converter
{     
    private static String check(String number)
    {
        return (number.contains("x"))?number.substring(2):number.substring(1);
    }
       
    private static double change(String number, int base)
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
    
    public static String hexToDouble(String number)
    {       
        return String.valueOf(change(check(number), 16));
    }
    
    public static String octToDouble(String number)
    {        
        return String.valueOf(change(check(number), 8));
    }
    
    public static String hexToInt(String number)
    {        
        return String.valueOf(Integer.parseInt(check(number),16));
    }
    
    public static String octToInt(String number)
    {        
        return String.valueOf(Integer.parseInt(check(number),8));
    }
}