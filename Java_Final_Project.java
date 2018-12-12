import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
/*import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;*/
import javax.swing.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Java_Final_Project extends JFrame
                     implements ActionListener,MouseListener{
   private static String labelString = "�Ѿl: ";
   private int num = -1;  // ���Ʋέp
   private JLabel label;
   JPanel cards;
   static JTextField area_1;
   static JTextArea area_2; 
   static JTextField area_3;
   private JButton button_1;
   private JButton button_2;
   private JMenuBar jmenubar_1;
   private JMenuItem gamerestart;
   private JMenuItem gameexit;
   
   int[] guest;
   boolean[] same;
   boolean[] copy_same;
   int check = -1;
   int answer;
   int a = 0;
   int b = 0;
   public Java_Final_Project() {   // �غc�l
      super("Java_Final_Project");  // �������D��r
	  super.setResizable(false);
      Container window = getContentPane(); // ���oContentPane
	  /*��l����*/
	  
	  guest = new int[4];
	  same = new boolean[10];
	  copy_same = new boolean[10];
	  for(int i = 0; i < 10; i++)
		  same[i] = false;
	  Random ran = new Random();
	  for(int i = 0; i < 4; i++)
	  {
		  guest[i] = ran.nextInt(10);
		  while(same[guest[i]])
		  {
			  guest[i] = ran.nextInt(10);
		  }  
		  same[guest[i]] = true;
	  }
	  	 	  	  	  		 
	  button_1 = new JButton("�T�w");
      button_1.addActionListener(this);
      cards = new JPanel();	  	  	  
      cards.setLayout(new CardLayout());
	  /*��ܦ��ƻP�T�{���s*/
	  
	  jmenubar_1=new JMenuBar();
	  JMenu game=new JMenu("�C��(G)");
	  game.setMnemonic(KeyEvent.VK_G);
	  gamerestart = new JMenuItem();
	  gameexit = new JMenuItem();
	  gamerestart.setText("���s�}�l");
	  gamerestart.addActionListener(this);
	  gameexit.setText("�����C��");
	  gameexit.addActionListener(this);
	  game.add(gamerestart);
	  game.add(gameexit);
	  jmenubar_1.add(game);
	  setJMenuBar(jmenubar_1);
	  
	  JLabel labelname= new JLabel("                                                                                        �q�Ʀr");//�]�w�W�r
	  JTextArea area=
	  new JTextArea("�C���W�h:\n��J4�Ӭ۲����Ʀr�ë��U�T�w(K)\n�b�k��|�X�{�A�ҿ�J���Ʀr�δXA�XB\nA�N��Ʀr�O���T����m�]�O���T��\nB�N��Ʀr�O���T������m�����T\n�Y�b5��������h�C���L��\n�Ϥ��h����\nGood Luck\n",15,30);
	  area.setEditable(false);
      label = new JLabel(labelString + num); 
	  label.setBorder(   // �]�w�ؽu
      BorderFactory.createLineBorder(Color.red));
      button_2 = new JButton("�T�{(K)");
      button_2.setMnemonic(KeyEvent.VK_K);// �]�w����Alt_K
      button_2.addActionListener(this);   // ���U�ƥ�B�z
      JPanel jpanel_1 = new JPanel();  // �إ�JPanel����
	  jpanel_1.setLayout(new BorderLayout());
      JPanel jpanel_2 = new JPanel();  // �إ�JPanel����
	  jpanel_2.setLayout(new BorderLayout());
      JPanel jpanel_3 = new JPanel();  // �إ�JPanel����
	  jpanel_3.setLayout(new BorderLayout());
	  /*��J�ϰ�*/  
	  area_1 = new
            JTextField("�п�J�Q�q���ƦrXD\n");
	  area_1.setBorder(   // �]�w�ؽu
      	    BorderFactory.createLineBorder(Color.yellow));
	  area_1.setPreferredSize( new Dimension( 298, 24 ) );
      area_1.addMouseListener(this); // ���U�ƥ�B�z
	  /*��J�L���ϰ�*/
	  area_2 = new JTextArea("�o�O�z����J�L���Ʀr\n"/* + guest[0] + guest[1] +guest[2] +guest[3]*/,5,26);
	  area_2.setBorder(   // �]�w�ؽu
      	    BorderFactory.createLineBorder(Color.blue));
	  area_2.setEditable(false);      
	  area_3 = new JTextField(10);
	  area_3.setBorder(   // �]�w�ؽu
      	    BorderFactory.createLineBorder(Color.black));
	  area_3.setText("");
	  area_3.setHorizontalAlignment(JTextField.CENTER);
	  area_3.setEditable(false);    
	  jpanel_1.add(button_1, BorderLayout.SOUTH);
	  jpanel_1.add(labelname,BorderLayout.NORTH);
	  jpanel_1.add(area,BorderLayout.CENTER);
	  jpanel_2.add(area_1,BorderLayout.WEST);
	  jpanel_2.add(area_2,BorderLayout.EAST);
      jpanel_3.add(label,BorderLayout.WEST);  // �s�W�����JPanel
      jpanel_3.add(button_2,BorderLayout.EAST);
	  jpanel_2.add(jpanel_3,BorderLayout.SOUTH);
	  jpanel_3.add(area_3,BorderLayout.CENTER);
      cards.add(jpanel_1, "�}�l����");
      cards.add(jpanel_2, "�C������");
      window.add(cards, BorderLayout.CENTER);
	  
   }
   
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
	   CardLayout c_1 = (CardLayout)(cards.getLayout());
	   
		if(evt.getSource()==gamerestart){
			guest = new int[4];
			same = new boolean[10];
			copy_same = new boolean[10];
			for(int i = 0; i < 10; i++)
				same[i] = false;
			Random ran = new Random();
			for(int i = 0; i < 4; i++)
			{
				guest[i] = ran.nextInt(10);
				while(same[guest[i]])
				{
					guest[i] = ran.nextInt(10);
				}  
				same[guest[i]] = true;
			}
			c_1.first(cards);
			num=5;
			 area_1.setEditable(true);
			 area_2.setText("�o�O�z����J�L���Ʀr\n");
			 area_3.setText("");
			 area_1.setText("�п�J�Q�q���ƦrXD\n");
			 check = -1;
		}
		if(evt.getSource()==gameexit){
			super.dispose();
		}
		
		if(evt.getSource()==button_1){
			c_1.next(cards);
			num = 5;
			label.setText(labelString+num); // ���]��r���e        //+"�����|"  �u���Ĥ@���� �ҥH�Τ@�����@!(��)
		}
		
		if(evt.getSource()==button_2){
			if ( num == -1 ) { 
				
			}
			else{
				if(num != 0){
					answer = Integer.parseInt(area_1.getText());
					/////////
					String str = area_1.getText();
					if(str.length() == 4){
						for(int i = 0; i < 10; i++)
						  copy_same[i] = same[i];
						int count = 0;
						if(!((answer/1000) == guest[0] && (answer/100%10) == guest[1] && (answer/10%10) == guest[2] && (answer%10) == guest[3]))
						{
							a = 0;
							b = 0;
							if((answer/1000) == guest[0]){
								copy_same[answer/1000] = false;
								a++;
							}
							else{
								if(copy_same[answer/1000]){
									copy_same[answer/1000] = false;
									b++;
								}
							}
							if((answer/100%10) == guest[1]){
								copy_same[answer/100%10] = false;
								a++;
							}
							else{
								if(copy_same[answer/100%10]){
									copy_same[answer/100%10] = false;
									b++;
								}
							}
							if((answer/10%10) == guest[2]){
								copy_same[answer/10%10] = false;
								a++;
							}
							else{
								if(copy_same[answer/10%10]){
									copy_same[answer/10%10] = false;
									b++;
								}
							}
							if((answer%10) == guest[3]){
								copy_same[answer%10] = false;
								a++;
							}
							else{
								if(copy_same[answer%10]){
									copy_same[answer%10] = false;
									b++;
								}
							}
							check = 0;
						}
						else{
							a = 4;
							b = 0;
							check = 1;
						}
						num--; // ���s���ƥ[�@
						if(check == 1){
						  area_3.setText("Bingo !!! \\^o^/");
						  num=0;
						  area_1.setEditable(false);
						  area_2.append("�z���Ʀr: " + answer +"\n");
						  area_2.append("A: "+ a +"   " + "B: " + b + "\n");
						}
						else if(num == 0 && check == 0){
							label.setText(labelString+num);
							area_3.setText("Fail !!! ��(������)�~");
							area_1.setText("The answer is : "+guest[0]+guest[1]+guest[2]+guest[3]);
							area_1.setEditable(false); 
						}
						else if(check == 0){
							area_3.setText("error !!! (��(��)��)");
							label.setText(labelString+num); // ���]��r���e
							if((answer/1000%10) == 0)		//�p�G�Ʀr�Ĥ@��O0�����
							{
								area_2.append("�z���Ʀr: 0"+ answer + "\n");
							}
							else
							{
								area_2.append("�z���Ʀr: " + answer +"\n");
							}
							area_2.append("A: "+ a +"   " + "B: " + b + "\n");
							area_1.setText("");
						}
					}
					else{
						area_3.setText("enter error !!! �ס@����");
					}
				}
			}
		}
   }
   public void mousePressed(MouseEvent evt) {
		if(num != 0 && check == 0 || check == -1){
			area_1.setText("");
		}
   }
   public void mouseEntered(MouseEvent evt) {}
   public void mouseExited(MouseEvent evt) {}
   public void mouseClicked(MouseEvent evt) {}
   public void mouseReleased(MouseEvent evt) {}
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��������
      Java_Final_Project GUESS_A_B = new Java_Final_Project();
      GUESS_A_B.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      GUESS_A_B.setSize(593,350);  // �]�w�����ؤo
      GUESS_A_B.setVisible(true);  // ��ܵ���
   }
}