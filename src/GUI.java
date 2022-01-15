import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textmsp;
	private JTextField texttensp;
	private JTextField textdongia;
	private JTextField textngayban;
	private JTextField textdtr;
	private JTextField texthangsx;
	private JTextField textuudai;
	private JTable table;
	private JTextField textsoluong;
	JComboBox cmBox = new JComboBox();
	JLabel Soluong = new JLabel("");

	Vector vTitle = new Vector();
	Vector vContent = new Vector();
	Vector vRow;
	int count =0;
	
	DefaultTableModel dtable = new DefaultTableModel();
	
	
	void title() {
		vTitle.add("Mã sp");
		vTitle.add("Tên sp");
		vTitle.add("Số lượng");
		vTitle.add("Đơn giá");
		vTitle.add("Ưu đãi");
		vTitle.add("Ngày bán");
		vTitle.add("Hãng sx");
		vTitle.add("Đặc tính riêng");
		vTitle.add("MẶT HÀNG");
		vTitle.add("VAT");
		vTitle.add("Thành tiền");
	}
	
	void input (MATHANG mh) {
		vRow = new Vector();
		vRow.add(mh.getItem_code());
		vRow.add(mh.getItem_name());
		vRow.add(mh.getAmount());
		vRow.add(mh.getUnit_price());
		vRow.add(mh.getDiscount());
		vRow.add(mh.getDate_sale());
		vRow.add(mh.getManufacturer());
		vRow.add(mh.getOwncharacteristics());
		if(cmBox.getSelectedIndex()==0) {
			vRow.add("Điện máy");
			vRow.add("10%");//VAT
		}
		if(cmBox.getSelectedIndex()==1) {
			vRow.add("Gia dụng");
			vRow.add("5%");//VAT
		}
		vRow.add(mh.Cal());
		vContent.add(vRow);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		title();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textmsp = new JTextField();
		textmsp.setBounds(138, 63, 166, 24);
		contentPane.add(textmsp);
		textmsp.setColumns(10);
		
		
		cmBox.setModel(new DefaultComboBoxModel(new String[] {"\u0110i\u1EC7n m\u00E1y", "Gia d\u1EE5ng"}));
		cmBox.setBounds(98, 21, 101, 24);
		contentPane.add(cmBox);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EB6T H\u00C0NG");
		lblNewLabel_1.setBounds(25, 22, 63, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u00E3 sp");
		lblNewLabel_1_1.setBounds(64, 63, 63, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("T\u00EAn sp");
		lblNewLabel_1_1_1.setBounds(64, 96, 63, 22);
		contentPane.add(lblNewLabel_1_1_1);
		
		texttensp = new JTextField();
		texttensp.setColumns(10);
		texttensp.setBounds(138, 96, 166, 24);
		contentPane.add(texttensp);
		
		textdongia = new JTextField();
		textdongia.setColumns(10);
		textdongia.setBounds(138, 129, 166, 24);
		contentPane.add(textdongia);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_1_1_2.setBounds(64, 129, 63, 22);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ng\u00E0y b\u00E1n");
		lblNewLabel_1_1_1_1.setBounds(64, 162, 63, 22);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textngayban = new JTextField();
		textngayban.setColumns(10);
		textngayban.setBounds(138, 162, 166, 24);
		contentPane.add(textngayban);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("\u01AFu \u0111\u00E3i");
		lblNewLabel_1_1_3.setBounds(416, 63, 63, 22);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("H\u00E3ng sx");
		lblNewLabel_1_1_1_2.setBounds(416, 96, 63, 22);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Đặc tính");
		lblNewLabel_1_1_2_1.setBounds(416, 162, 101, 22);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		textdtr = new JTextField();
		textdtr.setColumns(10);
		textdtr.setBounds(491, 163, 166, 24);
		contentPane.add(textdtr);
		
		texthangsx = new JTextField();
		texthangsx.setColumns(10);
		texthangsx.setBounds(490, 96, 166, 24);
		contentPane.add(texthangsx);
		
		textuudai = new JTextField();
		textuudai.setColumns(10);
		textuudai.setBounds(490, 63, 166, 24);
		contentPane.add(textuudai);
		
		JButton btnadd = new JButton("Th\u00EAm");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MATHANG s = null;
					String msp = textmsp.getText();
					String tsp = texttensp.getText();
					float dg = Float.parseFloat(textdongia.getText());
					String db = textngayban.getText();
					float ud = Float.parseFloat(textuudai.getText());
					String hsx = texthangsx.getText();
					float sl = Float.parseFloat(textsoluong.getText());
					String ttr = textdtr.getText();
					
					if(cmBox.getSelectedIndex()==0) {
						s = new DIENMAY(msp,tsp,sl,dg,ud, db, hsx, ttr);
					}
					if(cmBox.getSelectedIndex()==1) {
						s = new GIADUNG(msp,tsp,sl,dg,ud, db, hsx, ttr);
					}
					input(s);
					textmsp.setText("");
					texttensp.setText("");
					textdongia.setText("");
					textngayban.setText("");
					textuudai.setText("");
					texthangsx.setText("");
					textsoluong.setText("");
					textdtr.setText("");
					dtable.setDataVector(vContent, vTitle);
					table.setModel(dtable);
					count +=1;
					String co = String.valueOf(count);
					Soluong.setText(""+co);
					
					
			}
		});
		btnadd.setBounds(94, 197, 89, 23);
		contentPane.add(btnadd);
		
		JButton btndel = new JButton("Xóa");
		btndel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					dtable.removeRow(i);
					count -=1;
					String co = String.valueOf(count);
					Soluong.setText(""+co);
				}
				else
					System.out.println("Delete error!");
			}
		});
		btndel.setBounds(215, 197, 89, 23);
		contentPane.add(btndel);
		
		JButton btnexit = new JButton("Thoát");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnexit.setBounds(461, 197, 89, 23);
		contentPane.add(btnexit);
		
		JButton btnres = new JButton("Đặt lại");
		btnres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textmsp.setText("");
				texttensp.setText("");
				textdongia.setText("");
				textngayban.setText("");
				textuudai.setText("");
				texthangsx.setText("");
				textsoluong.setText("");
				textdtr.setText("");
			}
		});
		btnres.setBounds(337, 197, 89, 23);
		contentPane.add(btnres);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 231, 719, 132);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {
			},
			new String[] {
				//"M\u00E3 sp", "T\u00EAn sp", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "\u01AFu \u0111\u00E3i", "Ng\u00E0y b\u00E1n", "H\u00E3ng sx", "Thu\u1ED9c t\u00EDnh", "VAT", "Th\u00E0nh ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Số lượng");
		lblNewLabel_1_1_4.setBounds(416, 129, 63, 22);
		contentPane.add(lblNewLabel_1_1_4);
		
		textsoluong = new JTextField();
		textsoluong.setColumns(10);
		textsoluong.setBounds(490, 129, 166, 24);
		contentPane.add(textsoluong);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				textmsp.setText(dtable.getValueAt(i, 0).toString());
				texttensp.setText(dtable.getValueAt(i, 1).toString());
				textsoluong.setText(dtable.getValueAt(i, 2).toString());
				textdongia.setText(dtable.getValueAt(i, 3).toString());
				textuudai.setText(dtable.getValueAt(i, 4).toString());
				textngayban.setText(dtable.getValueAt(i, 5).toString());
				texthangsx.setText(dtable.getValueAt(i, 6).toString());
				textdtr.setText(dtable.getValueAt(i, 7).toString());
			}
		});
		
		JButton btnedit = new JButton("Cập nhật");
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					dtable.setValueAt(texttensp.getText(), i, 1);
					dtable.setValueAt(textmsp.getText(), i, 0);
					dtable.setValueAt(textsoluong.getText(), i, 2);
					dtable.setValueAt(textdongia.getText(), i, 3);
					dtable.setValueAt(textuudai.getText(), i, 4);
					dtable.setValueAt(textngayban.getText(), i, 5);
					dtable.setValueAt(texthangsx.getText(), i, 6);
					dtable.setValueAt(textdtr.getText(), i, 7);
					int d = cmBox.getSelectedIndex();
					String c=null;
					if (d == 0)
						c="Điện máy   ";
					else if (d == 1)
						c="Gia dụng   ";			
					dtable.setValueAt(c, i, 8);
					if (cmBox.getSelectedIndex()==0) {
						float r =(((Float.parseFloat(textsoluong.getText())*Float.parseFloat(textdongia.getText())) * 0.1f) * ((100-Float.parseFloat(textuudai.getText()))/100)); 
						dtable.setValueAt(r, i, 10);
					}
					else if(cmBox.getSelectedIndex()==1) {
						float r =( (( Float.parseFloat(textsoluong.getText())*Float.parseFloat(textdongia.getText()) ) * 0.05f)* ((100-Float.parseFloat(textuudai.getText()))/100) );
						dtable.setValueAt(r, i, 10);
					}																									
					
					
				}
				else
					System.out.println("Update error!");
					
			}
		});
		btnedit.setBounds(587, 197, 89, 23);
		contentPane.add(btnedit);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Số lượng");
		lblNewLabel_1_1_5.setBounds(416, 374, 63, 22);
		contentPane.add(lblNewLabel_1_1_5);
		
		
		Soluong.setBounds(502, 374, 63, 22);
		contentPane.add(Soluong);
		
		JButton btExport = new JButton("Xuất file.txt");
		btExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("C:\\Users\\Trung\\Desktop\\2.txt");
				if(!f.exists()) {
					try {
						f.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
				}
				try {
					FileWriter fw = new FileWriter(f);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for (int i=0;i<table.getRowCount();i++) {
						for(int j=0; j<table.getColumnCount();j++) {
							bw.write(table.getValueAt(i, j).toString()+"   ");
						}
						bw.newLine();
					}
					bw.close();
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btExport.setBounds(587, 374, 89, 23);
		contentPane.add(btExport);
	}
}
