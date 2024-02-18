
package generador.de.números.aleatorios.umg;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.TreeSet;
import java.io.FileReader;


public class Frm_Menu extends JFrame {


    public Frm_Menu() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TITULO = new javax.swing.JLabel();
        jbn_crear = new javax.swing.JButton();
        jbn_ordenar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TITULO.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        TITULO.setText("GENERADOR DE NUMEROS");

        jbn_crear.setText("Crear nuevos numeros");
        jbn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbn_crearActionPerformed(evt);
            }
        });

        jbn_ordenar.setText("Ordenar numeros");
        jbn_ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbn_ordenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbn_crear)
                        .addGap(32, 32, 32)
                        .addComponent(jbn_ordenar)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbn_crear)
                    .addComponent(jbn_ordenar))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbn_crearActionPerformed
        int cantidadNumeros = 1000000;
        int rangoMinimo = -10000000;
        int rangoMaximo = 10000000;

        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numeros_aleatorios.txt"))) {
            for (int i = 0; i < cantidadNumeros; i++) {
                int numeroAleatorio = rangoMinimo + random.nextInt(rangoMaximo - rangoMinimo + 1);
                writer.write(Integer.toString(numeroAleatorio));
                writer.newLine();
            }
            System.out.println("Numeros aleatorios generados y guardados en 'numeros_aleatorios.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbn_crearActionPerformed

    private void jbn_ordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbn_ordenarActionPerformed
        TreeSet<Integer> numerosOrdenados = cargarYOrdenarNumeros();
        guardarNumerosOrdenados(numerosOrdenados, "numeros_aleatorios.txt");

        System.out.println("Números ordenados y guardados en 'numeros_aleatorios.txt'.");
        // Mostrar los números ordenados en la consola
       
    }//GEN-LAST:event_jbn_ordenarActionPerformed

    private static TreeSet<Integer> cargarYOrdenarNumeros() {
        TreeSet<Integer> numerosOrdenados = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("numeros_aleatorios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                int numero = Integer.parseInt(linea);
                numerosOrdenados.add(numero);
            }
            
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            System.err.println("Error al cargar y ordenar los números desde el archivo.");
        }

        return numerosOrdenados;
    }
    
    private static void guardarNumerosOrdenados(TreeSet<Integer> numerosOrdenados, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int numero : numerosOrdenados) {
                writer.write(Integer.toString(numero));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar los números ordenados.");
        }
    }

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
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TITULO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbn_crear;
    private javax.swing.JButton jbn_ordenar;
    // End of variables declaration//GEN-END:variables
}
