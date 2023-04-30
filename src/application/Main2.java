package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Collections;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class Main2 extends Application {
	  static LinkedList liGa=new LinkedList();
	    static LinkedList scGa=new LinkedList();
	    static LinkedList liWb=new LinkedList();
	    static LinkedList scWb=new LinkedList();
	@Override
	public void start(Stage primaryStage) {
		try {
			  BorderPane root = new BorderPane();
			  root.setPadding(new Insets(5));
			  root.setPadding(new Insets(10));
		      Image image = new Image("gg2jpg.jpg");
		      ImageView imageView = new ImageView();
		      imageView.setImage(image);    
		      imageView.setFitWidth(450);
		      imageView.resize(789, 550);
		      imageView.setPreserveRatio(true); 
		      imageView.setTranslateY(0);
		      root.setLeft(imageView);
		      FileChooser fc1=new FileChooser();
		      FileChooser fc2=new FileChooser();

		      GridPane gp=new GridPane();
		      gp.setAlignment(Pos.CENTER);
		      Label la=new Label("Tawjihi Palestine 2022");
		   //   la.setFont(Font.font("Verdana"));
		    //  gp.addRow(4, la);
		      la.setFont(new Font("Impact",30));
			  la.setTextFill(Color.DARKSLATEBLUE);
			  la.setTranslateX(-100);
			  
			  Label la2=new Label("West Bank and Gaza");
		     // la2.setFont(Font.font("Verdana"));
		      gp.addRow(6, la2);
		      la2.setFont(new Font("Times New Roman",20));
			  la2.setTextFill(Color.DARKSLATEBLUE);
			  la2.setTranslateX(-60);

		      Label region =new Label(" Region:   "),
					  branch =new Label(" Branch:  ");
				region.setFont(Font.font("Lucida Sans Unicode", 15));
				region.setFont(new Font("Times New Roman",20));
				region.setTextFill(Color.MIDNIGHTBLUE);
				branch.setFont(new Font("Times New Roman",20));
				branch.setTextFill(Color.MIDNIGHTBLUE);
				RadioButton gaza=new RadioButton("Gaza");
				RadioButton westb=new RadioButton("WestBank");
				gaza.setFont(Font.font("Lucida Sans Unicode",  15));
				gaza.setTextFill(Color.MIDNIGHTBLUE);
				westb.setFont(Font.font("Lucida Sans Unicode",  15));
				westb.setTextFill(Color.MIDNIGHTBLUE);
				RadioButton literary=new RadioButton("Literary");
				RadioButton Science=new RadioButton("Science");
				literary.setFont(Font.font("Lucida Sans Unicode",  15));
				literary.setTextFill(Color.MIDNIGHTBLUE);
				Science.setFont(Font.font("Lucida Sans Unicode", 15));
				Science.setTextFill(Color.MIDNIGHTBLUE);
				 ToggleGroup group1 = new ToggleGroup();
			        gaza.setToggleGroup(group1);
			        westb.setToggleGroup(group1);
			     ToggleGroup group2 = new ToggleGroup();
			     literary.setToggleGroup(group2);
			     Science.setToggleGroup(group2);
				//gp.addRow(1, region,gaza,westb);	
				//gp.addRow(2, branch,literary,Science);
			     Button read=new Button("Read data from files");
			     Label view=new Label();
			     VBox vb1=new VBox(region,branch);
			     VBox vb2=new VBox(gaza,literary);
			     VBox vb3=new VBox(westb,Science);
				  vb1.setTranslateX(15);
				  vb2.setTranslateX(22);
				  vb3.setTranslateX(24);
			      gp.addRow(4, la ,vb1,vb2,vb3);
			      read.setTranslateX(15);
			      view.setTranslateX(290);
			      gp.addRow(6, read);
			      gp.addRow(8, view);
/////////////////////////////////////////////////////////////////////////
			      File westBankfile = new File("WestBank_2022.txt");
				  File gazafile = new File("Gaza_2022.txt");
					
					Scanner wbsc = new Scanner(westBankfile);
					Scanner gsc = new Scanner(gazafile);
				////////////////////////	
			      read.setOnAction(e-> {
			    	  if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
		        		{
		        		  //if the user does not select the region and branch
			    		  view.setText("select region and branch");		   
			    		  view.setTextFill(Color.DARKRED);
		        	      System.out.println("select both region and branch");		        	         
		        		}
			    	  else if ( gaza.isSelected() && literary.isSelected()  )
		        	  {
		                  //read from gaza file if the user select gaza-literally 
		        		  System.out.println("gaza-Literary file has been read");
		        		  view.setText("Gaza-Literary file has been read");		   
			    		  view.setTextFill(Color.FORESTGREEN);
		  		          
		  		        String str[];  
		  		        while (gsc.hasNextLine()) {
		  					String line = gsc.nextLine();
		  			        line = line.replace("	",",");
							str=gsc.nextLine().replace("	",",").split(",");//replace all spaces 
							if (str[1].equals("Literary")) {
                                //add sorted data to linked list								
								tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(str[0]),str[1],Double.parseDouble(str[2]));
				        	   // System.out.println(tr.getGrade()+tr.getBranch());	
				        	    liGa.insert2(tr);
							}	
		  				}
		  		        liGa.printList();
		  		      System.out.println("-------------------------");         
		        	  }
			    	  else if ( gaza.isSelected() && Science.isSelected()  )
		        	  {
		                  //read from gaza file if the user select gaza-sc 
		        		  System.out.println("gaza-Science");
		        		  view.setText("Gaza-Science file has been read");		   
			    		  view.setTextFill(Color.DARKOLIVEGREEN);          
		  		          // read from gaza file  
		  		        String str[];  
		  		        while (gsc.hasNextLine()) {
		  					String line = gsc.nextLine();
		  			        line = line.replace("	",",");
							str=gsc.nextLine().replace("	",",").split(",");
							if (str[1].equals("Scientific")) {
			        	  //  System.out.println(line);
			        	    tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(str[0]),str[1],Double.parseDouble(str[2]));
				        	  //  System.out.println(tr.getGrade()+tr.getBranch());	
				        	    scGa.insert2(tr);
							}
		  				}
		  		        scGa.printList();
		        	  }
			    	  else if ( westb.isSelected() && literary.isSelected()  )
		        	  {
		        		  //read from westBank file if the suer select westb-literary
		        		  System.out.println("westBank-Literary");
		        		  view.setText("West Bank-Literary file has been read");		   
			    		  view.setTextFill(Color.DARKOLIVEGREEN);      
		  		        //read from westBank file  
		  		        String str[];  
		  		        while (wbsc.hasNextLine()) {
		  					String line = wbsc.nextLine();
		  			        line = line.replace("	",",");
							str=wbsc.nextLine().replace("	",",").split(",");
							if (str[1].equalsIgnoreCase("Literary")) {
			        	  //  System.out.println(line);	
			        	    tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(str[0]),str[1],Double.parseDouble(str[2]));
				        	  //  System.out.println(tr.getGrade()+tr.getBranch());	
				        	    liWb.insert2(tr);
							}
		  				}  
		  		        liWb.printList(); 
			  		    System.out.println("-------------------------");
		        	  }
			    	  else if ( westb.isSelected() && Science.isSelected()  )
		        	  {
		        		  //read from westBank file if the suer select westb-sc
		        		  System.out.println("westBank-Science");	  
		        		  view.setText("West Bank-Science file has been read");		   
			    		  view.setTextFill(Color.DARKOLIVEGREEN); 
		  		          
		  		        String str[];  
		  		        while (wbsc.hasNextLine()) {
		  					String line = wbsc.nextLine();
		  			        line = line.replace("	",",");
							str=wbsc.nextLine().replace("	",",").split(",");
							if (str[1].equals("Scientific")) {
			        	 //   System.out.println(line);	
			        	    tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(str[0]),str[1],Double.parseDouble(str[2]));
				        	  //  System.out.println(tr.getGrade()+tr.getBranch());	
				        	    scWb.insert2(tr);
							}
		  				}  
		  		        scWb.printList();
		  		      System.out.println("-------------------------");
		        	  }  
			    	  
			      });
		    root.setTop(gp);     
		  
		    BorderPane gp2=new BorderPane();
		 //   gp2.setAlignment(Pos.CENTER);
		    Button insert=new Button (" insert new Tawjihi record");
			Button delete=new Button (" delete a Tawjihi record");
			Button search=new Button (" search for a Tawjihi record");
			Button display=new Button (" display the top 10 students");
			Button mean=new Button (" calculate the mean");
			Button mode=new Button (" calculate the mode");
			Button perc=new Button (" num and perc of students >= grade");
			insert.setPrefSize(260, 40);
			insert.setFont(Font.font("Verdana",  15));
			insert.setStyle("-fx-background-color:#D5DDDF;");
			delete.setPrefSize(260, 40);
			delete.setFont(Font.font("Verdana",  15));
			delete.setStyle("-fx-background-color:#D5DDDF;");
			search.setPrefSize(260, 40);
			search.setFont(Font.font("Verdana",  15));
			search.setStyle("-fx-background-color:#D5DDDF;");
			display.setPrefSize(260, 40);
			display.setFont(Font.font("Verdana",  15));
			display.setStyle("-fx-background-color:#D5DDDF;");
			mean.setPrefSize(260, 40);
			mean.setFont(Font.font("Verdana",  15));
			mean.setStyle("-fx-background-color:#D5DDDF;");
			mode.setPrefSize(260, 40);
			mode.setFont(Font.font("Verdana",  15));
			mode.setStyle("-fx-background-color:#D5DDDF;");
			perc.setPrefSize(260, 40);
			perc.setFont(Font.font("Verdana",  13));
			perc.setStyle("-fx-background-color:#D5DDDF;");
			VBox vbB=new VBox(10,insert,delete,search,display,mean,mode,perc);
			vbB.setTranslateY(2);
			vbB.setTranslateX(-250);
			vbB.setAlignment(Pos.CENTER);
			gp2.setLeft(vbB);
		    root.setRight(gp2);
////////////////////////////////////////////////////////////////////////////////////////////////
		    insert.setOnAction(e->{
				GridPane gpi = new GridPane();
				Label seat=new Label("seat number ");
				TextField tf1=new TextField();
				tf1.setPrefSize(80, 20);
				Label grade=new Label("grade ");
				TextField tf2=new TextField();
				tf2.setPrefSize(80, 20);
                Button add=new Button("insert");
                seat.setFont(Font.font("Lucida Sans Unicode",  15));
    			grade.setFont(Font.font("Lucida Sans Unicode", 15));
    			add.setPrefSize(60, 30);
    			add.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(1, seat,tf1);
				gpi.addRow(2, grade,tf2);
				gpi.addRow(3, add);
			//	gpi.setTranslateX(50);
			//	gpi.setTranslateY(-200);
				
				 Label select=new Label();
				gpi.setAlignment(Pos.CENTER_LEFT);	
				
				add.setOnAction(e1->{
			
			try {		
				if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
        		{
				  select.setText("select region and branch ");
        		  select.setTextFill(Color.DARKRED);
  		          gpi.addRow(5, select);
        	       System.out.println("select region and branch");		        	         
        		}
				else if ( gaza.isSelected() && literary.isSelected()  ) {
					 //if the user select gaza and literally
					    tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),"Literary",Double.parseDouble(tf2.getText()));
					    if ( liGa.searchbyseat(Integer.parseInt(tf1.getText()))!="not found")
						  {
			        	      select.setText("a student with that seat number already exists");
			        		  select.setTextFill(Color.DARKRED);
						  }
					    if (Integer.parseInt(tf2.getText())>100 || Integer.parseInt(tf2.getText())<50 ) {
					    	 select.setText("Enter the mark above 50 and below 100");
			        		  select.setTextFill(Color.DARKRED);
					    }
					    else {
		        	      liGa.insert2(tr);
		        	      select.setText("Done");
		        		  select.setTextFill(Color.DARKGREEN);
		  				  // add new data to the file
		  				String filename= "Gaza_2022.txt";
		  			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		  			    fw.write(tf1.getText()+","+"literary"+tf2.getText());//appends the string to the file
		  			    fw.close();
					    }
		  				  gpi.addRow(5, select);

		  	         //   System.out.println(tf1.getText()+","+"literary"+","+tf2.getText());
				 }
				 else if ( gaza.isSelected() && Science.isSelected() ) {
					    tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),"Scientific",Double.parseDouble(tf2.getText()));
					    if ( scGa.searchbyseat(Integer.parseInt(tf1.getText()))!="not found")
						  {
					    	  System.out.println("wtf");
			        	      select.setText("a student with that seat number already exists");
			        		  select.setTextFill(Color.DARKRED);
						  }
					    if (Integer.parseInt(tf2.getText())>100 || Integer.parseInt(tf2.getText())<50 ) {
					    	 select.setText("Enter the mark above 50 and below 100");
			        		  select.setTextFill(Color.DARKRED);
					    }else {
		        	    System.out.println(tr.getSeatNumber()+" "+tr.getBranch()+" "+tr.getGrade());	
		        	    scGa.insert2(tr);
		        	    scGa.printList();
		        	     select.setText("Done ");
		        		 select.setTextFill(Color.DARKGREEN); 
		  				String filename= "Gaza_2022.txt";
		  			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		  			    fw.write(tf1.getText()+","+Science.isSelected()+","+tf2.getText());//appends the string to the file
		  			    fw.close();
						  }
		  				 gpi.addRow(5, select);
				 }
				 else if(westb.isSelected() && literary.isSelected()) {
					 //wb l
					 tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),"Literary",Double.parseDouble(tf2.getText()));
		        	 //   System.out.println(tr.getSeatNumber()+" "+tr.getBranch()+" "+tr.getGrade());	
					 if ( liWb.searchbyseat(Integer.parseInt(tf1.getText()))!="not found")
					  {
		        	      select.setText("a student with that seat number alrady exists");
		        		  select.setTextFill(Color.DARKRED);}
					 if (Integer.parseInt(tf2.getText())>100 || Integer.parseInt(tf2.getText())<50 ) {
				    	 select.setText("Enter the mark above 50 and below 100");
		        		  select.setTextFill(Color.DARKRED);
				    }
					 else {
		        	    liWb.insert2(tr);
		        	    liWb.printList();
		        	    select.setText("Done ");
		        	    select.setTextFill(Color.DARKGREEN);
		  			    gpi.addRow(5, select);
		  			    String filename= "WestBank_2022.txt";
		  			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		  			    fw.write(tf1.getText()+","+literary.getText()+tf2.getText());//appends the string to the file
		  			    fw.close();
					 }
	  				 gpi.addRow(5, select);  
				 }
				 else if(westb.isSelected() && Science.isSelected()) {
					 //wb sc
					 tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),"Scientific",Double.parseDouble(tf2.getText()));
		        	  //  System.out.println(tr.getSeatNumber()+" "+tr.getBranch()+" "+tr.getGrade());
					 if ( scWb.searchbyseat(Integer.parseInt(tf1.getText()))!="not found")
					  {
				    	  System.out.println("wtf");
		        	      select.setText("a student with that seat number alrady exists");
		        		  select.setTextFill(Color.DARKRED);
					  }if (Integer.parseInt(tf2.getText())>100 || Integer.parseInt(tf2.getText())<50 ) {
					    	 select.setText("Enter the mark above 50 and below 100");
			        		  select.setTextFill(Color.DARKRED);
					    }else {
		        	    scWb.insert2(tr);
		        	    scWb.printList();
		        	    select.setText("Done ");
		        		select.setTextFill(Color.DARKGREEN);	
		  				gpi.addRow(5, select);
		  				 String filename= "WestBank_2022.txt";
			  			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			  			    fw.write(tf1.getText()+","+Science.getText()+tf2.getText()+"\n");//appends the string to the file
			  			    fw.close();
				 }
	  				 gpi.addRow(5, select);  

				 }} catch (Exception e2)
			{
				select.setText("Entry Error");
				select.setTextFill(Color.DARKRED);
				gpi.addRow(5,select);
				System.out.print(e2.getMessage());
			}
				});	
				gp2.setBottom(gpi);
			    		
			});
//////////////////////////////////////////////////////////////////////////////////////////////
		    delete.setOnAction(e->{
				GridPane gpi = new GridPane();
				Label seat=new Label("seat number ");
				TextField tf1=new TextField();
				tf1.setPrefSize(80, 20);
                Button remove=new Button("remove");
                seat.setFont(Font.font("Lucida Sans Unicode",  15));
    			remove.setPrefSize(60, 30);
    			remove.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(1, seat,tf1);
				 Label select=new Label();
				gpi.addRow(3, remove,select);

				gpi.setAlignment(Pos.CENTER_LEFT);
				gp2.setBottom(gpi);	
				remove.setOnAction(e1->{
					tawjihiRecord tr=new tawjihiRecord();
				try {	
					if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
	        		{ //if the user does not select the branch and the region
	        		  select.setText("select region and branch");
	        		  select.setTextFill(Color.DARKRED);
	  		          //gpi.addRow(3, select);
	        	       System.out.println("select region and branch");		        	         
	        		}
					 else if ( gaza.isSelected() && literary.isSelected()  ) {
						// if the user select the gaza and literally
						boolean  check=liGa.removebyseat(Integer.parseInt(tf1.getText()));
			        	  if( check == true) {
			        		  select.setText("Done");
			        		  select.setTextFill(Color.DARKGREEN);
			        		  System.out.println("-----");
			        		  liGa.printList();
			        		// Read the file line by 
			        	  }
			        	  else  {
			        		  select.setText("cant found");
			        		  select.setTextFill(Color.DARKRED);
			        	  }
			        	   liGa.printList();
					 }
					 else if ( gaza.isSelected() && Science.isSelected()  ) {
							// if the user select the gaza and Science
							boolean  check=scGa.removebyseat(Integer.parseInt(tf1.getText()));
				        	  if( check == true) {
				        		  select.setText("Done");
				        		  select.setTextFill(Color.DARKGREEN);
				        		  System.out.println("-----");
				        		  scGa.printList();
				        	  }
				        	  else  {
				        		  select.setText("cant found");
				        		  select.setTextFill(Color.DARKRED);
				        	  }
				        	   scGa.printList();
						 }
					 else if(westb.isSelected() && literary.isSelected()) {
							boolean  check=liWb.removebyseat(Integer.parseInt(tf1.getText()));
				        	  if( check == true) {
				        		  select.setText("Done");
				        		  select.setTextFill(Color.DARKGREEN);
				        		  System.out.println("-----");
				        		  scGa.printList();
				        	  }
				        	  else  {
				        		  select.setText("cant found");
				        		  select.setTextFill(Color.DARKRED);
				        	  }
				        	  liWb.printList();
						 
					 }
					 else if(westb.isSelected() && Science.isSelected()) {
						 boolean  check=scWb.removebyseat(Integer.parseInt(tf1.getText()));
			        	  if( check == true) {
			        		  select.setText("Done");
			        		  select.setTextFill(Color.DARKGREEN);
			        		  System.out.println("-----");
			        		  scWb.printList();
			        	  }
			        	  else  {
			        		  select.setText("cant found");
			        		  select.setTextFill(Color.DARKRED);
			        	  }
			        	  scWb.printList();
					 } 
				} catch (Exception e2)
				{
					select.setText("Entry Error");
					select.setTextFill(Color.DARKRED);
					System.out.print(e2.getMessage());
				}
							
				});
		    });
///////////////////////////////////////////////////////////////////////////////////////////////////
		    search.setOnAction(e->{
				GridPane gpi = new GridPane();
				Label seat=new Label("seat number ");
				TextField tf1=new TextField();
				tf1.setPrefSize(80, 20);
                Button check=new Button("search");
                seat.setFont(Font.font("Lucida Sans Unicode",  15));
    			check.setPrefSize(60, 30);
    			check.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(1, seat,tf1);
				 Label select=new Label();
				gpi.addRow(3, check,select);
				//gpi.setTranslateX(50);
				//gpi.setTranslateY(-200);

				gpi.setAlignment(Pos.CENTER_LEFT);
				gp2.setBottom(gpi);	
				
				check.setOnAction(e1->{
					tawjihiRecord tr=new tawjihiRecord();
					try {
					if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
	        		{ //if the user does not select the branch and the region
	        		   select.setText("select both region and branch");
	        		  select.setTextFill(Color.RED);
	        	       System.out.println("select region and branch");		        	         
	        		}
					 else if ( gaza.isSelected() && literary.isSelected()  ) {
						// if the user select the gaza and literally
					   liGa.searchbyseat(Integer.parseInt(tf1.getText()));
			           select.setText(liGa.searchbyseat(Integer.parseInt(tf1.getText())));
					 }
					 else if ( gaza.isSelected() && Science.isSelected()  ) {
							// if the user select the gaza and Science
						 scGa.searchbyseat(Integer.parseInt(tf1.getText()));
						 select.setText(scGa.searchbyseat(Integer.parseInt(tf1.getText())));
			        	  
					 }
					 else if(westb.isSelected() && literary.isSelected()) {
						 liWb.searchbyseat(Integer.parseInt(tf1.getText()));
						 select.setText(liWb.searchbyseat(Integer.parseInt(tf1.getText())));
						 
					 }
					 else if(westb.isSelected() && Science.isSelected()) {
						 scWb.searchbyseat(Integer.parseInt(tf1.getText()));
						 select.setText(scWb.searchbyseat(Integer.parseInt(tf1.getText())));
					 }
					}catch (Exception e2)
						{
						select.setText("Entry Error");
							//ta.setTextFill(Color.DARKRED);
							System.out.print(e2.getMessage());
						}			
				});
			
		    });
////////////////////////////////////////////////////////////////////////////////////////////////
		    display.setOnAction(e->{
				GridPane gpi = new GridPane();
		    	TextArea ta=new TextArea();
				ta.setPrefSize(90, 150);
				//ta.setTranslateX(50);
			//	ta.setTranslateY(-90);
			//	gpi.addRow(1, ta);
				gp2.setBottom(ta);	
				try {
				if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
        		{ //if the user does not select the branch and the region
        		  ta.setText("select both region and branch");
        	      System.out.println("select region and branch");		        	         
        		}
				 else if ( gaza.isSelected() && literary.isSelected()  ) {
					// if the user select the gaza and literally
					liGa.displayTop10();
					System.out.println(liGa.displayTop10());
					ta.setText(liGa.displayTop10());
					
				 }
				 else if ( gaza.isSelected() && Science.isSelected()  ) {
						// if the user select the gaza and Science
					 scGa.displayTop10();
					 ta.setText(scGa.displayTop10());
		        	  
				 }
				 else if(westb.isSelected() && literary.isSelected()) {
					 liWb.displayTop10();
					ta.setText(liWb.displayTop10());
				 }
				 else if(westb.isSelected() && Science.isSelected()) {
					 scWb.displayTop10();
					ta.setText(scWb.displayTop10());
				 }	
				
				}catch (Exception e2)
				{
					ta.setText("Entry Error");
					//ta.setTextFill(Color.DARKRED);
					System.out.print(e2.getMessage());
				}
				
		    });
///////////////////////////////////////////////////////////////////////////////////////////////////
		    mean.setOnAction(e->{
				Label ta=new Label();
				gp2.setBottom(ta);	
						;
				if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
        		{ //if the user does not select the branch and the region
        		  ta.setText("select both region and branch");
        		  ta.setTextFill(Color.DARKRED);
        	      System.out.println("select region and branch");		        	         
        		}
				 else if ( gaza.isSelected() && literary.isSelected()  ) {
					ta.setText( "mean of Gaza,literary:\n"+String.valueOf(liGa.meanAvg()));
					ta.setTextFill(Color.MIDNIGHTBLUE);
					ta.setFont(Font.font("Verdana",  15));
					
				 }
				 else if ( gaza.isSelected() && Science.isSelected()  ) {
						// if the user select the gaza and Science
					    ta.setText( "mean of Gaza,sc:\n"+String.valueOf(scGa.meanAvg()));
						ta.setTextFill(Color.MIDNIGHTBLUE);
						ta.setFont(Font.font("Verdana",  15));		        	  
				 }
				 else if(westb.isSelected() && literary.isSelected()) {
					  ta.setText( "mean of WestBank,literary:\n"+String.valueOf(liWb.meanAvg()));
						ta.setTextFill(Color.MIDNIGHTBLUE);
						ta.setFont(Font.font("Verdana",  15));		
				 }
				 else if(westb.isSelected() && Science.isSelected()) {
					 ta.setText( "mean of WestBank,sc:\n"+String.valueOf(scWb.meanAvg()));
						ta.setTextFill(Color.MIDNIGHTBLUE);
						ta.setFont(Font.font("Verdana",  15));	
				 }	
			});
///////////////////////////////////////////////////////////////////////////////////////////////////		    
		    mode.setOnAction(e->{
		    	Label ta=new Label();
				gp2.setBottom(ta);	
				if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
        		{ //if the user does not select the branch and the region
        		  ta.setText("select both region and branch");
        	      System.out.println("select region and branch");		        	         
        		}
				 else if ( gaza.isSelected() && literary.isSelected()  ) {
					ta.setText( "mode avg of Gaza,literary:\n"+String.valueOf(liGa.modeAvg()));
					ta.setTextFill(Color.MIDNIGHTBLUE);
					ta.setFont(Font.font("Verdana",  15));
					
				 }
				 else if ( gaza.isSelected() && Science.isSelected()  ) {
						// if the user select the gaza and Science
					    ta.setText( "mode avg of Gaza,Scientific:\n"+String.valueOf(scGa.modeAvg()));
						ta.setTextFill(Color.MIDNIGHTBLUE);
						ta.setFont(Font.font("Verdana",  15));		        	  
				 }
				 else if(westb.isSelected() && literary.isSelected()) {
					  ta.setText( "mode avg of WestBank,literary:\n"+String.valueOf(liWb.modeAvg()));
						ta.setTextFill(Color.MIDNIGHTBLUE);
						ta.setFont(Font.font("Verdana",  15));		
				 }
				 else if(westb.isSelected() && Science.isSelected()) {
					 ta.setText( "mode avg of WestBank,Scientific:\n"+String.valueOf(scWb.modeAvg()));
						ta.setTextFill(Color.MIDNIGHTBLUE);
						ta.setFont(Font.font("Verdana",  15));	
				 }	
			});
///////////////////////////////////////////////////////////////////////////////////////////////////		   
		    perc.setOnAction(e->{
		    	GridPane gpi = new GridPane();
				Label grade=new Label("enter grade ");
				TextField tf1=new TextField();
				tf1.setPrefSize(80, 20);
                Button done=new Button("done");
                grade.setFont(Font.font("Lucida Sans Unicode",  15));
    			done.setPrefSize(60, 30);
    			done.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(1, grade,tf1);
				Label ta=new Label();
				Label ta2=new Label();
				gpi.addRow(3, done);
				gpi.addRow(4, ta);
				gpi.addRow(5, ta2);
				gpi.setAlignment(Pos.CENTER_LEFT);
				Label ta0=new Label();
				gp2.setBottom(gpi);	
				
				done.setOnAction(e1->{
					try {
					if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
	        		{ //if the user does not select the branch and the region
	        		  ta.setText("select both region and branch");
	        		  ta.setTextFill(Color.DARKRED);
	        	      System.out.println("select region and branch");		        	         
	        		}
					 else if ( gaza.isSelected() && literary.isSelected()  ) {
						ta.setText( " number of students "+String.valueOf(liGa.numAbove(Double.parseDouble(tf1.getText()) ))+"\n");
						ta.setTextFill(Color.MIDNIGHTBLUE);
						ta.setFont(Font.font("Verdana",  10));
						ta2.setText( "percentage of students "+String.valueOf(liGa.percentageAbove(Double.parseDouble(tf1.getText()))));
						ta2.setTextFill(Color.MIDNIGHTBLUE);
						ta2.setFont(Font.font("Verdana",  10));	

					 }
					 else if ( gaza.isSelected() && Science.isSelected()  ) {
							// if the user select the gaza and Science
						 ta.setText( " number of students "+String.valueOf(scGa.numAbove(Double.parseDouble(tf1.getText()))));
							ta.setTextFill(Color.MIDNIGHTBLUE);
							ta.setFont(Font.font("Verdana",  10));
							ta2.setText( "percentage of students "+String.valueOf(scGa.percentageAbove(Double.parseDouble(tf1.getText()))));
							ta2.setTextFill(Color.MIDNIGHTBLUE);
							ta2.setFont(Font.font("Verdana",  10));			        	  
					 }
					 else if(westb.isSelected() && literary.isSelected()) {
						 ta.setText( " number of students "+String.valueOf(liWb.numAbove(Double.parseDouble(tf1.getText()))));
							ta.setTextFill(Color.MIDNIGHTBLUE);
							ta.setFont(Font.font("Verdana",  10));
							ta2.setText( "percentage of students "+String.valueOf(liWb.percentageAbove(Double.parseDouble(tf1.getText()))));
							ta2.setTextFill(Color.MIDNIGHTBLUE);
							ta2.setFont(Font.font("Verdana",  10));							        	  	
					 }
					 else if(westb.isSelected() && Science.isSelected()) {
						 ta.setText( " number of students "+String.valueOf(scWb.numAbove(Double.parseDouble(tf1.getText()))));
							ta.setTextFill(Color.MIDNIGHTBLUE);
							ta.setFont(Font.font("Verdana",  10));
							ta2.setText( "percentage of students "+String.valueOf(scWb.percentageAbove(Double.parseDouble(tf1.getText()))));
							ta2.setTextFill(Color.MIDNIGHTBLUE);
							ta2.setFont(Font.font("Verdana",  10));			        	  
					 }
					}catch (Exception e2)
					{
						ta.setText("Entry Error");
						//ta.setTextFill(Color.DARKRED);
						System.out.print(e2.getMessage());
					}
				}); 
		    	
		    });
		    Scene scene = new Scene(root,960,520);
		    Background bk=new Background(new BackgroundFill(Color.WHITE,new CornerRadii(0),new Insets(0)));
			root.setBackground(bk);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
