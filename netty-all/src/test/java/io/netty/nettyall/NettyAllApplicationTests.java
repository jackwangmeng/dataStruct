package io.netty.nettyall;

import io.netty.nettyall.server.MyRPCServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NettyAllApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void testServer() throws Exception {
        MyRPCServer myRPCServer = new MyRPCServer();
        myRPCServer.start(5566);
    }

}
