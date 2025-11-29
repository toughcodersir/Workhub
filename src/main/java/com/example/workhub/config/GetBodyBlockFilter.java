package com.example.workhub.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GetBodyBlockFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;

    // 1️⃣ Allow CORS preflight OPTIONS requests
    if (req.getMethod().equalsIgnoreCase("OPTIONS")) {
      chain.doFilter(request, response);
      return;
    }

    // 2️⃣ Block GET requests with body based ONLY on content-length
    if (req.getMethod().equalsIgnoreCase("GET")) {
      String length = req.getHeader("Content-Length");
      if (length != null) {
        try {
          int len = Integer.parseInt(length);
          if (len > 0) {
            ((HttpServletResponse) response)
                .sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "GET request should not contain a body");
            return;
          }
        } catch (Exception ignored) {
        }
      }
    }

    // 3️⃣ Continue normally for all other cases
    chain.doFilter(request, response);
  }
}
