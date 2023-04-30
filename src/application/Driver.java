package application;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      LinkedList tw=new LinkedList();
      tawjihiRecord tr=  new tawjihiRecord(7,"sc",78.9);
      tawjihiRecord tr1=  new tawjihiRecord(8,"li",88);
      tawjihiRecord tr2=  new tawjihiRecord(5,"sc",60.3);
      tawjihiRecord tr3=  new tawjihiRecord(2,"li",90.9);
      tawjihiRecord tr4=  new tawjihiRecord(3,"li",90.1);
      tawjihiRecord tr5=  new tawjihiRecord(79,"sc",79.9);
      tawjihiRecord tr6=  new tawjihiRecord(10,"li",88);
      tawjihiRecord tr7=  new tawjihiRecord(44,"sc",68.3);
      tawjihiRecord tr8=  new tawjihiRecord(22,"li",97.9);
      tawjihiRecord tr9=  new tawjihiRecord(01,"li",89.1);
      tawjihiRecord tr10=  new tawjihiRecord(98,"li",99.4);
      tawjihiRecord tr11=  new tawjihiRecord(84,"li",99.5);
      tawjihiRecord tr12=  new tawjihiRecord(83,"li",99.5);
      tawjihiRecord tr13=  new tawjihiRecord(81,"li",79.5);
      tawjihiRecord tr14=  new tawjihiRecord(879,"li",65.1);
      tawjihiRecord tr15=  new tawjihiRecord(893,"li",80.4);//
      tawjihiRecord tr16=  new tawjihiRecord(813,"li",80.4); //
      tawjihiRecord tr17=  new tawjihiRecord(8323,"li",80.4); //
      tawjihiRecord tr18=  new tawjihiRecord(83123,"li",80.4); //
      tawjihiRecord tr19=  new tawjihiRecord(83123,"li",65.1);
      tawjihiRecord tr20=  new tawjihiRecord(7843,"li",65.1);
      tawjihiRecord tr21=  new tawjihiRecord(7483,"sc",81.4);
      tawjihiRecord tr22=  new tawjihiRecord(555,"sc",80.5);
      tawjihiRecord tr23=  new tawjihiRecord(333,"sc",80.4); //

      tw.insert2(tr);
      tw.insert2(tr1);
      tw.insert2(tr2);
      tw.insert2(tr3);
      tw.insert2(tr4);
      tw.insert2(tr5);
      tw.insert2(tr6);
      tw.insert2(tr7);
    
      tw.insert2(tr8);
      tw.insert2(tr9);
      tw.insert2(tr10);
      tw.insert2(tr11);
      tw.insert2(tr12);
      tw.insert2(tr13);
      tw.insert2(tr14);
      tw.insert2(tr15);
      tw.insert2(tr16);
      tw.insert2(tr17);
      tw.insert2(tr18);  tw.insert2(tr20); tw.insert2(tr21); tw.insert2(tr22); tw.insert2(tr23); 



     tw.printList();
    
     if (tw.removebyseat(0)==true)
     {
    	// System.out.println("done");
     }
     else
     {
    	// System.out.println("enter correct value");
     }
  //   tw.printList();
     //tw.remove(tr2);
   // System.out.println( tw.searchbyseat(0));
    System.out.println("--");
    System.out.println( "n= "+ tw.numAbove(55) );
   
   System.out.println(tw.modeAvg());

	}
}
