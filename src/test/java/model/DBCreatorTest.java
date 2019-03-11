package model;

import org.junit.*;

public class DBCreatorTest  {

    @Test
    public void testRun() throws Exception {
        new DBCreator().run();
    }
}
