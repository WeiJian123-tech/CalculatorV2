package calculatorV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 	Links that I researched that helped me build my calculator:
	https://www.macs.hw.ac.uk/cs/java-swing-guidebook/?name=Layouts&page=7
	https://youtu.be/IyfB0u9g2x0
	https://stackoverflow.com/questions/16069502/how-to-define-the-keystroke-for-the-numpad-enter-key
	https://stackoverflow.com/questions/23876885/keylisteners-with-numpad
	https://stackoverflow.com/questions/4578716/boolean-value-changing-button-click
	
	Thank you to hw.ac.uk, Bro Code YouTube Channel, and Stackoverflow users tenorsax Anubian Noob and drekka
	for the wonderful code snippets that aided the development of this calculator.
	
	The purpose of this program is mainly for professional development and educational programming practice.
	
	I learned about JLabels, how to program mouse clicks and keyboard presses for JButtons, changing the
	boolean value when a button is clicked, how to dynamically change the size of Components in a program,
	and a little bit about JComboboxes even if I had difficulty in implementing it within this calculator program.
	
	Happy calculating! :D
**/

public class CalcFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel backgroundPanel;
	private JPanel settingsPanel;
	private JPanel numberPanel;
	private JPanel operatorPanel;
	private JPanel specOpsPanel;
	protected JTextField display;
	private JButton oneBtn;
	private JButton twoBtn;
	private JButton threeBtn;
	private JButton fourBtn;
	private JButton fiveBtn;
	private JButton sixBtn;
	private JButton sevenBtn;
	private JButton eightBtn;
	private JButton nineBtn;
	private JButton swapSignsBtn;
	private JButton zeroBtn;
	private JButton decimalBtn;
	private JButton sqrBtn;
	private JButton sqrtBtn;
	private JButton modBtn;
	private JButton percBtn;
	private JButton clearEntryBtn;
	private JButton clearAllBtn;
	private JButton deleteBtn;
	private JButton divideBtn;
	private JButton multiplyBtn;
	private JButton subtractBtn;
	private JButton addBtn;
	private JButton equalsBtn;
	private ArrayList<String> history;
	private JComboBox<String> historyList;
	private boolean isDay;
	private JButton darkMode;
	private JLabel prevNumDisplay;
	private JLabel operatorDisplay;
	private Font calcFont;
	private GridBagConstraints bgGBC;
	private GridBagConstraints nGBC;
	private GridBagConstraints opGBC;
	private GridBagConstraints spOpsGBC;
	private GridBagConstraints settingsGBC;
	
	public CalcFrame() {
		backgroundPanel = new JPanel();
		settingsPanel = new JPanel();
		numberPanel = new JPanel();
		operatorPanel = new JPanel();
		specOpsPanel = new JPanel();
		display = new JTextField();
		oneBtn = new JButton("1");
		twoBtn = new JButton("2");
		threeBtn = new JButton("3");
		fourBtn = new JButton("4");
		fiveBtn = new JButton("5");
		sixBtn = new JButton("6");
		sevenBtn = new JButton("7");
		eightBtn = new JButton("8");
		nineBtn = new JButton("9");
		swapSignsBtn = new JButton();
		zeroBtn = new JButton("0");
		decimalBtn = new JButton();
		sqrBtn = new JButton();
		sqrtBtn = new JButton();
		modBtn = new JButton();
		percBtn = new JButton();
		clearEntryBtn = new JButton();
		clearAllBtn = new JButton();
		deleteBtn = new JButton();
		divideBtn = new JButton();
		multiplyBtn = new JButton();
		subtractBtn = new JButton();
		addBtn = new JButton();
		equalsBtn = new JButton();
		history = new ArrayList<String>();
		historyList = new JComboBox<String>();
		darkMode = new JButton();
		isDay = false;
		prevNumDisplay = new JLabel();
		operatorDisplay = new JLabel();
		calcFont = new Font("Serif", Font.PLAIN, 24);
		bgGBC = new GridBagConstraints();
		nGBC = new GridBagConstraints();
		opGBC = new GridBagConstraints();
		spOpsGBC = new GridBagConstraints();
		settingsGBC = new GridBagConstraints();
	}
	
	public void defineGUI() {
		setTitle("Standard Calculator V2");
		//Change dimensions later
		setMinimumSize(new Dimension(330, 450));
		setPreferredSize(new Dimension(330, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		
		setLayout(new BorderLayout());
		
		calcContents(); 
		
		pack();
		setVisible(true);
	}
	
	private void calcContents() {
		
		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setMinimumSize(getMinimumSize());
		backgroundPanel.setPreferredSize(getPreferredSize());
		backgroundPanel.setLayout(new GridBagLayout());
		
		settingsPanel();
		
		/*******************************************************************************************************/
		
		panelGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 1, 1, 2, 1, 1, 0, 0);
		
		display = new JTextField();
		display.setBackground(Color.GRAY);
		display.setMinimumSize(new Dimension(330, 40));
		display.setPreferredSize(new Dimension(330, 40));
		display.setMaximumSize(new Dimension(330, 40));
		display.setAlignmentX(Component.CENTER_ALIGNMENT);
		display.setAlignmentY(Component.CENTER_ALIGNMENT);
		display.setFont(calcFont);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setEditable(false);
		
		backgroundPanel.add(display, bgGBC);
		
		/*********************************************************************************************************/
		
		defineSpecOpsPanel();
		
		defineOperatorPanel();
		
		defineNumberPanel();
		
		add(backgroundPanel);
		
	}
	
	private void settingsPanel() {
		panelGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.PAGE_START, 0, 0, 1, 2, 1, 1, 0, 0);
		
		settingsPanel = new JPanel();
		settingsPanel.setBackground(new Color(173, 252, 3));
		settingsPanel.setMinimumSize(new Dimension(330, 50));
		settingsPanel.setPreferredSize(new Dimension(330, 50));
		settingsPanel.setMaximumSize(new Dimension(330, 50));
		settingsPanel.setLayout(new GridBagLayout());
		
		/*********************************************************/
		
		settingsGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 0, 1, 1, 1, 1, 0, 0);
		
		settingsPanel.add(historyList, settingsGBC);
		
		/********************************************/
		
		settingsGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 1, 0, 1, 1, 1, 1, 0, 0);
		
		darkMode = new JButton();
		darkMode.setText("Dark Mode");
		
		Action toggleAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(isDay) {
					backgroundPanel.setBackground(Color.WHITE);
					display.setBackground(Color.GRAY);
					settingsPanel.setBackground(new Color(173, 252, 3));
					specOpsPanel.setBackground(Color.ORANGE);
					operatorPanel.setBackground(Color.YELLOW);
					numberPanel.setBackground(Color.GREEN);
					
					oneBtn.setBackground(Color.WHITE);
					twoBtn.setBackground(Color.WHITE);
					threeBtn.setBackground(Color.WHITE);
					fourBtn.setBackground(Color.WHITE);
					fiveBtn.setBackground(Color.WHITE);
					sixBtn.setBackground(Color.WHITE);
					sevenBtn.setBackground(Color.WHITE);
					eightBtn.setBackground(Color.WHITE);
					nineBtn.setBackground(Color.WHITE);
					swapSignsBtn.setBackground(Color.WHITE);
					zeroBtn.setBackground(Color.WHITE);
					decimalBtn.setBackground(Color.WHITE);
					sqrBtn.setBackground(Color.WHITE);
					sqrtBtn.setBackground(Color.WHITE);
					modBtn.setBackground(Color.WHITE);
					percBtn.setBackground(Color.WHITE);
					clearEntryBtn.setBackground(Color.WHITE);
					clearAllBtn.setBackground(Color.WHITE);
					deleteBtn.setBackground(Color.WHITE);
					divideBtn.setBackground(Color.WHITE);
					multiplyBtn.setBackground(Color.WHITE);
					subtractBtn.setBackground(Color.WHITE);
					addBtn.setBackground(Color.WHITE);
					equalsBtn.setBackground(Color.WHITE);
					historyList.setBackground(Color.WHITE);
					darkMode.setBackground(Color.WHITE);
					
					
					darkMode.setText("Light Mode");
				} else {
					backgroundPanel.setBackground(Color.BLACK);
					display.setBackground(Color.LIGHT_GRAY);
					settingsPanel.setBackground(new Color(21, 214, 150));
					specOpsPanel.setBackground(new Color(156, 105, 39));
					operatorPanel.setBackground(new Color(148, 148, 145));
					numberPanel.setBackground(new Color(120,134,107));
					
					oneBtn.setBackground(new Color(109, 138, 161));
					twoBtn.setBackground(new Color(109, 138, 161));
					threeBtn.setBackground(new Color(109, 138, 161));
					fourBtn.setBackground(new Color(109, 138, 161));
					fiveBtn.setBackground(new Color(109, 138, 161));
					sixBtn.setBackground(new Color(109, 138, 161));
					sevenBtn.setBackground(new Color(109, 138, 161));
					eightBtn.setBackground(new Color(109, 138, 161));
					nineBtn.setBackground(new Color(109, 138, 161));
					swapSignsBtn.setBackground(new Color(109, 138, 161));
					zeroBtn.setBackground(new Color(109, 138, 161));
					decimalBtn.setBackground(new Color(109, 138, 161));
					sqrBtn.setBackground(new Color(110, 142, 153));
					sqrtBtn.setBackground(new Color(110, 142, 153));
					modBtn.setBackground(new Color(110, 142, 153));
					percBtn.setBackground(new Color(110, 142, 153));
					clearEntryBtn.setBackground(new Color(110, 142, 153));
					clearAllBtn.setBackground(new Color(110, 142, 153));
					deleteBtn.setBackground(new Color(80, 100, 133));
					divideBtn.setBackground(new Color(80, 100, 133));
					multiplyBtn.setBackground(new Color(80, 100, 133));
					subtractBtn.setBackground(new Color(80, 100, 133));
					addBtn.setBackground(new Color(80, 100, 133));
					equalsBtn.setBackground(new Color(152, 158, 43));
					historyList.setBackground(Color.GRAY);
					darkMode.setBackground(new Color(112, 112, 112));
					
					darkMode.setText("Dark Mode");
				}
				
				//Make method to contain and modify component attributes.
				
				isDay = !isDay;
			}
			
		};
		
		darkMode.addActionListener(toggleAction);
		
		settingsPanel.add(darkMode, settingsGBC);
		
		settingsGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 2, 0, 1, 1, 1, 1, 0, 0);
		
		prevNumDisplay = new JLabel();
		prevNumDisplay.getText();
		
		settingsPanel.add(prevNumDisplay, settingsGBC);
		
		settingsGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 3, 0, 1, 1, 1, 1, 0, 0);
		
		operatorDisplay = new JLabel();
		operatorDisplay.getText();
		
		settingsPanel.add(operatorDisplay, settingsGBC);
		
		backgroundPanel.add(settingsPanel, bgGBC);
	}
	
	private void defineSpecOpsPanel() {
		panelGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 2, 1, 1, 1, 1, 0, 0);
		
		specOpsPanel = new JPanel();
		specOpsPanel.setBackground(Color.ORANGE);
		specOpsPanel.setMinimumSize(new Dimension(225, 100));
		specOpsPanel.setPreferredSize(new Dimension(225, 100));
		specOpsPanel.setMaximumSize(new Dimension(225, 100));
		specOpsPanel.setLayout(new GridBagLayout());
		
		specialOperatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 0, 1, 1, 1, 1, 0, 0);
		
		modBtn = new JButton();
		modBtn.setText("Mod(%)");
		
		Action modAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				operatorDisplay.setText(modBtn.getText());
				operatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
				
				if(display.getText().length() > 0 && operatorDisplay.getText().contains(modBtn.getText())) {
					prevNumDisplay.setText(display.getText());
					prevNumDisplay.setHorizontalAlignment(SwingConstants.CENTER);
					display.setText("");
				}
			}
			
		};
		
		modBtn.addActionListener(modAction);
		
		specOpsPanel.add(modBtn, spOpsGBC);
		
		specialOperatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 1, 0, 1, 1, 1, 1, 0, 0);
		
		clearEntryBtn = new JButton();
		clearEntryBtn.setText("CE");
		
		Action clearEntryAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText("");
			}
			
		};
		
		clearEntryBtn.addActionListener(clearEntryAction);
		
		specOpsPanel.add(clearEntryBtn, spOpsGBC);
		
		specialOperatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 2, 0, 1, 1, 1, 1, 0, 0);
		
		clearAllBtn = new JButton();
		clearAllBtn.setText("C");
		
		Action clearAllAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText("");
				operatorDisplay.setText("");
				prevNumDisplay.setText("");
			}
			
		};
		
		clearAllBtn.addActionListener(clearAllAction);
		
		specOpsPanel.add(clearAllBtn, spOpsGBC);
		
		specialOperatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 1, 1, 1, 1, 1, 0, 0);
		
		percBtn = new JButton();
		percBtn.setText("Percent(100%)");
		
		Action percentageAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CalcEquations equations = new CalcEquations(display.getText());
				display.setText(equations.percentage());
			}
			
		};
		
		percBtn.addActionListener(percentageAction);
		
		specOpsPanel.add(percBtn, spOpsGBC);
		
		specialOperatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 1, 1, 1, 1, 1, 1, 0, 0);
		
		sqrBtn = new JButton();
		sqrBtn.setText("Sqr(x^2)");
		
		Action sqrAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CalcEquations equations = new CalcEquations(display.getText());
				display.setText(equations.squared());
			}
			
		};
		
		sqrBtn.addActionListener(sqrAction);
		
		specOpsPanel.add(sqrBtn, spOpsGBC);
		
		specialOperatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 2, 1, 1, 1, 1, 1, 0, 0);
		
		sqrtBtn = new JButton();
		sqrtBtn.setText("Sqrt (√x)");
		
		Action sqrtAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CalcEquations equations = new CalcEquations(display.getText());
				display.setText(equations.squareRoot());
			}
			
		};
		
		sqrtBtn.addActionListener(sqrtAction);
		
		specOpsPanel.add(sqrtBtn, spOpsGBC);
		
		backgroundPanel.add(specOpsPanel, bgGBC);
	}
	
	private void defineOperatorPanel() {
		panelGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 1, 2, 2, 1, 1, 1, 0, 0);
		
		operatorPanel = new JPanel();
		operatorPanel.setBackground(Color.YELLOW);
		operatorPanel.setMinimumSize(new Dimension(75, 300));
		operatorPanel.setPreferredSize(new Dimension(75, 300));
		operatorPanel.setMaximumSize(new Dimension(75, 300));
		operatorPanel.setLayout(new GridBagLayout());
		
		operatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 0, 1, 1, 1, 1, 0, 0);
		
		deleteBtn = new JButton();
		deleteBtn.setText("DELETE");
		
		Action deleteAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!display.getText().isBlank()) {
					display.setText(
							"" + display.getText().substring(0, display.getText().length()-1)
							);
				} else {
					display.setText("0");
				}
				
			}
			
		};
		
		deleteBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
		deleteBtn.getActionMap().put("delete", deleteAction);
		
		deleteBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "delete");
		deleteBtn.getActionMap().put("delete", deleteAction);
		
		deleteBtn.addActionListener(deleteAction);
		
		operatorPanel.add(deleteBtn, opGBC);
		
		operatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 1, 1, 1, 1, 1, 0, 0);
		
		operatorKeys(addBtn, "+", calcFont, prevNumDisplay, operatorDisplay, display, KeyEvent.VK_PLUS, KeyEvent.VK_ADD, "add", opGBC);
		
		operatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 2, 1, 1, 1, 1, 0, 0);
		
		operatorKeys(subtractBtn, "-", calcFont, prevNumDisplay, operatorDisplay, display, KeyEvent.VK_MINUS, KeyEvent.VK_SUBTRACT, "subtract", opGBC);
		
		operatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 3, 1, 1, 1, 1, 0, 0);
		
		operatorKeys(multiplyBtn, "*", calcFont, prevNumDisplay, operatorDisplay, display, KeyEvent.VK_ASTERISK, KeyEvent.VK_MULTIPLY, "multiply", opGBC);
		
		operatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 4, 1, 1, 1, 1, 0, 0);
		
		operatorKeys(divideBtn, "/", calcFont, prevNumDisplay, operatorDisplay, display, KeyEvent.VK_SLASH, KeyEvent.VK_DIVIDE, "divide", opGBC);
		
		operatorGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 5, 1, 1, 1, 1, 0, 0);
		
		equalsBtn = new JButton();
		equalsBtn.setText("=");
		
		Action equalsAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CalcEquations equations = new CalcEquations(prevNumDisplay.getText(), operatorDisplay.getText(), display.getText());
				
				display.setText(equations.equals());
				
				//System.out.println("equals: " + prevNumDisplay.getText() + " " + operatorDisplay.getText() + " " + display.getText());
				
				history.add(display.getText());
				//System.out.println("h: " + history.get(history.size()-1));
				
				historyList.addItem(history.get(history.size()-1));
				
			}
			
		};
		
		equalsBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), "equals");
		equalsBtn.getActionMap().put("equals", equalsAction);
		
		equalsBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "equals");
		equalsBtn.getActionMap().put("equals", equalsAction);
		
		equalsBtn.addActionListener(equalsAction);
		
		operatorPanel.add(equalsBtn, opGBC);
		
		backgroundPanel.add(operatorPanel, bgGBC);
	}
	
	private void defineNumberPanel() {
		panelGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 3, 1, 1, 1, 1, 0, 0);
		
		numberPanel = new JPanel();
		numberPanel.setBackground(Color.GREEN);
		numberPanel.setMinimumSize(new Dimension(225, 225));
		numberPanel.setPreferredSize(new Dimension(225, 225));
		numberPanel.setMaximumSize(new Dimension(225, 225));
		numberPanel.setLayout(new GridBagLayout());
		
		//For number pad.
		//GridBagConstraints nGBC = new GridBagConstraints();
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 2, 0, 1, 1, 1, 1, 0, 0);
		
		//Button 9
		numberKeys(nineBtn, "9", calcFont, display, KeyEvent.VK_9, KeyEvent.VK_NUMPAD9, "nine", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 1, 0, 1, 1, 1, 1, 0, 0);
		
		//Button 8
		numberKeys(eightBtn, "8", calcFont, display, KeyEvent.VK_8, KeyEvent.VK_NUMPAD8, "eight", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 0, 1, 1, 1, 1, 0, 0);
		
		//Button 7
		numberKeys(sevenBtn, "7", calcFont, display, KeyEvent.VK_7, KeyEvent.VK_NUMPAD7, "seven", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 2, 1, 1, 1, 1, 1, 0, 0);
		
		//Button 6
		numberKeys(sixBtn, "6", calcFont, display, KeyEvent.VK_6, KeyEvent.VK_NUMPAD6, "six", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 1, 1, 1, 1, 1, 1, 0, 0);
		
		//Button 5
		numberKeys(fiveBtn, "5", calcFont, display, KeyEvent.VK_5, KeyEvent.VK_NUMPAD5, "five", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 1, 1, 1, 1, 1, 0, 0);
		
		//Button 4
		numberKeys(fourBtn, "4", calcFont, display, KeyEvent.VK_4, KeyEvent.VK_NUMPAD4, "four", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 2, 2, 1, 1, 1, 1, 0, 0);
		
		//Button 3
		numberKeys(threeBtn, "3", calcFont, display, KeyEvent.VK_3, KeyEvent.VK_NUMPAD3, "three", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 1, 2, 1, 1, 1, 1, 0, 0);
		
		//Button 2
		numberKeys(twoBtn, "2", calcFont, display, KeyEvent.VK_2, KeyEvent.VK_NUMPAD2, "two", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 2, 1, 1, 1, 1, 0, 0);
		
		//Button 1
		numberKeys(oneBtn, "1", calcFont, display, KeyEvent.VK_1, KeyEvent.VK_NUMPAD1, "one", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 0, 3, 1, 1, 1, 1, 0, 0);
		
		//Button swapSigns
		swapSignsBtn = new JButton();
		swapSignsBtn.setText("+/-");
		
		swapSignsBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		Action swapSignsBtnAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isNegative = display.getText().contains("-");
				
				if(!isNegative) {
					display.setText("-" + display.getText());
				} else {
					display.setText(display.getText().replace("-", ""));
				}
			}
			
		};
		
		swapSignsBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.SHIFT_DOWN_MASK, 0), "swapSigns");
		swapSignsBtn.getActionMap().put("swapSigns", swapSignsBtnAction);
		
		swapSignsBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_SHIFT, 0), "swapSigns");
		swapSignsBtn.getActionMap().put("swapSigns", swapSignsBtnAction);
		
		swapSignsBtn.addActionListener(swapSignsBtnAction);
		
		numberPanel.add(swapSignsBtn, nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 1, 3, 1, 1, 1, 1, 0, 0);
		
		//Button 0
		numberKeys(zeroBtn, "0", calcFont, display, KeyEvent.VK_0, KeyEvent.VK_NUMPAD0, "zero", nGBC);
		
		numberGridBagConstraints(GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 2, 3, 1, 1, 1, 1, 0, 0);
		
		//Button decimal
		numberKeys(decimalBtn, ".", calcFont, display, KeyEvent.VK_PERIOD, KeyEvent.VK_DECIMAL, "period", nGBC);
		
		backgroundPanel.add(numberPanel, bgGBC);
	}
	
	private void panelGridBagConstraints(
			int fill, int anchor,
			int gridx, int gridy,
			int gridheight, int gridwidth,
			int weightx, int weighty,
			int ipadx, int ipady
			) {
		
		bgGBC.fill = fill;
		bgGBC.anchor = anchor;
		bgGBC.gridx = gridx;
		bgGBC.gridy = gridy;
		bgGBC.gridheight = gridheight;
		bgGBC.gridwidth = gridwidth;
		bgGBC.weightx = weightx;
		bgGBC.weighty = weighty;
		bgGBC.ipadx = ipadx;
		bgGBC.ipady = ipady;
		
	}
	
	private void numberGridBagConstraints(
			int fill, int anchor,
			int gridx, int gridy,
			int gridheight, int gridwidth,
			int weightx, int weighty,
			int ipadx, int ipady
			) {
		
		nGBC.fill = fill;
		nGBC.anchor = anchor;
		nGBC.gridx = gridx;
		nGBC.gridy = gridy;
		nGBC.gridheight = gridheight;
		nGBC.gridwidth = gridwidth;
		nGBC.weightx = weightx;
		nGBC.weighty = weighty;
		nGBC.ipadx = ipadx;
		nGBC.ipady = ipady;
		
	}
	
	private void operatorGridBagConstraints(
			int fill, int anchor,
			int gridx, int gridy,
			int gridheight, int gridwidth,
			int weightx, int weighty,
			int ipadx, int ipady
			) {
		
		opGBC.fill = fill;
		opGBC.anchor = anchor;
		opGBC.gridx = gridx;
		opGBC.gridy = gridy;
		opGBC.gridheight = gridheight;
		opGBC.gridwidth = gridwidth;
		opGBC.weightx = weightx;
		opGBC.weighty = weighty;
		opGBC.ipadx = ipadx;
		opGBC.ipady = ipady;
		
	}
	
	private void specialOperatorGridBagConstraints(
			int fill, int anchor,
			int gridx, int gridy,
			int gridheight, int gridwidth,
			int weightx, int weighty,
			int ipadx, int ipady
			) {
		
		spOpsGBC.fill = fill;
		spOpsGBC.anchor = anchor;
		spOpsGBC.gridx = gridx;
		spOpsGBC.gridy = gridy;
		spOpsGBC.gridheight = gridheight;
		spOpsGBC.gridwidth = gridwidth;
		spOpsGBC.weightx = weightx;
		spOpsGBC.weighty = weighty;
		spOpsGBC.ipadx = ipadx;
		spOpsGBC.ipady = ipady;
		
	}
	
	private void settingsGridBagConstraints(
			int fill, int anchor,
			int gridx, int gridy,
			int gridheight, int gridwidth,
			int weightx, int weighty,
			int ipadx, int ipady
			) {
		
		settingsGBC.fill = fill;
		settingsGBC.anchor = anchor;
		settingsGBC.gridx = gridx;
		settingsGBC.gridy = gridy;
		settingsGBC.gridheight = gridheight;
		settingsGBC.gridwidth = gridwidth;
		settingsGBC.weightx = weightx;
		settingsGBC.weighty = weighty;
		settingsGBC.ipadx = ipadx;
		settingsGBC.ipady = ipady;
		
	}
	
	private void numberKeys(
			JButton numBtns, String numBtnTxt, Font numFont,
			JTextField display,
			int vkNum, int vkNumpadNum, String vkName,
			GridBagConstraints nGBC
			) {
		
		numBtns = new JButton();
		numBtns.setText(numBtnTxt);
		
		numBtns.setFont(numFont);
		numBtns.setBackground(Color.WHITE);
		
		Action numBtnAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText() + numBtnTxt);
				display.setHorizontalAlignment(SwingConstants.RIGHT);
				//System.out.println("Pressed");
			}
			
		};
		
		numBtns.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(vkNum, 0), vkName);
		numBtns.getActionMap().put(vkName, numBtnAction);
		
		numBtns.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(vkNumpadNum, 0), vkName);
		numBtns.getActionMap().put(vkName, numBtnAction);
		
		numBtns.addActionListener(numBtnAction);
		
		numberPanel.add(numBtns, nGBC);
		
	}
	
	private void operatorKeys(
			JButton opBtns, String opBtnTxt, Font opFont,
			JLabel prevNumDis, JLabel opDis, JTextField display,
			int vkOp, int vkNumpadOp, String vkName,
			GridBagConstraints opGBC
			) {
		
		opBtns = new JButton();
		opBtns.setText(opBtnTxt);
		
		opBtns.setFont(opFont);
		opBtns.setBackground(Color.WHITE);
		
		Action opBtnAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				opDis.setText(opBtnTxt);
				opDis.setHorizontalAlignment(SwingConstants.CENTER);
				
				if(!display.getText().isBlank() && opDis.getText().contains(divideBtn.getText())) {
					prevNumDis.setText(display.getText());
					prevNumDis.setHorizontalAlignment(SwingConstants.CENTER);
					display.setText("");
					
					System.out.println("op: " + prevNumDisplay.getText() + " " + operatorDisplay.getText() + " " + display.getText());
				}
			}
			
		};
		
		opBtns.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(vkOp, 0), vkName);
		opBtns.getActionMap().put(vkName, opBtnAction);
		
		opBtns.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(vkNumpadOp, 0), vkName);
		opBtns.getActionMap().put(vkName, opBtnAction);
		
		opBtns.addActionListener(opBtnAction);
		
		operatorPanel.add(opBtns, opGBC);
		
	}
}
