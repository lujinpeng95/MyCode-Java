package core.filter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Enumeration;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebFrameworkHttpLogFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(WebFrameworkHttpLogFilter.class);

    private static final String JSON_CONTENT_TYPE = "application/json";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (request.getContentType() == null || !request.getContentType().contains(JSON_CONTENT_TYPE)) {
            chain.doFilter(request, response);
            return;
        }

        // 可重复读的request
        LoggingHttpServletRequestWrapper requestWrapper =
                new LoggingHttpServletRequestWrapper((HttpServletRequest) request);

        // 可重复写的response
        ContentCachingResponseWrapper responseWrapper =
                new ContentCachingResponseWrapper((HttpServletResponse) response);

        // 埋时间点
        long startTime = System.currentTimeMillis();
        try {
            doBefore(requestWrapper);
            chain.doFilter(requestWrapper, responseWrapper);
            try {
                doAfter(responseWrapper, startTime);
            } finally {
                responseWrapper.copyBodyToResponse();
            }
        } catch (Exception e) {
            logger.warn("running exception, ", e);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("WebFrameworkHttpLogFilter init.");
    }

    @Override
    public void destroy() {
        logger.info("WebFrameworkHttpLogFilter destroy.");
    }

    private void doBefore(LoggingHttpServletRequestWrapper request) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("request").append("\n");
        sb.append("> ").append(request.getMethod()).append(" ").append(request.getRequestURI()).append("\n");
        Enumeration names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            sb.append("> ");
            String name = names.nextElement().toString();
            sb.append(name).append(": ");
            Enumeration headers = request.getHeaders(name);
            while (headers.hasMoreElements()) {
                sb.append(headers.nextElement());
            }
            sb.append("\n");
        }
        String body = IOUtils.toString(request.getBody(), request.getCharacterEncoding());
        sb.append(body);
        logger.info(sb.toString());
    }

    private void doAfter(ContentCachingResponseWrapper response, long startTime) {
        StringBuilder sb = new StringBuilder();
        sb.append("response").append("\n");
        sb.append("< status: ").append(response.getStatusCode()).append("\n");
        Collection<String> names = response.getHeaderNames();
        for (String name : names) {
            sb.append("> ");
            sb.append(name).append(": ");
            String value = response.getHeader(name);
            sb.append(value);
            sb.append("\n");
        }
        sb.append("< cost: ").append(getCost(startTime)).append("ms\n");
        String res = getResponseBody(response);
        if (StringUtils.isBlank(res)) {
            sb.append("no response result");
        } else {
            sb.append(getResponseBody(response));
        }

        logger.info(sb.toString());
    }

    /**
     * 获取耗时
     * @param startTime
     * @return
     */
    private long getCost(long startTime) {
        long now = System.currentTimeMillis();
        return now - startTime;
    }

    /**
     * 获取返回值
     * @param response
     */
    private String getResponseBody(ContentCachingResponseWrapper response) {
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(
                response,
                ContentCachingResponseWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                String payload;
                try {
                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    payload = "[unknown]";
                }
                return payload;
            }
        }
        return "";
    }
}

