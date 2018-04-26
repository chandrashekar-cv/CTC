package schedulingAlgorithms;
import java.util.*;
import java.text.SimpleDateFormat;

class CalendarEvent
{
    private Date start, end; 

    public CalendarEvent(Date start, Date end)
    {
        this.start = start;
        this.end = end;
    }

    public Date getStart()
    {
	    return this.start;
    }

    public Date getEnd()
    {
	    return this.end;
    }
    
    public void setEnd(Date end) {
    	this.end = end;
    }
}

public class TotalMeetingDuration_Overlapping_Intervals
{
    public static int CalculateTotalTimeInMeetings(Collection<CalendarEvent> events)
    {
        Comparator<CalendarEvent> cmp = new Comparator<CalendarEvent>(){
          public int compare(CalendarEvent c1, CalendarEvent c2)  {
              if(c1.getStart().getTime() < c2.getStart().getTime())
            	  return -1;
              else if(c1.getStart().getTime() > c2.getStart().getTime())
            	  return 1;
              else 
            	  return 0;

          }
        };
        
        List<CalendarEvent> eventList = new ArrayList<>(events);
        Collections.sort(eventList, cmp);
        CalendarEvent previous = eventList.get(0);
        
        List<CalendarEvent> resultList = new ArrayList<>();
        
        for(int i=1;i<eventList.size();i++) {
        	CalendarEvent current = eventList.get(i);
        	if(previous.getEnd().getTime() < current.getStart().getTime()) {
        		resultList.add(previous);
        		previous = current;
        		
        	}
        	else {
        		if(previous.getEnd().getTime() < current.getEnd().getTime())
        			previous.setEnd(current.getEnd());
        	}
        	
        }
        resultList.add(previous);
        
        float totalTime = 0;
        
        for(CalendarEvent event: resultList) {
        	totalTime  += ((float)(event.getEnd().getTime() - event.getStart().getTime())/(1000*60));
        }
        
		return (int) totalTime;
        
        
    }

    public static void main(String[] args) throws Exception
    {
	    SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");
	    ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
        
        events.add(new CalendarEvent(sdf.parse("2018-01-01 20:00"),sdf.parse("2018-01-01 21:30")));
        events.add(new CalendarEvent(sdf.parse("2018-01-01 20:10"),sdf.parse("2018-01-01 21:40")));
        events.add(new CalendarEvent(sdf.parse("2018-01-01 21:40"),sdf.parse("2018-01-01 22:00")));

        System.out.println("Total time in meetings = " + TotalMeetingDuration_Overlapping_Intervals.CalculateTotalTimeInMeetings(events));
        System.out.println("The correct answer is 120");        
    }
}