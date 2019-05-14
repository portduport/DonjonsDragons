import java.util.Scanner;

public class Questions {

    private String insert;
    private int num;

    public void questions (String asking){
        Scanner question = new Scanner(System.in);
        System.out.println(asking);
        insert = question.nextLine();
    }

    public void intQuestions (String asking){
        Scanner question = new Scanner(System.in);
        System.out.println(asking);
        num = question.nextInt();
    }




    // We will create the SETTERS

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public void setNum(int num) {
        this.num = num;
    }

    // We will create the GETTERS


    public String getInsert() {
        return insert;
    }

    public int getNum() {
        return num;
    }
}

