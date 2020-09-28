package de.jdsr.java.exam.sommer17;

public class RcadTest {
	
	public static void main(String[] args)
	{
		PKW mustang = new PKW(1,"Ford Mustang", "Blau",  2005, 100000);

		System.out.println(mustang.mieten("11.11.2011", "13:30", "Peter", 100000));
		System.out.println(mustang.mieten("16.02.2012", "13:40", "Manuel", 190000));
		System.out.println(mustang.mieten("16.02.2012", "13:40", "Sherlock", 200000));
	}
}
