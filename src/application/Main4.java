package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Collections;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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


public class Main4 extends Application {
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
////////////////////////////////////////////
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
		  
		    GridPane gp2=new GridPane();
		    gp2.setAlignment(Pos.CENTER);
		    Button insert=new Button (" insert new Tawjihi record");
			Button delete=new Button (" delete a Tawjihi record");
			Button search=new Button (" search for a Tawjihi record");
			Button display=new Button (" display the top 10 students");
			Button mean=new Button (" calculate the mean");
			Button mode=new Button (" calculate the mode");
			Button perc=new Button (" percentage of students");
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
			perc.setFont(Font.font("Verdana",  15));
			perc.setStyle("-fx-background-color:#D5DDDF;");
			VBox vbB=new VBox(10,insert,delete,search,display,mean,mode,perc);
			vbB.setTranslateY(2);
			vbB.setTranslateX(-250);
			vbB.setAlignment(Pos.CENTER);
			gp2.addRow(1, vbB);
		    root.setRight(gp2);
////////////////////////////////////////////////////////////////////////////////////////////////
		    insert.setOnAction(e->{
				GridPane gpi = new GridPane();
				Label seat=new Label("seat number ");
				TextField tf1=new TextField();
				tf1.setPrefSize(80, 40);
				Label grade=new Label("grade ");
				TextField tf2=new TextField();
				tf2.setPrefSize(80, 40);
                Button add=new Button("insert");
                seat.setFont(Font.font("Lucida Sans Unicode",  15));
    			grade.setFont(Font.font("Lucida Sans Unicode", 15));
    			add.setPrefSize(60, 30);
    			add.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(1, seat,tf1);
				gpi.addRow(2, grade,tf2);
				gpi.addRow(3, add);
				gpi.setTranslateX(50);
				gpi.setTranslateY(-200);
				 Label select=new Label();
				gpi.setAlignment(Pos.CENTER_LEFT);	
				gp2.addRow(5, gpi);

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
					    tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),literary.getText(),Double.parseDouble(tf2.getText()));
		        	      liGa.insert2(tr);
		        	      select.setText("Done");
		        		  select.setTextFill(Color.DARKGREEN);
		  			//	  gpi.addRow(5, select);
		  				  // add new data to the file
		        		  System.out.println("done");
		  				String filename= "Gaza_2022.txt";
		  			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		  			    fw.write(tf1.getText()+","+gaza.getText()+tf2.getText());//appends the string to the file
		  			    fw.close();
		  	            System.out.println(tf1.getText()+","+gaza.getText()+","+tf2.getText());
				 }
				 else if ( gaza.isSelected() && Science.isSelected() ) {
					    tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),literary.getText(),Double.parseDouble(tf2.getText()));
		        	    System.out.println(tr.getSeatNumber()+" "+tr.getBranch()+" "+tr.getGrade());	
		        	    scGa.insert2(tr);
		        	    scGa.printList();
		        	     select.setText("Done ");
		        		 select.setTextFill(Color.DARKGREEN); 
		  				//  gpi.addRow(5, select);
		        		  System.out.println("done");
		  				String filename= "Gaza_2022.txt";
		  			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		  			    fw.write(tf1.getText()+","+gaza.getText()+tf2.getText());//appends the string to the file
		  			    fw.close();
				 }
				 else if(westb.isSelected() && literary.isSelected()) {
					 //wb l
					 tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),literary.getText(),Double.parseDouble(tf2.getText()));
		        	 //   System.out.println(tr.getSeatNumber()+" "+tr.getBranch()+" "+tr.getGrade());	
		        	    liWb.insert2(tr);
		        	    liWb.printList();
		        	    select.setText("Done ");
		        	    select.setTextFill(Color.DARKGREEN);
		  			 //   gpi.addRow(5, select);
		        		  System.out.println("done");
		  			    String filename= "WestBank_2022.txt";
		  			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		  			    fw.write(tf1.getText()+","+westb.getText()+tf2.getText());//appends the string to the file
		  			    fw.close();
				 }
				 else if(westb.isSelected() && Science.isSelected()) {
					 //wb sc
					 tawjihiRecord tr=new tawjihiRecord(Integer.parseInt(tf1.getText()),literary.getText(),Double.parseDouble(tf2.getText()));
		        	  //  System.out.println(tr.getSeatNumber()+" "+tr.getBranch()+" "+tr.getGrade());	
		        	    scWb.insert2(tr);
		        	    scWb.printList();
		        	    select.setText("Done ");
		        		select.setTextFill(Color.DARKGREEN);	
		  				//gpi.addRow(5, select);
		        		  System.out.println("done");
		  				 String filename= "WestBank_2022.txt";
			  			 FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			  			 fw.write(tf1.getText()+","+westb.getText()+tf2.getText());//appends the string to the file
			  			 fw.close();
				 }
			} catch (Exception e2)
			{
				select.setText("Entry Error");
				select.setTextFill(Color.DARKRED);
				gpi.addRow(5,select);
				System.out.print(e2.getMessage());
			}
				});	
			});
/////////////////////////////////////////////////////////////////////////////////////////////////		    
		    delete.setOnAction(e->{
		    	GridPane gpi = new GridPane();
				Label seat=new Label("seat number ");
				TextField tf1=new TextField();
				tf1.setPrefSize(80, 20);
                Button remove=new Button("delete");
                seat.setFont(Font.font("Lucida Sans Unicode",  15));
    			remove.setPrefSize(60, 30);
    			remove.setFont(Font.font("Lucida Sans Unicode", 10));
				gpi.addRow(1, seat,tf1);
				gpi.addRow(2, remove);
				gpi.setTranslateX(50);
				gpi.setTranslateY(-200);	
				Label select=new Label();
				gpi.setAlignment(Pos.CENTER_LEFT);
				gp2.addRow(5, gpi);
				remove.setOnAction(e1->{
					tawjihiRecord tr=new tawjihiRecord();
					try {
					if (!((gaza.isSelected() || westb.isSelected() )&& (literary.isSelected() || Science.isSelected() )))
	        		{ //if the user does not select the branch and the region
	        		  select.setTextFill(Color.RED);
	  		          gpi.addRow(3, select);
	        	       System.out.println("select region and branch");		        	         
	        		}
					 else if ( gaza.isSelected() && literary.isSelected()  ) {
						// if the user select the gaza and literally
						boolean  check=liGa.removebyseat(Integer.parseInt(tf1.getText()));
			        	  if( check == true) {
			        		  Label done =new Label("done");
			        		  done.setTextFill(Color.GREEN);
			        		  gpi.addRow(3, done);
			        		  System.out.println("-----");
			        		  liGa.printList();
			        	  }
			        	  else  {
			        		  Label cant =new Label("cant found ");
			        		  cant.setTextFill(Color.RED);
			        		  gpi.addRow(3, cant);
			        	  }
			        	   liGa.printList();
					 }
					 else if ( gaza.isSelected() && Science.isSelected()  ) {
							// if the user select the gaza and Science
							boolean  check=scGa.removebyseat(Integer.parseInt(tf1.getText()));
				        	  if( check == true) {
				        		  Label done =new Label("done");
				        		  done.setTextFill(Color.GREEN);
				        		  gpi.addRow(3, done);
				        		  System.out.println("-----");
				        		  scGa.printList();
				        	  }
				        	  else  {
				        		  Label cant =new Label("cant found ");
				        		  cant.setTextFill(Color.RED);
				        		  gpi.addRow(3, cant);
				        	  }
				        	   scGa.printList();
						 }
					 else if(westb.isSelected() && literary.isSelected()) {
							boolean  check=liWb.removebyseat(Integer.parseInt(tf1.getText()));
				        	  if( check == true) {
				        		  Label done =new Label("done");
				        		  done.setTextFill(Color.GREEN);
				        		  gpi.addRow(3, done);
				        		  System.out.println("-----");
				        		  scGa.printList();
				        	  }
				        	  else  {
				        		  Label cant =new Label("cant found ");
				        		  cant.setTextFill(Color.RED);
				        		  gpi.addRow(3, cant);
				        	  }
				        	  liWb.printList();
						 
					 }
					 else if(westb.isSelected() && Science.isSelected()) {
						 boolean  check=scWb.removebyseat(Integer.parseInt(tf1.getText()));
			        	  if( check == true) {
			        		  Label done =new Label("done");
			        		  done.setTextFill(Color.GREEN);
			        		  gpi.addRow(3, done);
			        		  System.out.println("-----");
			        		  scWb.printList();
			        	  }
			        	  else  {
			        		  Label cant =new Label("not found ");
			        		  cant.setTextFill(Color.RED);
			        		  gpi.addRow(3, cant);
			        	  }
			        	  scWb.printList();
					 }	
					} catch (Exception e2)
					{
						select.setText("Entry Error");
						select.setTextFill(Color.DARKRED);
						gpi.addRow(5,select);
						System.out.print(e2.getMessage());
					}
				});
		    });
///////////////////////////////////////////////////////////////////////////////////////////////////////		
            
		    Scene scene = new Scene(root,990,510);
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
