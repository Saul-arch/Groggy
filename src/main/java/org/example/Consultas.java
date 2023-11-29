package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class Consultas {
    public ResultSet rs;
    public void refresh(Statement st, JTable lista, Vector<String> columnas, String consulta, String tipo_tabla){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        DefaultTableModel model;

        try{
            rs = st.executeQuery(consulta);

            if (tipo_tabla.equals("clientes")){
                while (rs.next()){
                    Vector<Object> row = new Vector<Object>();
                    // Vector<Object> columnNames = new Vector<Object>();
                    row.add(rs.getString("cod_cliente"));
                    row.add(rs.getString("nombre"));
                    row.add(rs.getString("apellido_p"));
                    row.add(rs.getString("apellido_m"));
                    row.add(rs.getString("sexo"));
                    row.add(rs.getString("fecha_regi"));
                    data.add(row);


                }
                model = new DefaultTableModel(data, columnas);
                lista.setModel(model);
                lista.repaint();
                System.out.println("Refresco");
            }


        }catch(Exception e){
            System.out.println("aqui trono"+e);
        }

    }
}
