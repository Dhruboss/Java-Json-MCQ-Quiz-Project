import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonAssignment {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner MyObj = new Scanner(System.in);
        System.out.println("1. Add Quiz\n" +
                "2. Start Quiz");

        int firstOption = MyObj.nextInt();

        String optionA= "Option a";
        String optionB= "Option b";
        String optionC= "Option c";
        String optionD= "Option d";
        String question= "Question";
        String answer= "Answer";

        String fileName="./src/main/resources/MCQlist.json";
        char ch;
        if (firstOption==1){
            do{
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(new FileReader(fileName));
                JSONArray jsonArray = (JSONArray) obj;

                JSONObject mcqObj = new JSONObject();
                Scanner sc = new Scanner(System.in);

                System.out.println(question+" :");
                String questionInput = sc.nextLine();
                System.out.println(optionA+" :");
                String optionAInput = sc.nextLine();
                System.out.println(optionB+" :");
                String optionBInput = sc.nextLine();
                System.out.println(optionC+" :");
                String optionCInput = sc.nextLine();
                System.out.println(optionD+" :");
                String optionDInput = sc.nextLine();
                System.out.println(answer+" :");
                String answerInput = sc.nextLine();


                mcqObj.put(question,questionInput);
                mcqObj.put(optionA,optionAInput);
                mcqObj.put(optionB,optionBInput);
                mcqObj.put(optionC,optionCInput);
                mcqObj.put(optionD,optionDInput);
                mcqObj.put(answer,answerInput);

                jsonArray.add(mcqObj);
                System.out.print(jsonArray);
                FileWriter file = new FileWriter(fileName);
                file.write(jsonArray.toJSONString());
                file.flush();
                System.out.println("Saved!");


                System.out.println("If you want to continue press y if not press q");
                Scanner sch = new Scanner(System.in);
                ch=sch.next().charAt(0);
            }while(ch!='q');

        }
        if (firstOption==2){
            int max = 14;
            int min =0;
            int marks=0;
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) obj;
            for (int i=0 ; i<5 ; i++){

                double rand = Math.random()*(max-min+1)+min;
                int randnumb= (int)Math.floor(rand);

                JSONObject quesObj = (JSONObject) jsonArray.get(randnumb);
                String ques = (String) quesObj.get("Question");
                String a = (String) quesObj.get("Option a");
                String b = (String) quesObj.get("Option b");
                String c = (String) quesObj.get("Option c");
                String d = (String) quesObj.get("Option d");
                String ans = (String) quesObj.get("Answer");

                System.out.println(ques);
                System.out.println("a) "+a);
                System.out.println("b) "+b);
                System.out.println("c) "+c);
                System.out.println("d) "+d);
                //System.out.println(ans);

                Scanner sc2 = new Scanner(System.in);
                String ansInput = sc2.nextLine();

                if (ansInput.equals(ans)){
                    System.out.println("Correct");
                    marks++;
                }
                else {
                    System.out.println("incorrect");
                }
            }
            System.out.println("You got "+marks+" out of 5");

            }

        else {
            System.out.println("Wrong Input");
        }


    }
}
