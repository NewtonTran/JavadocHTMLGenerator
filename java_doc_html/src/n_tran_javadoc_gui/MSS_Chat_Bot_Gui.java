package n_tran_javadoc_gui;
/**************************************************************************/
/*
 * HERE IS WHERE YOU WILL IMPORT YOUR PACKAGE
 */

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;

import javax.swing.JLabel;

import java.awt.Color;

import java.awt.SystemColor;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;

public class MSS_Chat_Bot_Gui {

    private JFrame frmMssChatBot;
    private String finalString;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MSS_Chat_Bot_Gui window = new MSS_Chat_Bot_Gui();
                    window.frmMssChatBot.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MSS_Chat_Bot_Gui() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmMssChatBot = new JFrame();
        frmMssChatBot.setIconImage(Toolkit.getDefaultToolkit().getImage(MSS_Chat_Bot_Gui.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
        frmMssChatBot.setTitle("JavaDoc Tool 1.0");
        frmMssChatBot.setBackground(SystemColor.activeCaption);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        frmMssChatBot.setSize((int)width,(int)height);
        frmMssChatBot.setResizable(true);
        frmMssChatBot.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmMssChatBot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMssChatBot.getContentPane().setLayout(null);

        final JEditorPane jFile = new JEditorPane();
        jFile.setBackground(SystemColor.menu);
        jFile.setEditable(false);


        JScrollPane holderJava = new JScrollPane(jFile);
        holderJava.setBounds(10, 94, (int)height/2, (int)width/2);
        holderJava.setBorder(null);
        frmMssChatBot.getContentPane().add(holderJava);
        
        
        HTMLEditorKit kit = new HTMLEditorKit();
        final JEditorPane htmlFile = new JEditorPane();
        htmlFile.setEditorKit(kit);
        htmlFile.setBackground(SystemColor.menu);
        htmlFile.setEditable(false);


        JScrollPane holderHtml = new JScrollPane(htmlFile);
        holderHtml.setBounds(522, 94, (int)height/2, (int)width/2);
        holderHtml.setBorder(null);
        frmMssChatBot.getContentPane().add(holderHtml);
        
        final JLabel lblJavaFile = new JLabel("Java File");
        lblJavaFile.setBounds(10, 69, 70, 14);
        lblJavaFile.setVisible(false);
        frmMssChatBot.getContentPane().add(lblJavaFile);
        
        final JLabel lblHtmlFile = new JLabel("Html File");
        lblHtmlFile.setBounds(522, 69, 80, 14);
        lblHtmlFile.setVisible(false);
        frmMssChatBot.getContentPane().add(lblHtmlFile);
        
        JMenuBar bar = new JMenuBar();
        frmMssChatBot.setJMenuBar(bar);
        JMenu mnFileMenu = new JMenu("File");
        mnFileMenu.setBackground(new Color(135, 206, 235));
        mnFileMenu.setBounds(10, 0, 107, 22);
        bar.add(mnFileMenu);
        
        
        JMenuItem mntmOpen = new JMenuItem("Open Java File");
        mntmOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Java Files", "java"));
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                 
                // The selectedFile is a File object containing the java file chosen to be 
                // "javadoc-ed"
                    
                  File selectedFile = fileChooser.getSelectedFile();
                  
                  // THIS IS WHERE YOU WILL 
                  // CALL YOUR METHOD(S) TO EXTRACT COMMENTS AND KEYWORDS
                  // FROM THE JAVA FILE SELECTED!!
                  /************************************************************/
                  try {
                	  FileToString lines = new FileToString(selectedFile.getAbsolutePath());
                	  finalString = toHTML.appendString(lineFormat.format(lineFormat.checkAsterisk(lines.getLines())));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                  /************************************************************/
                  /*
                   * this code will extract the content of the 
                   * java file and display its content on the 
                   * application frame
                   */
                  if (selectedFile.canRead()){
                      BufferedReader javaFile = null;
                    try {
                        javaFile = new BufferedReader(new FileReader(selectedFile));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                      String javaText = "";
                      String line;
                          try {
                            while ((line = javaFile.readLine()) != null) {
                                javaText+= line + "\n";
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                      // Display using a JeditorPane
                      jFile.setText(javaText);

                  }
                }
                lblJavaFile.setVisible(true);
            }
        });
        
        
        mntmOpen.setBackground(new Color(238, 130, 238));
        mnFileMenu.add(mntmOpen);
        
        
        JMenuItem mntmCreateHtmlFile = new JMenuItem("Create Html File");
        mntmCreateHtmlFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("HTML Files", "html"));
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                /************************************************************/
                 // THIS IS WHERE YOU WILL DO YOUR MAGIC!!
                 // Create the html formatted string
               /************************************************************/
     
                      
                      
                /************************************************************/  
                    ////////////////////////////////////////////////////////////////////////
                    //This is how the htmlString was displayed and written in an html file//
                    ////////////////////////////////////////////////////////////////////////
                    
                    String htmlString = finalString;   
                    htmlFile.setText(htmlString);
                   // The selectedFile is a File where you will write your html content            
                   File selectedFile = fileChooser.getSelectedFile();
                    try {
                        FileWriter fw = new FileWriter(selectedFile.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        ///////////////////////////////////////////////////////////////////////////////////
                        ////////////////////////////THE htmlString contains the formatted comments/////////
                        ///////You may change it at your will /////////////////////////////////////////////
                        ///////////////////////////////////////////////////////////////////////////////////
                        bw.write(htmlString);
                        bw.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                  }
            lblHtmlFile.setVisible(true);
            }
        });
        mntmCreateHtmlFile.setBackground(new Color(205, 133, 63));
        mnFileMenu.add(mntmCreateHtmlFile);
        
        JMenuItem mntmClearViewer = new JMenuItem("Clear Viewer");
        mntmClearViewer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFile.setText("");
                htmlFile.setText("");
                lblJavaFile.setVisible(false);
                lblHtmlFile.setVisible(false);
                
            }
        });
        mntmClearViewer.setBackground(new Color(222, 184, 135));
        mnFileMenu.add(mntmClearViewer);
        
        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frmMssChatBot.dispose();
            }
        });
        
        JMenuItem mntmHelp = new JMenuItem("Help");
        mntmHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(frmMssChatBot,
                        //HERE IS WHERE YOU ADD YOUR GUIDE ON HOW TO WRITE
                        // PROPER COMMENTS
                        "To use this application, click File at the top left side of the window and select a JAVA file to be documented in an HTML File. \n Make sure the correct file was selected when the JAVA file is previewed. \n Next, click File again and click 'Create HTML File', choose a destination and enter the desired name of the file ending with '.html'. \n \n To clear the screen of all previewed documents, click File and then Clear Viewer. \n \n When writing comments, an '@' followed by the appropriate keyword must be used when creating comments. \n The keyword comes before the substring that corresponds to the keyword. \n For example, for a description, use '@description' before writing the description. \n The name of the class or method must come sequencially before the other keywords in a comment block. \n For example, \n * @methodname name \n * @author author \n * @description description...",
                        "Java Doc Helper",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mnFileMenu.add(mntmHelp);
        mntmExit.setBackground(new Color(152, 251, 152));
        mnFileMenu.add(mntmExit);
    }
}