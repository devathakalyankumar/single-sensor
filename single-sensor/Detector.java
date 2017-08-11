import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.lang.*;
public class Detector extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JPanel contentPane;
	ServerSocket server_1;
	DataOutputStream dis1;
	DataOutputStream dis2;
	DataInputStream dis;
	Socket socket_1;
	Socket client_1;
	Socket client_2;
	long temp;
	int i=1;
	int length;
	
	// End of variables declaration


	public Detector()
	{
		super();
		initializeComponent();
		this.setVisible(true);
		try
		{
			server_1=new ServerSocket(111);
			
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
	}

		private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jButton1 = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setText("INTRUSION DETECTOR");
		//
		// jTextArea1
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTextArea1);
		//
		// jButton1
		//
		jButton1.setBackground(new Color(255, 255, 255));
		jButton1.setText("Exit");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
                      
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(153, 204, 255));
		addComponent(contentPane, jLabel1, 172,9,133,38);
		addComponent(contentPane, jScrollPane1, 26,37,441,341);
		addComponent(contentPane, jButton1, 204,390,83,28);
		//
		// Detector
		//
		this.setTitle("Detector - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(505, 462));
	}

		private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

		private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

		
public void server()
	{
		
						try
						{
							
						String rr="";
						socket_1=server_1.accept();	
						dis=new DataInputStream(socket_1.getInputStream());
						int length=dis.readInt();
						String destination=dis.readUTF();
						if(destination.equalsIgnoreCase("R-101"))
							{
								jTextArea1.append("\t**********************************\n");
								jTextArea1.append("\tTHIS IS FROM PORT I_101\n");
								jTextArea1.append("\t**********************************\n");
								client_1=new Socket("localhost",101);
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeInt(length);
						while(length>0)
							{
								
								rr=dis.readUTF();
								jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeUTF(rr);
								length--;
								i++;
							}
								
							}
						else if (destination.equalsIgnoreCase("R-102"))
						{
								jTextArea1.append("\t**********************************\n");
								jTextArea1.append("\tTHIS IS FROM PORT R_102\n");
								jTextArea1.append("\t**********************************\n");
								client_1=new Socket("localhost",102);
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeInt(length);
								
						while(length>0)
							{
									
								rr=dis.readUTF();
								jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeUTF(rr);
								length--;
								i++;
							}


								
						}
						else if (destination.equalsIgnoreCase("R-103"))
						{
								jTextArea1.append("\t**********************************\n");
								jTextArea1.append("\tTHIS IS FROM PORT R_103\n");
								jTextArea1.append("\t**********************************\n");
								client_1=new Socket("localhost",103);
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeInt(length);
								
						while(length>0)
							{
									
								rr=dis.readUTF();
								jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
								dis1=new DataOutputStream(client_1.getOutputStream());
								dis1.writeUTF(rr);
								length--;
								i++;
							}


								
						}
						else if (destination.equalsIgnoreCase("I-104"))
						{
								jTextArea1.append("\t**********************************\n");
								jTextArea1.append("\tTHIS IS FROM PORT I_104\n");
								jTextArea1.append("\t**********************************\n");
								while(length>0)
									{
									
									rr=dis.readUTF();
									StringBuffer sb=new StringBuffer(rr);
									sb.delete(7,10);
									jTextArea1.append("\t\tPacket "+i+"\t"+rr.substring(4,15)+" Recieved...\n");
									length--;
									i++;
								
									}
									JOptionPane.showMessageDialog(null,"This Is From Intruder Port");
									JOptionPane.showMessageDialog(null,"The Intruder Has Been Detected");
										
						}

						
						
						}
						catch (Exception exp)
						{
							exp.printStackTrace();
						}
						
					
					
	
	}

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		Detector r1=new Detector();
		while (true)
		{
			r1.server();
		}
	}
//= End of Testing =


}
