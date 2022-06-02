/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tecservices;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author garroakion
 */
public class TecServices extends javax.swing.JFrame {

    private ArrayList<Cliente> clientes;
    private ArrayList<IEmpresa> empresas;
    private ArrayList<String> tempTels;
    private Cliente admin;
    private Cliente usuarioActual;
    private ArrayList<IProducto> productTemp;

    private Ventas ventaTemp;

    Boolean flag = false;

    /**
     * Constructor de la clase
     */
    public TecServices() {

        this.clientes = new ArrayList<Cliente>();
        this.empresas = new ArrayList<IEmpresa>();
        SetAkionUser();
        setAdmin();
        initComponents();
        configComponentes();
        //this.empresas = Empresa.getEmpresasGeneradas();
        Empresa e1 = Empresa.getInstance();
        Empresa e2 = Empresa.getInstance();
        e2.setProductosEmpresa(Producto.generatedProductsFarmacia(e2));
        this.empresas.add(e1);
        this.empresas.add(e2);
        mostrarEmpresas();

    }

    /**
     * Usuario de prueba para el ingreso directo Admin y Usuario Normal
     */
    private void SetAkionUser() {
        ArrayList<String> telefonos = new ArrayList<String>();
        telefonos.add("12345678");
        Cliente akion = new Cliente("1234", "Akion", "San Juan", telefonos, "1234");
        clientes.add(akion);
    }

    private void setAdmin() {
        ArrayList<String> telAdmin = new ArrayList<String>();
        telAdmin.add("85045830");
        this.admin = new Cliente("Admin", "Admin", "Admin", telAdmin, "Admin");
    }

    /**
     * Configuracion de componentes gráficos
     */
    private void configComponentes() {
        this.registro.setEnabled(false);
        this.registro.setVisible(false);
        this.home.setEnabled(false);
        this.home.setVisible(false);
        this.adminPanel.setEnabled(false);
        this.adminPanel.setVisible(false);
        this.carritoUsuario.setEnabled(false);
        this.carritoUsuario.setVisible(false);
        this.historialCompras.setVisible(false);
        this.historialCompras.setEnabled(false);
    }

    /**
     * ------------------------------------------Utilidades------------------------------------
     * ----------------------------------------------------------------------------------------
     * ----------------------------------------------------------------------------------------
     */
    /**
     * Mostrar todas las empresas disponibles, de manera grafica.
     */
    private void mostrarEmpresas() {
        DefaultListModel model = new DefaultListModel();
        this.listaEmpresas.setModel(model);
        listaEmpresas.setFixedCellWidth(80);
        listaEmpresas.setFixedCellHeight(80);

        for (int i = 0; i < this.empresas.size(); i++) {
            Empresa e1 = (Empresa) this.empresas.get(i);
            model.addElement(e1.getDescripcion());
        }
    }

    /**
     * Mostrar todas los productos disponibles de una empresa.
     */
    private void mostrarProductos(Integer current) {
        DefaultListModel model = new DefaultListModel();
        this.listaProductos.setModel(model);
        IEmpresa empresa = this.empresas.get(current);

        for (int i = 0; i < empresa.getProductos().size(); i++) {
            model.addElement(empresa.getProductos().get(i).getDetalles());
        }
    }

    /**
     * Agrega a la lista de empresas de la parte de admin
     */
    private void mostrarEmpresasAdmin() {
        DefaultListModel model = new DefaultListModel();
        this.listaEmpresasAdmin.setModel(model);
        listaEmpresasAdmin.setFixedCellWidth(80);
        listaEmpresasAdmin.setFixedCellHeight(80);

        for (int i = 0; i < this.empresas.size(); i++) {
            Empresa e1 = (Empresa) this.empresas.get(i);
            model.addElement(e1.getDescripcion());
        }
    }

    /**
     * Utilidad para desplazarse a Registro
     */
    private void irRegistro() {
        this.registro.setEnabled(true);
        this.registro.setVisible(true);
        this.login.setEnabled(false);
        this.login.setVisible(false);
    }

    /**
     * Utilidad para desplazarse a Login
     */
    private void irLogin() {
        this.registro.setEnabled(false);
        this.registro.setVisible(false);
        this.login.setEnabled(true);
        this.login.setVisible(true);
    }

    /**
     * Utilidad para desplazarse a Home
     */
    private void irHome() {
        this.home.setEnabled(true);
        this.home.setVisible(true);
        this.login.setEnabled(false);
        this.login.setVisible(false);
    }

    /**
     * Utilidad para desplazarse a Admin
     */
    private void irAdmin() {
        this.adminPanel.setEnabled(true);
        this.adminPanel.setVisible(true);
        this.login.setEnabled(false);
        this.login.setVisible(false);
        mostrarEmpresasAdmin();
    }

    /**
     * Limpia los campos de la parte del login
     */
    private void cleanFields() {
        this.cedulaLogin.setText("");
        this.contraLogin.setText("");
    }

    /**
     * Muestra los productos que se van agregando al carrito Muestra los
     * detalles y de la venta con sus montos.
     */
    private void mostrarProductosCarrito() {
        this.ventaTemp = new Ventas();
        DefaultListModel model = new DefaultListModel();
        this.carritoProductos.setModel(model);
        Double montoSinImpuestos = 0d;
        for (int i = 0; i < this.usuarioActual.getCarritoCompras().size(); i++) {
            Producto p1 = (Producto) this.usuarioActual.getCarritoCompras().get(i);
            montoSinImpuestos += p1.getCosto() * p1.getCantidad();
            model.addElement(this.usuarioActual.getCarritoCompras().get(i).getDetalles());
        }
        ventaTemp.setCarritoCompras(this.usuarioActual.getCarritoCompras());
        ventaTemp.setMontoSinImpuesto(montoSinImpuestos);
        ventaTemp.setImpuesto(0.13d);
        ventaTemp.setCostpEnvio(1000d);
        Double montoTotal = (ventaTemp.getMontoSinImpuesto() * ventaTemp.getImpuesto()) + (ventaTemp.getMontoSinImpuesto()) + ventaTemp.getCostpEnvio();
        ventaTemp.setMontoTotal(montoTotal);

        String detalles = "Monto Sin Impuesto: " + ventaTemp.getMontoSinImpuesto() + "\n"
                + "Impuesto: " + ventaTemp.getImpuesto() + "\n"
                + "Costo Envio: " + ventaTemp.getCostpEnvio() + "\n"
                + "Monto total: " + ventaTemp.getMontoTotal() + "\n";

        this.detallesCompra.setText(detalles);

    }

    /**
     * Limpia los campos del registro
     */
    private void cleanFieldsAndValues() {
        this.cedulaRegistro.setText("");
        this.nombreRegistro.setText("");
        this.dirRegistro.setText("");
        this.telefonoRegistro.setText("");
        this.contraRegistro.setText("");

    }

    /**
     * Compara si la cedula ya existe.
     *
     * @param cedula
     * @return Si existe o no
     */
    private Boolean checkUsuarioRegistrado(String cedula) {
        Boolean flag = false;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getCedula().equals(cedula)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Compara si corresponden los datos con los usuarios existentes
     *
     * @param cedula
     * @param password
     * @return
     */
    private Boolean checkLoginSuccess(String cedula, String password) {
        Boolean flag = false;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getCedula().equals(cedula) && this.clientes.get(i).getContra().equals(password)) {
                flag = true;
                this.usuarioActual = this.clientes.get(i);
            }
        }
        return flag;
    }

    /**
     * Compara si corresponde a los credenciales del admin
     *
     * @param cedula
     * @param password
     * @return
     */
    private Boolean checkLoginAdmin(String cedula, String password) {
        Boolean flag = false;

        if (this.admin.getCedula().equals(cedula) && this.admin.getContra().equals(password)) {
            flag = true;
        }
        return flag;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpresas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        carritoUsuario = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        carritoProductos = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        facturarButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        eliminarProducto = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        detallesCompra = new javax.swing.JTextArea();
        historialCompras = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        comprasRealizadas = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        productosVenta = new javax.swing.JList<>();
        adminPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaEmpresasAdmin = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        agregarProductoAdmin = new javax.swing.JButton();
        login = new javax.swing.JPanel();
        logoServices = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cedulaLogin = new javax.swing.JTextField();
        contraLogin = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        registroBtn = new javax.swing.JButton();
        ingresarBtn = new javax.swing.JButton();
        registro = new javax.swing.JPanel();
        cedulaRegistro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombreRegistro = new javax.swing.JTextField();
        telefonoRegistro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dirRegistro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        contraRegistro = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tec Services App");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setMinimumSize(new java.awt.Dimension(350, 600));
        home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaEmpresas.setBackground(new java.awt.Color(255, 255, 255));
        listaEmpresas.setForeground(new java.awt.Color(0, 0, 0));
        listaEmpresas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaEmpresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaEmpresas);

        home.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 350, 170));

        listaProductos.setBackground(new java.awt.Color(255, 255, 255));
        listaProductos.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(listaProductos);

        home.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 350, 180));

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Historial");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        home.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 120, 30));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Productos:");
        home.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 350, 30));

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Ventas");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        home.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 110, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecservices/Images/carrito.png"))); // NOI18N
        home.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 30, 30));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Empresas:");
        home.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 350, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecservices/Images/historial.png"))); // NOI18N
        home.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Agregar Producto");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        home.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 160, -1));

        jLabel22.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("<");
        jLabel22.setToolTipText("");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        home.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 600));

        carritoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        carritoUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        carritoProductos.setBackground(new java.awt.Color(255, 255, 255));
        carritoProductos.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(carritoProductos);

        carritoUsuario.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 310, 290));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Precio de los servicios:");
        carritoUsuario.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 350, 30));

        facturarButton.setText("Pagar");
        facturarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facturarButtonMouseClicked(evt);
            }
        });
        carritoUsuario.add(facturarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 350, -1));

        jLabel18.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("<");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        carritoUsuario.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        eliminarProducto.setText("Eliminar");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });
        carritoUsuario.add(eliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 120, -1));

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Productos:");
        carritoUsuario.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 30));

        detallesCompra.setEditable(false);
        detallesCompra.setBackground(new java.awt.Color(255, 255, 255));
        detallesCompra.setColumns(20);
        detallesCompra.setForeground(new java.awt.Color(0, 0, 0));
        detallesCompra.setRows(5);
        jScrollPane5.setViewportView(detallesCompra);

        carritoUsuario.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 330, 140));

        getContentPane().add(carritoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 600));

        historialCompras.setBackground(new java.awt.Color(255, 255, 255));
        historialCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Detalles de la compra:");
        historialCompras.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 350, 30));

        jLabel25.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("<");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        historialCompras.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel26.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Compras Realizadas:");
        historialCompras.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 30));

        comprasRealizadas.setBackground(new java.awt.Color(255, 255, 255));
        comprasRealizadas.setForeground(new java.awt.Color(0, 0, 0));
        comprasRealizadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comprasRealizadasMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(comprasRealizadas);

        historialCompras.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 310, 230));

        productosVenta.setBackground(new java.awt.Color(255, 255, 255));
        productosVenta.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane8.setViewportView(productosVenta);

        historialCompras.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, 280));

        getContentPane().add(historialCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        adminPanel.setBackground(new java.awt.Color(255, 255, 255));
        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaEmpresasAdmin.setBackground(new java.awt.Color(255, 255, 255));
        listaEmpresasAdmin.setForeground(new java.awt.Color(0, 0, 0));
        listaEmpresasAdmin.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaEmpresasAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaEmpresasAdminMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaEmpresasAdmin);

        adminPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 350, 170));

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Empresas:");
        adminPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 350, 30));

        jLabel21.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("<");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jLabel21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel21KeyPressed(evt);
            }
        });
        adminPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        agregarProductoAdmin.setBackground(new java.awt.Color(255, 255, 255));
        agregarProductoAdmin.setForeground(new java.awt.Color(0, 0, 0));
        agregarProductoAdmin.setText("Agregar Nuevo Producto");
        agregarProductoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoAdminActionPerformed(evt);
            }
        });
        adminPanel.add(agregarProductoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        getContentPane().add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 600));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setMinimumSize(new java.awt.Dimension(350, 600));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoServices.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        logoServices.setForeground(new java.awt.Color(0, 0, 0));
        logoServices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoServices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecservices/Images/logo.png"))); // NOI18N
        login.add(logoServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 200));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña:");
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 350, 30));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cedula:");
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 350, 30));

        cedulaLogin.setBackground(new java.awt.Color(255, 255, 255));
        cedulaLogin.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cedulaLogin.setForeground(new java.awt.Color(0, 0, 0));
        cedulaLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedulaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaLoginActionPerformed(evt);
            }
        });
        login.add(cedulaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 220, 30));

        contraLogin.setBackground(new java.awt.Color(255, 255, 255));
        contraLogin.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        contraLogin.setForeground(new java.awt.Color(0, 0, 0));
        contraLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        login.add(contraLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 220, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecservices/Images/letras.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 350, 60));

        registroBtn.setBackground(new java.awt.Color(255, 255, 255));
        registroBtn.setForeground(new java.awt.Color(0, 0, 0));
        registroBtn.setText("Registrarse");
        registroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBtnActionPerformed(evt);
            }
        });
        login.add(registroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 120, 30));

        ingresarBtn.setBackground(new java.awt.Color(255, 255, 255));
        ingresarBtn.setForeground(new java.awt.Color(0, 0, 0));
        ingresarBtn.setText("Ingresar");
        ingresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBtnActionPerformed(evt);
            }
        });
        login.add(ingresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 80, 30));

        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 600));

        registro.setBackground(new java.awt.Color(255, 255, 255));
        registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cedulaRegistro.setBackground(new java.awt.Color(255, 255, 255));
        cedulaRegistro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cedulaRegistro.setForeground(new java.awt.Color(0, 0, 0));
        cedulaRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaRegistroActionPerformed(evt);
            }
        });
        registro.add(cedulaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 190, 30));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Registro");
        registro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 270, 80));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cedula:");
        registro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 90, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nombre:");
        registro.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, 30));

        nombreRegistro.setBackground(new java.awt.Color(255, 255, 255));
        nombreRegistro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombreRegistro.setForeground(new java.awt.Color(0, 0, 0));
        nombreRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreRegistroActionPerformed(evt);
            }
        });
        registro.add(nombreRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 190, 30));

        telefonoRegistro.setBackground(new java.awt.Color(255, 255, 255));
        telefonoRegistro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        telefonoRegistro.setForeground(new java.awt.Color(0, 0, 0));
        telefonoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoRegistroActionPerformed(evt);
            }
        });
        registro.add(telefonoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 190, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Contraseña:");
        registro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 110, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecservices/Images/add.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        registro.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, 30));

        dirRegistro.setBackground(new java.awt.Color(255, 255, 255));
        dirRegistro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        dirRegistro.setForeground(new java.awt.Color(0, 0, 0));
        dirRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirRegistroActionPerformed(evt);
            }
        });
        registro.add(dirRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 190, 30));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Dirección:");
        registro.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 90, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        registro.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 130, 50));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Teléfono:");
        registro.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, 30));

        contraRegistro.setBackground(new java.awt.Color(255, 255, 255));
        contraRegistro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        contraRegistro.setForeground(new java.awt.Color(0, 0, 0));
        contraRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        registro.add(contraRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 329, 190, 30));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("<");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        registro.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        getContentPane().add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 600));

        getAccessibleContext().setAccessibleDescription("JFrameVentana");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cedulaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaLoginActionPerformed

    private void registroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBtnActionPerformed
        irRegistro();
        this.tempTels = new ArrayList<String>();
    }//GEN-LAST:event_registroBtnActionPerformed

    private void cedulaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaRegistroActionPerformed

    private void nombreRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreRegistroActionPerformed

    private void telefonoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoRegistroActionPerformed

    private void dirRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirRegistroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (this.nombreRegistro.getText().equals("") || this.dirRegistro.getText().equals("") || this.cedulaRegistro.getText().equals("") || this.contraRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos Incompletos");
        } else {
            if (checkUsuarioRegistrado(this.cedulaRegistro.getText()) == true) {
                JOptionPane.showMessageDialog(null, "Usuario ya se encuentra registrado");
            } else {
                if (this.tempTels.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero de teléfono");
                } else {

                    String cedTemp = this.cedulaRegistro.getText();
                    String nombTemp = this.nombreRegistro.getText();
                    String dirTemp = this.dirRegistro.getText();
                    String contraTemp = this.contraRegistro.getText();
                    ArrayList<String> telTemp = new ArrayList<String>();
                    telTemp = this.tempTels;
                    Cliente cliente = new Cliente(cedTemp, nombTemp, dirTemp, telTemp, contraTemp);
                    this.clientes.add(cliente);
                    JOptionPane.showMessageDialog(null, "Registrado Satisfactoriamente");
                    cleanFieldsAndValues();
                    irLogin();
                    this.tempTels.clear();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if (!this.telefonoRegistro.getText().equals("")) {
            String tel = this.telefonoRegistro.getText();
            this.tempTels.add(tel);
            JOptionPane.showMessageDialog(null, "Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Digite un numero de telefono");
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        irLogin();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void ingresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBtnActionPerformed
        if (this.cedulaLogin.getText().equals("") || this.contraLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos Vacios");
        } else {
            if (checkLoginSuccess(this.cedulaLogin.getText(), this.contraLogin.getText()) == true) {
                irHome();
                cleanFields();

            } else if (checkLoginAdmin(this.cedulaLogin.getText(), this.contraLogin.getText()) == true) {
                irAdmin();
                cleanFields();
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra el usuario");
            }
        }

    }//GEN-LAST:event_ingresarBtnActionPerformed


    private void listaEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaEmpresasMouseClicked
        Integer i = this.listaEmpresas.getSelectedIndex();
        mostrarProductos(i);
    }//GEN-LAST:event_listaEmpresasMouseClicked

    private void listaEmpresasAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaEmpresasAdminMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaEmpresasAdminMouseClicked

    private void jLabel21KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel21KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21KeyPressed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        this.adminPanel.setEnabled(false);
        this.adminPanel.setVisible(false);
        this.login.setEnabled(true);
        this.login.setVisible(true);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void agregarProductoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductoAdminActionPerformed
        this.empresas.get(listaEmpresasAdmin.getSelectedIndex()).addProducto();
    }//GEN-LAST:event_agregarProductoAdminActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        this.home.setEnabled(false);
        this.home.setVisible(false);
        this.login.setEnabled(true);
        this.login.setVisible(true);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        IEmpresa empTemp = this.empresas.get(this.listaEmpresas.getSelectedIndex());
        Producto productTemp = (Producto) empTemp.getProductos().get(this.listaProductos.getSelectedIndex());
        Integer cantTemp = Integer.parseInt(JOptionPane.showInputDialog("¿Digite la cantidad que desea agregar?"));
        productTemp.setCantidad(cantTemp);
        this.usuarioActual.AgregarCarrito(productTemp);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.carritoUsuario.setVisible(false);
        this.carritoUsuario.setEnabled(false);
        this.home.setVisible(true);
        this.home.setVisible(true);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        this.carritoUsuario.setVisible(true);
        this.carritoUsuario.setEnabled(true);
        this.home.setVisible(false);
        this.home.setVisible(false);
        mostrarProductosCarrito();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void facturarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facturarButtonMouseClicked

        
        this.productTemp = new ArrayList<IProducto>();
        productTemp = (ArrayList<IProducto>)(usuarioActual.getCarritoCompras()).clone();
        this.ventaTemp.setCarritoCompras(productTemp);
        this.usuarioActual.addComprasRealizada(this.ventaTemp);
        
        JOptionPane.showMessageDialog(null, "Registrado correctamente");
        this.usuarioActual.clearCarrito();
        mostrarProductosCarrito();

    }//GEN-LAST:event_facturarButtonMouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        this.historialCompras.setVisible(true);
        this.historialCompras.setEnabled(true);
        this.home.setVisible(false);
        this.home.setVisible(false);

        mostrarCompras();

    }//GEN-LAST:event_jLabel19MouseClicked

    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed
        DefaultListModel modelo = (DefaultListModel) carritoProductos.getModel();
        int index = carritoProductos.getSelectedIndex();
        modelo.remove(index);
        this.usuarioActual.getCarritoCompras().remove(index);
        mostrarProductosCarrito();
    }//GEN-LAST:event_eliminarProductoActionPerformed

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        this.historialCompras.setVisible(false);
        this.historialCompras.setEnabled(false);
        this.home.setVisible(true);
        this.home.setVisible(true);

    }//GEN-LAST:event_jLabel25MouseClicked

    private void comprasRealizadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comprasRealizadasMouseClicked
        mostrarDetallesCompra();
    }//GEN-LAST:event_comprasRealizadasMouseClicked

    private void mostrarCompras() {
        DefaultListModel model = new DefaultListModel();
        this.comprasRealizadas.setModel(model);
        comprasRealizadas.setFixedCellWidth(80);
        comprasRealizadas.setFixedCellHeight(80);

        for (int i = 0; i < this.usuarioActual.getComprasRealizadas().size(); i++) {

            Ventas v = new Ventas();
            v = (Ventas) this.usuarioActual.getComprasRealizadas().get(i);
            model.addElement(v.obtenerInformacionCompras());
        }
    }

    private void mostrarDetallesCompra() {
        Integer current = this.comprasRealizadas.getSelectedIndex();
        DefaultListModel model = new DefaultListModel();
        this.productosVenta.setModel(model);
        this.productosVenta.setFixedCellWidth(200);
        this.productosVenta.setFixedCellHeight(200);

        ArrayList<Ventas> compras = this.usuarioActual.getComprasRealizadas();
        Ventas temp = compras.get(current);
        for (int j = 0; j < temp.getCarritoCompras().size(); j++) {
            Producto producTemp = (Producto) temp.getCarritoCompras().get(j);

            model.addElement(producTemp.getDetalles());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TecServices.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TecServices.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TecServices.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TecServices.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TecServices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JButton agregarProductoAdmin;
    private javax.swing.JList<String> carritoProductos;
    private javax.swing.JPanel carritoUsuario;
    private javax.swing.JTextField cedulaLogin;
    private javax.swing.JTextField cedulaRegistro;
    private javax.swing.JList<String> comprasRealizadas;
    private javax.swing.JPasswordField contraLogin;
    private javax.swing.JPasswordField contraRegistro;
    private javax.swing.JTextArea detallesCompra;
    private javax.swing.JTextField dirRegistro;
    private javax.swing.JButton eliminarProducto;
    private javax.swing.JButton facturarButton;
    private javax.swing.JPanel historialCompras;
    private javax.swing.JPanel home;
    private javax.swing.JButton ingresarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<String> listaEmpresas;
    private javax.swing.JList<String> listaEmpresasAdmin;
    private javax.swing.JList<String> listaProductos;
    private javax.swing.JPanel login;
    private javax.swing.JLabel logoServices;
    private javax.swing.JTextField nombreRegistro;
    private javax.swing.JList<String> productosVenta;
    private javax.swing.JPanel registro;
    private javax.swing.JButton registroBtn;
    private javax.swing.JTextField telefonoRegistro;
    // End of variables declaration//GEN-END:variables
}
