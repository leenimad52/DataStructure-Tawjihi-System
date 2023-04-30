package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Home extends Application {
	
	Scene scene2;
	@Override
	public void start(Stage primaryStage) {
		try {
				
			FlowPane bp1=new FlowPane();
			Label welc=new Label("Welcome");
			welc.setFont(new Font("Impact",30));
			welc.setTextFill(Color.DARKSLATEBLUE);
		//	bp1.setTop(welc);
			welc.setTranslateY(80);
			welc.setTranslateX(50);
		    	
			ImageView imv9=new ImageView("CC.webp");	
			imv9.setFitHeight(490);
			imv9.setFitWidth(550);
			bp1.setRight(imv9);

	        /////////////////////////////////////////////////////////////////		
				
			
			// ImageView imv8=new ImageView(new Image("school.png"));
	         /*   bb.setBackground(new Background(new BackgroundImage(new Image("schoo1.png"), BackgroundRepeat.NO_REPEAT,
	                    BackgroundRepeat.NO_REPEAT,
	                    BackgroundPosition.DEFAULT,
	                    null))); */
			Scene scene = new Scene(bp1,900,500);			
			bp1.setBackground( new Background(new BackgroundFill(Color.WHITE,null,null)));
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

