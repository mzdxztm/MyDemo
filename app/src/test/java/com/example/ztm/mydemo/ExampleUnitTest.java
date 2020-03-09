package com.example.ztm.mydemo;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    /**
     * 返回首字母
     */
    public static String getPYIndexStr(String strChinese, boolean bUpCase) {
        try {
            StringBuffer buffer = new StringBuffer();
            strChinese = strChinese.replace("（", "").replace("）", "");// 特殊符号处理
            byte b[] = strChinese.getBytes("GBK");// 把中文转化成byte数组
            for (int i = 0; i < b.length; i++) {
                if ((b[i] & 255) > 128) {
                    int char1 = b[i++] & 255;
                    char1 <<= 8;
                    // 左移运算符用“<<”表示，是将运算符左边的对象，向左移动运算符右边指定的位数，并且在低位补零。其实，向左移n位，就相当于乘上2的n次方
                    int chart = char1 + (b[i] & 255);
                    buffer.append(getPYIndexChar((char) chart, bUpCase));
                    continue;
                }
                char c = (char) b[i];
                if (!Character.isJavaIdentifierPart(c))// 确定指定字符是否可以是 Java // 标识符中首字符以外的部分。
                    c = 'A';
                buffer.append(c);
            }
            return buffer.toString();
        } catch (Exception e) {
            System.out.println((new StringBuilder()).append("\u53D6\u4E2D\u6587\u62FC\u97F3\u6709\u9519").append(e.getMessage()).toString());
        }
        return null;
    }

    /**
     * 得到首字母
     */
    private static char getPYIndexChar(char strChinese, boolean bUpCase) {
        int charGBK = strChinese;
        char result;
        if (charGBK >= 45217 && charGBK <= 45252) result = 'A';
        else if (charGBK >= 45253 && charGBK <= 45760) result = 'B';
        else if (charGBK >= 45761 && charGBK <= 46317) result = 'C';
        else if (charGBK >= 46318 && charGBK <= 46825) result = 'D';
        else if (charGBK >= 46826 && charGBK <= 47009) result = 'E';
        else if (charGBK >= 47010 && charGBK <= 47296) result = 'F';
        else if (charGBK >= 47297 && charGBK <= 47613) result = 'G';
        else if (charGBK >= 47614 && charGBK <= 48118) result = 'H';
        else if (charGBK >= 48119 && charGBK <= 49061) result = 'J';
        else if (charGBK >= 49062 && charGBK <= 49323) result = 'K';
        else if (charGBK >= 49324 && charGBK <= 49895) result = 'L';
        else if (charGBK >= 49896 && charGBK <= 50370) result = 'M';
        else if (charGBK >= 50371 && charGBK <= 50613) result = 'N';
        else if (charGBK >= 50614 && charGBK <= 50621) result = 'O';
        else if (charGBK >= 50622 && charGBK <= 50905) result = 'P';
        else if (charGBK >= 50906 && charGBK <= 51386) result = 'Q';
        else if (charGBK >= 51387 && charGBK <= 51445) result = 'R';
        else if (charGBK >= 51446 && charGBK <= 52217) result = 'S';
        else if (charGBK >= 52218 && charGBK <= 52697) result = 'T';
        else if (charGBK >= 52698 && charGBK <= 52979) result = 'W';
        else if (charGBK >= 52980 && charGBK <= 53688) result = 'X';
        else if (charGBK >= 53689 && charGBK <= 54480) result = 'Y';
        else if (charGBK >= 54481 && charGBK <= 55289) result = 'Z';
        else result = (char) (65 + (new Random()).nextInt(25));
        if (!bUpCase) result = Character.toLowerCase(result);
        return result;
    }

    @Test
    public void myTest() {
      /*  String str = "是谁if90地方";
        System.out.println("中文首字母：" + getPYIndexStr(str, true));*/
        String inFile = "C:\\Users\\ztm\\Desktop\\仙帝归来.txt";
        String outFile = "C:\\Users\\ztm\\Desktop\\仙帝归来2.txt";
        xiaoshou(inFile, outFile);
    }


    public static boolean isChinese(char c) {
        if (c >= 0x4e00 && c <= 0x9fa5) {
            return true;
        }
        return false;
    }

    public void xiaoshou(String inFilePath, String outFilePath) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inFilePath)));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFilePath)));
            String oneLineContent = "";
            while ((oneLineContent = in.readLine()) != null) {
//                if (oneLineContent.equals("")) oneLineContent = "\n";
                if (oneLineContent.contains("0") && oneLineContent.contains("章")) {
                    oneLineContent = "第" + oneLineContent.trim();
                } else {
                    oneLineContent = oneLineContent.trim();
                }
                out.write(oneLineContent);
                out.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}