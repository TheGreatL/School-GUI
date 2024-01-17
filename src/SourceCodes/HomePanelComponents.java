/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SourceCodes;

import static SourceCodes.DashBoard.NORMAL_COLOR;
import static SourceCodes.DashBoard.PANEL_BG_COLOR;
import static SourceCodes.DashBoard.homeIcon;
import static SourceCodes.DashBoard.mainFrame;
import static SourceCodes.DashBoard.moduleIcon;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.AbstractList;
import java.util.LinkedList;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import org.json.simple.JSONObject;

import calendar.DateChooser;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author Ken-Carlon
 */
public final class HomePanelComponents{

	protected JButton plusIcon = new JButton();
        int p =0;
          String      path = "src/pictures/ant.png";
  DashBoard board;
  double temperature = 0;
  long humidity = 0;
  double windspeed = 0;
  static String userInput ="";
    String weatherCondition = "";
     LinkedList<JLabel> list = new LinkedList<>();
     protected JButton btnSearch = new JButton();
 	protected JTextField txt = new JTextField();
       protected JLabel windspeedText = new JLabel();
        protected JLabel humidityText  = new JLabel();
       protected JLabel  locationText = new JLabel();
       protected JLabel  weatherConditionDesc = new JLabel();
        protected JLabel temperatureText = new JLabel();
        protected JPanel weatherPanel = new JPanel();
        protected JLabel weatherIcon = new JLabel();
         protected  JPanel calendarPanel = new JPanel();
        protected JSONObject weatherData;
        protected DateChooser dateChooser  = new DateChooser();
        protected JPanel todoListPanel = new JPanel();
        protected LinkedList<String> list_toDo = new LinkedList<>();
    private final Color panelBG = new Color(0x466071);
   HomePanelComponents(DashBoard board) {
    this.board =  board;    //	  new Thread(() -> {}).start();
                   
  }

  private void setWeathes() {
    new Thread(() -> {
      try {
        // Your existing code for weather data retrieval
        if (userInput.replaceAll("\\s", "").length() <= 0) {
          return;
        }
        weatherData = weather.getWeatherData(userInput);
        locationText.setText(userInput);

        weatherCondition = (String) weatherData.get("weather_condition");

        // Update UI on the EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
          // Your existing code for updating UI components
           weatherIcon.setHorizontalAlignment(JLabel.CENTER);
           weatherIcon.setVerticalAlignment(JLabel.CENTER);
          switch (weatherCondition) {
            case "Clear" -> weatherIcon.setIcon(setWeatherIcon("src/pictures/weatherIcons/sunny.png")); 
            case "Cloudy" -> weatherIcon.setIcon(setWeatherIcon("src/pictures/weatherIcons/cloudy.png"));
            case "Rain" -> weatherIcon.setIcon(setWeatherIcon("src/pictures/weatherIcons/heavy-rain.png"));
            case "Snow" -> weatherIcon.setIcon(setWeatherIcon("src/pictures/weatherIcons/snow.png"));
          }
          temperature = (double) weatherData.get("temperature");
          	temperatureText.setText(temperature + " C");
          
          // update weather condition text
         weatherConditionDesc.setText(weatherCondition);

          // update humidity text
          humidity = (long) weatherData.get("humidity");
          	humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");

          // update windspeed text
          windspeed = (double) weatherData.get("windspeed");
         windspeedText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");
        });
      } catch (Exception e) {
        // Handle exceptions

          JOptionPane.showMessageDialog(DashBoard.mainFrame,
              "Error: could not connect to API.\nPlease Double check your input", "ERROR", JOptionPane.ERROR_MESSAGE);
  
      }
    }).start();
  }

  protected void weatherPart() {
  
        new Thread(() -> {
    
    btnSearch = new JButton("Search");

     btnSearch.setFont(new Font("Tahoma", Font.BOLD, 17));
     btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
     btnSearch.setBounds(87, 255, 100, 30);

     temperatureText = new JLabel("Searching...");
     temperatureText.setBounds(-88, 175, 450, 45);
      temperatureText.setFont(new Font("Dialog", Font.BOLD, 28));
      temperatureText.setHorizontalAlignment(SwingConstants.CENTER);

    // weather condition description
      weatherConditionDesc = new JLabel("Searching...");
      weatherConditionDesc.setBounds(-88, 130, 450, 36);
      weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
      weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);

      locationText = new JLabel("Searching...");
      locationText.setBounds(-88, 0, 450, 36);
      locationText.setFont(new Font("Dialog", Font.PLAIN, 32));
      locationText.setHorizontalAlignment(SwingConstants.CENTER);

    // humidity text
      humidityText = new JLabel("<html><b>...</b></html>");
      humidityText.setBounds(188, 159, 85, 55);
      humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));

    // windspeed text
      windspeedText = new JLabel("<html><b>...</b></html>");
      windspeedText.setBounds(10, 159, 85, 55);
      windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));

      txt = new JTextField();
   
      txt.setBounds(31, 223, 200, 30);
      txt.setFont(new Font("",Font.BOLD,20));
      txt.addKeyListener(new KeyAdapter() {
    	@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() =='\n') 
			{
                                                        
				if (  txt.getText() != null) {
			        userInput =  txt.getText();
                                                            weatherConditionDesc.setText("Searching....");
                                                            locationText.setText("Searching....");
					 setWeathes();
				}
			      else
			        JOptionPane.showMessageDialog(DashBoard.mainFrame, "You cannot leave the textfield empty");
			      	
			     
			}
			
		}
    });

   // board.calendarPanel.setBounds(930, 58, 268, 225);
   // todoListPanel.setBounds(930, 290, 267, 111);
	

   weatherPanel.setBounds(925, 475, 275, 310);
    weatherPanel.setBackground(Color.WHITE);
    weatherPanel.setBorder(BorderFactory.createLineBorder(Color.black,3));
   weatherPanel.setLayout(null);

    weatherIcon = new JLabel();
    
    weatherIcon.setBounds(87, 36, 100, 100);
   weatherPanel.add(txt);
    userInput = "Quezon City";
    setWeathes();

   btnSearch.addActionListener((ActionEvent e) -> {
        String    s= txt.getText();
        if ( !s.isBlank()) {
                weatherConditionDesc.setText("Searching....");
                         locationText.setText("Searching....");

         
            userInput = s;
            setWeathes();
        }
        else {
            btnSearch.setEnabled(false);
            JOptionPane.showMessageDialog(DashBoard.mainFrame, "You Cannot leave the textfield ","Error",JOptionPane.ERROR_MESSAGE);
            btnSearch.setEnabled(true);
        }
     });
   
     weatherPanel.add(  locationText);
     weatherPanel.add(  windspeedText);
     weatherPanel.add(  humidityText);
     weatherPanel.add(  weatherConditionDesc);
     weatherPanel.add(  temperatureText);
     weatherPanel.add(  txt);
	 weatherPanel.add(  weatherIcon, BorderLayout.CENTER);

     weatherPanel.add(  btnSearch);
         }).start();///////////
    board.homePanel.add(weatherPanel);
  }

  private ImageIcon setWeatherIcon(String url) {
    try {
      BufferedImage image = ImageIO.read(new File(url));
      ImageIcon icon = new ImageIcon(image);
      Image im = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
      icon.setImage(im);
      return icon;

    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Cannot Find Picure path", "Error", JOptionPane.ERROR_MESSAGE);
    }

    return null;
  }


  protected void setCalendar() {
     calendarPanel.setForeground(Color.black);
    calendarPanel.setBounds(925, 75, 275, 225);
    calendarPanel.setBackground(DashBoard.PANEL_BG_COLOR);
    calendarPanel.setLayout(new BorderLayout());
    calendarPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

      // Your existing code for updating UI components
       dateChooser.setForeground(panelBG);
       dateChooser.setFont( DashBoard.ICON_FONT);
       calendarPanel.add( dateChooser, BorderLayout.CENTER);

    board.homePanel.add(calendarPanel);
  }
  protected void setToDoList(){
      final int LIMIT = 3;
            
	todoListPanel.setBackground(panelBG);
	 todoListPanel.setBounds(925, 310, 275, 150);
	todoListPanel.setLayout(null);
	todoListPanel.setBorder(BorderFactory.createLineBorder(Color.black,3));
          
      JLabel todoTxt = new JLabel("To-do");
      todoTxt.setBounds(10, -19, 201, 91);
      todoTxt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
      todoTxt.setForeground(Color.WHITE);
      todoTxt.setIcon(setIconsReturnIcon("src/pictures/task.png"));
      todoTxt.setHorizontalAlignment(JLabel.LEFT);
        todoTxt.setVerticalAlignment(JLabel.CENTER);
          todoTxt.setHorizontalTextPosition(JLabel.LEFT);
       
      JPanel bpanel = new JPanel();
      bpanel.setBackground(Color.white);
      bpanel.setBounds(2 , 48, 271, 100);
      bpanel.setLayout(new GridLayout(3,1,0,0));
        
    
        plusIcon = new JButton("+");
        plusIcon.setFocusable(false);
    plusIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        plusIcon.setForeground(Color.white);
      plusIcon.setContentAreaFilled(false);
     plusIcon.setBounds(210, 0, 71, 50);
       plusIcon.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 5, Color.black));
     plusIcon.setHorizontalAlignment(JButton.CENTER);
     plusIcon.setVerticalAlignment(JButton.CENTER);
     plusIcon.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
     plusIcon.setBackground(Color.LIGHT_GRAY);
     plusIcon.setBorder(DashBoard.NO_LINE_BORDER);
      plusIcon.setFont(new Font("Tahoma ",Font.BOLD,35));
     plusIcon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				 plusIcon.setForeground(Color.red );
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				 plusIcon.setForeground(Color.white);
				
			}
      	
      });
      plusIcon.addActionListener((ActionEvent e) -> {
          //	JOptionPane.showInputDialog(mainFrame,"Input Message","TO-DO List",JOptionPane.PLAIN_MESSAGE);
          
          
          plusIcon.setEnabled(false);
          JLabel messageTxt = new JLabel();
          
          if(p<=2){
              PrompClass.showInputToDoList(plusIcon);
              String pr =PrompClass.getTXT();
              
              if(!pr.isEmpty()){
      
                  messageTxt.setText(pr);
                  board.listOfTodo.add(messageTxt.getText());
                  messageTxt.setFont(new Font("",Font.BOLD,16));
                  messageTxt.setBorder(DashBoard.ICON_BORDER);
                  messageTxt.setHorizontalAlignment(JLabel.LEFT);
                  messageTxt.setHorizontalAlignment(JLabel.CENTER);
                  messageTxt.setHorizontalTextPosition(JLabel.LEFT);
                  messageTxt.setVerticalTextPosition(JLabel.CENTER);
                  messageTxt.setIcon(setIconsReturnIcon(path));
                      messageTxt.setCursor(DashBoard.HAND_CURSOR);
                 ModulePanelComponents.updateTask();
                 
                  messageTxt.addMouseListener(new MouseAdapter(){
                      
                      @Override
                      public void mouseClicked(MouseEvent e){
                          
                          messageTxt.setVisible(false);
                             ModulePanelComponents.removeTask();
                          bpanel.remove(messageTxt);
                          p--;
                        
                          plusIcon.setEnabled(true);

                      }
                  });
              
              }
              else {
                  return;
                  
              }
              
                    
          }
          else{
              JOptionPane.showMessageDialog(DashBoard.mainFrame, "Exceed","Error",JOptionPane.ERROR_MESSAGE);
              plusIcon.setEnabled(false);
              return;
          }
          
          if(path.equals("src/pictures/ant.png"))
              path = "src/pictures/bug.png";
          else if(path.equals( "src/pictures/bug.png"))
              path = "src/pictures/cow.png";
          else if(path.equals( "src/pictures/cow.png"))
              path =   "src/pictures/ant.png";
          p++;
          
          bpanel.add(messageTxt);

      });
          
  
    
          todoListPanel.add(bpanel);
  todoListPanel.add(plusIcon);

    todoListPanel.add(todoTxt);
    board.homePanel.add(todoListPanel);
  }
  
  protected void schoolEventPanel() {
	   int sizeH = 335;
	   int sizeW = 875;
	   new Thread(() -> {
                         
			SchoolPanel mainPanel = new SchoolPanel();
                                             
			
			mainPanel.setBounds(28, 75, sizeW, sizeH);
		       
		        
		        	board.homePanel.add(mainPanel);

		      
		
		    }).start();


	
  }
  protected void shortcutHandout(){
      String iconPath ="src/pictures/shortCut.png";
      Dimension moduleSize = new Dimension(250, 300);
      JPanel modulePanel = new JPanel();
      
      
      modulePanel.setBackground(DashBoard.MODULE_PANEL_COLOR);
      modulePanel.setBounds(28, 420, 875, 365);
      modulePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      modulePanel.setLayout(null);
       
      
      JPanel contentPanel = new JPanel();
      contentPanel.setBackground(DashBoard.MODULE_PANEL_COLOR);
      contentPanel.setBounds(20, 57, 830, 290);
       contentPanel.setBorder(DashBoard.NO_LINE_BORDER);
       
     // contentPanel.setLayout(new GridLayout(1,3,20,0));
           contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
      JPanel module1 = new JPanel();
      module1.setBackground(DashBoard.MODULE_SHORTCUT_COLOR);
      module1.setPreferredSize(moduleSize);
      module1.addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseClicked(MouseEvent e){
                board.tabs.setSelectedIndex(2);
                       moduleIcon.setBackground(PANEL_BG_COLOR);
             moduleIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             moduleIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
          }
      });
      
      module1.setLayout(new BorderLayout());
      JLabel sub1 =new JLabel(DashBoard.userRecords.getSubject1());
      sub1.setHorizontalAlignment(JLabel.CENTER);
      sub1.setForeground(Color.WHITE);
      sub1.setCursor(DashBoard.HAND_CURSOR);
           sub1.setSize(100, 100);
      sub1.setIcon(MethodsForAll.setIconsReturnIcon(iconPath, sub1));
      sub1.setVerticalTextPosition(JLabel.BOTTOM);
       sub1.setHorizontalTextPosition(JLabel.CENTER);
      module1.add(sub1,BorderLayout.CENTER);
      
      
      JPanel module2 = new JPanel();
      module2.setBackground(DashBoard.MODULE_SHORTCUT_COLOR);
      module2.setPreferredSize(moduleSize);
        module2.addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseClicked(MouseEvent e){
                board.tabs.setSelectedIndex(2);
                       moduleIcon.setBackground(PANEL_BG_COLOR);
             moduleIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             moduleIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
          }
      });
      
          module2.setLayout(new BorderLayout());
      JLabel sub2 =new JLabel(DashBoard.userRecords.getSubject2());
      sub2.setHorizontalAlignment(JLabel.CENTER);
      sub2.setForeground(Color.WHITE);
      sub2.setCursor(DashBoard.HAND_CURSOR);
      
          sub2.setSize(100, 100);
      sub2.setIcon(MethodsForAll.setIconsReturnIcon(iconPath, sub2));
      sub2.setVerticalTextPosition(JLabel.BOTTOM);
       sub2.setHorizontalTextPosition(JLabel.CENTER);
      
      module2.add(sub2,BorderLayout.CENTER);
      
      JPanel module3 = new JPanel();
      module3.setBackground(DashBoard.MODULE_SHORTCUT_COLOR);
      module3.setPreferredSize(moduleSize);
       module3.addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseClicked(MouseEvent e){
                board.tabs.setSelectedIndex(2);
                       moduleIcon.setBackground(PANEL_BG_COLOR);
             moduleIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             moduleIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
          }
      });
      
                module3.setLayout(new BorderLayout());
      JLabel sub3 =new JLabel(DashBoard.userRecords.getSubject3());
      sub3.setHorizontalAlignment(JLabel.CENTER);
      sub3.setForeground(Color.WHITE);
      sub3.setCursor(DashBoard.HAND_CURSOR);
      
      sub3.setSize(100, 100);
      sub3.setIcon(MethodsForAll.setIconsReturnIcon(iconPath, sub3));
      sub3.setVerticalTextPosition(JLabel.BOTTOM);
       sub3.setHorizontalTextPosition(JLabel.CENTER);
      
      module3.add(sub3,BorderLayout.CENTER);
      
      JPanel module4 = new JPanel();
      module4.setBackground(DashBoard.MODULE_SHORTCUT_COLOR);
      module4.setPreferredSize(moduleSize);
      module4.addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseClicked(MouseEvent e){
                board.tabs.setSelectedIndex(2);
                       moduleIcon.setBackground(PANEL_BG_COLOR);
             moduleIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             moduleIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
          }
      });
      module4.setVisible(false);
      
                      module4.setLayout(new BorderLayout());
      JLabel sub4 =new JLabel(DashBoard.userRecords.getSubject4());
      sub4.setHorizontalAlignment(JLabel.CENTER);
      sub4.setForeground(Color.WHITE);
      sub4.setCursor(DashBoard.HAND_CURSOR);
       sub4.setSize(100, 100);
      sub4.setIcon(MethodsForAll.setIconsReturnIcon(iconPath, sub4));
      sub4.setVerticalTextPosition(JLabel.BOTTOM);
       sub4.setHorizontalTextPosition(JLabel.CENTER);
      module4.add(sub4,BorderLayout.CENTER);
      
      
      JPanel module5 = new JPanel();
      module5.setBackground(DashBoard.MODULE_SHORTCUT_COLOR);
      module5.setPreferredSize(moduleSize);
       module5.addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseClicked(MouseEvent e){
                board.tabs.setSelectedIndex(2);
                       moduleIcon.setBackground(PANEL_BG_COLOR);
             moduleIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             moduleIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
          }
      });
        module5.setVisible(false);
        
                           module5.setLayout(new BorderLayout());
      JLabel sub5 =new JLabel(DashBoard.userRecords.getSubject5());
      sub5.setHorizontalAlignment(JLabel.CENTER);
      sub5.setForeground(Color.WHITE);
      sub5.setCursor(DashBoard.HAND_CURSOR);
      
      sub5.setSize(100, 100);
      sub5.setIcon(MethodsForAll.setIconsReturnIcon(iconPath, sub5));
      sub5.setVerticalTextPosition(JLabel.BOTTOM);
       sub5.setHorizontalTextPosition(JLabel.CENTER);
       
      module5.add(sub5,BorderLayout.CENTER);
      
        
        
      JPanel module6 = new JPanel();
      module6.setBackground(DashBoard.MODULE_SHORTCUT_COLOR);
      module6.setPreferredSize(moduleSize);
        module6.setVisible(false);
          module6.addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseClicked(MouseEvent e){
                board.tabs.setSelectedIndex(2);
                       moduleIcon.setBackground(PANEL_BG_COLOR);
             moduleIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             moduleIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
          }
      });
      
                                module6.setLayout(new BorderLayout());
      JLabel sub6 =new JLabel(DashBoard.userRecords.getSubject6());
      sub6.setHorizontalAlignment(JLabel.CENTER);
      sub6.setForeground(Color.WHITE);
      sub6.setCursor(DashBoard.HAND_CURSOR);
      
         sub6.setSize(100, 100);
      sub6.setIcon(MethodsForAll.setIconsReturnIcon(iconPath, sub6));
      sub6.setVerticalTextPosition(JLabel.BOTTOM);
       sub6.setHorizontalTextPosition(JLabel.CENTER);
      
      module6.add(sub6,BorderLayout.CENTER);
        
        
      JButton button = new JButton(">");
      button.setBounds(750,5,80,50);
      button.setFont(new Font("Tahoma", Font.BOLD, 40));
      button.setHorizontalAlignment(JButton.CENTER);
      button.setVerticalAlignment(JButton.CENTER);
      button.setFocusable(false);
      button.setBackground(Color.white);
      button.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              if(module1.isVisible()&&module2.isVisible()&&module3.isVisible()){
                  button.setText("<");
                  module4.setVisible(true);
                  module5.setVisible(true);
                  module6.setVisible(true);
                  module1.setVisible(false);
                  module2.setVisible(false);
                  module3.setVisible(false);
              }
              else if(module4.isVisible()&& module5.isVisible()&&module6.isVisible()){
                      button.setText(">");
                     module1.setVisible(true);
                  module2.setVisible(true);
                  module3.setVisible(true);
                     module4.setVisible(false);
                  module5.setVisible(false);
                  module6.setVisible(false);
              }
          }
          
      });
      
      contentPanel.add(module1);
      contentPanel.add(module2);
      contentPanel.add(module3);
      contentPanel.add(module4);
      contentPanel.add(module5);
      contentPanel.add(module6);
      modulePanel.add(button);
      modulePanel.add(contentPanel);
      board.homePanel.add(modulePanel);
      
  }


  public class SchoolPanel extends JPanel implements ActionListener
  {
	  
	  Image eventImage;
    String imagePath;
   Timer timer;
   
   public SchoolPanel() {
                new Thread(() -> {
                         
		   imagePath ="src/pictures/EventsPics/P1.jpg";
	  eventImage = setIconsReturnImage(imagePath); 
	  timer =  new Timer(10000,this);
	  this.setBorder(BorderFactory.createLineBorder(Color.black,5));
	  timer.start();

		      
		      
		    }).start();
	
   }
       @Override
       public void paint(Graphics g){
    	   super.paint(g);
         Graphics2D g2D = (Graphics2D) g;
         g2D.drawImage(eventImage, 0, 0, null);
         g2D.setStroke(new BasicStroke(3));
        g2D.drawRect(0, 0, 874, 334);
        g2D.setColor(Color.black);
        
      
         
       }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(imagePath.equals("src/pictures/EventsPics/P1.jpg")) {
			   imagePath ="src/pictures/EventsPics/P2.jpg";
				  eventImage = setIconsReturnImage(imagePath); 
                                     repaint();
		}
		else if(imagePath.equals("src/pictures/EventsPics/P2.jpg")) {
			   imagePath ="src/pictures/EventsPics/P3.jpg";
				  eventImage = setIconsReturnImage(imagePath); 
                                     repaint();
		}
		else if(imagePath.equals("src/pictures/EventsPics/P3.jpg")) {
			   imagePath ="src/pictures/EventsPics/P4.jpg";
				  eventImage = setIconsReturnImage(imagePath); 
                                     repaint();
		}
                                   else if(imagePath.equals("src/pictures/EventsPics/P4.jpg")){
                                               imagePath ="src/pictures/EventsPics/P5.jpg";
				  eventImage = setIconsReturnImage(imagePath); 
                                     repaint();
                                   }
                                  else if(imagePath.equals("src/pictures/EventsPics/P5.jpg"))
                                  {
                                               imagePath ="src/pictures/EventsPics/P1.jpg";
				  eventImage = setIconsReturnImage(imagePath); 
                                  repaint();
                                   }
	
	
		
	}
	 public   Image setIconsReturnImage(String resourcePath){
	        try{
	            // read the image file from the path given
	            BufferedImage imagebuff = ImageIO.read(new File(resourcePath));
	             ImageIcon icon = new ImageIcon(imagebuff);
	              Image image = icon.getImage().getScaledInstance(875, 335, Image.SCALE_SMOOTH);
	       
	         
	            return image;
	        }catch(IOException e){
	      
	            JOptionPane.showMessageDialog(mainFrame, "Error, Buffering Image.\n\"Could not find resource\"", "Error", JOptionPane.ERROR_MESSAGE);
	        }

	        return null;
	    }
  }
    public   ImageIcon setIconsReturnIcon(String resourcePath ){
        try{
            // read the image file from the path given
            BufferedImage imagebuff = ImageIO.read(new File(resourcePath));
             ImageIcon icon = new ImageIcon(imagebuff);
              Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
           icon.setImage(image);
         
            return icon;
        }catch(IOException e){

            JOptionPane.showMessageDialog(mainFrame, "Error, Buffering Image.\n\"Could not find resource\"", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

  
}
