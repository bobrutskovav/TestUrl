import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Aleks on 06.03.2017.
 */
public class UrlTest {
    @Test
    public void urlTest() throws Exception{

        String actualUrl = "http://test.com?k1=1&k3=3&k2=2&k3=3";
        String expectedUrl = "http://test.com?k1=1&k3=3&k2=2";

        String[] comesUrlParts = actualUrl.split("\\?");
        String[] expectedUrlParts = expectedUrl.split("\\?");

        if (comesUrlParts.length != 2 || expectedUrlParts.length != 2){
            throw new Exception("Url comes without parameters or crashed");
        }
        //Two asserts in one test is a wrong way, but we need to check all url string
        Assert.assertEquals("Wrong url domain",comesUrlParts[0],expectedUrlParts[0]);

        //remove duplicates int params section
        HashSet<String> actualParams = new HashSet<>(Arrays.asList(comesUrlParts[1].split("&")));
        HashSet<String> expectedParams = new HashSet<>(Arrays.asList(expectedUrlParts[1].split("&")));
        //for debug
        actualParams.forEach( s -> System.out.println(s));
        expectedParams.forEach(s -> System.out.println(s));

        Assert.assertEquals("Wrong params in actual url",actualParams,expectedParams);
        
    }
}
