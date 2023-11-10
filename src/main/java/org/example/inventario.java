package org.example;

import javax.swing.*;
import java.awt.*;

public class inventario {
    JFrame framePrincipal;
    JPanel pnlPrincipalInventario;
    JPanel pnlTablaProductos;
    JPanel pnlDetallesProductos;
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
        JLabel lblEmpresa = new JLabel();
        JLabel lblFechaConvenio = new JLabel();
        JLabel lblGananciasUnit = new JLabel();
        JLabel lblGananciasTotales = new JLabel();

        pnlTablaProductos.setSize(800, 790);
        pnlTablaProductos.setLocation(10, 10);
        pnlTablaProductos.setBackground(Color.cyan);
        pnlTablaProductos.setVisible(true);
        pnlTablaProductos.setLayout(null);

        lblDetalles.setSize(130, 30);
        lblDetalles.setLocation(200, 20);
        lblDetalles.setForeground(Color.GRAY);
        lblDetalles.setFont(new Font("Arial", Font.PLAIN, 18));

        lblProveedor.setText("Proveedor: ");
        lblProveedor.setSize(130, 20);
        lblProveedor.setLocation(10, 100);

        lblEmpresa.setText("Empresa: ");
        lblEmpresa.setSize(130, 20);
        lblEmpresa.setLocation(10, 130);

        lblFechaConvenio.setText("Fecha de convenio: ");
        lblFechaConvenio.setSize(130, 20);
        lblFechaConvenio.setLocation(10, 160);

        lblGananciasUnit.setText("Ganancia por unidad: ");
        lblGananciasUnit.setSize(130, 20);
        lblGananciasUnit.setLocation(10, 190);

        lblGananciasTotales.setText("Ganancias totales: ");
        lblGananciasTotales.setSize(130, 20);
        lblGananciasTotales.setLocation(10, 220);

        pnlDetallesProductos.setSize(460, 790);
        pnlDetallesProductos.setLocation(812, 10);
        pnlDetallesProductos.add(lblDetalles);
        pnlDetallesProductos.add(lblProveedor);
        pnlDetallesProductos.add(lblEmpresa);
        pnlDetallesProductos.add(lblFechaConvenio);
        pnlDetallesProductos.add(lblGananciasUnit);
        pnlDetallesProductos.add(lblGananciasTotales);

        pnlDetallesProductos.setBackground(Color.PINK);
        pnlDetallesProductos.setLayout(null);
        pnlDetallesProductos.setVisible(true);

        pnlPrincipalInventario.setSize(1300, 870);
        pnlPrincipalInventario.setLocation(209, 30);
        pnlPrincipalInventario.setLayout(null);
        pnlPrincipalInventario.add(pnlTablaProductos);
        pnlPrincipalInventario.add(pnlDetallesProductos);
        pnlPrincipalInventario.setVisible(false);
        framePrincipal.add(pnlPrincipalInventario);

    }

}
