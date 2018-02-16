package com.iesemilidarder.projectozero;

import com.iesemilidarder.base.ReadDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostrarRestaurantsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //A la part del servlet , farém : Un string ID amb un request.getParameter id , amb una nova conexió a la base de dades

        String id = request.getParameter("id");

        //amb una nova conexió a la base de dades

        ReadDB readDB = new ReadDB();

        //I amb un set Attribute amb el new ReadDB i amb el String id

        request.setAttribute("id" , readDB.ReadDBB(id));

        request.getRequestDispatcher("ShowRestaurant.jsp").forward(request, response);

    }


    }


