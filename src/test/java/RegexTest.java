import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void testDomain(){
        // 测试带协议的域名正则
        String demo = "http://192.168.25.133/group1/M00/00/00/wKgZhVstv6eAUlDYAACD0rbF19s.imgFil";
        String urlRegStr = "^((?:http://)|(?:https://))([\\w\\._-]{4,}/)(.+)$";
        Pattern pattern = Pattern.compile(urlRegStr);
        Matcher matcher = pattern.matcher(demo);
        if (matcher.matches()){
            int groupCount = matcher.groupCount();
            for (int i = 0 ; i <= groupCount;i++){
                System.out.println("------------"+i+" :"+matcher.group(i));
            }
            System.out.println("------------ over");
        } else {
            System.out.println("------------ not match !!!");
        }
    }

    @Test
    public void testDomain2(){
        String domain = "192.168.25.133";
        String domain2 = "www.tony-bro.com";
        String reg = "^[0-9a-zA-Z]+\\.[0-9a-zA-z_-]+\\..+$";
        if (!domain.matches(reg)){
            System.out.println("1 not match");
        } else {
            System.out.println("1 match !");
        }
        if (!domain2.matches(reg)){
            System.out.println("2 not match");
        } else {
            System.out.println("2 match !");
        }
    }

    @Test
    public void testReplace(){
        String content = "<p><br/></p><p><img src=\"http://192.168.25.133/group1/M00/00/00/wKgZhVtd5GCAUVVrAAFNdauh9ug10..jpg\" title=\"\" alt=\"Minion7-1.jpg\"/></p><p>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 当时完成它们的时候真的很开心，这就够了吧~。<br/></p>"
                + "<p><br/></p><p><img src=\"http://192.168.25.133/group1/M00/00/00/wKgZhVtd5FSAdqHJAAC9LPKnEJ871..jpg\" title=\"\" alt=\"minion2.jpg\"/></p>";
        Pattern pattern = Pattern.compile("(<img.+?src=\")((?:http://)|(?:https://))([\\w\\._-]{4,}/)(.+?\")");
        Matcher matcher = pattern.matcher(content);
        // while (matcher.find()){
        //     System.out.println(matcher.group(0));
        //     for (int i = 1; i <= matcher.groupCount();i++){
        //         System.out.println("---"+i+":"+matcher.group(i));
        //     }
        // }
        String s = matcher.replaceAll("$1https://file.tony.com/$4");
        System.out.println(s);
        // System.out.println(content.replaceAll("(<img.+?src=\")((?:http://)|(?:https://))([\\w\\._-]{4,}/)(.+?)\"",
        //         "$1https://$3$4"));
    }
}
