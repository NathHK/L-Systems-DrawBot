//Name: Nathan Kalafut

package kalanat_Ass04;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

import java.util.*;

import java.lang.Math;

/**
 * Note:
 * To change the max generation, go to line 382 (that's where getData(#) is located).
 *
 */
class L_Gui extends JFrame {

    /** default constructor  */
    public L_Gui() {
        initComponents();
    }
    
    // all the initializations in one method
    private void initComponents() {
      
    	this.setPreferredSize(new Dimension(1000,800));
    	//loadButton hasn't been pressed yet
    	loaded = false;
    	
        jLabel0		= new JLabel("generation");
        jLabel1		= new JLabel("axiom");
        jLabel2		= new JLabel("rule");
        jLabel3		= new JLabel("angle");
        jLabel4		= new JLabel("scale");
        jLabel5		= new JLabel("x-coor");
        jLabel6		= new JLabel("y-coor");
        jLabel7		= new JLabel("direction");
        jSpace1		= new JLabel("");
        jSpace2		= new JLabel("");
        jSpace3		= new JLabel("");

        maxGenLabel = new JLabel("");
        
        jTextField0	= new JTextField(); //GENERATION #
        
        jTextField1	= new JTextField(); //AXIOM
        								// --> editable after LOAD
        jTextField2	= new JTextField(); //RULE (production)
        								// --> editable after LOAD
        
        jTextField3	= new JTextField(); //ANGLE (degree of each rotation)
        								// --> editable after LOAD
        
        jTextField4	= new JTextField(); //SCALE (pixels per step i.e. distance)
        								/// --> editable after LOAD
        
        jTextField5	= new JTextField(); //INITIAl X-COORDINATE
        								// --> editable after LOAD
        jTextField6	= new JTextField(); //INITIAL Y-COORDINATE
        								// --> 
        jTextField7	= new JTextField(); //DIRECTION (where turtle is facing)
        
        scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);

        scrollBar2 = new JScrollBar(JScrollBar.HORIZONTAL);
        
        drawButton	= new JButton("DRAW");
        loadButton	= new JButton("LOAD" );

        // make a drawing surface
        // DECLARATION OF DrawBot p!!!
          p = new DrawBot();
          
        // make the panel of buttons
          controlPanel = new JPanel();
          controlPanel.setPreferredSize( new Dimension(100, 800));
          controlPanel.setLayout(new FlowLayout());
          controlPanel.setBackground(new Color(122, 173, 223));//(new Color(225, 225, 123));
        
        // make the scrolly panel
          scrolly = new JPanel();
          scrolly.setPreferredSize(new Dimension(80,45));
          scrolly.setLayout(new BoxLayout(scrolly, BoxLayout.Y_AXIS));
          scrolly.setBackground(new Color(122, 173, 223));
          
        // make the scrolly2 panel
          scrolly2 = new JPanel();
          scrolly2.setPreferredSize(new Dimension(80,45));
          scrolly2.setLayout(new BoxLayout(scrolly2, BoxLayout.Y_AXIS));
          scrolly2.setBackground(new Color(122, 173, 223));
          jTextField2.setCaretPosition(0);
          
        // set the Layout to FlowLayout
          getContentPane().setLayout(new BorderLayout());

        // add a WindowListener to terminate the program when 
        // window is closed
          addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(1);
            }
          });


        // set up drawButton
          drawButton.setPreferredSize( new Dimension(80,25));
          drawButton.setBackground(new Color(235, 235, 235));
          drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            	if(loaded) {

            		if(p.generation < p.MAX_Gen) {
            			p.repaint();
            			p.genPlus();
            		}
            		
            		else
            			maxGenLabel.setText("MAX GEN");
            		
            	}
            }
          });
          
          jTextField0.setPreferredSize( new Dimension(80,25));
          jTextField1.setPreferredSize( new Dimension(80,25));
          jTextField2.setPreferredSize( new Dimension(80,25));
          jTextField3.setPreferredSize( new Dimension(80,25));
          jTextField4.setPreferredSize( new Dimension(80,25));
          jTextField5.setPreferredSize( new Dimension(80,25));
          jTextField6.setPreferredSize( new Dimension(80,25));
          jTextField7.setPreferredSize( new Dimension(80,25));
          
          jTextField0.setHorizontalAlignment(JTextField.CENTER);
          jTextField1.setHorizontalAlignment(JTextField.CENTER);
          jTextField2.setHorizontalAlignment(JTextField.CENTER);
          jTextField3.setHorizontalAlignment(JTextField.CENTER);
          jTextField4.setHorizontalAlignment(JTextField.CENTER);
          jTextField5.setHorizontalAlignment(JTextField.CENTER);
          jTextField6.setHorizontalAlignment(JTextField.CENTER);
          jTextField7.setHorizontalAlignment(JTextField.CENTER);
          
          jSpace1.setPreferredSize( new Dimension(80,20));
          jSpace2.setPreferredSize( new Dimension(80,20));
          jSpace3.setPreferredSize( new Dimension(80,20));

        // Fix up loadButton
          loadButton.setPreferredSize( new Dimension(80,25));
          loadButton.setBackground(new Color(235, 235, 235));
          
          loadButton.addActionListener(new ActionListener() {
             
        	  public void actionPerformed(ActionEvent evt){

            	 try {
            		 
            		 Scanner in = new Scanner(new File("l-system1.txt"));
                	 
            		 jTextField0.setText(String.valueOf(-1));
            		 jTextField1.setText(in.next()); //axiom
            		 jTextField2.setText(in.next()); //rule
            		 jTextField3.setText(in.next()); //angle
            		 jTextField4.setText(in.next()); //scale
            		 jTextField5.setText(in.next()); //x
            		 jTextField6.setText(in.next()); //y
            		 jTextField7.setText(in.next()); //direction
            	
            		 //loadButton = pressed
            		 // --> Safe for DB to getData!
            		 loaded = true;
            		 
//-----------------------LOAD DATA INTO THE DRAWBOT!!!-----------------------//
            		
            		 // **** CODE to read in L_System parameters
            		 
            		 //close scanner to prevent resource leak
            		 in.close();
            		 
            		 jTextField1.setCaretPosition(0);
            		 jTextField2.setCaretPosition(0);
                	 
            	 }
            	 
            	 catch (FileNotFoundException e){
            		 
            		 System.out.println("NO File found");
            		 System.exit(0);
            	 
            	 }
             }
        	    
          });
        
        // Add components to scrolly (jPanel)
          BoundedRangeModel brm = jTextField1.getHorizontalVisibility();
          //scrollBar.setForeground(new Color(122, 173, 223));
          scrollBar.setBackground(new Color(122, 173, 223));
          scrollBar.setModel(brm);
          
        // Add components to scrolly2
          BoundedRangeModel brm2 = jTextField2.getHorizontalVisibility();
          scrollBar2.setBackground(new Color(122, 173, 223));
          scrollBar2.setModel(brm2);
          
          scrolly.setBackground(new Color(122, 173, 223));
          scrolly.add(jTextField1);
          scrolly.add(scrollBar);
          
          scrolly2.setBackground(new Color(122, 173, 223));
          scrolly2.add(jTextField2);
          scrolly2.add(scrollBar2);
          
        // Add the components to the control panel
          controlPanel.add(jSpace1); 
          
          //add scrolly and scrolly2 panels
          controlPanel.add(scrolly);
          
          controlPanel.add(jLabel1); 

          controlPanel.add(scrolly2);
          
          controlPanel.add(jLabel2); 
          controlPanel.add(jTextField3);
          controlPanel.add(jLabel3);       
          controlPanel.add(jTextField4);
          controlPanel.add(jLabel4); 
          controlPanel.add(jTextField5);
          controlPanel.add(jLabel5); 
          controlPanel.add(jTextField6);
          controlPanel.add(jLabel6); 
          controlPanel.add(jTextField7);
          controlPanel.add(jLabel7); 
          controlPanel.add(jSpace2);
          controlPanel.add(loadButton);
          controlPanel.add(drawButton);
          controlPanel.add(jSpace3);
          controlPanel.add(jTextField0);        
          controlPanel.add(jLabel0);
          
          controlPanel.add(maxGenLabel);
          
          //MAKE TEXT FIELDS 1-7 EDITABLE
          jTextField1.setEditable(true);
          
          jTextField2.setEditable(true); //user can edit RULE
          jTextField3.setEditable(true); //user can edit ANGLE
          jTextField4.setEditable(true); //user can edit SCALE
          
          jTextField5.setEditable(true);
          jTextField6.setEditable(true);
          jTextField7.setEditable(true);
        
        // add the panels to the L_GUI
          getContentPane().add(controlPanel, BorderLayout.WEST);
        // p = DrawBot
          getContentPane().add(p, BorderLayout.CENTER);

          pack();
          setVisible(true);
    } // _________  end of InitComponents

    private class  DrawBot extends JPanel{
	   
    	private String axiom;
    	private String rule;
	    
    	private double angle; //in degrees
    	
    	private int step;	// units in a forward motion
        private int Xcoor;	// initial x-coordinate position
    	private int Ycoor;	// initial y-coordinate position
    	
    	private double direction;
    	
    	private int generation;
    	private int MAX_Gen;	// maximum # of generations
	    private String S;
	   
	    private ArrayList<String> preBracket;
	    private ArrayList<double[]> priorStates;
	    
	    private int preX;
	    private int preY;
	    private int preD;
	    private int bracketCount;
	    
	    
	    //DrawBot CONSTRUCTOR
	    public DrawBot(){
          
	    	setBackground(Color.white);

	    	generation = -1;
	    	S="";
	    	
	    	preBracket = new ArrayList<String>();
	    	priorStates = new ArrayList<double[]>(); 
	    	bracketCount = 0;
	    }
      
	    //Add info for a prior DB state (pos and direction) to the ArrayList
	    public void addState(double x, double y, double direc) {
	    	
	    	double[] state = {x, y, direc};
	    	priorStates.add(state);
	    	
	    }
	    
	    /**
	     * Gets data from TextFields and loads it into the drawbot
	     */
	    public void getData( int maxGenerations ){
    	  
	    	axiom = jTextField1.getText();
	    	rule = jTextField2.getText();
	    	
	    	angle = Double.parseDouble(jTextField3.getText());
	    	
	    	step = Integer.parseInt(jTextField4.getText());
	    	Xcoor = Integer.parseInt(jTextField5.getText());
	    	Ycoor = Integer.parseInt(jTextField6.getText());
	    	
	    	direction = Double.parseDouble(jTextField7.getText());
	    	
	    	generation = Integer.parseInt(jTextField0.getText());
	    	MAX_Gen = maxGenerations;
	    	S = this.axiom;
    	
	    	// debugging
	    	/*
		    	System.out.println(axiom);
		    	System.out.println(rule);
		    	System.out.println(angle);
		    	System.out.println(step);
		    	System.out.println(Xcoor);
		    	System.out.println(Ycoor);
		    	System.out.println(direction);
		    	System.out.println(generation);
	    	*/
	    	
	    }
      
	    //increment the value of this.generation
	    //and update the text displayed in the appropriate textField
	    public void genPlus() {
	    	
	    	int gen = Integer.parseInt(jTextField0.getText());
	    	gen++;
	    	jTextField0.setText(String.valueOf(gen));
	    	
	    	System.out.println("gen = " + gen);
	    	
	    	if(gen > 0)
	    		jTextField1.setText(axiom);
	    	
	    	jTextField1.setCaretPosition(0);
	    	
	    }    
	    
	    	/**
	    	 * Paints the drawing
	    	 */
	 
	    public void paintComponent(Graphics g){
	          
	    	super.paintComponent(g);
	    	//System.out.println("Drawbot paincomponent called.");
        
	    	double xStep = 0; 
	    	double yStep = 0; 
	    	
	//------GROW!----------THAT!----------PLANT!!!------//
	        
	    	if(loaded) {

	    		getData(10);
	    		
	    		double x1 = Xcoor;
				double y1 = Ycoor;
	    		
	    		//Direction in radians (instead of degrees)
	    		double d = Math.toRadians(direction);
	    		
	    		for(int i = 0; i < axiom.length(); i++) {
	    			
	    			char c = axiom.charAt(i);
	    			
	    			if(c == 'F') {
	    				
	    				xStep = Math.rint(Math.cos(d) * step);
	    				yStep = Math.rint(Math.sin(d) * step);
	    				
	    				int xInt = (int)(x1);
	    				int yInt = (int) (y1);
	    				
	    				int x2Int = (int) Math.rint(x1 + xStep);
	    				int y2Int = (int) Math.rint(y1 + yStep);

	    				g.drawLine(xInt, yInt, x2Int, y2Int);
	    				
	    				x1 = x1 + xStep;
	    				y1 = y1 + yStep;
	    				
	    			}
	    			
	    			
	    			else if(c == '+')
	    				d = d - Math.toRadians(angle);
	    			
	    			else if(c == '-')
	    				d = d + Math.toRadians(angle);
	    			
	    			//Open bracket --> save current state of DB!
	    			else if(c == '[') {
	    				
	    				//System.out.println("Open bracket found!");
	    				//add one to count of open brackets
	    				bracketCount++;
	    				
	    				//add current state to the AL priorStates
	    				addState(x1, y1, d);
	    				
	    			}
	    			
	    			else if(c == ']') {
	    				
	    				//decrement count of open (unpaired) brackets
	    				bracketCount--;
	    				
	    				double[] state = priorStates.get(bracketCount);
	    				//apply values for old state to the turtle
	    				x1 = state[0];
	    				y1 = state[1];
	    				d = state[2];
	    				
	    				//remove the requested state from priorStates AL
	    				priorStates.remove(bracketCount);	
	    			}
	    		} //end of for loop
	    		
	    		axiom = "";
	    		
	    		for(int index = 0; index < S.length(); index++) {
	    			
	    			if(S.charAt(index) == 'F')
	    				axiom = axiom + rule;
	    			
	    			else
	    				axiom = axiom + S.charAt(index);
	    			
	    		}
	    	} //end of if(loaded)
	        
	    } //end of paintComponent(Graphics g)
    } //end of class DrawBot

 // Variable declarations
    private JLabel		jLabel0;
    private JLabel		jLabel1;
    private JLabel		jLabel2;
    private JLabel		jLabel3;
    private JLabel		jLabel4;
    private JLabel		jLabel5;
    private JLabel		jLabel6;
    private JLabel		jLabel7;
    private JLabel		jSpace1;
    private JLabel		jSpace2;
    private JLabel		jSpace3;
    
    private JLabel      maxGenLabel;
    
    private JTextField	jTextField0;
    private JTextField	jTextField1;
    private JTextField	jTextField2;
    private JTextField	jTextField3;
    private JTextField	jTextField4;
    private JTextField	jTextField5;
    private JTextField	jTextField6;
    private JTextField	jTextField7;
    
    private JButton		drawButton;
    private JButton		loadButton;    

    private DrawBot	p;
    private JPanel		controlPanel;
    
    private boolean loaded; //Has the loadButton been pressed?
    private JPanel scrolly; //holds jTextField1 and scrollBar
    private JPanel scrolly2; //holds jTextField2 and scrollBar2
    JScrollBar scrollBar; //Scroll-bar for axiom textField
    JScrollBar scrollBar2; //Scroll-bar for rule textField
    
    //END VARIABLES
    
	public static void main(String[] args) {
		
		L_Gui goo = new L_Gui();
		
	}
	
} //end of class L_Gui
