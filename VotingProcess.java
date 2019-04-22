import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;
import java.awt.Panel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;

public class VotingProcess extends JFrame 
{
	
	CardLayout cardLayoutObj ;
	Panel panelCard ;
	
	Panel panel_main_frame;
	JButton admin_button , voter_button;
	
	String voters_choice;
	String voter_id;
	
	VotingProcess() 
	{
		
		Dimensioning();
		making_Panel();
		card_slide_display();
		
	}
	
	
	
	public void card_slide_display()
	{
		int i = 1;
		try
		{
			while(i<3)
			{
				if(i == 1)
				{
					cardLayoutObj.show(panelCard,"PIC1");
					i++;
					Thread.sleep(2000);
				}
				
				if(i == 2)
				{
					cardLayoutObj.show(panelCard,"PIC2");
					i++;
					Thread.sleep(2000);
				}
				
				if(i == 3)
				{
					cardLayoutObj.show(panelCard,"PIC3");
					i++;
					Thread.sleep(2000);
				}
			
			}
			cardLayoutObj.show(panelCard,"MAIN");
		}
		
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void Dimensioning()
	{
		
		setLayout(new BorderLayout());
		setUndecorated(true);
		Dimension Machine_ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(Machine_ScreenSize.width , Machine_ScreenSize.height);
		setVisible(true);
		setResizable(false);
	}
	
	public void making_Panel()
	{
		setLayout(new BorderLayout());
		
		
		Dimension Machine_ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w  = 	Machine_ScreenSize.width - 1 ;
		int h  = 	Machine_ScreenSize.height - 1;  
		
		
		setVisible(false);
		setVisible(true);
		
				
		Panel panel_pic1 = new Panel(new FlowLayout());
		JLabel label_pic1 =	new JLabel(new ImageIcon("D:\\javap\\EVM\\picture4.png")); 
		setSize(w,h);
		setSize(Machine_ScreenSize.width , Machine_ScreenSize.height);
		panel_pic1.add(label_pic1);
		
		Panel panel_pic2 = new Panel(new FlowLayout());
		JLabel label_pic2 = new JLabel(new ImageIcon("D:\\javap\\EVM\\pic2.jpg"));
		panel_pic2.setBackground(Color.BLUE);
		setSize(w,h);
		panel_pic2.setSize(Machine_ScreenSize.width , Machine_ScreenSize.height);
		panel_pic2.add(label_pic2);
		
		
		Panel panel_pic3 = new Panel(new FlowLayout());
		JLabel label_pic3 = new JLabel(new ImageIcon("D:\\javap\\EVM\\pic3.jpg"));
		panel_pic3.setBackground(Color.RED);
		setSize(w,h);
		setSize(Machine_ScreenSize.width , Machine_ScreenSize.height);
	
		panel_pic3.add(label_pic3);
		
		Panel panel_main_frame = new Panel(new FlowLayout());
		setLayout(new BorderLayout());
		JLabel label_main_frame = new JLabel(new ImageIcon("D:\\javap\\EVM\\main_frame.jpg"));
		JButton admin_button = new JButton("ADMIN LOGIN");
		JButton voter_button = new JButton("VOTER LOGIN");
		
		admin_button.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent ae)
			{
				
				JFrame admin_details_frame = new JFrame();
				admin_details_frame.setLayout(null);
				admin_details_frame.setUndecorated(true);
				Dimension Machine_ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
				admin_details_frame.setSize(Machine_ScreenSize.width , Machine_ScreenSize.height);
				admin_details_frame.setVisible(true);
				admin_details_frame.setResizable(false);
				
				JLabel eci_symbol = new JLabel(new ImageIcon("D:\\javap\\EVM\\login_image.png"));
				JLabel ECI_NAME = new JLabel("ELECTION COMISSION OF INDIA");
				ECI_NAME.setFont(new Font("TimesRoman",Font.BOLD,50));
				ECI_NAME.setForeground(Color.BLUE);
				JLabel ADMIN_USERNAME_LABEL = new JLabel("USERNAME");
				JLabel ADMIN_PASSWORD = new JLabel("PASSWORD");
				
				JTextField ADMIN_USERNAME_TEXT = new JTextField(); 
				JPasswordField ADMIN_PASSWORD_TEXTFIELD = new JPasswordField(); 
				
				JButton ADMIN_LOGIN_BUTTON = new JButton("CLICK HERE TO LOGIN");
				
				eci_symbol.setBounds(10,50,200,200);
				ECI_NAME.setBounds(230,50,1300,200);
				ADMIN_USERNAME_LABEL.setBounds(500,300,100,30);
				ADMIN_USERNAME_TEXT.setBounds(700,300,100,30);
				ADMIN_PASSWORD.setBounds(500,320,100,80);
				ADMIN_PASSWORD_TEXTFIELD.setBounds(700,350,100,30);
				ADMIN_LOGIN_BUTTON.setBounds(550,450,200,50);
				
				admin_details_frame.add(eci_symbol);
				admin_details_frame.add(ECI_NAME);
				admin_details_frame.add(ADMIN_USERNAME_LABEL);
				admin_details_frame.add(ADMIN_USERNAME_TEXT);
				admin_details_frame.add(ADMIN_PASSWORD);
				admin_details_frame.add(ADMIN_PASSWORD_TEXTFIELD);
				admin_details_frame.add(ADMIN_LOGIN_BUTTON);
				
				ADMIN_LOGIN_BUTTON.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String admin_username = ADMIN_USERNAME_TEXT.getText();
						String admin_password = ADMIN_PASSWORD_TEXTFIELD.getText();
						
						
						
		
							if( admin_username.equals(new String("eci_com")) && admin_password.equals( new String("1234567")) )
							{	
								
								JOptionPane.showMessageDialog(admin_details_frame,"WELCOME !");
								
								// keeping track of admin login details like date and time
								try
								{
									Class.forName("com.mysql.jdbc.Driver");
									Connection con_admin_login = DriverManager.getConnection("jdbc:mysql://localhost/voting_data","eci_com","1234567");
		
									java.util.Date login_date = new java.util.Date();
									
									java.sql.Date login_sqlDate = new java.sql.Date(login_date.getTime());
									java.sql.Time login_sqlTime = new java.sql.Time(login_date.getTime());
									
									Thread.sleep(500);
									
									PreparedStatement ps_admin_login = con_admin_login.prepareStatement("insert into voting_data.`admin login details`(DATE,`LOGIN TIME`) values(?,?)");
									
									ps_admin_login.setDate(1,login_sqlDate);
									ps_admin_login.setTime(2,login_sqlTime);
									
									ps_admin_login.executeUpdate();			
									
									ps_admin_login.close();
									con_admin_login.close();
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(admin_details_frame,""+exc);
								}
														
								
								
								
								JFrame admin_work_frame = new JFrame();
								admin_work_frame.setLayout(null);
								admin_work_frame.setUndecorated(true);
								Dimension Machine_ScreenSize_1 = Toolkit.getDefaultToolkit().getScreenSize();
								admin_work_frame.setSize(Machine_ScreenSize_1.width , Machine_ScreenSize_1.height);
								admin_work_frame.setVisible(true);
								admin_work_frame.setResizable(false);
								admin_details_frame.dispose();
								
								JLabel eci_symbol = new JLabel(new ImageIcon("D:\\javap\\EVM\\login_image.png"));
								JLabel ECI_NAME = new JLabel("ELECTION COMISSION OF INDIA");
								ECI_NAME.setFont(new Font("TimesRoman",Font.BOLD,50));
								ECI_NAME.setForeground(Color.BLUE);
									
								
								JButton insert_a_new_voter_button = new JButton("Insert A New Voter");
								JButton delete_a_voter_button = new JButton("Delete a voter");
								JButton update_a_voter_button = new JButton("Update Voter's Credentials");
								JButton view_voters_list_button = new JButton("View Final Voter's List");
								JButton view_final_results_button= new JButton("View Final Results");
								JButton reset_votes_button = new JButton("Reset Votes in Votes Table");
								JButton insert_candidate_button = new JButton("Insert A New Candidate");
								JButton delete_candidate_button = new JButton("Delete A Candidate");
								JButton view_candidates_list_button = new JButton("View Final Candidates List");
								JButton admin_login_details_button = new JButton("Admin Login Details");
								JButton close_system_button = new JButton("Close the System");
								
								eci_symbol.setBounds(10,50,200,200);
								ECI_NAME.setBounds(230,50,1300,200);
								
								insert_a_new_voter_button.setBounds(50,300,150,50);
								delete_a_voter_button.setBounds(230,300,150,50);
								update_a_voter_button.setBounds(410,300,200,50);
								view_voters_list_button.setBounds(640,300,200,50);
								view_final_results_button.setBounds(870,300,200,50);
								reset_votes_button.setBounds(1100,300,200,50);
								
								insert_candidate_button.setBounds(50,500,200,50);
								delete_candidate_button.setBounds(280,500,200,50);
								view_candidates_list_button.setBounds(510,500,200,50);
								admin_login_details_button.setBounds(730,500,200,50);
								close_system_button.setBounds(960,500,200,50);
							
								admin_work_frame.add(eci_symbol);
								admin_work_frame.add(ECI_NAME);
								
								admin_work_frame.add(insert_a_new_voter_button);
								admin_work_frame.add(delete_a_voter_button);
								admin_work_frame.add(update_a_voter_button);
								admin_work_frame.add(view_voters_list_button);
								admin_work_frame.add(view_final_results_button);
								admin_work_frame.add(reset_votes_button);
								admin_work_frame.add(insert_candidate_button);
								admin_work_frame.add(delete_candidate_button);
								admin_work_frame.add(view_candidates_list_button);
								admin_work_frame.add(admin_login_details_button);
								admin_work_frame.add(close_system_button);
								
								insert_a_new_voter_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent i)
									{
											JFrame voter_insert_frame = new JFrame("INSERT A NEW VOTER");
											Image icon = Toolkit.getDefaultToolkit().getImage("D:\\javap\\EVM\\login_image.png");  
											voter_insert_frame.setIconImage(icon);  	
											voter_insert_frame.setLayout(null);
											voter_insert_frame.setSize(700,700);
											voter_insert_frame.setVisible(true);
											voter_insert_frame.setResizable(false);
											
											JLabel new_voter_id = new JLabel("VOTER ID FOR NEW VOTER");
											JLabel new_voter_name = new JLabel("NAME OF NEW VOTER");
											JLabel new_voter_dob = new JLabel("D.O.B. OF NEW VOTER");
											JLabel new_voter_mobile_no = new JLabel("MOBILE NUMBER OF VOTER");
											JLabel new_voter_address = new JLabel("ADDRESS OF NEW VOTER");
											JLabel new_voter_city = new JLabel("CITY OF NEW VOTER");
											JLabel new_voter_state = new JLabel("STATE OF NEW VOTER");
											
											JTextField new_voter_id_text = new JTextField();
											JTextField new_voter_name_text = new JTextField();
											JTextField new_voter_dob_text = new JTextField();
											JTextField new_voter_mobile_no_text = new JTextField();
											JTextField new_voter_address_text = new JTextField();
											JTextField new_voter_city_text = new JTextField();
											JTextField new_voter_state_text = new JTextField();
											
											JButton submit_button = new JButton("SUBMIT");
											
											new_voter_id.setBounds(100,50,200,50);
											new_voter_name.setBounds(100,130,200,50);
											new_voter_dob.setBounds(100,210,200,50);
											new_voter_mobile_no.setBounds(100,290,200,50);
											new_voter_address.setBounds(100,370,200,50);
											new_voter_city.setBounds(100,450,200,50);
											new_voter_state.setBounds(100,530,200,50);
										
											new_voter_id_text.setBounds(400,50,200,50);
											new_voter_name_text.setBounds(400,130,200,50);
											new_voter_dob_text.setBounds(400,210,200,50);
											new_voter_mobile_no_text.setBounds(400,290,200,50);
											new_voter_address_text.setBounds(400,370,200,50);
											new_voter_city_text.setBounds(400,450,200,50);
											new_voter_state_text.setBounds(400,530,200,50);
											
											submit_button.setBounds(290,600,100,50);
										
											voter_insert_frame.add(new_voter_id);
											voter_insert_frame.add(new_voter_name);
											voter_insert_frame.add(new_voter_dob);
											voter_insert_frame.add(new_voter_mobile_no);
											voter_insert_frame.add(new_voter_address);
											voter_insert_frame.add(new_voter_city);
											voter_insert_frame.add(new_voter_state);
											
											voter_insert_frame.add(new_voter_id_text);
											voter_insert_frame.add(new_voter_name_text);
											voter_insert_frame.add(new_voter_dob_text);
											voter_insert_frame.add(new_voter_mobile_no_text);
											voter_insert_frame.add(new_voter_address_text);
											voter_insert_frame.add(new_voter_city_text);
											voter_insert_frame.add(new_voter_state_text);
											
											voter_insert_frame.add(submit_button);
											
											submit_button.addActionListener(new ActionListener()
											{
												public void actionPerformed(ActionEvent ae)
												{
												
													try
													{
														String voter_id = new_voter_id_text.getText();
														String voter_name = new_voter_name_text.getText();
														String voter_dob = new_voter_dob_text.getText();
														String voter_mobile_no = new_voter_mobile_no_text.getText();
														String voter_address = new_voter_address_text.getText();
														String voter_city = new_voter_city_text.getText();
														String voter_state = new_voter_state_text.getText();
														
														
														int a = JOptionPane.showConfirmDialog(voter_insert_frame,"Are you sure?");  
														if(a == JOptionPane.YES_OPTION)
														{
															Class.forName("com.mysql.jdbc.Driver");
															Connection my_conn = DriverManager.getConnection("jdbc:mysql://localhost/voting_data","eci_com","1234567");
															
															PreparedStatement serial_stmt = my_conn.prepareStatement("select `Serial number` from `voters table`");
															ResultSet serial_rst = serial_stmt.executeQuery();
															
															serial_rst.last();
															int serialNumber = serial_rst.getInt(1);
															serialNumber += 1;
															
															// to convert date from string format to date format
															java.util.Date voter_dob_date = new SimpleDateFormat("yyyy/MM/dd").parse(voter_dob);
															java.sql.Date sqlDate_dob = new java.sql.Date(voter_dob_date.getTime());
															
									
															PreparedStatement insert_pst = my_conn.prepareStatement("insert voting_data.`voters table`(`Serial number`,`VOTER ID`,`VOTER NAME`,`D.O.B.`,`Mobile Number`,`Address`,`City`,`State`,`Voted Party`) values(?,?,?,?,?,?,?,?,?)");
															
															insert_pst.setInt(1,serialNumber);
															insert_pst.setString(2,voter_id);
															insert_pst.setString(3,voter_name);
															insert_pst.setDate(4,sqlDate_dob);
															insert_pst.setString(5,voter_mobile_no);
															insert_pst.setString(6,voter_address);
															insert_pst.setString(7,voter_city);
															insert_pst.setString(8,voter_state);
															insert_pst.setString(9,"NIL");
															
															insert_pst.executeUpdate();
															
															JOptionPane.showMessageDialog(voter_insert_frame,"NEW VOTER INSERTED SUCCESSFULLY !");
															
															my_conn.close(); 
														}
													voter_insert_frame.dispose();	
														
													}
													
													catch(Exception ex)
													{
														JOptionPane.showMessageDialog(voter_insert_frame,""+ex);
													}
												}
											});
													
									}
								});
								
								// delete a voter button	
								delete_a_voter_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
										try
										{
											Class.forName("com.mysql.jdbc.Driver");
											Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com" ,"1234567");
											
											String voter_id_to_delete = JOptionPane.showInputDialog(admin_details_frame,"Enter VOTER ID");
											
											Statement delete_voter_stmt = connect.createStatement();
											delete_voter_stmt.execute("DELETE FROM `voters table` WHERE  `VOTER ID` = '"+voter_id_to_delete+"' ");
											
											JOptionPane.showMessageDialog(admin_details_frame,"VOTER SUCCESSFULLY DELETED");
											
											delete_voter_stmt.close();
											connect.close();
										}
										
										catch(Exception ex)
										{
											JOptionPane.showMessageDialog(admin_details_frame,""+ex);
										}
		
									}
									
								});	
									
								// update a voter button	
								update_a_voter_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
										try
										{
											String voter_id_for_updation = JOptionPane.showInputDialog(admin_details_frame,"VOTER ID FOR UPDATION");	
											Class.forName("com.mysql.jdbc.Driver");
											Connection con_update = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com" ,"1234567");
											
											PreparedStatement pst_up = con_update.prepareStatement("SELECT `VOTER ID` from `voters table`");
											
											ResultSet rst_up = pst_up.executeQuery();
											
											while(rst_up.next())
											{
												String db_voter_id = rst_up.getString(1);
												
												if(voter_id_for_updation.equals(db_voter_id) == true)
												{	
													String what_to_update = JOptionPane.showInputDialog(admin_details_frame,"WHAT TO YOU WANT TO UPDATE ? \n\n VOTER NAME / D.O.B./ Mobile Number / Address / City / State \n ENTER IN  THESE  FORMATS ONLY." );
													
													if(what_to_update.equals("VOTER NAME") == true)
													{
														String updated_voter_name = JOptionPane.showInputDialog(admin_details_frame,"What is the updated name ?");
														
														Statement st_voter_name_update = con_update.createStatement();
														String sql_voter_name_update = "UPDATE `voters table` SET `VOTER NAME` = '"+updated_voter_name+"' WHERE `VOTER ID`= '"+voter_id_for_updation+"' " ;
														st_voter_name_update.executeUpdate(sql_voter_name_update);
														JOptionPane.showMessageDialog(admin_details_frame,"UPDATED SUCCESSFULLY !");										
														st_voter_name_update.close();
													}
													
													if(what_to_update.equals("D.O.B.") == true)
													{
														String updated_voter_dob = JOptionPane.showInputDialog(admin_details_frame," NOTE: Enter d.o.b only in yy/MM/dd f  \n\nWhat is the updated D.O.B. ? ");
														
														Statement st_voter_dob_update = con_update.createStatement();
														String sql_voter_dob_update = "UPDATE `voters table` SET `D.O.B.` = '"+updated_voter_dob+"' WHERE `VOTER ID`= '"+voter_id_for_updation+"' " ;
														st_voter_dob_update.executeUpdate(sql_voter_dob_update);
														JOptionPane.showMessageDialog(admin_details_frame,"UPDATED SUCCESSFULLY !");										
														st_voter_dob_update.close();
													}
													
													if(what_to_update.equals("Mobile Number") == true)
													{
														String updated_voter_m_no = JOptionPane.showInputDialog(admin_details_frame,"What is the updated mobile number ?");
														
														Statement st_voter_mobile_update = con_update.createStatement();
														String sql_voter_mobile_update = "UPDATE `voters table` SET `Mobile Number` = '"+updated_voter_m_no+"' WHERE `VOTER ID`= '"+voter_id_for_updation+"' " ;
														st_voter_mobile_update.executeUpdate(sql_voter_mobile_update);
														JOptionPane.showMessageDialog(admin_details_frame,"UPDATED SUCCESSFULLY !");										
														st_voter_mobile_update.close();
													}
													
													if(what_to_update.equals("Address") == true)
													{
														String updated_voter_address = JOptionPane.showInputDialog(admin_details_frame,"What is the updated address ?");
														
														Statement st_voter_address_update = con_update.createStatement();
														String sql_voter_address_update = "UPDATE `voters table` SET `Address` = '"+updated_voter_address+"' WHERE `VOTER ID`= '"+voter_id_for_updation+"' " ;
														st_voter_address_update.executeUpdate(sql_voter_address_update);
														JOptionPane.showMessageDialog(admin_details_frame,"UPDATED SUCCESSFULLY !");										
														st_voter_address_update.close();
													}
													
													if(what_to_update.equals("City") == true)
													{
														String updated_voter_city = JOptionPane.showInputDialog(admin_details_frame,"What is the updated city ?");
														
														Statement st_voter_city_update = con_update.createStatement();
														String sql_voter_city_update = "UPDATE `voters table` SET `City` = '"+updated_voter_city+"' WHERE `VOTER ID`= '"+voter_id_for_updation+"' " ;
														st_voter_city_update.executeUpdate(sql_voter_city_update);
														JOptionPane.showMessageDialog(admin_details_frame,"UPDATED SUCCESSFULLY !");										
														st_voter_city_update.close();
													}
													
													if(what_to_update.equals("State") == true)
													{
														String updated_voter_state = JOptionPane.showInputDialog(admin_details_frame,"What is the updated state ?");
														
														Statement st_voter_state_update = con_update.createStatement();
														String sql_voter_state_update = "UPDATE `voters table` SET `State` = '"+updated_voter_state+"' WHERE `VOTER ID`= '"+voter_id_for_updation+"' " ;
														st_voter_state_update.executeUpdate(sql_voter_state_update);
														JOptionPane.showMessageDialog(admin_details_frame,"UPDATED SUCCESSFULLY !");
														st_voter_state_update.close();
													}
												
												
												}	
												
											}
											
											pst_up.close();
											con_update.close();
											
											
										}
										
										catch(Exception ex)
										{
											JOptionPane.showMessageDialog(admin_details_frame,""+ex);
											
										}
										
									}
									
								});	
								

								// view voters list button	
								view_voters_list_button.addActionListener(new ActionListener()
								{
									
										public void actionPerformed(ActionEvent a)
										{
												
												
											
												JFrame view_voter_list_frame = new JFrame("VOTERS LIST");
												Image icon = Toolkit.getDefaultToolkit().getImage("D:\\javap\\EVM\\login_image.png");  
												view_voter_list_frame.setIconImage(icon);  	
													
												view_voter_list_frame.setSize(1200,300);
												view_voter_list_frame.setVisible(true);
												view_voter_list_frame.setResizable(true);
												try
												{
												
													Class.forName("com.mysql.jdbc.Driver");
													Connection con_view_voter_list = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com" ,"1234567");
													
													ArrayList columnNames = new ArrayList(); // array to hold column names in voters table
													ArrayList data = new ArrayList();		
													
													String sql_view_voter_list = "SELECT * FROM `voters table` ";
													Statement stmt_view_voter_list = con_view_voter_list.createStatement();
													ResultSet rs_view_voter_list = stmt_view_voter_list.executeQuery(sql_view_voter_list);
													
													// getting total number of columns in the voters table
													ResultSetMetaData md_view_voter_list = rs_view_voter_list.getMetaData();
													int columns = md_view_voter_list.getColumnCount();
													
													// getting column name of each column in voters table
													for (int i = 1; i <= columns; i++) 
													{
														columnNames.add(md_view_voter_list.getColumnName(i));
													}
													
													while (rs_view_voter_list.next()) 
													{
														 ArrayList row = new ArrayList(columns);
														 for (int i = 1; i <= columns; i++) 
														 {
															row.add(rs_view_voter_list.getObject(i));
														 }
														  data.add(row);
													}
													
													
													Vector columnNamesVector = new Vector();
													Vector dataVector = new Vector();
													for (int i = 0; i < data.size(); i++) 
													{
													  ArrayList subArray = (ArrayList) data.get(i);
													  Vector subVector = new Vector();
													  for(int j = 0; j < subArray.size(); j++) 
													  {
															subVector.add(subArray.get(j));
													  }
													  dataVector.add(subVector);
													}
													
													
													for (int i = 0; i < columnNames.size(); i++)
													columnNamesVector.add(columnNames.get(i));
													JTable table = new JTable(dataVector, columnNamesVector) 
													{
													  public Class getColumnClass(int column) 
													  {
														for (int row = 0; row < getRowCount(); row++)
															{
															  Object o = getValueAt(row, column);
															  if (o != null) 
															  {
																return o.getClass();
															  }
															}
														return Object.class;
													  }
													};

													JScrollPane scrollPane = new JScrollPane(table);
													view_voter_list_frame.getContentPane().add(scrollPane);
													JPanel buttonPanel = new JPanel();
													view_voter_list_frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
													con_view_voter_list.close();
										
												}
												
												catch(Exception ex)
												{
													JOptionPane.showMessageDialog(view_voter_list_frame,""+ex);
												}
												
												
										}
								});	
								
								// view final results button	
								view_final_results_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
												JFrame result_frame = new JFrame("FINAL RESULTS");
												Image icon = Toolkit.getDefaultToolkit().getImage("D:\\javap\\EVM\\login_image.png");  
												result_frame.setIconImage(icon);  	
													
												result_frame.setSize(800,300);
												result_frame.setVisible(true);
												result_frame.setResizable(true);
												try
												{
												
													Class.forName("com.mysql.jdbc.Driver");
													Connection con_view_result = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com" ,"1234567");
													
													ArrayList columnNames = new ArrayList(); 
													ArrayList data = new ArrayList();		
													
													String sql_view_result = "SELECT `Serial number`,`PARTY NAME` ,`VOTES ATTAINED` FROM `votes data table` ";
													Statement stmt_view_result = con_view_result.createStatement();
													ResultSet rs_view_result = stmt_view_result.executeQuery(sql_view_result);
													
													ResultSetMetaData md_view_result = rs_view_result.getMetaData();
													int columns = md_view_result.getColumnCount();
													
													for (int i = 1; i <= columns; i++) 
													{
														columnNames.add(md_view_result.getColumnName(i));
													}
													
													while (rs_view_result.next()) 
													{
														 ArrayList row = new ArrayList(columns);
														 for (int i = 1; i <= columns; i++) 
														 {
															row.add(rs_view_result.getObject(i));
														 }
														  data.add(row);
													}
													
													
													Vector columnNamesVector = new Vector();
													Vector dataVector = new Vector();
													for (int i = 0; i < data.size(); i++) 
													{
													  ArrayList subArray = (ArrayList) data.get(i);
													  Vector subVector = new Vector();
													  for(int j = 0; j < subArray.size(); j++) 
													  {
															subVector.add(subArray.get(j));
													  }
													  dataVector.add(subVector);
													}
													
													
													for (int i = 0; i < columnNames.size(); i++)
													columnNamesVector.add(columnNames.get(i));
													JTable table = new JTable(dataVector, columnNamesVector) 
													{
													  public Class getColumnClass(int column) 
													  {
														for (int row = 0; row < getRowCount(); row++)
															{
															  Object o = getValueAt(row, column);
															  if (o != null) 
															  {
																return o.getClass();
															  }
															}
														return Object.class;
													  }
													};

													JScrollPane scrollPane = new JScrollPane(table);
													result_frame.getContentPane().add(scrollPane);
													JPanel buttonPanel = new JPanel();
													result_frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
													con_view_result.close();
												}
												
												catch(Exception ex)
												{
													JOptionPane.showMessageDialog(result_frame,""+ex);
												}
									}	
									
								});
								
								// reset votes button	
								reset_votes_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
										try
										{
											int b = JOptionPane.showConfirmDialog(admin_details_frame,"DO YOU REALLY WANT TO RESET VOTES ? ");
											if(b == JOptionPane.YES_OPTION)
											{
												Class.forName("com.mysql.jdbc.Driver");
												Connection con_reset = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com", "1234567");
												PreparedStatement pst_reset = con_reset.prepareStatement("select `VOTES ATTAINED` from `votes data table` ");
												ResultSet rst_reset = pst_reset.executeQuery();
												while(rst_reset.next())
												{
													int vote = 0;
																																					
													Statement st_reset = con_reset.createStatement();
													String sql = "UPDATE `votes data table` SET `Votes Attained`= '"+vote+"' ";
													st_reset.executeUpdate(sql);
																																																
												}
												JOptionPane.showMessageDialog(admin_details_frame, "VOTES RESET SUCCESSFULLY !");
												pst_reset.close();
												con_reset.close();
											}
										}
										
										catch(Exception ex)
										{
											JOptionPane.showMessageDialog(admin_details_frame,""+ex);
										}

									}
									
								});
								
								
								// insert candidate button	
								insert_candidate_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
											JFrame candidate_insert_frame = new JFrame("INSERT A NEW CANDIDATE");
											Image icon = Toolkit.getDefaultToolkit().getImage("D:\\javap\\EVM\\login_image.png");  
											candidate_insert_frame.setIconImage(icon);  	
											candidate_insert_frame.setLayout(null);
											candidate_insert_frame.setSize(500,400);
											candidate_insert_frame.setVisible(true);
											candidate_insert_frame.setResizable(false);
											
											JLabel new_candidate_party_label = new JLabel("PARTY NAME");
											JLabel new_candidate_name_label = new JLabel("PARTY CANDIDATE NAME");
											
											JTextField new_candidate_party_text = new JTextField();
											JTextField new_candidate_name_text = new JTextField();
											
											JButton submit_button = new JButton("SUBMIT");
											
											new_candidate_party_label.setBounds(50,50,200,50);
											new_candidate_name_label.setBounds(50,130,200,50);
											
											new_candidate_party_text.setBounds(280,50,200,50);
											new_candidate_name_text.setBounds(280,130,200,50);
											
											submit_button.setBounds(200,250,100,50);
										
											candidate_insert_frame.add(new_candidate_party_label);
											candidate_insert_frame.add(new_candidate_name_label);
											
											candidate_insert_frame.add(new_candidate_party_text);
											candidate_insert_frame.add(new_candidate_name_text);
											
											candidate_insert_frame.add(submit_button);
										
										
											submit_button.addActionListener(new ActionListener()
											{
												public void actionPerformed(ActionEvent ae)
												{
												
													try
													{
														String candidate_party = new_candidate_party_text.getText();
														String candidate_name = new_candidate_name_text.getText();
										
														int c = JOptionPane.showConfirmDialog(candidate_insert_frame,"Are you sure?");  
														if(c == JOptionPane.YES_OPTION)
														{
															
															candidate_insert_frame.dispose();
															
															Class.forName("com.mysql.jdbc.Driver");
															Connection con_candidate_insert = DriverManager.getConnection("jdbc:mysql://localhost/voting_data","eci_com","1234567");
															
															PreparedStatement serial_stmt = con_candidate_insert.prepareStatement("select `Serial number` from `votes data table` ");
															ResultSet serial_rst = serial_stmt.executeQuery();
															
															serial_rst.last();
															int serialNumber = serial_rst.getInt(1);
															serialNumber += 1;
														
															PreparedStatement insert_pst = con_candidate_insert.prepareStatement("insert voting_data.`votes data table`(`Serial number`,`Party Name`,`Party Candidate Name`,`Votes Attained`) values(?,?,?,?)");
															
															insert_pst.setInt(1,serialNumber);
															insert_pst.setString(2,candidate_party);
															insert_pst.setString(3,candidate_name);
															insert_pst.setInt(4,0);
															
															insert_pst.executeUpdate();
															
															JOptionPane.showMessageDialog(candidate_insert_frame,"NEW CANDIDATE INSERTED SUCCESSFULLY !");
															con_candidate_insert.close();
															 
														}
														
														
													}
													
													catch(Exception ex)
													{
														JOptionPane.showMessageDialog(candidate_insert_frame,""+ex);
													}
												}
											});
										
										
										
									}
									
								});
									
								
								// delete candidate button	
								delete_candidate_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
										try
										{
											Class.forName("com.mysql.jdbc.Driver");
											Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com" ,"1234567");
											
											String candidate_to_delete = JOptionPane.showInputDialog(admin_details_frame,"Enter CANDIDATE NAME");
											
											Statement delete_candidate_stmt = connect.createStatement();
											delete_candidate_stmt.execute("DELETE FROM `votes data table` WHERE  `Party Candidate Name` = '"+candidate_to_delete+"' ");
											
											JOptionPane.showMessageDialog(admin_details_frame,"CANDIDATE SUCCESSFULLY DELETED");
											
											delete_candidate_stmt.close();
											connect.close();
										}
										
										catch(Exception ex)
										{
											JOptionPane.showMessageDialog(admin_details_frame,""+ex);
										}
									}
									
								});
								
								// view candidates list button	
								view_candidates_list_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
										
												JFrame candidate_list_frame = new JFrame("FINAL CANDIDATE LIST");
												Image icon = Toolkit.getDefaultToolkit().getImage("D:\\javap\\EVM\\login_image.png");  
												candidate_list_frame.setIconImage(icon);  	
													
												candidate_list_frame.setSize(800,300);
												candidate_list_frame.setVisible(true);
												candidate_list_frame.setResizable(true);
												try
												{
												
													Class.forName("com.mysql.jdbc.Driver");
													Connection con_view_candidate_list = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com" ,"1234567");
													
													ArrayList columnNames = new ArrayList(); 
													ArrayList data = new ArrayList();		
													
													String sql_view_candidate_list = "SELECT `Serial number`,`PARTY NAME` ,`PARTY CANDIDATE NAME` FROM `votes data table` ";
													Statement stmt_view_candidate_list = con_view_candidate_list.createStatement();
													ResultSet rs_view_candidate_list = stmt_view_candidate_list.executeQuery(sql_view_candidate_list);
													
													ResultSetMetaData md_view_candidate_list = rs_view_candidate_list.getMetaData();
													int columns = md_view_candidate_list.getColumnCount();
													
													for (int i = 1; i <= columns; i++) 
													{
														columnNames.add(md_view_candidate_list.getColumnName(i));
													}
													
													while (rs_view_candidate_list.next()) 
													{
														 ArrayList row = new ArrayList(columns);
														 for (int i = 1; i <= columns; i++) 
														 {
															row.add(rs_view_candidate_list.getObject(i));
														 }
														  data.add(row);
													}
													
													
													Vector columnNamesVector = new Vector();
													Vector dataVector = new Vector();
													for (int i = 0; i < data.size(); i++) 
													{
													  ArrayList subArray = (ArrayList) data.get(i);
													  Vector subVector = new Vector();
													  for(int j = 0; j < subArray.size(); j++) 
													  {
															subVector.add(subArray.get(j));
													  }
													  dataVector.add(subVector);
													}
													
													
													for (int i = 0; i < columnNames.size(); i++)
													columnNamesVector.add(columnNames.get(i));
													JTable table = new JTable(dataVector, columnNamesVector) 
													{
													  public Class getColumnClass(int column) 
													  {
														for (int row = 0; row < getRowCount(); row++)
															{
															  Object o = getValueAt(row, column);
															  if (o != null) 
															  {
																return o.getClass();
															  }
															}
														return Object.class;
													  }
													};

													JScrollPane scrollPane = new JScrollPane(table);
													candidate_list_frame.getContentPane().add(scrollPane);
													JPanel buttonPanel = new JPanel();
													candidate_list_frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
													con_view_candidate_list.close();
												}
												
												catch(Exception ex)
												{
													JOptionPane.showMessageDialog(candidate_list_frame,""+ex);
												}
										
									}
									
								});
								
								// admin login details button	
								admin_login_details_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
												JFrame admin_login_details_frame = new JFrame("ADMIN LOGIN DETAILS LIST LIST");
												Image icon = Toolkit.getDefaultToolkit().getImage("D:\\javap\\EVM\\login_image.png");  
												admin_login_details_frame.setIconImage(icon);  	
													
												admin_login_details_frame.setSize(500,300);
												admin_login_details_frame.setVisible(true);
												admin_login_details_frame.setResizable(true);
												try
												{
												
													Class.forName("com.mysql.jdbc.Driver");
													Connection con_admin_login_details = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com" ,"1234567");
													
													ArrayList columnNames = new ArrayList(); 
													ArrayList data = new ArrayList();		
													
													String sql_admin_login_details = "SELECT * FROM `admin login details` ";
													Statement stmt_admin_login_details = con_admin_login_details.createStatement();
													ResultSet rs_admin_login_details = stmt_admin_login_details.executeQuery(sql_admin_login_details);
													
													ResultSetMetaData md_admin_login_details = rs_admin_login_details.getMetaData();
													int columns = md_admin_login_details.getColumnCount();
													
													// getting column name of each column in voters table
													for (int i = 1; i <= columns; i++) 
													{
														columnNames.add(md_admin_login_details.getColumnName(i));
													}
													
													while (rs_admin_login_details.next()) 
													{
														 ArrayList row = new ArrayList(columns);
														 for (int i = 1; i <= columns; i++) 
														 {
															row.add(rs_admin_login_details.getString(i));   // get date and time in their respective formats .
														 }
														  data.add(row);
													}
													
													
													Vector columnNamesVector = new Vector();
													Vector dataVector = new Vector();
													for (int i = 0; i < data.size(); i++) 
													{
													  ArrayList subArray = (ArrayList) data.get(i);
													  Vector subVector = new Vector();
													  for(int j = 0; j < subArray.size(); j++) 
													  {
															subVector.add(subArray.get(j));
													  }
													  dataVector.add(subVector);
													}
													
													
													for (int i = 0; i < columnNames.size(); i++)
													columnNamesVector.add(columnNames.get(i));
													JTable table = new JTable(dataVector, columnNamesVector) 
													{
													  public Class getColumnClass(int column) 
													  {
														for (int row = 0; row < getRowCount(); row++)
															{
															  Object o = getValueAt(row, column);
															  if (o != null) 
															  {
																return o.getClass();
															  }
															}
														return Object.class;
													  }
													};

													JScrollPane scrollPane = new JScrollPane(table);
													admin_login_details_frame.getContentPane().add(scrollPane);
													JPanel buttonPanel = new JPanel();
													admin_login_details_frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
													con_admin_login_details.close();
										
												}
												
												catch(Exception ex)
												{
													JOptionPane.showMessageDialog(admin_login_details_frame,""+ex);
												}
										
									}
									
								});
								
								// close system button 	
								close_system_button.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent a)
									{
										int y = JOptionPane.showConfirmDialog(admin_details_frame,"ARE YOU SURE YOU WANT TO CLOSE THE SYSTEM ? ");
										if(y == JOptionPane.YES_OPTION)
										{
											System.exit(0);
										}
									}
									
								});
									
							}
							
							else
							{
								JOptionPane.showMessageDialog(admin_details_frame," admin login credentials didnt match !");
							}
						
						
								
					}
				});
				
			}
		});
		
		voter_button.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent ae)
			{
				
				JFrame voter_details_frame = new JFrame();
				voter_details_frame.setLayout(null);
				voter_details_frame.setUndecorated(true);
				Dimension Machine_ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
				voter_details_frame.setSize(Machine_ScreenSize.width , Machine_ScreenSize.height);
				voter_details_frame.setVisible(true);
				voter_details_frame.setResizable(false);
				
				
				JLabel eci_symbol = new JLabel(new ImageIcon("D:\\javap\\EVM\\login_image.png"));
				JLabel ECI_NAME = new JLabel("ELECTION COMISSION OF INDIA");
				ECI_NAME.setFont(new Font("TimesRoman",Font.BOLD,50));
				ECI_NAME.setForeground(Color.BLUE);
				
				JLabel VOTER_ID = new JLabel("VOTER ID");
				JLabel VOTER_DOB = new JLabel("D.O.B.");
				JLabel VOTER_M_No = new JLabel("MOBILE NUMBER");
				JLabel VOTER_NAME = new JLabel("VOTER NAME");
				JLabel note_1_for_user = new JLabel("1. Enter VOTER  NAME in capitals only . ");
				JLabel note_2_for_user = new JLabel("2. Enter the date of birth in yyyy/MM/dd format only. ");
				
				note_1_for_user.setFont(new Font("TimesRoman",Font.PLAIN,20));
				note_1_for_user.setForeground(Color.RED);
				
				note_2_for_user.setFont(new Font("TimesRoman",Font.PLAIN,20));
				note_2_for_user.setForeground(Color.RED);
				
				
				JTextField VOTER_ID_TEXT = new JTextField(); 
				JTextField VOTER_NAME_TEXT = new JTextField(); 
				JTextField VOTER_DOB_TEXT = new JTextField(); 
				JTextField VOTER_M_No_TEXT = new JTextField(); 
				
				JButton CLICK_HERE_TO_VOTE_BUTTON = new JButton("CLICK HERE TO VOTE");
				
				
				eci_symbol.setBounds(10,50,200,200);
				ECI_NAME.setBounds(230,50,1300,200);
				
				VOTER_ID.setBounds(500,300,100,30);
				VOTER_ID_TEXT.setBounds(700,300,100,30);
				VOTER_NAME.setBounds(500,320,100,80);
				VOTER_NAME_TEXT.setBounds(700,350,100,30);
				VOTER_DOB.setBounds(500,400,100,30);
				VOTER_DOB_TEXT.setBounds(700,400,100,30);
				VOTER_M_No.setBounds(500,450,100,30);
				VOTER_M_No_TEXT.setBounds(700,450,100,30);
				CLICK_HERE_TO_VOTE_BUTTON.setBounds(550,550, 200,50);
				note_1_for_user.setBounds(500,600,500,30);
				note_2_for_user.setBounds(500,620,500,30);
				
				voter_details_frame.add(eci_symbol);
				voter_details_frame.add(ECI_NAME);
				voter_details_frame.add(VOTER_ID);
				voter_details_frame.add(VOTER_NAME);
				voter_details_frame.add(VOTER_DOB);
				voter_details_frame.add(VOTER_M_No);
				
				voter_details_frame.add(VOTER_ID_TEXT);
				voter_details_frame.add(VOTER_NAME_TEXT);
				voter_details_frame.add(VOTER_DOB_TEXT);
				voter_details_frame.add(VOTER_M_No_TEXT);
				
				voter_details_frame.add(CLICK_HERE_TO_VOTE_BUTTON);
				voter_details_frame.add(note_1_for_user);
				voter_details_frame.add(note_2_for_user);
				CLICK_HERE_TO_VOTE_BUTTON.addActionListener(new ActionListener()
													{
														public void actionPerformed(ActionEvent a) 
														
														{
															try
															{
																voter_id = VOTER_ID_TEXT.getText();
																String voter_name = VOTER_NAME_TEXT.getText();
																String voter_dob = VOTER_DOB_TEXT.getText();
																String voter_mobile_no = VOTER_M_No_TEXT.getText();
																
																Class.forName("com.mysql.jdbc.Driver");
																Connection con = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com", "1234567");
																PreparedStatement pst = con.prepareStatement("select `VOTER ID`, `VOTER NAME`, `D.O.B.` , `Mobile Number` from `voters table` ");
																ResultSet rst = pst.executeQuery();
																
																while(rst.next())
																{
																	String db_voter_id = rst.getString(1);
																	
																	if( voter_id.equals(db_voter_id))
																	{
																		String db_voter_name = rst.getString(2);
																		Date db_voter_dob = rst.getDate(3);
																		String db_voter_m_no = rst.getString(4);
																		
																		Date voter_dob_date_format = new SimpleDateFormat("yyyy/MM/dd").parse(voter_dob);  
																		if( voter_name.equals(db_voter_name) && (voter_dob_date_format.compareTo(db_voter_dob) == 0) && (voter_mobile_no.equals(db_voter_m_no)))
																		{
																			JOptionPane.showMessageDialog(voter_details_frame, "WELCOME !");
																			Thread.sleep(1000);
																			
																			
																			JFrame voting_frame = new JFrame();
																			voting_frame.setLayout(null);
																			Dimension Machine_ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
																			voting_frame.setSize(Machine_ScreenSize.width , Machine_ScreenSize.height);
																			voting_frame.setUndecorated(true);
																			voter_details_frame.setVisible(false);
																			voting_frame.setVisible(true);
																			voting_frame.setResizable(false);
																			
																			JLabel eci_symbol = new JLabel(new ImageIcon("D:\\javap\\EVM\\login_image.png"));
																			JLabel ECI_NAME = new JLabel("ELECTION COMISSION OF INDIA");
																			ECI_NAME.setFont(new Font("TimesRoman",Font.BOLD,50));
																			ECI_NAME.setForeground(Color.BLUE);
																			
																			eci_symbol.setBounds(10,50,200,200);
																			ECI_NAME.setBounds(230,50,1300,200);
																			voting_frame.add(eci_symbol);
																			voting_frame.add(ECI_NAME);
				
																			JButton submit_button = new JButton("SUBMIT");
																			
																			CheckboxGroup party_candidates = new CheckboxGroup();
																			Checkbox checkbox_party_1 = new Checkbox("B.J.P.",party_candidates,false);
																			Checkbox checkbox_party_2 = new Checkbox("B.S.P.",party_candidates,false);
																			Checkbox checkbox_party_3 = new Checkbox("A.A.P.",party_candidates,false);
																			Checkbox checkbox_party_4 = new Checkbox("Congress",party_candidates,false);
																			Checkbox checkbox_party_5 = new Checkbox("Not Applicable",party_candidates,false);
																			
																			
																			checkbox_party_1.setFont(new Font("TimesRoman",Font.BOLD,20));
																			checkbox_party_2.setFont(new Font("TimesRoman",Font.BOLD,20));
																			checkbox_party_3.setFont(new Font("TimesRoman",Font.BOLD,20));
																			checkbox_party_4.setFont(new Font("TimesRoman",Font.BOLD,20));
																			checkbox_party_5.setFont(new Font("TimesRoman",Font.BOLD,20));
																			
																			
																			checkbox_party_1.setForeground(Color.RED);
																			checkbox_party_2.setForeground(Color.RED);
																			checkbox_party_3.setForeground(Color.RED);
																			checkbox_party_4.setForeground(Color.RED);
																			checkbox_party_5.setForeground(Color.RED);
																			
																			JLabel bjp_logo = new JLabel(new ImageIcon("D:\\javap\\EVM\\bjp_logo.png"));
																			JLabel bsp_logo = new JLabel(new ImageIcon("D:\\javap\\EVM\\bsp_logo.png"));
																			JLabel aap_logo = new JLabel(new ImageIcon("D:\\javap\\EVM\\aap_logo.png"));
																			JLabel congress_logo = new JLabel(new ImageIcon("D:\\javap\\EVM\\congress_logo.jpg"));
																			
																			
																			JLabel bjp_candidate = new JLabel("Narendra Modi");
																			JLabel bsp_candidate = new JLabel("Mulayam Yadav");
																			JLabel aap_candidate = new JLabel("Arvind Kejriwal");
																			JLabel congress_candidate = new JLabel("Rahul Gandhi");
																			
																			
																			bjp_candidate.setFont(new Font("Courier",Font.BOLD,20));
																			bsp_candidate.setFont(new Font("Courier",Font.BOLD,20));
																			aap_candidate.setFont(new Font("Courier",Font.BOLD,20));
																			congress_candidate.setFont(new Font("Courier",Font.BOLD,20));
																			
																			checkbox_party_1.setBounds(50,300,100,50);
																			checkbox_party_2.setBounds(50,500,100,50);
																			
																			checkbox_party_3.setBounds(50,700,100,50);
																			checkbox_party_4.setBounds(800,300,100,50);
																			checkbox_party_5.setBounds(800,450,200,50);
																			
																			bjp_logo.setBounds(200,270,150,150);
																			bsp_logo.setBounds(200,450,150,150);
																			aap_logo.setBounds(200,600,150,150);
																			congress_logo.setBounds(900,280,150,150);
																			
																			bjp_candidate.setBounds(360,300,200,50);
																			bsp_candidate.setBounds(360,500,200,50);
																			aap_candidate.setBounds(360,700,200,50);
																			congress_candidate.setBounds(1060,300,200,50);
																			submit_button.setBounds(1000,650,100,50);
																			
																			voting_frame.add(submit_button);
																			voting_frame.add(bjp_logo);
																			voting_frame.add(bsp_logo);
																			voting_frame.add(aap_logo);
																			voting_frame.add(congress_logo);
																			
																			voting_frame.add(bjp_candidate);
																			voting_frame.add(bsp_candidate);
																			voting_frame.add(aap_candidate);
																			voting_frame.add(congress_candidate);
																			
																			voting_frame.add(checkbox_party_1);
																			voting_frame.add(checkbox_party_2);
																			voting_frame.add(checkbox_party_3);
																			voting_frame.add(checkbox_party_4);
																			voting_frame.add(checkbox_party_5);

																			
																			checkbox_party_1.addItemListener(new ItemListener()
																			{
																				public void itemStateChanged(ItemEvent i)
																				{
																					if(checkbox_party_1.getState() == true)
																						voters_choice = checkbox_party_1.getLabel();
																				}
																			});
																			checkbox_party_2.addItemListener(new ItemListener()
																			{
																				public void itemStateChanged(ItemEvent i)
																				{
																					if(checkbox_party_2.getState() == true)
																						voters_choice = checkbox_party_2.getLabel();
																				}
																			});
																			checkbox_party_3.addItemListener(new ItemListener()
																			{
																				public void itemStateChanged(ItemEvent i)
																				{
																					if(checkbox_party_3.getState() == true)
																						voters_choice = checkbox_party_3.getLabel();
																				}
																			});
																			
																			checkbox_party_4.addItemListener(new ItemListener()
																			{
																				public void itemStateChanged(ItemEvent i)
																				{
																					if(checkbox_party_4.getState() == true)
																						voters_choice = checkbox_party_4.getLabel();
																				}
																			});
																			checkbox_party_5.addItemListener(new ItemListener()
																			{
																				public void itemStateChanged(ItemEvent i)
																				{
																					if(checkbox_party_5.getState() == true)
																						voters_choice = checkbox_party_5.getLabel();
																			}
																			});
																			
																			
																			submit_button.addActionListener(new ActionListener()
																			{
																				public void actionPerformed(ActionEvent sub) 
																				{
																					try
																					{
																						int a = JOptionPane.showConfirmDialog(voting_frame,"Are you sure?");  
																						if(a==JOptionPane.YES_OPTION)
																						{
																							
																							
																							Class.forName("com.mysql.jdbc.Driver");
																							Connection voting_con = DriverManager.getConnection("jdbc:mysql://localhost/voting_data", "eci_com", "1234567");
																							PreparedStatement st_1 = voting_con.prepareStatement("select * from `votes data table` ");
																							ResultSet rst_1 = st_1.executeQuery();
																							while(rst_1.next())
																							{
																								String party_name =  rst_1.getString(2);
																								if(party_name.equals(voters_choice))
																								{
																									int vote = rst_1.getInt(4);
																									vote = vote + 1;
																									
																									
																									
																									Statement st_2 = voting_con.createStatement();
																									String sql = "UPDATE `votes data table` SET `Votes Attained`= '"+vote+"' WHERE `Party Name` = '"+ party_name + "' " ;
																									st_2.executeUpdate(sql);
																									
																									Statement st_3 = voting_con.createStatement();
																									String sql_1 = "UPDATE `voters table` SET `Voted Party` = '"+voters_choice+"' WHERE `VOTER ID`= '"+voter_id+"' " ;
																									st_3.executeUpdate(sql_1);
																								
																									JOptionPane.showMessageDialog(voting_frame, "THANKS FOR VOTING !");
																									voting_frame.dispose();
																									voter_details_frame.dispose();
																								
																								}
																							}
																						}
																					}	
																						catch(SQLException s)
																						{
																							s.printStackTrace();
																						}
																						
																						catch(ClassNotFoundException s)
																						{
																							s.printStackTrace();
																						}
																
																					
																				
																				}
																			}); 
																

																}
																		else
																		{
																			 JOptionPane.showMessageDialog(voter_details_frame, "Invalid Login ! Check Credentials");
																		}
																	}
															
																}
																
															}
															
															catch(InterruptedException ex)
															{
																System.err.println(ex);
															}
															
															catch(ParseException pe)
															{
																System.err.println(pe);
															}
															
															catch(ClassNotFoundException ex)
															{
																System.err.println(ex);
															}
															catch(SQLException ex)
															{
																System.err.println(ex);
																JOptionPane.showMessageDialog(voter_details_frame, ""+ex);
															}
														}
													});
				
			}
		});
		
		panel_main_frame.add(voter_button);
		panel_main_frame.add(label_main_frame);
		panel_main_frame.add(admin_button);
		panel_main_frame.setBackground(Color.YELLOW);
		
		setSize(w,h);
		setSize(Machine_ScreenSize.width , Machine_ScreenSize.height);
	
		
		cardLayoutObj = new CardLayout();
		panelCard = new Panel(cardLayoutObj);
		
		
		panelCard.add(panel_pic1, "PIC1");
		panelCard.add(panel_pic2, "PIC2");
		panelCard.add(panel_pic3, "PIC3");
		panelCard.add(panel_main_frame, "MAIN");
		
		add(panelCard, BorderLayout.CENTER);		
	}
		
	public static void main(String arr[]) 
	{
		VotingProcess VotingFrame_obj = new VotingProcess();
	}
}