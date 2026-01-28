package cn.pintia.zoj.problem1951.model;


import com.alibaba.arthas.tunnel.client.TunnelClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class TunnelClientRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        TunnelClient tunnelClient = new TunnelClient();
        tunnelClient.connect(false);
        tunnelClient.start();
    }
}
