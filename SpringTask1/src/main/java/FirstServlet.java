import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/index", ""})
public class FirstServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  List<String> data = new ArrayList<>();

//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    String userName = request.getParameter("userName").trim();
//    if(userName == null || "".equals(userName)){
//      userName = "Guest";
//    }
//
//    String greetings = "Hello " + userName;
//
//    response.setContentType("text/plain");
//    response.getWriter().write(greetings);
//  }

  private static String inputStreamToString(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream, "UTF-8");
    return scanner.hasNext() ? scanner.useDelimiter("\\A")
        .next() : "";
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("--put--");
    String body = inputStreamToString(req.getInputStream());
    body = body.substring(1, body.length() - 1);
    if (!data.contains(body)) {
      data.add(body);
    }
    req.setAttribute("data", data);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("--get--");
    String name = req.getParameter("name");
    Cookie cookie = readCookie(req);
    if (cookie != null) {
      resp.addCookie(cookie);
    }
    if (name != null && !name.isEmpty()) {
      data.add(name);
    }

    req.setAttribute("data", data);
    RequestDispatcher dispatcher = req.getServletContext()
        .getRequestDispatcher("/index.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.addCookie(readCookie(req));
    System.out.println("--post--");
    String name = req.getParameter("name");
    if (name != null && !name.isEmpty()) {
      data.add(name);
    }
    req.setAttribute("data", data);
    RequestDispatcher dispatcher = req.getServletContext()
        .getRequestDispatcher("/index.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("--delete--");
    String body = inputStreamToString(req.getInputStream());
    body = body.substring(1, body.length() - 1);
    if (data.contains(body)) {
      data.remove(body);
    }
    req.setAttribute("data", data);

  }

  private Cookie readCookie(HttpServletRequest req) {
    Cookie cookie = null;
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName()
            .equals("count")) {
          cookie = cookies[i];
          Integer newValue = Integer.valueOf(cookies[i].getValue()) + 1;
          cookie.setValue(newValue.toString());
          cookie.setMaxAge(30);
        }
      }
    }
    return cookie;
  }
}
