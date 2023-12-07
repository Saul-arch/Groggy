package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class Consultas {
    public ResultSet rs;
    public String medida;
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
            }else if (tipo_tabla.equals("inventario")){
                while (rs.next()){
                    Vector<Object> row = new Vector<Object>();
                    // Vector<Object> columnNames = new Vector<Object>();
                    row.add(rs.getString("codigo_barr"));
                    row.add(rs.getString("cod_proveedor"));
                    row.add(rs.getString("nombre"));
                    row.add(rs.getString("unidad_medida"));
                    row.add(rs.getString("precio_unit"));
                    row.add(rs.getString("presentacion"));
                    row.add(rs.getString("stock"));
                    data.add(row);


                }
            }else if (tipo_tabla.equals("ventas")){
                System.out.println("Entro a la opcion de ventas");

                while (rs.next()){
                    Vector<Object> row = new Vector<Object>();
                    // Vector<Object> columnNames = new Vector<Object>();
                    row.add(rs.getString("codigo_barr"));
                    row.add(rs.getString("cod_cliente"));
                    row.add(rs.getString("cod_factura"));
                    row.add(rs.getString("nombre_prod"));
                    row.add(rs.getString("nombre_vend"));
                    row.add(rs.getString("cantidad"));
                    row.add(rs.getString("precio_unit"));
                    row.add(rs.getString("precio_total"));
                    data.add(row);

                    System.out.println(rs.getString("codigo_barr"));

                }
            }
            model = new DefaultTableModel(data, columnas);
            lista.setModel(model);
            lista.repaint();
            System.out.println("Refresco");

        }catch(Exception e){
            System.out.println("aqui trono"+e);
        }

    }
    public String buscarProductoNuevaVenta(Statement st, String Consulta, JTextField txtProducto, JTextField txtPrecio, String presentacion, String medida){
        try{
            rs = st.executeQuery(Consulta);
            rs.next();
            txtProducto.setText(rs.getString("nombre"));
            txtPrecio.setText(rs.getString("precio_unit"));
            presentacion = rs.getString("presentacion");
            medida = rs.getString("unidad_medida");
            this.medida = medida;

        }catch (Exception e){
            System.out.println(e);
        }
        return presentacion;
    }

    public void agregarVenta(Statement st, JTable tblTablaNuevaVentas, DefaultTableModel modelNuevaVenta, String Cliente){
        String nuevaFactura = "insert into factura(hora) values(SYSDATE)";
        try {
            rs = st.executeQuery(nuevaFactura);
            rs = st.executeQuery("commit");

            int cantFilas = modelNuevaVenta.getRowCount();
            System.out.println("FIlas, "+cantFilas);

            for (int i = 0; i < cantFilas; i++){
                String nameProducto = modelNuevaVenta.getValueAt(i, 0).toString();
                String presentacion = modelNuevaVenta.getValueAt(i, 1).toString();
                String cantidad = modelNuevaVenta.getValueAt(i, 3).toString();
                String precioTotal = modelNuevaVenta.getValueAt(i, 4).toString();

                String Consulta = "insert into ventas values((select codigo_barr from inventario where nombre = '"+nameProducto+"' and presentacion = '"+presentacion+"'),(select cod_cliente from clientes where nombre = '"+Cliente+"'),(select cod_factura from factura order by cod_factura desc FETCH FIRST 1 ROW ONLY),'"+nameProducto+"',SYSDATE, (SELECT USER FROM DUAL), "+cantidad+",(select precio_unit from inventario where codigo_barr = (select codigo_barr from inventario where nombre = '"+nameProducto+"' and presentacion = '"+presentacion+"')),"+precioTotal+")";
                rs = st.executeQuery(Consulta);
            }
            rs = st.executeQuery("commit");

            JOptionPane.showMessageDialog(null, "Ventas Realizada Con Exito!!!");

        }catch (Exception e){
            System.out.println(e);
        }


    }
    public void refreshComboBox(Statement st, String consulta, String ComboBox, JComboBox<String> Combo){
        try {
            rs = st.executeQuery(consulta);

            if (ComboBox.equals("cbbNuevaVentaClientes")){
                while (rs.next()){
                    Combo.addItem(rs.getString("nombre"));
                }
            }
            Combo.repaint();

        }catch (Exception e){
            System.out.println(e);
        }

    }

}