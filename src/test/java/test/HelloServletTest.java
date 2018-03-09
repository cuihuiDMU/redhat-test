package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.servlets.HelloServlet;

public class HelloServletTest {
	private HelloServlet servlet;
    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;
      
    @Before  
    public void setUp(){
        servlet = new HelloServlet();
        mockRequest = EasyMock.createMock(HttpServletRequest.class);
        mockResponse = EasyMock.createMock(HttpServletResponse.class);
    }  
      
    @Test  
    public void testDoGet() throws ServletException, IOException {
    	EasyMock.expect(mockResponse.getWriter()).andReturn(new PrintWriter(new StringWriter())).once();
    	EasyMock.replay(mockResponse);
    	
    	servlet.doGet(mockRequest, mockResponse);
    }  
}
