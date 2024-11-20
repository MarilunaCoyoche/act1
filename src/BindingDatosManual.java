import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase principal para la aplicación de binding de datos manual
public class BindingDatosManual {
    // Atributos del modelo de datos
    private String nombre; // Almacena el nombre del producto
    private double precio;  // Almacena el precio del producto

    // Componentes de la interfaz gráfica
    private JTextField txtNombre; // Campo de texto para el nombre
    private JTextField txtPrecio;  // Campo de texto para el precio
    private JLabel lblResultado;   // Etiqueta para mostrar el resultado

    // Constructor de la clase
    public BindingDatosManual() {
        JFrame frame = createFrame(); // Crear el marco principal
        initializeComponents(frame);  // Inicializar los componentes de la interfaz
        frame.setVisible(true);        // Hacer visible el marco
    }

    // Método para crear y configurar el marco principal
    private JFrame createFrame() {
        JFrame frame = new JFrame("Binding de Datos Manual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        frame.setSize(300, 200); // Establecer tamaño del marco
        frame.setLayout(new FlowLayout()); // Usar un layout de flujo para los componentes
        return frame; // Retornar el marco creado
    }

    // Método para inicializar los componentes de la interfaz gráfica
    private void initializeComponents(JFrame frame) {
        txtNombre = new JTextField(15); // Crear campo de texto para el nombre con 15 columnas
        txtPrecio = new JTextField(15);  // Crear campo de texto para el precio con 15 columnas
        JButton btnActualizar = new JButton("Actualizar Producto"); // Botón para actualizar datos
        lblResultado = new JLabel("Producto: "); // Etiqueta para mostrar resultados iniciales

        // Agregar etiquetas y campos al marco
        frame.add(new JLabel("Nombre: "));
        frame.add(txtNombre);
        frame.add(new JLabel("Precio: "));
        frame.add(txtPrecio);
        frame.add(btnActualizar);
        frame.add(lblResultado);

        // Acción del botón para actualizar el modelo de datos al hacer clic
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData(); // Llamar al método para actualizar datos
            }
        });
    }

    // Método para actualizar los datos del modelo y mostrar en la etiqueta
    private void updateData() {
        nombre = txtNombre.getText(); // Obtener el nombre ingresado por el usuario
        try {
            precio = Double.parseDouble(txtPrecio.getText()); // Convertir el precio ingresado a double
            lblResultado.setText("Producto: " + nombre + ", Precio: " + precio); // Mostrar resultado en la etiqueta
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
            // Mostrar mensaje de error si el formato del precio es incorrecto
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BindingDatosManual::new); // Ejecutar en el hilo de eventos de Swing
    }
}