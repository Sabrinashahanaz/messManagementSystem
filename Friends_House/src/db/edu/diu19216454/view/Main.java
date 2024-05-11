package db.edu.diu19216454.view;

import bd.edu.diu19216454.model.LoggedInMember;
import bd.edu.diu19216454.model.Member;

@SuppressWarnings("serial")
public class Main extends javax.swing.JFrame {
    
    Member loggedInMember = LoggedInMember.getInstance().getMember();
    
    public Main() {
        initComponents();
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        if (!"manager".equals(loggedInMember.gettype())) {
            memberMenu.setVisible(false);
            shoppingMenu.setVisible(false);
        }
      
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        desktopPanel = new javax.swing.JDesktopPane();
        MenuBar = new javax.swing.JMenuBar();
        memberMenu = new javax.swing.JMenu();
        shoppingMenu = new javax.swing.JMenu();
        fsMenu = new javax.swing.JMenuItem();
        depositMenu1 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(33, 47, 60));

        desktopPanel.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout desktopPanelLayout = new javax.swing.GroupLayout(desktopPanel);
        desktopPanel.setLayout(desktopPanelLayout);
        desktopPanelLayout.setHorizontalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        desktopPanelLayout.setVerticalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPanel)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        MenuBar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        MenuBar.setMargin(new java.awt.Insets(5, 0, 5, 0));

        memberMenu.setText("Member");
        memberMenu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        memberMenu.setMargin(new java.awt.Insets(5, 0, 5, 0));
        memberMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                memberMenuMousePressed(evt);
            }
        });
        MenuBar.add(memberMenu);

        shoppingMenu.setText("  Shopping");
        shoppingMenu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        fsMenu.setText("Regular Shopping");
        fsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fsMenuActionPerformed(evt);
            }
        });
        shoppingMenu.add(fsMenu);

        MenuBar.add(shoppingMenu);

        depositMenu1.setText("  Deposit");
        depositMenu1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        depositMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                depositMenu1MousePressed(evt);
            }
        });
        MenuBar.add(depositMenu1);

        jMenu1.setText("  Fixed Expense");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        MenuBar.add(jMenu1);

        jMenu3.setText("  Payment");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        MenuBar.add(jMenu3);

        jMenu4.setText("  Meal");
        jMenu4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu4MousePressed(evt);
            }
        });
        MenuBar.add(jMenu4);

        jMenu5.setText("   Final Report");
        jMenu5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MenuBar.add(jMenu5);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void memberMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberMenuMousePressed
        MemberForm mf = new MemberForm();
        mf.setVisible(true);
        desktopPanel.add(mf);
    }//GEN-LAST:event_memberMenuMousePressed

    private void depositMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositMenu1MousePressed
        DepositForm df = new DepositForm();
        df.setVisible(true);
        desktopPanel.add(df);
    }//GEN-LAST:event_depositMenu1MousePressed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        FixedExpenseView fxv = new FixedExpenseView();
        fxv.setVisible(true);
        desktopPanel.add(fxv);
    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        PaymentView pv = new PaymentView();
        pv.setVisible(true);
        desktopPanel.add(pv);
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
        MealView mv = new MealView();
        mv.setVisible(true);
        desktopPanel.add(mv);
    }//GEN-LAST:event_jMenu4MousePressed

    private void fsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fsMenuActionPerformed
        RegularShoppingView fsv = new RegularShoppingView();
        fsv.setVisible(true);
        desktopPanel.add(fsv);
    }//GEN-LAST:event_fsMenuActionPerformed
    
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu depositMenu1;
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JMenuItem fsMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenu memberMenu;
    private javax.swing.JMenu shoppingMenu;
    // End of variables declaration//GEN-END:variables
}
