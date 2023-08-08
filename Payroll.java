import javax.swing.JOptionPane;
public class Payroll {
   public static void main(String [] args) {
   //instantiate variables
      String name;
      String position;
      double payRate;
      double hoursWorked;
      double earnings;
      double totalPayroll = 0.0;
   
   //creating variable to allow user to enter another employee
      boolean stop = false;
      String stopInput;
      int count = 0;
   
   //user input
      do{
         try{
         //calling methods
            name = getName();
            position = getPosition();
            payRate = getPayRate();
            hoursWorked = getHoursWorked();
            earnings = setEarnings(hoursWorked, payRate);
            totalPayroll += earnings;
         //print report
            JOptionPane.showMessageDialog(null, "**Employee Info**" + "\n Employee Name: " + name + "\n Job Title: " + position + "\n Hourly Pay Rate: " + payRate + "\n Hours Worked: " + hoursWorked + "\n Earnings: $" + earnings);
            count++;
         //ask user if they want another patient
            stopInput = JOptionPane.showInputDialog(null, "Enter another patient? (Y/N): ");
            if(stopInput.equalsIgnoreCase("N")){
               stop = true;
               JOptionPane.showMessageDialog(null, "**Summary**" + "\n Total Number of Employees: " + count + "\n Total Payroll: $" + totalPayroll);
            }
         }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid User Input, Please Try Again");
         }
       
      }while(!stop);
   
   
   }
   //accessor methods
   public static String getName(){
      String employeeName;
        do {
            employeeName = JOptionPane.showInputDialog(null, "Enter Employee Name: ");
        } while (employeeName == null || employeeName.isEmpty());
        return employeeName;
   }
   public static String getPosition(){
      String employeePosition;
        do {
            employeePosition = JOptionPane.showInputDialog(null, "Enter Job Title: ");
        } while (employeePosition == null || employeePosition.isEmpty());
        return employeePosition;
   }
   public static double getPayRate(){
      double employeePay = 0.0;
        try {
            employeePay = (Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Hourly Pay Rate: ")));
        } catch (NumberFormatException e)
	{
	   JOptionPane.showMessageDialog(null, "Invalid Input, Please enter an number");
	}
        return employeePay;
   }
   public static double getHoursWorked(){
      double hours = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Hours Worked This Period: "));
      return hours;
   }
   
   //mutator methods
   public static double setEarnings(double hoursWorked, double pay){
      double wage = (hoursWorked * pay);
      return wage;
   }
   

   
   
   
   
}