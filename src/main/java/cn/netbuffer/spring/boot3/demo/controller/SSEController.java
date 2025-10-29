package cn.netbuffer.spring.boot3.demo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sse")
public class SSEController {

    @GetMapping("data")
    public String data(HttpServletResponse httpServletResponse) throws IOException, InterruptedException {
        httpServletResponse.setContentType(MediaType.TEXT_EVENT_STREAM_VALUE);
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        while (true) {
            printWriter.write("data: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "\n\n");
            printWriter.flush();
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
