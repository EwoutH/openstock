/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author meyerlu
 */
public class TelaPrincipal extends javax.swing.JFrame 
{

    //novo layout do mierstockfx
    //ele cria varios graficos, e todos tem a sua propria instancia de grafico com anotacoes, indicadores, e pode ser salvo ou carregado
    
    //public mierclasses.mcavcomms mav; //classe utilizada para comunicacao com alpha vantage
    public mierclasses.mciexcomms miex; //classe utilizada para comunicacao com IEX API
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal()
    {
        initComponents();
 
        inicializarTelaPrincipal();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Funcionamento Tela Principal">
    
    void inicializarTelaPrincipal()
    {
        //funcao inicial do programa, roda ao ligar
        //limitando para no maximo 20 graficos ao mesmo tempo
        jPanelItensAnalisadorAsset.setLayout(new java.awt.GridLayout(20,1));
        //holder do grafico eh um grid com um unico item
        jPanelHolderAnalisadorAsset.setLayout(new java.awt.GridLayout(1,1));

        //popular miex, utilizando para comunicar com IEX API
        miex = new mierclasses.mciexcomms();
        
        //revalidar componentes apos alteracoes graficas e criacoes
        this.validate();
        this.repaint();
    }
    
    
    void adicionarNovoAnalisadorAsset()
    {
        //existe um limite de 20 graficos por programa
        int numerograficos = jPanelItensAnalisadorAsset.getComponentCount();
        
        if (numerograficos < 20)
        {
            //funcao para adicionar novo itemanalisadorasset no programa, e este itemanalisadorasset tem um submodulografico associado a ele.
            panels.analisadorasset.itemanalisadorasset novompig = new panels.analisadorasset.itemanalisadorasset(this);
        
            //adicionar itemanalisadorasset ao jPanelItensGrafico
            jPanelItensAnalisadorAsset.add(novompig);

            //selecionar automaticamente ultimo componente adicionado
            int novonumeroassets = jPanelItensAnalisadorAsset.getComponentCount();
            selecionarItemAnalisadorAsset((panels.analisadorasset.itemanalisadorasset)jPanelItensAnalisadorAsset.getComponent(novonumeroassets-1));
        }
        else if (numerograficos >= 20)
        {
            mierclasses.mcfuncoeshelper.mostrarmensagem("Limite de 20 assets atingido");
        }
        
        //revalidar componentes apos alteracoes graficas e criacoes
        this.validate();
        this.repaint();
    }
    
    public void removerAnalisadorAsset(panels.analisadorasset.itemanalisadorasset mpiadeletar)
    {
        jPanelItensAnalisadorAsset.remove(mpiadeletar);
        
        int numerograficos = jPanelItensAnalisadorAsset.getComponentCount();
        if (numerograficos > 0)
        {
            selecionarItemAnalisadorAsset((panels.analisadorasset.itemanalisadorasset)jPanelItensAnalisadorAsset.getComponent(numerograficos-1));
        }
        else
        {
            jPanelHolderAnalisadorAsset.removeAll();
        }
        
        this.validate();
        this.repaint();
    }
    
    public void selecionarItemAnalisadorAsset(panels.analisadorasset.itemanalisadorasset mpigselecionar)
    {
        //funcao para selecionar item grafico
        
        //pintar todos os itens graficos com a cor padrao e esconder os seus submodulos
        int numerograficos = jPanelItensAnalisadorAsset.getComponentCount();
        for (int i = 0; i < numerograficos; i++)
        {
            panels.analisadorasset.itemanalisadorasset mpigatual = (panels.analisadorasset.itemanalisadorasset) jPanelItensAnalisadorAsset.getComponent(i);
            mpigatual.jPanelSub.setBackground(new java.awt.Color(55, 55, 55));
        }
        jPanelHolderAnalisadorAsset.removeAll();
        
        //pintar o item grafico desejado com cor de destaque, para demonstrar que este eh o grafico em uso no momento
        mpigselecionar.jPanelSub.setBackground(new java.awt.Color(55, 55, 105));
        
        //mostrar submodulo deste item grafico
        jPanelHolderAnalisadorAsset.add(mpigselecionar.aasset);
        
        
        //revalidar componentes apos alteracoes graficas e criacoes
        this.validate();
        this.repaint();
    }
    // </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanelHolderTelaPrincipal = new javax.swing.JPanel();
        jPanelHolderAnalisadorAsset = new javax.swing.JPanel();
        jLabelAdicionarAnalisadorAsset = new javax.swing.JLabel();
        jButtonJanelaConfiguracoes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelItensAnalisadorAsset = new javax.swing.JPanel();
        jButtonAdicionarAnalisadorAsset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Open Stock");
        setMinimumSize(new java.awt.Dimension(1200, 1000));

        jPanelHolderAnalisadorAsset.setBackground(new java.awt.Color(25, 25, 25));

        javax.swing.GroupLayout jPanelHolderAnalisadorAssetLayout = new javax.swing.GroupLayout(jPanelHolderAnalisadorAsset);
        jPanelHolderAnalisadorAsset.setLayout(jPanelHolderAnalisadorAssetLayout);
        jPanelHolderAnalisadorAssetLayout.setHorizontalGroup(
            jPanelHolderAnalisadorAssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        jPanelHolderAnalisadorAssetLayout.setVerticalGroup(
            jPanelHolderAnalisadorAssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        jLabelAdicionarAnalisadorAsset.setText("Assets");

        jButtonJanelaConfiguracoes.setText("Options");
        jButtonJanelaConfiguracoes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonJanelaConfiguracoesActionPerformed(evt);
            }
        });

        jPanelItensAnalisadorAsset.setBackground(new java.awt.Color(155, 155, 155));

        javax.swing.GroupLayout jPanelItensAnalisadorAssetLayout = new javax.swing.GroupLayout(jPanelItensAnalisadorAsset);
        jPanelItensAnalisadorAsset.setLayout(jPanelItensAnalisadorAssetLayout);
        jPanelItensAnalisadorAssetLayout.setHorizontalGroup(
            jPanelItensAnalisadorAssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );
        jPanelItensAnalisadorAssetLayout.setVerticalGroup(
            jPanelItensAnalisadorAssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelItensAnalisadorAsset);

        jButtonAdicionarAnalisadorAsset.setText("Add");
        jButtonAdicionarAnalisadorAsset.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAdicionarAnalisadorAssetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHolderTelaPrincipalLayout = new javax.swing.GroupLayout(jPanelHolderTelaPrincipal);
        jPanelHolderTelaPrincipal.setLayout(jPanelHolderTelaPrincipalLayout);
        jPanelHolderTelaPrincipalLayout.setHorizontalGroup(
            jPanelHolderTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHolderTelaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHolderTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelHolderTelaPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabelAdicionarAnalisadorAsset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAdicionarAnalisadorAsset))
                    .addComponent(jButtonJanelaConfiguracoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHolderAnalisadorAsset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHolderTelaPrincipalLayout.setVerticalGroup(
            jPanelHolderTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHolderAnalisadorAsset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelHolderTelaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHolderTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdicionarAnalisadorAsset)
                    .addComponent(jButtonAdicionarAnalisadorAsset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonJanelaConfiguracoes)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHolderTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHolderTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarAnalisadorAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarAnalisadorAssetActionPerformed
        adicionarNovoAnalisadorAsset();
    }//GEN-LAST:event_jButtonAdicionarAnalisadorAssetActionPerformed

    private void jButtonJanelaConfiguracoesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonJanelaConfiguracoesActionPerformed
    {//GEN-HEADEREND:event_jButtonJanelaConfiguracoesActionPerformed
        frames.configuracoes mfcg = new frames.configuracoes(this);
        mfcg.show();
    }//GEN-LAST:event_jButtonJanelaConfiguracoesActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarAnalisadorAsset;
    private javax.swing.JButton jButtonJanelaConfiguracoes;
    private javax.swing.JLabel jLabelAdicionarAnalisadorAsset;
    private javax.swing.JPanel jPanelHolderAnalisadorAsset;
    private javax.swing.JPanel jPanelHolderTelaPrincipal;
    private javax.swing.JPanel jPanelItensAnalisadorAsset;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
