package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MainController {
	@FXML
	private Label result;
	
	private float number1=0;
	
	private float number2=0;
	
	private String operator="";
	
	private boolean start=true;
	
	private Calclulate calculate=new Calclulate();
	
	@FXML
	public void processNumber(ActionEvent event){
		if(start){
			result.setText("");
			start=false;
		}
		String value=((Button)event.getSource()).getText();
		result.setText(result.getText()+ value);
	}
	
	@FXML
	public void processBinaryOperator(ActionEvent event) {
		String value=((Button)event.getSource()).getText();
		if(!value.equals("=")){
			if(!operator.isEmpty())
				return;
			
			operator = value;
			number1=Float.parseFloat(result.getText());			
			result.setText("");
		}else{
			if(operator.isEmpty())
				return;
			
			number2=Float.parseFloat(result.getText());
			float output=calculate.calculateBinaryNumber(number1, number2, operator);
			result.setText(String.valueOf(output));
			operator="";
		}
	}
	public void processUnaryOperator(ActionEvent event) {
	
		String value=((Button)event.getSource()).getText();
		System.out.println("hello"+value);
		if(!operator.isEmpty())
			return;
		
		operator = value;
		number1=Float.parseFloat(result.getText());	
		result.setText("");
		
		float output=calculate.calculateUnaryNumber(number1,operator);
		result.setText(String.valueOf(output));
		System.out.println(output);
		operator="";
	}
	
	public void ClearFunction(ActionEvent event){
		operator="";
		start=true;
		result.setText("");
	}
}
