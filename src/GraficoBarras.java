import java.awt.*;
import javax.swing.*;

// Clase principal para crear un gráfico de barras
public class GraficoBarras extends JPanel {
    private final int[] ventas = {50, 80, 30, 90, 60}; // Datos de ventas como ejemplo

    // Método que se llama automáticamente para dibujar en el panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llamar al método padre para limpiar el panel antes de dibujar
        drawBars(g);             // Llamar al método que dibuja las barras en el gráfico
    }

    // Método para dibujar las barras en el gráfico basado en los datos de ventas
    private void drawBars(Graphics g) {
        int anchoBarra = 40;     // Ancho de cada barra en píxeles
        int espacio = 10;         // Espacio entre las barras en píxeles
        int maxAltura = 100;      // Altura máxima del gráfico (en píxeles)

        for (int i = 0; i < ventas.length; i++) { 
            int altura = (int) ((ventas[i] / 100.0) * maxAltura); 
            g.fillRect(i * (anchoBarra + espacio), maxAltura - altura, anchoBarra, altura); 
            g.drawString(String.valueOf(ventas[i]), i * (anchoBarra + espacio), maxAltura - altura - 5); 
            // Dibujar cada barra y agregar etiquetas con los valores correspondientes encima de cada barra.
        }
    }

    // Método principal para ejecutar la aplicación gráfica del gráfico de barras.
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráfico de Barras"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(300, 200); 
        frame.add(new GraficoBarras()); 
        frame.setVisible(true); 
    }
}