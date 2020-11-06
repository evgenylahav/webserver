package test.java.com.myprojects.http;

import main.java.com.myprojects.http.HttpParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Evgeny Lahav
 */

@TestInstance(Lifecycle.PER_CLASS)
class HttpParserTest {

    private HttpParser httpParser;

    @BeforeAll
    public void beforeClass() {
        httpParser = new HttpParser();
    }

    @Test
    void parseHttpRequest() {
        httpParser.parseHttpRequest(generateValidTestCase());
    }

    private InputStream generateValidTestCase() {
        String rawData = "GET / HTTP/1.1\r\n" +
                         "Host: localhost:8080\r\n" +
                         "Connection: keep-alive\r\n" +
                         "Cache-Control: max-age=0\r\n" +
                         "Upgrade-Insecure-Requests: 1\r\n" +
                         "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36\r\n" +
                         "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                         "Sec-Fetch-Site: none\r\n" +
                         "Sec-Fetch-Mode: navigate\r\n" +
                         "Sec-Fetch-User: ?1\r\n" +
                         "Sec-Fetch-Dest: document\r\n" +
                         "Accept-Encoding: gzip, deflate, br\r\n" +
                         "Accept-Language: en-US,en;q=0.9\r\n" +
                         "Cookie: Pycharm-46424571=585cd361-2c7e-45cf-a3f4-b3cca4e24eb4" +
                         "\r\n";
        InputStream inputStream = new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII));
        return inputStream;
    }
}