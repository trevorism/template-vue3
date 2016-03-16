package com.trevorism.gcloud.webapi

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper
import com.trevorism.gcloud.model.TimedEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * @author tbrooks
 */
class CrudControllerTest {

    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void test() {
        CrudController controller = new CrudController()
        def event = new TimedEvent([name: "Trevor", description: "Desc"])
        def event2 = controller.createTimedEvent(event)
        def event3 = controller.getTimedEvent(event2.id)

        assert event2.id == event3.id
    }

}