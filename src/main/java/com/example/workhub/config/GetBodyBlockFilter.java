package com.example.workhub.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;

@Component
public class GetBodyBlockFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;

    // Only check GET requests
    if ("GET".equalsIgnoreCase(httpRequest.getMethod())) {

      // Wrap to allow reading body
      ContentCachingRequestWrapper wrapper = new ContentCachingRequestWrapper(httpRequest);

      // Quick Content-Length check
      String contentLengthHeader = httpRequest.getHeader("Content-Length");
      if (contentLengthHeader != null) {
        try {
          int len = Integer.parseInt(contentLengthHeader);
          if (len > 0) {
            ((HttpServletResponse) response).sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "GET request should not contain a body");
            return;
          }
        } catch (NumberFormatException ignored) {
        }
      }

      // Deep check
      byte[] cached = wrapper.getContentAsByteArray();
      if (cached != null && cached.length > 0) {
        ((HttpServletResponse) response).sendError(
            HttpServletResponse.SC_BAD_REQUEST,
            "GET request should not contain a body");
        return;
      }

      // Continue normally
      chain.doFilter(wrapper, response);
      return;
    }

    // Other methods pass normally
    chain.doFilter(request, response);
  }
}
