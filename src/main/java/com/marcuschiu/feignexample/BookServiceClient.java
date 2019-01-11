package com.marcuschiu.feignexample;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * make sure you run book-service application
 */
@FeignClient("book-service")
public interface BookServiceClient {
    @RequestMapping("/books")
    String getBooks();

    @RequestMapping("/books/local-service-instance")
    String getLocalServiceInstance();
}
