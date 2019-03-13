package model;

import org.junit.*;
import org.junit.jupiter.api.Assertions;

public class DBCreatorTest  {

    @Test
    public void testRun() throws Exception {
        new DBCreator().run();
        //Assertions.(false);
    }
}
