// Name: Devin Smith
// Section: OL
// Program Name: Calculator
// 
// Description: This program functions as a basic calculator. It is able to add,
// subtract, divide, and multiply numbers. The calculator also has the ability to 
// clear the screen. This program uses multiple layouts, the layouts used are
// Labels, TextFields, Buttons, Panes, and TilePanes. A rectangle is used for the
// background to fade in and out a color. the rectangle is binded the the size of
// the pane. The TilePane is used for the calculator buttons. Another rectangle is
// used for the background of the calculator screen (This is used for design).
// The TextField "text" is placed on top of the rectangle for the calculator screen.
// The TextField is uneditable and displays when buttons are pressed on the calculator.
// A Label "answerOutput" displays the answer of the calculator whenever the "=" button is pressed.
// Buttons are created in the Main class and use "setOnAction" to call the method 
// "myHandler". "myHandler" creates a new button and sets it as the text of the button
// pressed. this new button is used for the switch statement to determine which button
// was pressed. If 0 - 9 was pressed the method "insertNum" is called and adds the
// number to the TextField to be displayed to the user. if a operator was pressed
// the "operator" method is called and adds the operator with a space before and after.
// if the clear button (C) is pressed the "clearScreen" method is called and clears
// the screen of the TextField and the Label. if "=" is pressed the method "equals"
// is called. Equals assigns a String variable "text1" to TextFields text so that it can be
// split by spaces. An array "nums" holds the split text. the first 2 numbers and the 
// operator are calculated outside of the for loop. Int variables "sum1" and "sum2"
// hold the first 2 numbers. "sum1" holds the number before the operator, "sum2"
// holds the number after the operator. "sum3" holds the total of everything that 
// is being calculated. If statements check which operator was used and apply the 
// appropriate calculation. The for loop is entered and starts at the next operator.
// The same method used for outside of the for loop is used in the forloop. 
// methods "enableButtons", "disableButtons", "enableOperators", and "disableOperators"
// are used to block the user from entering a operator first before a number. It also
// keeps users from entering an operator twice.
package application;
	
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application 
{
	
	Label answerOutput = new Label();
	
	TextField text  = new TextField();
	
	Button btn0 = new Button("0");
	Button btn1 = new Button("1");
	Button btn2 = new Button("2");
	Button btn3 = new Button("3");	
	Button btn4 = new Button("4");
	Button btn5 = new Button("5");
	Button btn6 = new Button("6");
	Button btn7 = new Button("7");
	Button btn8 = new Button("8");
	Button btn9 = new Button("9");
	Button btnDivide = new Button("/");
	Button btnMultiply = new Button("*");
	Button btnSubtract = new Button("-");
	Button btnAdd = new Button("+");
	Button btnEquals = new Button("=");
	Button btnClear = new Button("C");

	
	public void operator(String num)
	{
		text.setText(text.getText() + " " + num + " ");
		disableOperators();
	}
	
	public void insertNum(String num)
	{
		text.setText(text.getText() + num);
		enableOperators();
	}
	
	public void clearScreen()
	{
		text.setText("");
		answerOutput.setText("");
		enableButtons();
		disableOperators();
	}
	
	public void disableButtons()
	{
		btn0.setDisable(true);
		btn1.setDisable(true);
		btn2.setDisable(true);
		btn3.setDisable(true);
		btn4.setDisable(true);
		btn5.setDisable(true);
		btn6.setDisable(true);
		btn7.setDisable(true);
		btn8.setDisable(true);
		btn9.setDisable(true);
		btnDivide.setDisable(true);
		btnMultiply.setDisable(true);
		btnSubtract.setDisable(true);
		btnAdd.setDisable(true);
		btnEquals.setDisable(true);
		
	}
	
	public void enableButtons()
	{
		btn0.setDisable(false);
		btn1.setDisable(false);
		btn2.setDisable(false);
		btn3.setDisable(false);
		btn4.setDisable(false);
		btn5.setDisable(false);
		btn6.setDisable(false);
		btn7.setDisable(false);
		btn8.setDisable(false);
		btn9.setDisable(false);
		btnDivide.setDisable(false);
		btnMultiply.setDisable(false);
		btnSubtract.setDisable(false);
		btnAdd.setDisable(false);
		btnEquals.setDisable(false);
	}
	
	public void disableOperators()
	{
		btnDivide.setDisable(true);
		btnMultiply.setDisable(true);
		btnSubtract.setDisable(true);
		btnAdd.setDisable(true);
		btnEquals.setDisable(true);
		
	}
	
	public void enableOperators()
	{
		btnDivide.setDisable(false);
		btnMultiply.setDisable(false);
		btnSubtract.setDisable(false);
		btnAdd.setDisable(false);
		btnEquals.setDisable(false);
	}
	

	
	final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>()
	{
		
		@Override
		public void handle(ActionEvent e)
		{
			Button btn = (Button) e.getSource();
			String num = btn.getText();
			
				
				switch(num)
				{
					case "1":
					case "2":
					case "3":
					case "4":
					case "5":
					case "6":
					case "7":
					case "8":
					case "9":
					case "0":
						insertNum(num);
						break;
					case "+":
					case "-":
					case "/":
					case "*":
						operator(num);
						break;
					case "C":
						clearScreen();
						break;
					case "=":
						equals(); // TEST
						break;
						
				}
				

			
		}

		private void equals()
		{
			String text1 = text.getText();
			
			
			String[] nums = text1.split(" ");
			
			int sum1 = Integer.parseInt(nums[0]);
			int sum2 = Integer.parseInt(nums[2]);
			Integer sum3 = 0;
			
			
			
			if (nums[1].equals("+"))				//TODO: add if statement to check
			{										// if first inout is an operator
				sum3 = sum1 + sum2;					// Add error and disable buttons 
			}										// if true.
			else if (nums[1].equals("-"))
			{
				sum3 = sum1 - sum2;
			}
			else if (nums[1].equals("/"))			// FUTURE UPDATE: add error message to TextField. disable input until screen cleared by user.
			{
				if (sum2 == 0)
				{
					text.setText("Error, cannot divide by 0");
					disableButtons();
					//System.out.println("Error, cannot divide by 0");
					return;
				}
				
				sum3 = sum1 / sum2;
				
			}
			else if (nums[1].equals("*"))
			{
				sum3 = sum1 * sum2;
			}
			
			// Solve

			for (int i = 3; i < nums.length; i++)
			{
				if (nums[i].equals("+"))
				{
					sum3 += Integer.parseInt(nums[i + 1]);
					i += 1;
					continue;
				}
				else if (nums[i].equals("-"))
				{
					sum3 -= Integer.parseInt(nums[i + 1]);
					i += 1;
					continue;
				}
				else if (nums[i].equals("/"))
				{
					if (Integer.parseInt(nums[i + 1]) == 0)
					{
						text.setText("Error, cannot divide by 0");
						disableButtons();
						//System.out.println("Error, cannot divide by 0");
						answerOutput.setText("");
						return;
					}
					sum3 /= Integer.parseInt(nums[i + 1]);
					i += 1;
					continue;
				}
				else if (nums[i].equals("*"))
				{
					sum3 *= Integer.parseInt(nums[i + 1]);
					i += 1;
					continue;
				}
			
			}
			//System.out.println(sum3);
			answerOutput.setText(sum3.toString());
			
		}
	
	};
	
	

	
	@Override
	public void start(Stage primaryStage)
	{
		try {
			
			
			
			// NAME ANIMATION - START
			Pane canvas = new Pane();
			
			// For background color
//			Random random = new Random();
//			int red = random.nextInt(255);
//			int blue = random.nextInt(255);
//			int green = random.nextInt(255);
			Rectangle color = new Rectangle();
//			color.setFill(Color.rgb(red, blue, green));
			color.setFill(Color.GREY);
			
			canvas.getChildren().add(color);
			
			// Disable operators for first input
			disableOperators();
			
			
			//btnNumbers.getChildren().add(one);
			//canvas.getChildren().add(btnNumbers);
			// For Background Fading
			FadeTransition fadeTran = new FadeTransition(Duration.millis(4000), color);
			fadeTran.setFromValue(1.0f);
			fadeTran.setToValue(0.1f);
			fadeTran.setCycleCount(Timeline.INDEFINITE);
			fadeTran.setAutoReverse(true);
			fadeTran.play();
			
			
			
			
			
			
			// LABEL 
			Label label = new Label("Devin");
			label.setTextFill(Color.BLUE);
			label.relocate(100, 100);
			label.setFont(Font.font(25));
			
			canvas.getChildren().add(label);
			
			
			
			final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>()
			{
				double deltaX = 2;
				double deltaY = 2;

				@Override
				public void handle(final ActionEvent t) 
				{
					
					
					label.setLayoutX(label.getLayoutX() + deltaX);
					label.setLayoutY(label.getLayoutY() + deltaY);
					
					final Bounds bounds = canvas.getBoundsInLocal();
					final boolean atRightBorder = label.getLayoutX() >= (bounds.getMaxX() - label.getWidth());
					final boolean atLeftBorder = label.getLayoutX() <= (bounds.getMinX());// FIXME: Not bouncing off border
					final boolean atBottomBorder = label.getLayoutY() >= (bounds.getMaxY() - label.getHeight());
					final boolean atTopBorder = label.getLayoutY() <= (bounds.getMinY());// FIXME: Not bouncing off border
	
				
					
					if (atRightBorder || atLeftBorder)
					{
						deltaX *= -1;
						
					}
					if (atBottomBorder || atTopBorder)
					{
						deltaY *= -1;
						
					}
					
					
				}		
		
		
			})); // NAME ANIMATION - END
			
//			// For TextField
//			TextField screen = new TextField();
//			screen.setAlignment(Pos.TOP_CENTER);
//			screen.setStyle("-fx-background-color: blue;");
//			screen.setEditable(false);
			
			// Screen
			Rectangle screen = new Rectangle(250, 100);
			screen.setFill(Color.WHITE);
			screen.setArcHeight(5);
			screen.setArcWidth(5);
			screen.setLayoutX(12);
			screen.setLayoutY(25);
						
			canvas.getChildren().add(screen);
			
			// Label for input on screen
			answerOutput.setFont(Font.font(22));
			answerOutput.setLayoutX(190);
			answerOutput.setLayoutY(97);
	
			canvas.getChildren().add(answerOutput);
			
			// TEXTFIELD TEST
			text.setPrefHeight(50);
			text.setPrefWidth(200);
			text.setLayoutX(38);
			text.setLayoutY(50);
			text.setEditable(false);
			
			canvas.getChildren().add(text);
		
			
			
			// For Calculator buttons
			TilePane tilePane = new TilePane();
//			Button btn0 = new Button("0");
//			btn0.setPrefSize(50, 50);
//			Button btn1 = new Button("1");
//			btn1.setPrefSize(50, 50);
//			Button btn2 = new Button("2");
//			btn2.setPrefSize(50, 50);
//			Button btn3 = new Button("3");
//			btn3.setPrefSize(50, 50);
//			Button btn4 = new Button("4");
//			btn4.setPrefSize(50, 50);
//			Button btn5 = new Button("5");
//			btn5.setPrefSize(50, 50);
//			Button btn6 = new Button("6");
//			btn6.setPrefSize(50, 50);
//			Button btn7 = new Button("7");
//			btn7.setPrefSize(50, 50);
//			Button btn8 = new Button("8");
//			btn8.setPrefSize(50, 50);
//			Button btn9 = new Button("9");
//			btn9.setPrefSize(50, 50);
//			Button btnDivide = new Button("/");
//			btnDivide.setPrefSize(50, 50);
//			Button btnMultiply = new Button("*");
//			btnMultiply.setPrefSize(50, 50);
//			Button btnSubtract = new Button("-");
//			btnSubtract.setPrefSize(50, 50);
//			Button btnAdd = new Button("+");
//			btnAdd.setPrefSize(50, 50);
//			Button btnEquals = new Button("=");
//			btnEquals.setPrefSize(50, 50);
//			Button btnClear = new Button("C");
//			btnClear.setPrefSize(50, 50);
			btn0.setPrefSize(50, 50);
			btn1.setPrefSize(50, 50);
			btn2.setPrefSize(50, 50);
			btn3.setPrefSize(50, 50);
			btn4.setPrefSize(50, 50);
			btn5.setPrefSize(50, 50);
			btn6.setPrefSize(50, 50);
			btn7.setPrefSize(50, 50);
			btn8.setPrefSize(50, 50);
			btn9.setPrefSize(50, 50);
			btnDivide.setPrefSize(50, 50);
			btnMultiply.setPrefSize(50, 50);
			btnSubtract.setPrefSize(50, 50);
			btnAdd.setPrefSize(50, 50);
			btnEquals.setPrefSize(50, 50);
			btnClear.setPrefSize(50, 50);
			btn0.setOnAction(myHandler);
			btn1.setOnAction(myHandler);
			btn2.setOnAction(myHandler);
			btn3.setOnAction(myHandler);
			btn4.setOnAction(myHandler);
			btn5.setOnAction(myHandler);
			btn6.setOnAction(myHandler);
			btn7.setOnAction(myHandler);
			btn8.setOnAction(myHandler);
			btn9.setOnAction(myHandler);
			btnDivide.setOnAction(myHandler);
			btnMultiply.setOnAction(myHandler);
			btnSubtract.setOnAction(myHandler);
			btnAdd.setOnAction(myHandler);
			btnEquals.setOnAction(myHandler);
			btnClear.setOnAction(myHandler);
			
			tilePane.getChildren().addAll(btn0, btn1, btn2, btnDivide, btn3, btn4, btn5);
			tilePane.getChildren().addAll(btnMultiply, btn6, btn7, btn8, btnSubtract);
			tilePane.getChildren().addAll(btn9, btnClear, btnEquals, btnAdd);
			
			canvas.getChildren().add(tilePane);
			
			
			
			
			tilePane.setVgap(7);
			tilePane.setHgap(10);
			tilePane.setPrefColumns(4);
			tilePane.setPrefRows(4);
			tilePane.setLayoutX(25);
			tilePane.setLayoutY(225);
			
			
		
			
			loop.setCycleCount(Timeline.INDEFINITE);
			loop.play();
			Scene scene = new Scene(canvas, 275, 450);	
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Calculator");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
			
			color.heightProperty().bind(canvas.heightProperty());
			color.widthProperty().bind(canvas.widthProperty());
			
			
			
			
			
			
			
			
			
			
			
			
	
			
		} catch(Exception e) 
			{
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
}
