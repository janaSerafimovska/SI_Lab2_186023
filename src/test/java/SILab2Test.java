import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private SILab2 tester = new SILab2();
    String username=null,password=null;

    @Test void EveryPathTest()
    {
        System.out.println("Starting test");
        assertEquals(false,tester.function(null,null)); //"User is null!"
        User user = new User(username,"j12s","jana@yahoo.com");
        assertEquals(false,tester.function(user,null)); //"Username or password is null!"
        user=new User("jana","12ja","");
        assertEquals(false,tester.function(user,null)); //"Password is less than 8 characters long or password contains the username"
        user = new User("jana","jsaenraafi","jana@yahoo.com");
        assertEquals(false,tester.function(user,null));
        user = new User("jana","jsa4nra2fi","jana@yahoo.com");
        assertEquals(false,tester.function(user,null));
        user = new User("jana","jsaAnraafFim","jana@yahoo.com");
        assertEquals(false,tester.function(user,null));
        user = new User("jana","js@anr_afim","jana@yahoo.com");
        assertEquals(false,tester.function(user,null));
        user = new User("jana","jsAa5ri4FiA","jana@yahoo.com");
        assertEquals(false,tester.function(user,null));
        user = new User("jana","js@a5ri4fi","jana@yahoo.com");
        assertEquals(false,tester.function(user,null));
        user = new User("jana","js@aAri?fi","jana@yahoo.com");
        assertEquals(false,tester.function(user,null));
        user = new User("jana","Js@aArif23","jana@yahoo.com");
        assertEquals(true,tester.function(user,null));

    }

    @Test
    void MultipleConditionTest()
    {
        User user = new User(null,"j12s","jana@yahoo.com");
        assertEquals(false,tester.function(user,null));
        user = new User("jan@S",null,"");
        assertEquals(false,tester.function(user,null));
        user = new User("jan@S","123ja","");
        assertEquals(false,tester.function(user,null));
        user = new User("jan@S","jaSenafim","");
        assertEquals(false,tester.function(user,null));
        user = new User("jan@S","j@2enaf5400","");
        assertEquals(false,tester.function(user,null));
        user = new User("jan@S","J@2anSe5400","");
        assertEquals(true,tester.function(user,null));
        user = new User("jan@S","JaSe2nfi54","");
        assertEquals(false,tester.function(user,null));
        user=new User("jan@S","jan@Se5400","");
        assertEquals(false, tester.function(user,null));

    }

}