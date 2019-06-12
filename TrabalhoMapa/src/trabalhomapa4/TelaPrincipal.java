/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomapa4;

public class TelaPrincipal extends javax.swing.JFrame {
    
    
    public TelaPrincipal(){
        initComponents();
    }
    
    
    private void initComponents() {
        
        mapa1 = new Mapa();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        javax.swing.GroupLayout mapa1Layout = new javax.swing.GroupLayout(mapa1);
        mapa1.setLayout(mapa1Layout);
        mapa1Layout.setHorizontalGroup(
            mapa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        mapa1Layout.setVerticalGroup(
            mapa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0,800, Short.MAX_VALUE)
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    
    }

    public static void main(String args[]){
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    private Mapa mapa1;

       
}