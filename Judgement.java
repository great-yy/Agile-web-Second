import java.util.Scanner;
//采用TDD，编写程序
public class Judgement {
    public static void main(String[] args) {
        Judgement.InputCard();//输入扑克牌组

    }
    public static void InputCard(){
        //输入两组扑克牌
  /*      String a[] = null;
        System.out.println("请依次输入一组扑克牌(Black)：");
        for(int i=0;i<5;i++){
            Scanner sc1 = new Scanner(System.in);
            String str1 = sc1.nextLine();
            a[i] = str1;
        }
        System.out.println("Black的牌为：");
        for (int i=0;i<5;i++){
            System.out.println(a[i]);
        }*/
        //扑克牌组1
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入一组扑克牌(Black)：");
        String str1 = sc1.nextLine();
        System.out.println("Black的牌为：" + str1);

        char c[] = null;
        int n[] = null;

        for(int i=0;i<str1.length();i++) {
            //获取花色
            if(str1.charAt(i) == 'D' ){
                c[i] = 'D';
            }
            if(str1.charAt(i) == 'S' ){
                c[i] = 'S';
            }
            if(str1.charAt(i) == 'H' ){
                c[i] = 'H';
            }
            if(str1.charAt(i) == 'C' ){
                c[i] = 'C';
            }
            //获取数字大小
            if(str1.charAt(i) == 'A' ){
                n[i] = 14;
            }
            if(str1.charAt(i) == 'K' ){
                n[i] = 13;
            }
            if(str1.charAt(i) == 'Q' ){
                n[i] = 12;
            }
            if(str1.charAt(i) == 'J' ){
                n[i] = 11;
            }
            if(str1.charAt(i) == 'T' ){
                n[i] = 10;
            }
            if(str1.charAt(i)>= '0' || str1.charAt(i) <= '9'){
                n[i] = str1.charAt(i);
            }

        }
        System.out.println("Black的花色为：");
        for(int i=0;i<str1.length();i++){
            System.out.println(c[i]);
        }
        //扑克牌组2
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入一组扑克牌(White)：");
        String str2 = sc2.nextLine();
        System.out.println("White的牌为：" + str2);


    }
}
