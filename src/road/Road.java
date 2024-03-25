/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package road;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author macie
 */
public class Road extends javax.swing.JFrame {

    int ARRAY_LENGTH = 50;
    int RANDOM_SCOPE = 400;
    
    int[][] points = new int[ARRAY_LENGTH][2]; 
    boolean[] isTouched = new boolean[ARRAY_LENGTH];
    
    Graphics g;
    Random random;
    
    /**
     * Creates new form Road
     */
    public Road() {
        initComponents();
        g = jPanel1.getGraphics();
        jPanel1.paintComponents(g);
        random = new Random();
        
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Only near");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("By Distance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(43, 43, 43)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        /* removing previous points*/
        g.setColor(jPanel1.getBackground());
        g.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        g.setColor(Color.black);
        
        boolean isStart = true;
        
        /* filling points */
        for (int i = 0; i < points.length; i++){
            g.setColor(Color.black);
            
            int x  = random.nextInt(RANDOM_SCOPE) + 1;
            int y = random.nextInt(RANDOM_SCOPE) + 1;

            points[i][0] = x;
            points[i][1] = y;

            if (isStart){
                g.setColor(Color.blue);
                isStart = false;
            }
            
            if (i == points.length - 1){
                g.setColor(Color.red);
            }
            
            g.fillOval(x - 5, y - 5, 10, 10);
            
            isTouched[i] = false;
       }
       isTouched[0] = true;
       jButton3.setEnabled(true);
       jButton4.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      jPanel1.repaint();
      jButton3.setEnabled(false);
      jButton4.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        g.setColor(Color.black);
        
        int lastX = points[points.length - 1][0];
        int lastY = points[points.length - 1][1];
        
        int currentX = points[0][0];
        int currentY = points[0][1];
        
        int nextX = -1;
        int nextY = -1;
        int nextIndex = -1;
        
        boolean isEnd = false;
        
        for (int[] point: points){
            int x = point[0];
            int y = point[1];
            
            float lastDistance = Integer.MAX_VALUE;
            
            for (int i = 0; i < points.length; i++){
                if(isTouched[i]){
                    continue;
                }
                
                float currentDistance = (float) Math.sqrt((points[i][0] - currentX) * (points[i][0] - currentX) + (points[i][1] - currentY) * (points[i][1] - currentY));
                
                if (currentDistance < lastDistance){
                    nextX = points[i][0];
                    nextY = points[i][1];
                    nextIndex = i;
                    lastDistance = currentDistance;
                }
            }
            
            isTouched[nextIndex] = true;
           
            if (!isEnd){
                g.drawLine(currentX, currentY, nextX, nextY);
                currentX = nextX;
                currentY = nextY;
            }
            
            if (nextIndex == ARRAY_LENGTH - 1){
                isEnd = true;
            }
        }
        
       jButton3.setEnabled(false);
       jButton4.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        g.setColor(Color.black);
        
        int lastX = points[points.length - 1][0];
        int lastY = points[points.length - 1][1];
        
        int currentX = points[0][0];
        int currentY = points[0][1];
        
        int nextX = -1;
        int nextY = -1;
        int nextIndex = -1;
        
        boolean isEnd = false;
        
        float DISTANCE_BETWEEN_START_AND_STOP = (float) Math.sqrt((lastX - currentX) * (lastX - currentX) + (lastY - currentY) * (lastY - currentY));
        float currentDistanceToStop = DISTANCE_BETWEEN_START_AND_STOP;
        
        for (int[] point: points){
            int x = point[0];
            int y = point[1];
            
            float lastDistance = Integer.MAX_VALUE;
            
            for (int i = 0; i < points.length; i++){
                if(isTouched[i]){
                    continue;
                }
                
                float currentDistance = (float) Math.sqrt((points[i][0] - currentX) * (points[i][0] - currentX) + (points[i][1] - currentY) * (points[i][1] - currentY));
                
                currentDistanceToStop = (float) Math.sqrt((lastX - currentX) * (lastX - currentX) + (lastY - currentY) * (lastY - currentY));
                float nextDistanceToStop = (float) Math.sqrt((lastX - points[i][0]) * (lastX - points[i][0]) + (lastY - points[i][1]) * (lastY - points[i][1]));
              
                if (nextDistanceToStop < currentDistanceToStop){
                    if (currentDistance < lastDistance){
                        nextX = points[i][0];
                        nextY = points[i][1];
                        nextIndex = i;
                        lastDistance = currentDistance;
                    }
                }
            }
            
            isTouched[nextIndex] = true;
           
            if (!isEnd){
                g.drawLine(currentX, currentY, nextX, nextY);
                currentX = nextX;
                currentY = nextY;
            }
            
            if (nextIndex == ARRAY_LENGTH - 1){
                isEnd = true;
            }
        }
       jButton3.setEnabled(false);
       jButton4.setEnabled(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Road.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Road.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Road.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Road.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Road().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
