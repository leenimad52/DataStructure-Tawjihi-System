package application;

public class LinkedList {
	private Node first;
	private int count = 0;

	public LinkedList() {
		super();
	}
	
	  public void printList() {
			Node current = first;
			while (current != null) {
				System.out.print(current.element + "\n");
			//	current.element.toString();
				current = current.next;
			}
			System.out.print("\n");
		}
	  /////////////////////////////////////////
	  public void insert2(tawjihiRecord data) {
		 
		  //insert data and sort them
	    	Node temp = new Node(data);	
	    	if(first == null) { //insert in empty linked list
	    	   first = temp;
	    	   count++; }
	    	else {
	    		Node  prev=null;
	    		Node current=first;
	    		while(  current !=null && ((tawjihiRecord)current.element).compareTo(data) < 0 ) { 
	    			// insert new record into the List -sorted by grade-
	    		    //insert the data sorted by using compare to method
	    				prev = current;
	    				current = current.next; }   
	    		
	    		if(prev == null) { //add first if the new node in the beginning (greater than first)
	    			temp.next=first;
	    			first = temp;	
	    			count++;
	    		}else {  //add between 
	    			prev.next=temp;
	    			temp.next=current;	
	    			count++;
	    		}
	    	}    	
	    }	
	  /////////////////////////////////////////////
	  public boolean removebyseat(int seatNumber)
	  {
		  Node current=first;
		  Node prev=null;
	     while(current !=null) {
	    	
		 if( current.element.getSeatNumber()==seatNumber)
		 {
			prev.next = current.next;
			 return true;
			 
		 }
		 prev=current;
		 current=current.next;	
		 }
	     return false;
	  }
	  ///////////////////////////////////////
	  public String searchbyseat(int seatNumber)
	  {
		  Node current=first;
		  while( current != null)
		  {   
			  if (current.element.getSeatNumber() == seatNumber)
			  {
				  return current.element.toString2();
			  }
			  current=current.next;
		  }	   
			  return "not found";
	  }
      ///////////////////////////////////////////
	  public double meanAvg()
	  {
		Node current=first;
		int countOfN=0;
		double sumOf=0;
		if (current ==null) //if empty linkedlist
		{
			return 0;
		}
		// calculate the avg 
		while (current != null)
		{ 
			tawjihiRecord tw=current.element;
			countOfN++;
			sumOf+=tw.getGrade();
			current=current.next;
		}
		double mean=sumOf/countOfN;
		return mean;
	  }
	  //////////////////////////////////////////
	  public int numAbove(double grade)
	  {
		  //return the number and percentage of students whom grade above or equal a specific grade.
		  Node current = first;
			int count = 0;
			// if cuurrent above or equal the specific grade then increment the counter
			while (current != null) {
				if ((current.element).getGrade() >= grade) {
					count++;
				}
				current = current.next;
			}
			return count;
	  }
	  ///////////////////////////////////
	  public double percentageAbove(double grade) {
		  //calculate the perc by divide sum of numbers that
		  //greater than spesfic grade on number of sum of the grades
			double percentage = (numAbove(grade) / (double) count) * 100;
			return percentage;
		}
	  /////////////////////////////////////////
	  public double modeAvg()
	  {
		  //find the avg which appears most often.
		    double mode = 0;
			int duplicate = 0;
		   	Node current = first;
			  while (current != null) {
				int freq = dub((current.element).getGrade());
				if (freq > duplicate) { //Check the repetitions of each number 
					duplicate = freq;
					mode = ( current.element).getGrade();
				}
				current = current.next;
			}
			return mode;		  		    
	  }
	  //////////////////////////////////////////

		public String displayTop10() {
			//display top 10 grades with freq -sorted linkedlist
			//time comlexety O(n)
			Node current = first;
			String str = "";
			int i=0; 
			while (  i<10 && current.next != null )
			{ 
				if (current.element.getGrade()==current.next.element.getGrade())
				{	//if the grades are repetitive then Stop the counter
					current=current.next;
					str = str + current.element.toString3() + "\n";
				}
				else {
					///if the grades arent repetitive then increment the counter
				str = str + current.element.toString3() + "\n";
				current=current.next;
				i++;
				}
			}
			return str;
		}
		///////////////////////////////////////////////
		  public int dub(double grade)
		  {
			  // The number of times the grade is repeated
			  int i=0;
			  Node current =first;
			  while (current!=null) {
			    if(current.element.getGrade()==grade)
			  {
				  i++;
				  current=current.next;
			  }
			    else {
			    	current=current.next;
			    }
			  } 
			  return i;
		  }
		  //////////////////////////////////////////
		  
}
	

