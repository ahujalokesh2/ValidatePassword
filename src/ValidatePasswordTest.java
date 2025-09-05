import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ValidatePasswordTest {

    @Test
    public void testValidPassword(){

        assertTrue(ValidatePassword.passwordValidation("ValidPass1234"));
    }

    @Test
    public void testNullPassword(){

        Exception e =assertThrows(IllegalArgumentException.class,()-> {ValidatePassword.passwordValidation(null);});

        Assert.assertEquals("Password can't be null",e.getMessage());

    }

    @Test
    public void testNoUpperCharacter(){

        Exception e =assertThrows(IllegalArgumentException.class,()-> {ValidatePassword.passwordValidation("abcd12345");});

        Assert.assertEquals("Password must contain at least 1 uppercase",e.getMessage());
    }
    @Test
    public void testNoLowerCharcter(){

        Exception e =assertThrows(IllegalArgumentException.class,()-> {ValidatePassword.passwordValidation("ABCD12345");});

        Assert.assertEquals("Password must contain at least 1 lowercase",e.getMessage());
    }
    @Test
    public void testDigitCharacter(){

        Exception e =assertThrows(IllegalArgumentException.class,()-> {ValidatePassword.passwordValidation("abcdABCDC");});

        Assert.assertEquals("Password must contain at least 1 digit",e.getMessage());
    }

    @Test
    public void testSmallPassword(){

        Exception e =assertThrows(IllegalArgumentException.class,()-> {ValidatePassword.passwordValidation("abcdAb1");});

        Assert.assertEquals("Password must be longer than 8 chars",e.getMessage());
    }
}
