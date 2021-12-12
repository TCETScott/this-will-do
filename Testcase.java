package testcase;
/**
 *
 * @author Terrence Scott
 */
import java.util.Scanner;
public class Testcase {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double ammoCount = 0;
	double ammoCurrent = 0;
	double ammoMax = 0;
	boolean magSelected; //Determines the magazine that has been selected.
	boolean validAmmoCount; //Makes sure a valid ammunition amount is given.
	Scanner keyIn = new Scanner(System.in);
		
	magSelected = false;
        validAmmoCount = false;
	while (!magSelected) {
            System.out.println("Set a maximum amount of ammunition this magazine can hold:");
            ammoMax = keyIn.nextDouble(); 
            if (ammoMax > 0) {
                magSelected = true;
            }
            else {
                System.out.println("Please enter a number greater than 0.");
            }
        }
        
        do {
            System.out.printf("Enter the number of bullets inserted or removed from the magazine (Current = %.0f, Max = %.0f):", ammoCurrent, ammoMax);
            ammoCount = keyIn.nextDouble();
            ammoCurrent = ammoCurrent + ammoCount;
            if (ammoCurrent > ammoMax) {
                System.out.println("The ammunition count is too high for this magazine."); //Makes sure the ammunition count doesn't go above the set maximum.
                ammoCurrent = ammoCurrent - ammoCount;
            }
            if (ammoCurrent < 0) {
                System.out.println("The ammunition count must be a positive integer."); //Makes sure the ammunition count doesn't go below 0.
                ammoCurrent = ammoCurrent - ammoCount;
            }
        } while (ammoCurrent < ammoMax && !validAmmoCount);
        if (ammoCurrent == ammoMax) {
            System.out.printf("There are %.0f bullets in the magazine. The magazine is now ready to be inserted.", ammoCurrent);
            validAmmoCount = true;
        }
        keyIn.close();	
    }
}
