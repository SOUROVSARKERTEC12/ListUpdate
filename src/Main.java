import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("1. Show all student ");
        System.out.println("2. Show random student");
        System.out.println("3. Show number of students");
        System.out.println("4. Add a student");
        System.out.println("5. Find a student");
        System.out.println("Enter Option (1-5):");

        Scanner scanner = new Scanner(System.in);

        int Option = scanner.nextInt();

        if (Option == 1) {
            File file = new File(Constants.TEXT_FILE_NAME);
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println("Exception" + e.toString());
                e.printStackTrace();
            }
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                System.out.println(st);

            }
        } else if (Option == 2) {
            int count = getNumberOfStdents();

            File file = new File(Constants.TEXT_FILE_NAME);
            BufferedReader bufferedReader = null;

            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception e) {
                System.out.println("Exception :" + e.toString());
            }

            String[] ids = new String[count];

            int i = 0;

            String string;

            while ((string = bufferedReader.readLine()) != null) {
                if (string.equals("")) {
                    continue;
                }
                ids[i] = string;
                i++;
            }

            int randNumber = randInt(0, ids.length - 1);

            System.out.println("Random Students :" + ids[randNumber]);
        } else if (Option == 3) {
            File file = new File("C:\\Users\\TEC\\Desktop\\JavaStudent_list\\src\\Student.txt");
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println("Exception" + e.toString());
                e.printStackTrace();
            }
            String st;
            int count = 0;
            while ((st = bufferedReader.readLine()) != null) {
                count++;

            }
            System.out.println("Number of Students" + count);
        } else if (Option == 4) {

            FileWriter fileWriter = new FileWriter(Constants.TEXT_FILE_NAME, true);

            System.out.print("Enter your new student name :");
            String addst = scanner.next();

            fileWriter.write("\n" + addst);
            fileWriter.close();

            System.out.println("Student Added");

        } else if (Option == 5) {
            File file = new File("C:\\Users\\TEC\\Desktop\\JavaStudent_list\\src\\Student.txt");
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println("Exception" + e.toString());
                e.printStackTrace();
            }

            System.out.print("Enter Identity :");
            String checkst = scanner.next();
            String st;
            int flag = 0;
            while ((st = bufferedReader.readLine()) != null) {
                if (st.equals(checkst)) {
                    flag++;
                }
            }
            if (flag == 0)
                System.out.println("Not found");
            else {
                System.out.println("Found");
            }


        }
    }

    public static int randInt(int min, int max){
        Random random = new Random();
        int randomNum = random.nextInt((max - min)+1)+min;

        return randomNum;
    }

    public static int getNumberOfStdents() throws IOException{
        File file = new File(Constants.TEXT_FILE_NAME);
        BufferedReader bufferedReader = null;

        try{
            bufferedReader = new BufferedReader(new FileReader(file));
        }
        catch (Exception e){
            System.out.println("Exception "+e.toString());
        }

        String string;

        int count =0;

        while((string = bufferedReader.readLine())!=null){
            if(string.equals("")){
                continue;
            }
            count ++;
        }
        return count;
    }
}


   /* public static void file()throws Exception{
        File file = new File("C:\\Users\\TEC\\Desktop\\JavaStudent_list\\src\\Student.txt");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("Exception"+e.toString());
            e.printStackTrace();
        }
        String st;
        while ((st = bufferedReader.readLine())!= null){
            System.out.println(st);

        }
}*/
