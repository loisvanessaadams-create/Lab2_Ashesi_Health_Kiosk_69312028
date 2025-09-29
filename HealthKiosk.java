import java.util.Random;
import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
      System.out.println("Welcome to our Health Kiosk");
        
        double weightInKg;
        double heightInMeters;
        double BMI;
        double dosage;
        double angleInDegrees;
        double sine;
        double cosine;
        int tablets;
        int userOptions;
        double roundedBMI=0;
        double roundedMetric = 0;
        final int STANDARD_DOSAGE = 250;
   
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter a service code: ");
        char serviceCode = scanner.next().toUpperCase().charAt(0);

//TASK 1 - SERVICE ROUTER
        switch(serviceCode) {
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                System.out.println("Go to: Triage Desk"); 
                System.out.println("Option 1:BMI CALCULATOR");
                System.out.println("Option 2: DOSAGE ROUND-UP");
                System.out.println("Option 3:SIMPLE TRIG HELPER");
                System.out.println("Please pick one of the options above");
                userOptions = scanner.nextInt();
                

                switch (userOptions) {
                    case 1:
                    //OPTION A
                        System.out.println("BMI CALCULATIONS");
                        System.out.println("Please enter your Weight in Kg: ");
                        weightInKg = scanner.nextDouble();
                        //NB:once you declare it at the top as an int, double or string you dont have tot do it again in the scanner method
                        System.out.println("Please enter your height: ");
                        heightInMeters = scanner.nextDouble();
                        BMI = weightInKg / (heightInMeters * heightInMeters);
                        System.out.println("BMI:" + BMI);
                        roundedBMI = Math.round(BMI * 10)/ 10.0;
                        System.out.println(roundedBMI);
                        if (roundedBMI < 18.5){
                            System.out.println("Underweight");
                        } else if (roundedBMI >= 18.5 && roundedBMI <=24.9){
                            System.out.println("Normal");
                        }else if(roundedBMI >= 25.0 && roundedBMI <=29.9){
                            System.out.println("Overweight");
                        }else{
                            System.out.println("Obese");
                        }
                        break;
                    //OPTION B
                    case 2:
                        System.out.println("Please enter the required dosage in mg: ");
                        dosage = scanner.nextDouble();
                        tablets = (int)(Math.ceil(dosage/STANDARD_DOSAGE));
                        System.out.println("Number of Tablets Given: " + tablets);  
                        break;
                        //OPTION C
                    case 3:
                        System.out.println("Please enter the angle in degrees: ");
                        angleInDegrees = scanner.nextDouble();
                        sine = Math.sin(Math.toRadians(angleInDegrees));
                        cosine = Math.cos(Math.toRadians(angleInDegrees));
                        double sineRounded = Math.round(sine*1000)/1000.0;
                        double cosineRounded = Math.round(cosine * 1000)/1000.0;
                        System.out.println("sine = " + sineRounded + " and cos = " + cosineRounded); 
                        roundedMetric = (int)Math.round(sine*100);
                        System.out.println("Rounded Metric: " + roundedMetric);                            
                }       break; 
                
            case 'C':
                System.out.println("Go to: Counselling Desk");
                break;
            
            default:
                System.out.println("Invalid Service Code");
        }

       //TASK3 - ID SANITY CHECK
        char randomChar = (char)(rand.nextInt(26)+'A');
        System.out.println("Generated Random Character: " + randomChar);
        
        //Generating char between '3' and '9'
        int r1 = (int)(Math.random()*7)+3;
        int r2 = (int)(Math.random()*7)+3;
        int r3 = (int)(Math.random()*7)+3;
        int r4 = (int)(Math.random()*7)+3;

        String shortCode = "" + randomChar + r1 +r2 + r3 + r4;
        System.out.println("Short Code: " + shortCode);

        if (shortCode.length() != 5) {
            System.out.println("Invalid length.");
        } else if (!Character.isLetter(shortCode.charAt(0))) {
            System.out.println("Invalid: first char must be a letter.");
        } else if (!Character.isDigit(shortCode.charAt(1)) ||!Character.isDigit(shortCode.charAt(2)) ||!Character.isDigit(shortCode.charAt(3)) ||!Character.isDigit(shortCode.charAt(4))) {
            System.out.println("Invalid: last 4 must be digits.");
        } else {
            System.out.println("ID OK");
        }

        //TASK 4 ("SECURE" DISPLAY CODE)
        System.out.println("Please enter your name: ");
        String name = scanner.next().toUpperCase();
        char base;
        if(name.length() > 0){
            base = name.charAt(0);
            System.out.println("The first letter of the name is " + base);
        }else{
            System.out.println("You didn't enter a name!");
            base = ' ';
        }

        char Letterforwarded = (char)('A' + (base - 'A' + 2) % 26);
        System.out.println("Letter 2 steps ahead: " + Letterforwarded);
        String lastTwo = shortCode.substring(shortCode.length()-2);
        String secureCode = Letterforwarded + lastTwo;
        System.out.println("Secure Code: " + secureCode);         
        String finalCode = secureCode + "-" + roundedMetric;
        System.out.println("Display Code: " + finalCode);
            
        //TASK 5
        if (serviceCode == 'T'){
            System.out.println("Summary: TRIAGE | ID = " + shortCode + "| BMI = " + roundedBMI + " | Code = " + finalCode);
        }
        if (serviceCode == 'P'){
            System.out.println("Summary: PHARMACY | ID = " + shortCode + "| BMI = " + roundedBMI + " | Code = " + finalCode);
        }
        if (serviceCode == 'L'){
            System.out.println("Summary: LAB | ID = " + shortCode + "| BMI = " + roundedBMI + " | Code = " + finalCode);
        }
        if (serviceCode == 'C'){
            System.out.println("Summary: COUNSELLING | ID = " + shortCode + "| BMI = " + roundedBMI + " | Code = " + finalCode);
        }
    }
}




 
        
        
    
        
            
           
    
    





