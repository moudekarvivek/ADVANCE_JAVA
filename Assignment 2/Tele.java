import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class TeleGUI extends JFrame implements ActionListener
{
    JLabel TeleNo,Name,Address,Head;
    JTextField no,name,address;
    JMenu menu;
    JMenuItem insert,search,delete,display,exit;
    Connection con = null;
    JPanel p1,p2,p3,p4;

    TeleGUI()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.28.3/syca221574","syca221574","");
				    	
        	JMenuBar mb = new JMenuBar();
	    	menu = new JMenu("Operations");
	    	menu.setFont(new Font("Ariel", Font.ITALIC, 15));
	    
			insert = new JMenuItem("Insert");
			search = new JMenuItem("Search");
			delete = new JMenuItem("Delete");
			display = new JMenuItem("Display");
			exit = new JMenuItem("Exit");
			
			menu.add(insert);
			menu.add(search);
			menu.add(delete);
			menu.add(display);
			menu.add(exit);
			mb.add(menu);
			
			setLayout(new GridLayout(4,0,50,10));
        	p1 = new JPanel();
            Head = new JLabel("Telephone Directory", JLabel.CENTER);
            Head.setFont(new Font("", Font.BOLD, 18));
            p1.add(Head);
            
            p2 = new JPanel();
            p2.setLayout(new GridLayout(1,2,50,15));            
            TeleNo = new JLabel("Telephone No.", JLabel.CENTER);
            no = new JTextField();
            p2.add(TeleNo);
            p2.add(no);
            
            p3 = new JPanel();
            p3.setLayout(new GridLayout(1,2,50,15));
            Name = new JLabel("Name", JLabel.CENTER);
            name = new JTextField();
			p3.add(Name);
            p3.add(name);

			p4 = new JPanel();
			p4.setLayout(new GridLayout(1,2,50,15));
            Address = new JLabel("Address", JLabel.CENTER);
            address = new JTextField();
			p4.add(Address);
            p4.add(address);

            insert.addActionListener(this);
            search.addActionListener(this);
            delete.addActionListener(this);
            display.addActionListener(this);
            exit.addActionListener(this);
			
			setJMenuBar(mb);
            add(p1);
            add(p2);
            add(p3);
            add(p4);		
			setSize(450, 250);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		    setVisible(true);
            JOptionPane.showMessageDialog(null,"Connected to Database","Success",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
    }

    public void actionPerformed(ActionEvent Ae)
	{
		if(Ae.getSource() == exit)
		{
            try 
            {
                con.close();
                JOptionPane.showMessageDialog(null,"Disconnected From DB","Message",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }

		}
		else if(Ae.getSource() == insert)
		{   
            try 
            {
             	long noParam;
				if((no.getText()).length() == 10 && Long.parseLong(no.getText()) > 0 && !name.getText().isEmpty() && !address.getText().isEmpty())
				{
					noParam = Long.parseLong(no.getText());
					String nameParam = name.getText();
        			String addressParam = address.getText();
    
                	String insQury = "insert into tele values(?,?,?)" ;
                
                	PreparedStatement stmt = con.prepareStatement(insQury);
                	stmt.setLong(1,noParam);
                	stmt.setString(2,nameParam);
                	stmt.setString(3,addressParam);

                	int res = stmt.executeUpdate();
                	JOptionPane.showMessageDialog(null,res+" Rows Added","Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter Valid Data","Warning",JOptionPane.WARNING_MESSAGE);
					no.setText("");
					name.setText("");
					address.setText("");
				}
        	
            }
            catch(SQLIntegrityConstraintViolationException dup)
            {
                JOptionPane.showMessageDialog(null,"Number already exists","Warning",JOptionPane.WARNING_MESSAGE);
            }
            catch (Exception e) 
            {
                System.out.println(e);
            }
            finally
            {
            	no.setText("");
            	name.setText("");
            	address.setText("");
            }
		}
        else if(Ae.getSource() == delete)
        {
            try 
            {
                long noParam = Long.parseLong(no.getText());
    
                String deleteQury = "delete from tele where teleno=?" ;
                PreparedStatement stmt = con.prepareStatement(deleteQury); 
                stmt.setLong(1,noParam);

                int res = stmt.executeUpdate();
                if(res == 0)
                {
                    JOptionPane.showMessageDialog(null,"No Records Found","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,res+" Rows Deleted","Success",JOptionPane.INFORMATION_MESSAGE);
					no.setText("");
					name.setText("");
					address.setText("");
                }
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
        else if(Ae.getSource() == search)
        {
            try 
            {
                long noParam = Long.parseLong(no.getText());
                String nameParam = name.getText();
                String addressParam = address.getText();
                
                String searchQury = "select * from tele where teleno=?";
                PreparedStatement stmt = con.prepareStatement(searchQury);
                
                stmt.setLong(1, noParam);

                ResultSet rs = stmt.executeQuery();
                if (rs.next() == false)
                {
                    JOptionPane.showMessageDialog(null,"No Records Found","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    do
                    {
                        no.setText(String.valueOf(rs.getLong(1)));
                        name.setText(rs.getString(2));
                        address.setText(rs.getString(3));
                    }while(rs.next());
                }
            }
            catch(NumberFormatException NFE)
            {
                JOptionPane.showMessageDialog(null,"Please Enter Phone number","Error",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
        else
        {
            try 
            {   
                JFrame frame2 = new JFrame("Database Results");
                frame2.setLayout(new FlowLayout());
                frame2.setSize(400, 250);
         
                DefaultTableModel dtm = new DefaultTableModel();
                JTable table = new JTable(dtm);
                table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                table.setFillsViewportHeight(true);
                frame2.add(new JScrollPane(table));
                dtm.addColumn("Telephone No.");
                dtm.addColumn("Name");
                dtm.addColumn("Address");
                
            
                String displayQury = "select * from tele" ;
                PreparedStatement stmt = con.prepareStatement(displayQury); 

                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
                    dtm.addRow(new Object[]{rs.getLong("teleno"), rs.getString("name"), rs.getString("address")});
                }
                frame2.setVisible(true);
                frame2.validate(); 
                table.setEnabled(false); 
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
	}
}

public class Tele 
{
    public static void main(String[] args)
    {
        new TeleGUI();
    }
}   
