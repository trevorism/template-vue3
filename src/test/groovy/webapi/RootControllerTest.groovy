import org.junit.Test
import webapi.RootController

class RootControllerTest {

    @Test
    public void TestPing(){

        assert "pong" == new RootController().ping()
    }

    @Test
    public void TestEndpoints(){

        def endpoints = new RootController().getEndpoints()
        assert endpoints
        assert endpoints.size() == 1
        assert endpoints[0] == "ping"
    }
}