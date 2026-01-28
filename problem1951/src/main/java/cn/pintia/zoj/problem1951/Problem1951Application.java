package cn.pintia.zoj.problem1951;

import cn.pintia.zoj.problem1951.service.GoldBachService;
import com.alibaba.arthas.tunnel.client.TunnelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Problem1951Application {

    public static void main(String[] args) {
        SpringApplication.run(Problem1951Application.class, args);
    }

}


@Component
class ConnectArthasTunnel implements ApplicationRunner {

    // 启动arthas-tunnel-client
    @Override
    public void run(ApplicationArguments args) throws Exception {
        TunnelClient client = new TunnelClient();
        client.start();
    }
}


