package org.sonatype.bmi;

/**
 * This is a BMI calculator. (Program appearance and implementation - BMIJFrame.java | Test - BmiCalcTest.java)
 * @author Adrián Balázs
 * @version 1.0
 */
public class BmiCalculator {
	private int age;
	private double height;
	private double weight;
	private double metricResult;
	
	/**
	 * This return the current age of the person
	 * @return this person's age
	 */
	public int getAge(){  //változó lekérdezés
		return age;
	}
	
	/**
	* This return the current height of the person
	* @return this person's height
	*/
	public double getHeight(){
		return height;
	}
	
	/**
	* This return the current weight of the person
	* @return this person's weight
	*/
	public double getWeight(){
		return weight;
	}
	
	/**
	* This return the current BmiResult of the person.
	* @return this person's BmiResult
	*/
	public double getMetricResult(){
		return metricResult;
	}
	
	/**
	 * Sets the age of this person to 'age'
	 * @param age the age to set
	 */
	public void setAge(int age){
		this.age=age;  //külső age-emnek adom a belsőt (osztályszintű változónak a paraméteres age-t)
	}
	
	/**
	 * Sets the height of this person to 'height'
	 * @param height the height to set
	 */
	public void setHeight(double height){
		this.height=height;
	}
	
	/**
	 * Sets the weight of this person to 'weight'
	 * @param weight the weight to set
	 */
	public void setWeight(double weight){
		this.weight=weight;
	}
	
	/**
	 * Sets the result of bmi to 'metricResult'
	 * @param metricResult the result to set
	 */
	public void setMetricResult(double metricResult){
		this.metricResult=metricResult;
	}
	
	/**
	 * This contructors a car with a specified age, height, weight.
	 * @param age the age of the person
	 * @param height the height of the person
	 * @param weight the weight of the person
	 */	
	public BmiCalculator(int age, double height, double weight){
		this.age=age;
		this.height=height;
		this.weight=weight;
	}
	
	/**
	 * This is a Bmi formula.
	 */
	public void metricBMI(){
		metricResult = ( weight / ((height/100) * (height/100)));
	}
	
	/**
	 * 
	 * @return Return a string. For example: 15 - Severe Thinness
	 */
	public String result(){
		metricBMI();  //to call a metricBMI() method /(metódushívás a metricResult kiszámításához)/
		String result="";
		double number = Math.round(metricResult * 100);
		number = number/100;
		if (age>20){ //the age of person is greater than 20
			if (metricResult < 16){
				result = "Severe Thinness";
			} 
			else if (metricResult>=16 && metricResult<17){
				result = "Moderate Thinness";
			}
			else if (metricResult>=17 && metricResult<18.5){
				result = "Mild Thinness" ;
			}
			else if (metricResult>=18.5 && metricResult<25){
				result = "Normal" ;
			}
			else if (metricResult>=25 && metricResult<30){
				result = "Overweight" ;
			}
			else if (metricResult>=30 && metricResult<35){
				result = "Obese Class" ;
			}
			else if (metricResult>=35 && metricResult<40){
				result = "Obese Class II" ;
			}
			else if (metricResult>=40){
				result = "Obese Class III" ;
			}
		}
		else if(age>=2 && age<=20){ //the age of person is greater than or equal to 2 and less than or equal to 20
			if (metricResult < 5){
				result = "Underweight";
			} 
			else if(metricResult >= 5 && metricResult <85){
				result= "Healthy weight";
			}
			else if(metricResult >= 85 && metricResult <95){
				result= "At risk of overweight";
			}
			else if(metricResult >95){
				result= "Overweight";
			}
		}
			
		return number + " -> " + result;
	}
	
	/**
	 * convert meters to centimeters
	 */
	public void meterToCentimeter(){
		height= height*100;
	}
	
	/**
	 * convert inches to centimeters
	 */
	public void inchToCentimeter(){
		height= height*2.54;
	}
	
	/**
	 * convert pounds to kilograms
	 */
	public void poundsToKilogram(){
		weight=weight*0.453592;
	}
	
}
