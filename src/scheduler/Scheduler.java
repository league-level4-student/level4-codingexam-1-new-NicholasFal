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
	static String describe;
	static String time;
	static String day;
    public static void main(String[] args) throws SchedulingConflictException {
    	Days[] daysWeek = Event.Days.values();
    	LinkedList<Event> events = new LinkedList<Event>();
    	while(true) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Would you like to add an event, view events, or remove an event? (add, view, remove)");
		
    	String choice = scan.next();
    	if(choice.equalsIgnoreCase("add")) {
    		addEvent();
    		validSlot(events, Integer.parseInt(time), Days.valueOf(day.toUpperCase()));
    		events.add(new Event(describe, Integer.parseInt(time), Days.valueOf(day.toUpperCase())));
        	System.out.println("After: " + events.size());

    	} else if(choice.equalsIgnoreCase("view")) {
    		viewEvent(events);
    	} else if(choice.equalsIgnoreCase("remove")) {
    		removeEvent();
    		removeEventsTwo(events, describe, Integer.parseInt(time), Days.valueOf(day.toUpperCase()));
    	} else {
    		System.out.println("Answer cannot be computed");
    	}
    }
    }
    public static void addEvent() {
    	System.out.println("What event would you like to add?");
    	Scanner scan = new Scanner(System.in);
    	describe = scan.next();
    	System.out.println("What time would you like to add the event? (hour 0 - 23)");
    	Scanner scanTwo = new Scanner(System.in);
    	time = scanTwo.next();
    	System.out.println("What day would you like to add the event?");
    	Scanner scanThree = new Scanner(System.in);
    	day = scanThree.next();
    	
    }
    public static void viewEvent(LinkedList events) {
    	Node current = events.getHead();
    	Node index;
    	while(current != null) {
    		index = current.getNext();
    		while(index != null) {
    		Event currentE = (Event) current.getValue();
    		Event indexE = (Event) index.getValue();
    		if(currentE.getTime() > indexE.getTime()) {
    			int temp = currentE.getTime();
    			currentE.time = indexE.time;
    			indexE.time = temp;
    			
    			Days tempD = currentE.getDay();
    			currentE.day = indexE.day;
    			indexE.day = tempD;
    			
    			String tempD2 = currentE.getDescriber();
    			currentE.describer = indexE.describer;
    			indexE.describer = tempD2;
    		}
    		index = index.getNext();
    		}
        	current = current.getNext();
    	}
    	LinkedList<Event> newEvents = new LinkedList<Event>();
    	newEvents = events;
		Node head = newEvents.getHead();
    	for(int i = 0; i < events.size(); i++) {
    		Event headE = (Event) head.getValue();
    		System.out.println("Event: " + headE.getDescriber() + "  Time: " + headE.getTime() + "  Day: " + headE.getDay());
    		head = head.getNext();
    	}
    }
    public static void removeEvent() {
    	System.out.println("What event would you like to delete?");
    	Scanner scan = new Scanner(System.in);
    	describe = scan.next();
    	System.out.println("What time was this event? (hour 0 - 23)");
    	Scanner scanTwo = new Scanner(System.in);
    	time = scanTwo.next();
    	System.out.println("What day was this event?");
    	Scanner scanThree = new Scanner(System.in);
    	day = scanThree.next();
    	
    }
    private static void validSlot(LinkedList events, Integer time, Days day) throws SchedulingConflictException {
    	LinkedList<Event> newEvents = events;
    	Node head =  events.getHead();
    	while(head != null) {
    		Event headE = (Event) head.getValue();
    		if(headE.getDay() == day && headE.getTime() == time) {
    			throw new SchedulingConflictException("You tried to book a double time slot!");
    		}
    		
    		head = head.getNext();
    	}
    		
    	
		events = newEvents;
    }
    private static void removeEventsTwo(LinkedList events, String describer, Integer time, Days day) {
    	Node head = events.getHead();
    	Boolean found = false;
    	for(int i = 0; i < events.size(); i++) {
        	Event headE = (Event) head.getValue();
    		if(headE.getDay() == day && headE.getTime() == time && headE.getDescriber().equalsIgnoreCase(describer)) {
    		events.remove(i);
    		found = true;
    		} 
    		head = head.getNext();
    	}
    	if(!found) {
    		System.out.println("Event cannot be found");
    	}
    }
}
