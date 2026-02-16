import java.util.ArrayList;

public class student{
	public static void main(String[] args){
		studentClass s1 = new studentClass();
		s1.setClassGrade(0, 95);
		s1.setName("Joseph");
		System.out.println(s1);
		studentClass s2 = new studentClass(new int[]{80, 90, 85}, new String[]{"Math", "Art", "Science"}, "Lily", 13, true);
		System.out.println(s2);
	}

}

class studentClass{
	private ArrayList <Integer> grades = new ArrayList<>();
	private ArrayList <String> classes = new ArrayList<>();
	private String name;
	private int age;
	private boolean smart;

	//constructors
	public studentClass(){
		this(new int[]{0}, new String[]{"Class"}, "Name", 0, false);
	}

	public studentClass(int[] myGrades, String[] myClasses, String myName, int myAge, boolean mySmart){
		name = myName;
		setGrades(myGrades);
		setClasses(myClasses);
		age = myAge;
		smart = mySmart;
	}

	public studentClass(studentClass s){
		name = s.getName();
		grades = new ArrayList<>(s.getGrades());
		classes = new ArrayList<>(s.getClasses());
		age = s.getAge();
		smart = s.isSmart();
	}

	//getters
	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public boolean isSmart(){
		return smart;
	}

	public ArrayList<Integer> getGrades(){
		return grades;
	}

	public ArrayList<String> getClasses(){
		return classes;
	}


	//setters
	public void setName(String newName){
		name = newName;
	}
	public void setAge(int newAge){
		age = newAge;
	}
	public void setSmart(boolean newSmart){
		smart = newSmart;
	}

	public void addClass(String className, int classGrade){
		classes.add(className);
		grades.add(classGrade);
	}

	public void setClassGrade(int classIndex, int classGrade){
		grades.set(classIndex, classGrade);
	}

	public void setClassGrade(String className, int classGrade){
		int classIndex = classes.indexOf(className);
		grades.set(classIndex, classGrade);
	}
	public void setGrades(int[] newGrades){
		grades.clear();
		for (int i = 0; i < newGrades.length; i++){
			grades.add(newGrades[i]);
		}
		
	}
	public void setClasses(String[] newClasses){
		classes.clear();
		for (int i = 0; i < newClasses.length; i++){
			classes.add(newClasses[i]);
		}

	}
	//to string
	public String toString(){
		String part1 = "\nHello, my name is " + name + " and I am " + age + " years old. ";
		String part2;
		if (smart){part2 = "Some may say I'm intelligent. \n";}
		else{part2 = "I'm not the sharpest tool in the shed. \n";}
		String part3 = "Here are my classes and their corresponding grades: \n ";
		String part4 = compileGrades(grades, classes);
		return part1 + part2 + part3 + part4;
	}

	public String compileGrades(ArrayList <Integer> myGrades, ArrayList <String> myClasses){
		float gradeAvg = 0;
		String gradeList = "\n";
		for (int i = 0; i < myGrades.size(); i++){
			gradeAvg += myGrades.get(i);
			gradeList += myClasses.get(i) + ": \t" + myGrades.get(i) + "\n";
		}
		gradeAvg = gradeAvg/myGrades.size();
		gradeList += "My grade average is " + gradeAvg;
		return gradeList;
	}

}