package com.example.web;

import com.example.ejb.MedicineFacade;
import com.example.entity.Medicine;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {

    @EJB
    private MedicineFacade facade;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
                break;
            case "edit": {
                Long id = Long.parseLong(req.getParameter("id"));
                req.setAttribute("medicine", facade.find(id));
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
                break;
            }
            case "delete": {
                Long id = Long.parseLong(req.getParameter("id"));
                facade.remove(id);
                resp.sendRedirect("controller?action=list");
                break;
            }
            default: {
                List<Medicine> list = facade.findAll();
                req.setAttribute("medicines", list);
                req.getRequestDispatcher("list.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Medicine m = new Medicine();
        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            m.setId(Long.parseLong(idStr));
        }
        m.setName(req.getParameter("name"));
        m.setManufacturer(req.getParameter("manufacturer"));
        m.setPrice(Double.parseDouble(req.getParameter("price")));
        m.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        m.setExpiryDate(req.getParameter("expiryDate"));

        if (m.getId() == null) facade.create(m);
        else                   facade.edit(m);

        resp.sendRedirect("controller?action=list");
    }
}
