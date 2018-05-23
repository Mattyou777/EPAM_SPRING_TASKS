import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ReadListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class FirstServletTest {

  @Mock
  private HttpServletRequest request;
  @Mock
  HttpServletResponse response;
  @Mock
  RequestDispatcher dispatcher;
  @Mock
  ServletContext context;
  @Mock
  ServletInputStream inputStream;

  List<String> data;
  ServletInputStream servletInputStream;

  @Before
  public void beforeSetUp() {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    inputStream = mock(ServletInputStream.class);
    data = new ArrayList<>();
    data.add("me");
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
        "=me;".getBytes(StandardCharsets.UTF_8));
    servletInputStream = new ServletInputStream() {
      @Override
      public boolean isFinished() {
        return false;
      }

      @Override
      public boolean isReady() {
        return false;
      }

      @Override
      public void setReadListener(ReadListener readListener) {

      }

      public int read() throws IOException {
        return byteArrayInputStream.read();
      }
    };
  }

  @Test
  public void testDoPut() throws IOException, ServletException {
    when(request.getInputStream()).thenReturn(servletInputStream);

    new FirstServlet().doPut(request, response);

    verify(request, atLeast(1)).setAttribute("data", data);
  }

  @Test
  public void testDoGet() throws IOException, ServletException {
    context = mock(ServletContext.class);
    dispatcher = mock(RequestDispatcher.class);

    when(request.getParameter("name")).thenReturn("me");
    when(request.getServletContext()).thenReturn(context);
    when(context.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);

    new FirstServlet().doGet(request, response);

    verify(request, atLeast(1)).getParameter("name"); // verify name was called
    verify(request, atLeast(1)).setAttribute("data", data);
  }

  @Test
  public void testDoPost() throws IOException, ServletException {
    context = mock(ServletContext.class);
    dispatcher = mock(RequestDispatcher.class);

    when(request.getParameter("name")).thenReturn("me");
    when(request.getServletContext()).thenReturn(context);
    when(context.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);

    new FirstServlet().doPost(request, response);

    verify(request, atLeast(1)).getParameter("name"); // verify name was called
    verify(request, atLeast(1)).setAttribute("data", data);
  }

  @Test
  public void testDoDelete() throws IOException, ServletException {
    when(request.getInputStream()).thenReturn(servletInputStream);

    new FirstServlet().doDelete(request, response);
    data.remove(0);

    verify(request, atLeast(1)).setAttribute("data", data);
  }
}