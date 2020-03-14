import java.lang.reflect.Array;
import java.util.Arrays;

public class Pokers {

    public static int JudgePokerType(String Cards){
        //判断扑克牌组属于以下哪种牌型：
        /*
         * 0：散牌
         * 1：对子
         * 2：两对
         * 3：三条
         * 4：顺子
         * 5：同花
         * 6：葫芦
         * 7：铁支
         * 8：同花顺 */
        int type = 0;
        if (IsFlush(Cards) && IsStraight(Cards))
            type = 8;
        else if (JudgeSameNum(Cards) == 4)
            type = 7;
        else if (JudgeSameNum(Cards) == 3 && JudgeDouNum(Cards) == 1)
            type = 6;
        else if (IsFlush(Cards))
            type = 5;
        else if (IsStraight(Cards))
            type = 4;
        else if (JudgeSameNum(Cards) == 3)
            type = 3;
        else if (JudgeDouNum(Cards) == 2)
            type = 2;
        else if (JudgeDouNum(Cards) == 1)
            type = 1;
        return type;
    }
    //判断是否为同花
    public static boolean IsFlush(String Cards){
        char[] color = GetColor(Cards);
        for(int i = 0 ; i<5 ; i++){
            if(color[i] != color[0]){
                return false;
            }
        }
        return true;
    }
    //判断是否为顺子
    public static String Straight = "23456789TJQKA";
    public static boolean IsStraight(String Cards){
        String num = new String(GetValue(Cards));
        if(Straight.contains(num))
            return true;
        return false;
    }
    //判断含有相同大小数字的个数
    public static int JudgeSameNum(String Cards){
        int SameNum = 1;
        char[] values = GetValue(Cards);
        int i = 0;
        int num = 1;
        for (int j = i + 1; j < 5; j++){
            if (values[j] == values[i]){
                num++;
                if (num > SameNum)
                    SameNum = num;
            }
            else {
                i = j;
                num = 1;
            }
        }
        return SameNum;
    }
    //判断含有几个对子
    public static int JudgeDouNum(String Cards){
        int SameNum = 1;
        char[] values = GetValue(Cards);
        int i = 0;
        int DouNum = 0;
        for(int j = i + 1; j < 5; j++){
            if(values[i] == values[j]){
                SameNum++;
                if(SameNum == 2)
                    DouNum++;
                else if (SameNum == 3)
                    DouNum--;
            }
            else {
                i = j;
                SameNum = 1;
            }
        }
        return DouNum;
    }
    //获取扑克牌的花色
    public static char[] GetColor(String Cards){
        char[] color = new char[5];
        for(int i = 1; i < 15; i += 3){
            for(int j = 0; j < 5 ;j++){
                color[j] = Cards.charAt(i);
            }
        }
        return color;
    }
    //获取扑克牌的大小
    public static char[] GetValue(String Cards){
        char[] num = new char[5];
        for(int i = 0; i < 15; i += 3){
            for(int j = 0; j < 5 ;j++){
                num[j] = Cards.charAt(i);
            }
        }
        num = NumSort(num);
        return num;
    }
    //由大到小对扑克牌排序
    public static char[] NumSort(char[] num) {
        char temp;
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length; j++) {
                if (num[i] < num[j]) {
                    temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }
        return num;
    }
    //找到相应数量的最大的牌
    public static char FindBiggest(int kind, String Cards){
        char biggest = ' ';
        char[] values = GetValue(Cards);
        int i = values.length - 1;
        if (i == 0)
            return values[0];
        int num = 1;
        for (int j = i - 1; j >= 0; j--){
            if (values[j] == values[i]){
                num++;
            }
            if (num == kind) {
                biggest = values[i];
                break;
            }
            else
                i = j;
        }
        return biggest;
    }
    //删除相指定的牌
    public static String DropBiggest(char card, String Cards){
        String drop = "";
        for (int i = 0; i < Cards.length(); i++){
            if (Cards.charAt(i) != card)
                drop += Cards.charAt(i);
            else
                i += 2;
        }
        return drop;
    }
    //比较单牌大小
    public static String CompareBiggest0(String Black, String White){

        int winner;
        char black, white;//最大牌面
        while(Black != "" && White != ""){
            black = FindBiggest(1, Black);
            white = FindBiggest(1, White);
            winner = ComparePokers(black, white);
            if (winner == 1)
                return "Black wins";
            else if (winner == 2)
                return "White wins";
            Black = DropBiggest(black, Black);
            White = DropBiggest(white, White);
        }
        return "Tie";
    }
    //比较对子大小
    public static String CompareBiggest1(int type, String Black, String White){

        int winner;
        char black = FindBiggest(2, Black), white = FindBiggest(2, White);
        winner = ComparePokers(black, white);
        if (winner == 1)
            return "Black wins";
        else if (winner == 2)
            return "White wins";
        else {
            Black = DropBiggest(black, Black);
            White = DropBiggest(white, White);
            if (type == 2){
                black = FindBiggest(2, Black);
                white = FindBiggest(2, White);
                winner = ComparePokers(black, white);
                if (winner == 1)
                    return "Black wins";
                else if (winner == 2)
                    return "White wins";
                Black = DropBiggest(black, Black);
                White = DropBiggest(white, White);
            }
            return CompareBiggest0(Black, White);
        }
    }
    //比较大于2张重复牌及顺子的大小
    public static String CompareBiggest2(int kind, String Black, String White){

        int winner = ComparePokers(FindBiggest(kind, Black), FindBiggest(kind, White));
        if (winner == 1)
            return "Black wins";
        else if (winner == 2)
            return "White wins";
        else
            return "Tie";
    }

    public static int ComparePokers(char black, char white){
        //0:平 1:黑胜 2:白胜
        int B = Straight.indexOf(black), W = Straight.indexOf(white);
        if (B > W)
            return 1;
        else if (B < W)
            return 2;
        else
            return 0;
    }
    public static String GetWinner(String Black,String White){
        int black = JudgePokerType(Black),white = JudgePokerType(White);
        if (black > white)
            return "Black wins";
        else if (black < white)
            return "White wins";
        else{
            if (black == 0 || black == 5){
                //散牌和同花
                return CompareBiggest0(Black, White);
            }
            else if (black == 1 || black == 2){
                //对子和两对
                return CompareBiggest1(black, Black, White);
            }
            else if (black == 3 || black == 6){
                //三条和葫芦
                return CompareBiggest2(3, Black, White);
            }
            else if (black == 7){
                //铁支
                return CompareBiggest2(4, Black, White);
            }
            else {
                //顺子和同花顺
                return CompareBiggest2(1, Black, White);
            }
        }
    }
}
