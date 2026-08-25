//package javaFinalProject;
//
//
//import java.util.ArrayList;
//import java.util.Scanner;
//public class MainClassCSVIncomplete {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int nbQuestions;
//		Question [] questions;
//		Quiz quiz;
//		String date;
//		Midterm midterm;
//		Final finalExam;
//		ArrayList <String> loadedQuestions;
//		//loading quiz questions (if they exist)
//				loadedQuestions=FileReadWrite.readQuestionFromFile("D:\\Eclipse workspaces\\testExample","quiz_questions");
//				
//				if(loadedQuestions!=null) {
//					questions = new Question[loadedQuestions.size()];
//					for(int i=0;i<loadedQuestions.size();i++)
//						questions[i]=new Question();
//					for(int i=0;i<loadedQuestions.size();i++) {
//						questions[i].setDescription(loadedQuestions.get(i).split(",")[0]);
//						for(int j=0;j<4;j++)
//							questions[i].getAnswers()[j]=loadedQuestions.get(i).split(",")[j+1];
//						questions[i].setCorrectAnswer((Integer.parseInt(loadedQuestions.get(i).split(",")[5])));
//						}
//					nbQuestions=loadedQuestions.size();
//				}else {
//				//
//						//creating quiz
//						do {
//								System.out.println("Enter number of questions for the quiz (between 5 and 10):");
//								nbQuestions = sc.nextInt();
//								sc.nextLine();
//						}while(nbQuestions <5 ||nbQuestions >10);
//						questions = new Question[nbQuestions];
//						for(int i=0;i<nbQuestions;i++)
//							questions[i]=new Question();
//						System.out.println("Enter "+nbQuestions+" questions:");
//						for(int i=0;i<nbQuestions;i++) {
//							System.out.print("Question "+(i+1)+":\n");
//							System.out.print("Description:");
//							questions[i].setDescription(sc.nextLine());
//							System.out.println("Enter 4 answers for question "+(i+1)+":");
//							for(int j=0;j<4;j++)
//							{
//								System.out.print("Answer "+(j+1)+":");
//								questions[i].getAnswers()[j]=sc.nextLine();
//							}
//							int correctAns;
//							do {
//								System.out.print("Enter the number of the correct answer:");
//								correctAns=sc.nextInt();
//								sc.nextLine();
//							}while(correctAns<1||correctAns>4);
//							questions[i].setCorrectAnswer(correctAns-1);
//						}
//						//writing question to a file
//						for(int i=0;i<nbQuestions;i++)
//							FileReadWrite.writeQuestionToFile("D:\\Eclipse workspaces\\testExample","quiz_questions",questions[i]);
//						//
//				}
//		System.out.print("Enter quiz date:");
//		date=sc.nextLine();
//		quiz = new Quiz(date);
//		for(int i=0;i<nbQuestions;i++)
//			quiz.addQuestion(questions[i]);
//		
//	
//		loadedQuestions=FileReadWrite.readQuestionFromFile("D:\\Eclipse workspaces\\testExample","midterm_questions");
//		if(loadedQuestions!=null) {
//			questions = new Question[loadedQuestions.size()];
//			for(int i=0;i<loadedQuestions.size();i++)
//				questions[i]=new Question();
//			for(int i=0;i<loadedQuestions.size();i++) {
//				questions[i].setDescription(loadedQuestions.get(i).split(",")[0]);
//				for(int j=0;j<4;j++)
//					questions[i].getAnswers()[j]=loadedQuestions.get(i).split(",")[j+1];
//				questions[i].setCorrectAnswer((Integer.parseInt(loadedQuestions.get(i).split(",")[5])));
//				}
//			nbQuestions=loadedQuestions.size();
//		}else {
//		//
//	
//		//creating midterm
//		do {
//			System.out.println("Enter number of questions for the midterm (between 5 and 20):");
//			nbQuestions = sc.nextInt();
//			sc.nextLine();
//		}while(nbQuestions <5 ||nbQuestions >20);
//		questions = new Question[nbQuestions];
//		for(int i=0;i<nbQuestions;i++)
//			questions[i]=new Question();
//		System.out.println("Enter "+nbQuestions+" questions:");
//		for(int i=0;i<nbQuestions;i++) {
//			System.out.print("Question "+(i+1)+":\n");
//			System.out.print("Description:");
//			questions[i].setDescription(sc.nextLine());
//			System.out.println("Enter 4 answers for question "+(i+1)+":");
//			for(int j=0;j<4;j++)
//			{
//				System.out.print("Answer "+(j+1)+":");
//				questions[i].getAnswers()[j]=sc.nextLine();
//			}
//			int correctAns;
//			do {
//				System.out.print("Enter the number of the correct answer:");
//				correctAns=sc.nextInt();
//				sc.nextLine();
//			}while(correctAns<1||correctAns>4);
//			questions[i].setCorrectAnswer(correctAns-1);
//		}
//		//writing question to a file
//		for(int i=0;i<nbQuestions;i++)
//			FileReadWrite.writeQuestionToFile("D:\\Eclipse workspaces\\testExample","midterm_questions",questions[i]);
//		//
//		}
//		
//		System.out.print("Enter midterm's date:");
//		date=sc.nextLine();
//		midterm = new Midterm(date);
//		for(int i=0;i<nbQuestions;i++)
//			midterm.addQuestion(questions[i]);
//		
//		//loading final questions (if they exist)
//		loadedQuestions=FileReadWrite.readQuestionFromFile("D:\\Eclipse workspaces\\testExample","final_questions");
//		
//		if(loadedQuestions!=null) {
//			questions = new Question[loadedQuestions.size()];
//			for(int i=0;i<loadedQuestions.size();i++)
//				questions[i]=new Question();
//			for(int i=0;i<loadedQuestions.size();i++) {
//				questions[i].setDescription(loadedQuestions.get(i).split(",")[0]);
//				for(int j=0;j<4;j++)
//					questions[i].getAnswers()[j]=loadedQuestions.get(i).split(",")[j+1];
//				questions[i].setCorrectAnswer((Integer.parseInt(loadedQuestions.get(i).split(",")[5])));
//				}
//			nbQuestions=loadedQuestions.size();
//		}else {
//		//
//		
//		//creating final
//	
//		do {
//			System.out.println("Enter number of questions for the final (between 5 and 30):");
//			nbQuestions = sc.nextInt();
//			sc.nextLine();
//		}while(nbQuestions <5 ||nbQuestions >30);
//		questions = new Question[nbQuestions];
//		for(int i=0;i<nbQuestions;i++)
//			questions[i]=new Question();
//		System.out.println("Enter "+nbQuestions+" questions:");
//		for(int i=0;i<nbQuestions;i++) {
//			System.out.print("Question "+(i+1)+":\n");
//			System.out.print("Description:");
//			questions[i].setDescription(sc.nextLine());
//			System.out.println("Enter 4 answers for question "+(i+1)+":");
//			for(int j=0;j<4;j++)
//			{
//				System.out.print("Answer "+(j+1)+":");
//				questions[i].getAnswers()[j]=sc.nextLine();
//			}
//			int correctAns;
//			do {
//				System.out.print("Enter the number of the correct answer:");
//				correctAns=sc.nextInt();
//				sc.nextLine();
//			}while(correctAns<1||correctAns>4);
//			questions[i].setCorrectAnswer(correctAns-1);
//		}
//		//writing question to a file
//		for(int i=0;i<nbQuestions;i++)
//			FileReadWrite.writeQuestionToFile("D:\\Eclipse workspaces\\testExample","final_questions",questions[i]);
//		//
//		}
//		System.out.print("Enter final's date:");
//		date=sc.nextLine();
//		finalExam = new Final(date);
//		for(int i=0;i<nbQuestions;i++)
//			finalExam.addQuestion(questions[i]);
//		
//		
//		//creating Student
//		String name,id;
//		System.out.println("Creating student:");
//		System.out.print("Enter student's name:");
//		name=sc.nextLine();
//
//		System.out.print("Enter student's id:");
//		id=sc.nextLine();
//		Student st =new Student(name,id,quiz,midterm,finalExam);
//		st.performTests();
//		System.out.println("Printing tests:\nPrinting quiz:");
//		System.out.println(st.getQuiz());
//		System.out.println("Printing midterm:");
//		System.out.println(st.getMidterm());
//		System.out.println("Printing final:");
//		System.out.println(st.getFinalExam());
//		
//		System.out.println("Printing final results:\n"+st);
//		
//
//	}
//
//}
//
