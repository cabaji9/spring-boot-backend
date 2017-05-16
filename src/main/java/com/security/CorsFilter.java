package com.security;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    static final String ORIGIN = "Origin";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	    throws IOException, ServletException {

	HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) res;

	if (("null").equals(request.getHeader(ORIGIN))) {

	    response.setHeader("Access-Control-Allow-Origin", "*");// * or
								   // origin as
								   // u prefer
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Headers",
		    "x-requested-with, Content-Type, origin, authorization, accept, client-security-token");

	} else if (("OPTIONS").equals(request.getMethod())
		&& request.getHeader("Access-Control-Request-Method") != null) {
	    try {
		response.setHeader("Access-Control-Allow-Origin", "*");// * or
								       // origin
								       // as u
								       // prefer
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Max-Age", "36");
		response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
		response.setHeader("Access-Control-Expose-Headers", "X-Auth-Token");
		response.getWriter().print("OK");
		response.getWriter().flush();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else {
	    String origin = request.getHeader(ORIGIN);
	    response.setHeader("Access-Control-Allow-Origin", origin);// * or
								      // origin
								      // as u
								      // prefer
	    response.setHeader("Access-Control-Expose-Headers", "X-Auth-Token");
	    chain.doFilter(request, response);
	}

    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}