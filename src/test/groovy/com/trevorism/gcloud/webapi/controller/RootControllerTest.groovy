package com.trevorism.gcloud.webapi.controller

import com.trevorism.gcloud.LocalAppEngineTestBase
import org.junit.Test

/**
 * @author tbrooks
 */
class RootControllerTest extends LocalAppEngineTestBase{

    @Test
    void testRootController(){
        assert !(new RootController().endpoints)
    }
}
