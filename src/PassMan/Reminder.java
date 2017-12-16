package PassMan;

import java.util.GregorianCalendar;
//import java.util.Date;
import java.text.SimpleDateFormat;

public class Reminder {
	
	private GregorianCalendar creation;
	private GregorianCalendar dueDate;
	private int type;
	private int amount;
	
	public Reminder(){
		creation = new GregorianCalendar();
		dueDate = creation;
		type = GregorianCalendar.DAY_OF_MONTH;
		amount = 1;
	}
	
//	This function will be used to initialize the due date
//	for the password update time
//	It will be called with the amount and type (as in years, months, days)
//	The GUI needs to have a dropdown list for the type options
//	The function will also set the amount and type global variables
//	to enable easier updates
	
	public void setDueDate(int amount, String type){ 
		this.amount = amount;
		if (type.equals("days")){
			this.type = GregorianCalendar.DAY_OF_MONTH;
		}
		else if (type.equals("months")){
			this.type = GregorianCalendar.MONTH;		}
		else if (type.equals("years")){
			this.type = GregorianCalendar.YEAR;
		}
		dueDate.add(this.type, amount);
	}
	/*
	 * This function will be used to update the due date with
	 * the previously used settings
	 * If the user chooses to update with different settings 
	 * the setDueDate function should be used
	 */
	public void update(){
		dueDate.add(type, amount);
	}
	/*
	 * This function will return the remaining time for the next 
	 * reminder in string format.
	 * The structure will be Y:M:D
	 */
	public String dispRemainingTime(){
		
		GregorianCalendar now = new GregorianCalendar();
		int year = now.get(GregorianCalendar.YEAR);
		int month = now.get(GregorianCalendar.MONTH);
		int day = now.get(GregorianCalendar.DAY_OF_MONTH);
		
		GregorianCalendar remaining = dueDate;
		remaining.add(GregorianCalendar.YEAR, -year);
		remaining.add(GregorianCalendar.MONTH, -month);
		remaining.add(GregorianCalendar.DAY_OF_MONTH, -day);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(remaining.getTime());
	}
	/*
	 * This function is used to detect wether the time is up for the reminder or 
	 * not
	 * This operation will be performed each time the corresponding profile
	 * is logged into
	 * Currently the function outputs true for any time before it's due 
	 * date with a precision of miliseconds. .
	 * 
	 */
	public boolean checkDue(){
		return dueDate.before(new GregorianCalendar());
	}
}