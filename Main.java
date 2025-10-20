
public class Main{
    public static void main(String[] args){
        int count = 0;

        char[][] telephone = {{'1','2','3'},
                            {'4','5','6'},
                            {'7','8','9'},
                            {'*','0','#'}};

        for (char[] rows : telephone){
            count++;
            System.out.print("Row #" + count +": ");
            for(char numbers : rows){
                
                System.out.print(numbers);
            }
            
            System.out.println();
        }



    }
}