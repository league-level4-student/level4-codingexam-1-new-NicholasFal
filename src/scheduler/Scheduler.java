package scheduler;

import java.util.Scanner;

import scheduler.Event.Days;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event.
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables.
 */
public class Scheduler {

    public static void main(String[] args) {
    	Days[] daysWeek = Event.Days.values();
    	LinkedList<Event> events = new LinkedList<Event>();
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Would you like to add an event, view events, or remove an event? (add, view, remove)");
    	String choice = scan.next();
    	if(choice.equalsIgnoreCase("add")) {
    		
    	} else if(choice.equalsIgnoreCase("view")) {
    		
    	} else if(choice.equalsIgnoreCase("remove")) {
    		
    	}
    }
    public static void addEvent() {
    	System.out.println("What event would you like to add?");
    	Scanner scan = new Scanner(System.in);
    	String describe = scan.next();
    	System.out.println("What time would you like to add the event? (hour 0 - 23)");
    }
    public static void viewEvent() {
    	
    }
    public static void removeEvent() {
    	
    }
}
