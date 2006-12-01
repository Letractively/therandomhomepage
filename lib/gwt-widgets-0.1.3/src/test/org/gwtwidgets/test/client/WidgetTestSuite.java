package org.gwtwidgets.test.client;

import org.gwtwidgets.test.client.util.SimpleDateFormatTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class WidgetTestSuite extends TestCase
{

    public static Test suite ()
    {
        TestSuite result = new TestSuite();
        result.addTestSuite(SimpleDateFormatTest.class);
        return result;
    }
}
