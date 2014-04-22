/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.test.serch;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author TOY
 */
@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class Test extends HttpServlet {

    @Resource(lookup = "jdbc/smartvmi")
    private DataSource datasource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = getInitParameter("name");
        List<Data> mydto = new ArrayList<Data>();
        try (PrintWriter out = response.getWriter(); Connection connection = datasource.getConnection()) {
            Statement sm = connection.createStatement();
            ResultSet resultset = sm.executeQuery("SELECT * FROM DO_ITEM WHERE DRUGCODE LIKE \'" + data + "%\'");
            while (resultset.next()) {
                Data dto = new Data();
                dto.setId(resultset.getString("ID"));
                dto.setDrugcode(resultset.getString("DRUDCODE"));
                mydto.add(dto);
            }
            request.getRequestDispatcher("newjsp.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
