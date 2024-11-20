import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;

// Clase principal para la aplicación multimedia que reproduce audio.
public class ReproductorAudio {
    private Clip clip; // Clip que se utilizará para reproducir audio

    public ReproductorAudio() {
        JFrame frame = createFrame();       // Crear el marco principal.
        initializeComponents(frame);       // Inicializar los componentes gráficos.
        loadAudio();                       // Cargar el archivo de audio.
        frame.setVisible(true);             // Hacer visible el marco.
    }

    // Método para crear y configurar el marco principal.
    private JFrame createFrame() {
        JFrame frame = new JFrame("Reproductor de Audio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        return frame;                       // Retornar el marco creado.
    }

    // Método para inicializar los componentes gráficos (botones).
    private void initializeComponents(JFrame frame) {
        JButton btnReproducir = new JButton("Reproducir");   // Botón para reproducir audio.
        JButton btnPausar = new JButton("Pausar");           // Botón para pausar audio.
        JButton btnReanudar = new JButton("Reanudar");       // Botón para reanudar audio.

        btnReproducir.addActionListener(e -> playAudio());   // Acción al hacer clic en reproducir.
        btnPausar.addActionListener(e -> clip.stop());       // Acción al hacer clic en pausar.
        btnReanudar.addActionListener(e -> clip.start());     // Acción al hacer clic en reanudar.

        frame.add(btnReproducir);   // Agregar botón reproducir al marco.
        frame.add(btnPausar);       // Agregar botón pausar al marco.
        frame.add(btnReanudar);     // Agregar botón reanudar al marco.
    }

    // Método para cargar el archivo de audio desde una ruta específica.
    private void loadAudio() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/audio.wav")); 
            clip = AudioSystem.getClip();   // Obtener un clip de audio.
            clip.open(audioInputStream);     // Abrir y cargar el archivo de audio en el clip.
            
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) { 
                JOptionPane.showMessageDialog(null, "Error al cargar el audio.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();           // Imprimir stack trace si hay un error.
                System.exit(1);               // Terminar la aplicación si hay un error crítico.
            }
     }

     private void playAudio() { 
         clip.setFramePosition(0);   // Reiniciar la posición del clip a inicio antes de reproducir.
         clip.start();               // Iniciar la reproducción del audio.
     }

     public static void main(String[] args) { 
         SwingUtilities.invokeLater(ReproductorAudio::new);   // Ejecutar en hilo del evento Swing.
     }
}