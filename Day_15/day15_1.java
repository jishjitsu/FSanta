/*In today's fast-paced world, people often forget to pay their credit card bills on time. 
To help customers avoid late fees and maintain a good credit score, a bank wants to implement a Credit Card Bill Reminder System.
The system should send a reminder every 'k' days after the bill is generated, until the due date is reached.
If the bill is paid before the due date, reminders should stop immediately.

Your task is to design a system that, given the bill generation date, due date, and payment status, 
determines the dates on which reminders should be sent.


You are given the following inputs:

Bill Generation Date (B): The date when the bill is generated.
Due Date (D): The last date to pay the bill without a late fee.
K Days

The system should return a list of reminder dates that are spaced every k days from B until D.


Sample Test Case

case = 1
input = 2024-03-01
2024-03-10
2
output = 
CREDIT CARD REMINDER Sunday, March 3, 2024
CREDIT CARD REMINDER Tuesday, March 5, 2024
CREDIT CARD REMINDER Thursday, March 7, 2024
CREDIT CARD REMINDER Saturday, March 9, 2024

case = 2
input =2024-04-01
2024-04-09
2
output = 
CREDIT CARD REMINDER Wednesday, April 3, 2024
CREDIT CARD REMINDER Friday, April 5, 2024
CREDIT CARD REMINDER Sunday, April 7, 2024
CREDIT CARD REMINDER Tuesday, April 9, 2024

case = 3
input = 2024-05-01
2024-05-10
2
output =
CREDIT CARD REMINDER Friday, May 3, 2024
CREDIT CARD REMINDER Sunday, May 5, 2024
CREDIT CARD REMINDER Tuesday, May 7, 2024
CREDIT CARD REMINDER Thursday, May 9, 2024


case = 4
input = 2024-06-01
2024-06-07
2
output = 
CREDIT CARD REMINDER Monday, June 3, 2024
CREDIT CARD REMINDER Wednesday, June 5, 2024
CREDIT CARD REMINDER Friday, June 7, 2024 */

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class day15_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LocalDate B = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate D = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int k = sc.nextInt();
        for (LocalDate i = B.plusDays(k)); !i.isAfter(D); i = i.plusDays(k)){
            System.out.println("CREDIT CARD REMINDER " + i.getDayOfWeek().toString().substring(0, 1).toUpperCase() + i.getDayOfWeek().toString().substring(1).toLowerCase() + ", " +
                    i.getMonth().toString().substring(0, 1).toUpperCase() + i.getMonth().toString().substring(1).toLowerCase() + " " + i.getDayOfMonth() + ", " + i.getYear());
        }
    }
}