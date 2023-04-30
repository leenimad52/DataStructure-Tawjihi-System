package application;


public class tawjihiRecord   {
	
	private int seatNumber;
	private String branch;
	private double grade;
	
	
	public tawjihiRecord() {
		super();
	}

	public tawjihiRecord(int seatNumber, String branch, double grade) {
		super();
		this.seatNumber = seatNumber;
		this.branch = branch;
		this.grade = grade;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getGrade() {
		return grade;
	}


	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int compareTo(tawjihiRecord o) {
		return (int) ((o.grade)*100 - grade*100);
	}
	@Override
	public String toString() {
		return "[seatNumber=" + seatNumber + ", branch=" + branch + ", grade=" + grade + "]";
	} 
	
	public String toString2() {
		return  "\nbranch=" + branch + "\ngrade=" + grade ;
	} 
	
	public String toString3() {
		return "seatNumber=" + seatNumber + ", grade=" + grade;
	} 
	




}
