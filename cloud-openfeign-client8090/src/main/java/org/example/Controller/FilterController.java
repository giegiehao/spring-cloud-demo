package org.example.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.resp.Resp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
@RequestMapping("/filter")
public class FilterController {
    @GetMapping("/{something}")
    public Resp<String> getHeader(HttpServletRequest request, @PathVariable("something") String something){
        Enumeration<String> headers = request.getHeaderNames();

        System.out.println("Headers -------------------------------------------------");
        while (headers.hasMoreElements()) {
            String key = headers.nextElement();
            String value = request.getHeader(key);

            System.out.println(key + " : " + value);
        }
        System.out.println("------------------------------------------------- Headers");
        System.out.println("pathVariable: " + something);

        return Resp.success("");
    }
}
