//package javaFinalProject;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class AttendanceReadWrite {
//
//	public static void writeCourseToFile(String folderName,String fileName,Course course)
//    {
//        File dataDir = new File(folderName);
//
//        if(!dataDir.exists())
//            dataDir.mkdir();
//
//        File CoursesFile = new File(folderName+"\\"+fileName+".csv");
//
//
//        try {
//        	PrintWriter output = new PrintWriter(new FileOutputStream(CoursesFile, true));
//            	output.append(course.getcourseId()+","
//            			+course.getName()+","+
//            			course.getCFCIG()+","+course.getSize()+","+course.getCreditSize()+","+course.getNbStudents()+","
//            			+course.getStudentsArray()+","+course.getGradesArray()+","+course.getAttendanceArray()+","+course.getInstructor()+"\n");
//            output.close();
//
//        } catch (FileNotFoundException e) {
//        	System.out.println("Error: "+e.getMessage());
//        }
//
//    }
//    
//    public static ArrayList<String> readCourseIDFromFile(String folderName,String fileName)
//    {
//        ArrayList <String> courses = new ArrayList<String>();
//
//        File CoursesFile = new File(folderName+"\\"+fileName+".csv");
//
//        if(!CoursesFile.exists())
//            return null;
//
//        try {
//            Scanner input = new Scanner(CoursesFile);
//
//            while(input.hasNext())
//            {
//                //String[] values = input.nextLine().split(",");
//            	courses.add(input.nextLine());
//                
//
//            }
//
//            input.close();
//            return courses;
//
//        } catch (FileNotFoundException e) {
//        	return null;
//        }
//    }
//}
