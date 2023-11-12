package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class inventario {
    JFrame framePrincipal;
    JPanel pnlPrincipalInventario;
    JPanel pnlTablaProductos;
    JPanel pnlDetallesProductos;
    public JDialog dlgAgregarInventario = new JDialog();
    public JPanel pnlDatosProduct = new JPanel();
    public JPanel pnlListproduct = new JPanel();

    public inventario(JFrame framePrincipal){
        this.framePrincipal = framePrincipal;
        iniciarVista();
    }

    private void iniciarVista() {
        pnlPrincipalInventario = new JPanel();
        pnlTablaProductos = new JPanel();
        pnlDetallesProductos = new JPanel();
        JLabel lblDetalles = new JLabel("Detalles");
        JLabel lblProveedor = new JLabel();
        JLabel lblProveedorNombre = new JLabel();
        JLabel lblEmpresa = new JLabel();
        JLabel lblEmpresaNombre = new JLabel();
        JLabel lblFechaConvenio = new JLabel();
        JLabel lblFechaConvenioNombre = new JLabel();
        JLabel lblGananciasUnit = new JLabel();
        JLabel lblGananciasUnitNombre = new JLabel();
        JLabel lblGananciasTotales = new JLabel();
        JLabel lblGananciasTotalesNombre = new JLabel();
        JButton btnAgregar = new JButton();
        JButton btnVerProveedor = new JButton();
        JButton btnActualizarPrecio = new JButton();

        JTable tblTabla = new JTable();
        Vector<String> columnasVentas = new Vector<String>();
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        DefaultTableModel model;
        JScrollPane scpContenedorJtable = new JScrollPane();

        columnasVentas.add("Codigo");
        columnasVentas.add("producto");
        columnasVentas.add("Unidad de medida");
        columnasVentas.add("Precio unit");
        columnasVentas.add("Presentacion");
        columnasVentas.add("Stock");

        model = new DefaultTableModel(data, columnasVentas);
        tblTabla.setModel(model);

        scpContenedorJtable.setSize(800, 795);
        scpContenedorJtable.setLocation(0,4);
        scpContenedorJtable.setViewportView(tblTabla);

        pnlTablaProductos.setSize(800, 800);
        pnlTablaProductos.setLocation(0, 0);
        pnlTablaProductos.setVisible(true);
        pnlTablaProductos.setLayout(null);
        pnlTablaProductos.add(scpContenedorJtable);

        btnAgregar.setText("Agregar");
        btnAgregar.setForeground(Color.white);
        btnAgregar.setBackground(Color.decode("#F28989"));
        btnAgregar.setSize(130, 40);
        btnAgregar.setLocation(10, 740);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //Implementar la siguiente vista
               pnlPrincipalInventario.setVisible(false);
               dlgAgregarInventario.setVisible(true);
                
            }
        });

        btnVerProveedor.setText("Ver proveedor");
        btnVerProveedor.setForeground(Color.white);
        btnVerProveedor.setBackground(Color.decode("#06A2C4"));
        btnVerProveedor.setSize(130, 40);
        btnVerProveedor.setLocation(170, 740);

        btnActualizarPrecio.setText("Actualizar precio");
        btnActualizarPrecio.setForeground(Color.white);
        btnActualizarPrecio.setBackground(Color.decode("#64D3B2"));
        btnActualizarPrecio.setSize(130, 40);
        btnActualizarPrecio.setLocation(330, 740);

        lblDetalles.setSize(130, 30);
        lblDetalles.setLocation(200, 20);
        lblDetalles.setForeground(Color.GRAY);
        lblDetalles.setFont(new Font("Arial", Font.PLAIN, 20));

        lblProveedor.setText("Proveedor: ");
        lblProveedor.setSize(130, 20);
        lblProveedor.setLocation(10, 110);
        lblProveedor.setFont(new Font("", Font.PLAIN, 14));

        lblProveedorNombre.setText("Efren Garcia Reyes");
        lblProveedorNombre.setSize(130, 20);
        lblProveedorNombre.setLocation(90, 110);
        lblProveedorNombre.setFont(new Font("", Font.PLAIN, 14));
        lblProveedorNombre.setForeground(Color.decode("#6E6E6E"));

        lblEmpresa.setText("Empresa: ");
        lblEmpresa.setSize(100, 20);
        lblEmpresa.setLocation(10, 150);
        lblEmpresa.setFont(new Font("", Font.PLAIN, 14));

        lblEmpresaNombre.setText("Coca cola");
        lblEmpresaNombre.setSize(150, 20);
        lblEmpresaNombre.setLocation(80, 150);
        lblEmpresaNombre.setFont(new Font("", Font.PLAIN, 14));
        lblEmpresaNombre.setForeground(Color.decode("#6E6E6E"));

        lblFechaConvenio.setText("Fecha de convenio: ");
        lblFechaConvenio.setSize(150, 20);
        lblFechaConvenio.setLocation(10, 190);
        lblFechaConvenio.setFont(new Font("", Font.PLAIN, 14));

        lblFechaConvenioNombre.setText("2020-08-24");
        lblFechaConvenioNombre.setSize(150, 20);
        lblFechaConvenioNombre.setLocation(140, 190);
        lblFechaConvenioNombre.setFont(new Font("", Font.PLAIN, 14));
        lblFechaConvenioNombre.setForeground(Color.decode("#6E6E6E"));

        lblGananciasUnit.setText("Ganancia por unidad: ");
        lblGananciasUnit.setSize(150, 20);
        lblGananciasUnit.setLocation(10, 230);
        lblGananciasUnit.setFont(new Font("", Font.PLAIN, 14));

        lblGananciasUnitNombre.setText("$5.50");
        lblGananciasUnitNombre.setSize(150, 20);
        lblGananciasUnitNombre.setLocation(155, 230);
        lblGananciasUnitNombre.setFont(new Font("", Font.PLAIN, 14));
        lblGananciasUnitNombre.setForeground(Color.decode("#6E6E6E"));

        lblGananciasTotales.setText("Ganancias totales: ");
        lblGananciasTotales.setSize(150, 20);
        lblGananciasTotales.setLocation(10, 270);
        lblGananciasTotales.setFont(new Font("", Font.PLAIN, 14));

        lblGananciasTotalesNombre.setText("$321.50");
        lblGananciasTotalesNombre.setSize(150, 20);
        lblGananciasTotalesNombre.setLocation(140, 270);
        lblGananciasTotalesNombre.setFont(new Font("", Font.PLAIN, 14));
        lblGananciasTotalesNombre.setForeground(Color.decode("#6E6E6E"));

        pnlDetallesProductos.setSize(460, 790);
        pnlDetallesProductos.setLocation(812, 10);
        pnlDetallesProductos.setBackground(Color.white);
        pnlDetallesProductos.add(lblDetalles);
        pnlDetallesProductos.add(lblProveedor);
        pnlDetallesProductos.add(lblProveedorNombre);
        pnlDetallesProductos.add(lblEmpresa);
        pnlDetallesProductos.add(lblEmpresaNombre);
        pnlDetallesProductos.add(lblFechaConvenio);
        pnlDetallesProductos.add(lblFechaConvenioNombre);
        pnlDetallesProductos.add(lblGananciasUnit);
        pnlDetallesProductos.add(lblGananciasUnitNombre);
        pnlDetallesProductos.add(lblGananciasTotales);
        pnlDetallesProductos.add(lblGananciasTotalesNombre);
        pnlDetallesProductos.add(btnAgregar);
        pnlDetallesProductos.add(btnVerProveedor);
        pnlDetallesProductos.add(btnActualizarPrecio);

        pnlDetallesProductos.setLayout(null);
        pnlDetallesProductos.setVisible(true);

        pnlPrincipalInventario.setSize(1300, 870);
        pnlPrincipalInventario.setLocation(209, 30);
        pnlPrincipalInventario.setLayout(null);
        pnlPrincipalInventario.add(pnlTablaProductos);
        pnlPrincipalInventario.setBackground(Color.white);
        pnlPrincipalInventario.add(pnlDetallesProductos);
        pnlPrincipalInventario.setVisible(false);
        framePrincipal.add(pnlPrincipalInventario);

        initVistaNuevoInventario(framePrincipal);


    }
    private void initVistaNuevoInventario(JFrame framePrincipal) {
        dlgAgregarInventario.setSize(1000, 800);
        dlgAgregarInventario.setBackground(Color.white);
        dlgAgregarInventario.setLocation(209, 30);
        dlgAgregarInventario.setVisible(false);

        //framePrincipal.add(dlgAgregarInventario);
    }

}
