package notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad extends javax.swing.JFrame {

    String filename;

    public Notepad() {
        initComponents();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextEditor = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Exit = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        cutviewitem = new javax.swing.JMenuItem();
        copyviewitem = new javax.swing.JMenuItem();
        pasteviewitem = new javax.swing.JMenuItem();
        deleteviewitem = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextEditor.setColumns(20);
        TextEditor.setRows(5);
        jScrollPane1.setViewportView(TextEditor);

        FileMenu.setText("File");

        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        FileMenu.add(newFile);

        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        FileMenu.add(openFile);

        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        FileMenu.add(saveFile);
        FileMenu.add(jSeparator2);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        FileMenu.add(Exit);

        jMenuBar1.add(FileMenu);

        EditMenu.setText("Edit");
        EditMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMenuActionPerformed(evt);
            }
        });

        cutviewitem.setText("Cut");
        cutviewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutviewitemActionPerformed(evt);
            }
        });
        EditMenu.add(cutviewitem);

        copyviewitem.setText("Copy");
        copyviewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyviewitemActionPerformed(evt);
            }
        });
        EditMenu.add(copyviewitem);

        pasteviewitem.setText("Paste");
        pasteviewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteviewitemActionPerformed(evt);
            }
        });
        EditMenu.add(pasteviewitem);

        deleteviewitem.setText("Delete");
        deleteviewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteviewitemActionPerformed(evt);
            }
        });
        EditMenu.add(deleteviewitem);

        jMenuBar1.add(EditMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        // TODO add your handling code here:
        TextEditor.setText("");
        setTitle(filename);
    }//GEN-LAST:event_newFileActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        // TODO add your handling code here:
        FileDialog fd = new FileDialog(Notepad.this, "Select File", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            filename = fd.getDirectory() + fd.getFile();
            setTitle(filename);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line + "\n");
                TextEditor.setText(stringBuffer.toString());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }

       
    }//GEN-LAST:event_openFileActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);


    }//GEN-LAST:event_ExitActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
      
        FileDialog fileDialog = new FileDialog(Notepad.this, "Save File ", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(filename);
            try {
                FileWriter output = new FileWriter(filename);
                output.write(TextEditor.getText());
                output.close();
                setTitle(filename);

            } catch (Exception e) {
                System.out.println("File not Found");
            }
        }
        TextEditor.requestFocus();
    }//GEN-LAST:event_saveFileActionPerformed

    private void copyviewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyviewitemActionPerformed
       
        TextEditor.copy();
    }//GEN-LAST:event_copyviewitemActionPerformed

    private void EditMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMenuActionPerformed
      
    }//GEN-LAST:event_EditMenuActionPerformed

    private void cutviewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutviewitemActionPerformed
        
        TextEditor.cut();
    }//GEN-LAST:event_cutviewitemActionPerformed

    private void pasteviewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteviewitemActionPerformed
     
        TextEditor.paste();
    }//GEN-LAST:event_pasteviewitemActionPerformed

    private void deleteviewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteviewitemActionPerformed

    }//GEN-LAST:event_deleteviewitemActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JTextArea TextEditor;
    public javax.swing.JMenuItem copyviewitem;
    private javax.swing.JMenuItem cutviewitem;
    private javax.swing.JMenuItem deleteviewitem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem pasteviewitem;
    private javax.swing.JMenuItem saveFile;
    // End of variables declaration//GEN-END:variables
}
