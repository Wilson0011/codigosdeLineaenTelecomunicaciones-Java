
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanceVangot
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        combox = new javax.swing.JComboBox<>();
        combox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laboratorio Final, Teleco ll");

        jLabel4.setText("jLabel4");
        jLabel4.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        jLabel1.setText("Ingrese El Mensaje A Codificar");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setText("Linea");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setSelectionColor(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        jLabel2.setText("Codificación De Canal");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        jLabel3.setText("Codificación De Fuente");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Huffman", "Shannon", "Algebraica", "Bloques", "RLE", "DPCM" }));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButton1, org.jdesktop.beansbinding.ObjectProperty.create(), combox, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxActionPerformed(evt);
            }
        });

        combox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(combox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(127, 127, 127))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(192, 192, 192)
                            .addComponent(jLabel2)
                            .addGap(266, 266, 266)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(264, 264, 264))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)))
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
public int tipos=0;
public int lectura=0;
String Texto;
public int trama[]=new int [30];
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Texto="";
        int combobox=combox.getSelectedIndex();
        
    if(combobox==0){
        Huffman nuevo = new Huffman();
        Texto=nuevo.Huffman(this.jTextField1.getText());
        nuevo=null;
        System.out.println(Texto);
    }
    else if(combobox==1){
        Shannon_Fano nuevo = new Shannon_Fano();
        Texto=nuevo.Shannon(this.jTextField1.getText());
        nuevo=null;
        System.out.println(Texto);
    }
    else if(combobox==2){
        Algebraica nuevo = new Algebraica();
        Texto=nuevo.Alge(this.jTextField1.getText());
        nuevo=null;
        System.out.println(Texto);
        
    }
    else if(combobox==3){
        Bloques nuevo = new Bloques();
        Texto=nuevo.Bloqueo(this.jTextField1.getText());
        nuevo=null;
        System.out.println(Texto);
    }
    else if(combobox==4){
        int combobox2=combox2.getSelectedIndex();
        RLE nuevo = new RLE();
        if(combobox2==0){
            Texto=nuevo.rles(this.jTextField1.getText(),1);
        }
        else if(combobox2==1){
            Texto=nuevo.rles(this.jTextField1.getText(),2);
        }
        else if(combobox2==2){
            Texto=nuevo.rles(this.jTextField1.getText(),3);
        }
        nuevo=null;
        System.out.println(Texto);
    }
    else if(combobox==5){
        int combobox3=combox2.getSelectedIndex();
        DPCM nuevo = new DPCM();
        if(combobox3==0){
            Texto=nuevo.dpcm(this.jTextField1.getText(),1);
        }
        else if(combobox3==1){
            Texto=nuevo.dpcm(this.jTextField1.getText(),2);
        }
        else if(combobox3==2){
            Texto=nuevo.dpcm(this.jTextField1.getText(),3);
        }
        nuevo=null;
        System.out.println(Texto);
    }
    Hamming Medio = new Hamming();
    String Media=Medio.hamming(Texto);
    
    System.out.println(Media);
        Medio=null;
        this.jTextArea1.setText(Texto);
        this.jTextArea2.setText(Media);
        this.jTextArea1.setEditable(false);
        this.jTextArea2.setEditable(false);
        char temporal[]=Media.toCharArray();
        for(int i=0;i<30;i++){
            trama[i]=0;
            
        }
        int y=0;
        if(temporal.length>30){
        y=30;
    }else{
          y=  temporal.length;
        }
        for(int i=0;i<y;i++){
            if(temporal[i]=='1'){
                trama[i]=1;
            }
            else{
                trama[i]=0;
            }
        }
        AMI aplicacion = new AMI(trama);
//aplicacion.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE);
Manchester aplicacion2 = new Manchester(trama);
//aplicacion.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE);

    }//GEN-LAST:event_jButton1ActionPerformed
    
    DefaultComboBoxModel modelolectura;
    private void comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxActionPerformed
        int combobox=combox.getSelectedIndex();
        String [] lectura={"Horizontal","Vertical","Zig-Zag"};
        String [] blanco={" "};
        
        if (combobox==0){
            modelolectura=new DefaultComboBoxModel(blanco);
            combox2.setModel(modelolectura);
        }else if (combobox==1){
            modelolectura=new DefaultComboBoxModel(blanco);
            combox2.setModel(modelolectura);
        }else if (combobox==2){
            modelolectura=new DefaultComboBoxModel(blanco);
            combox2.setModel(modelolectura);
        }else if (combobox==3){
            modelolectura=new DefaultComboBoxModel(blanco);
            combox2.setModel(modelolectura);
        }else if (combobox==4){
            modelolectura=new DefaultComboBoxModel(lectura);
            combox2.setModel(modelolectura);
        }else if (combobox==5){
            modelolectura=new DefaultComboBoxModel(lectura);
            combox2.setModel(modelolectura);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxActionPerformed

    private void combox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox2ActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combox;
    private javax.swing.JComboBox<String> combox2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
