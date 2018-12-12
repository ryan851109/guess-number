import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
/*import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;*/
import javax.swing.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Java_Final_Project extends JFrame
                     implements ActionListener,MouseListener{
   private static String labelString = "剩餘: ";
   private int num = -1;  // 次數統計
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
   public Java_Final_Project() {   // 建構子
      super("Java_Final_Project");  // 視窗標題文字
	  super.setResizable(false);
      Container window = getContentPane(); // 取得ContentPane
	  /*初始頁面*/
	  
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
	  	 	  	  	  		 
	  button_1 = new JButton("確定");
      button_1.addActionListener(this);
      cards = new JPanel();	  	  	  
      cards.setLayout(new CardLayout());
	  /*顯示次數與確認按鈕*/
	  
	  jmenubar_1=new JMenuBar();
	  JMenu game=new JMenu("遊戲(G)");
	  game.setMnemonic(KeyEvent.VK_G);
	  gamerestart = new JMenuItem();
	  gameexit = new JMenuItem();
	  gamerestart.setText("重新開始");
	  gamerestart.addActionListener(this);
	  gameexit.setText("結束遊戲");
	  gameexit.addActionListener(this);
	  game.add(gamerestart);
	  game.add(gameexit);
	  jmenubar_1.add(game);
	  setJMenuBar(jmenubar_1);
	  
	  JLabel labelname= new JLabel("                                                                                        猜數字");//設定名字
	  JTextArea area=
	  new JTextArea("遊戲規則:\n輸入4個相異的數字並按下確定(K)\n在右邊會出現你所輸入的數字及幾A幾B\nA代表數字是正確的位置也是正確的\nB代表數字是正確的但位置不正確\n若在5次內答對則遊戲過關\n反之則失敗\nGood Luck\n",15,30);
	  area.setEditable(false);
      label = new JLabel(labelString + num); 
	  label.setBorder(   // 設定框線
      BorderFactory.createLineBorder(Color.red));
      button_2 = new JButton("確認(K)");
      button_2.setMnemonic(KeyEvent.VK_K);// 設定按鍵Alt_K
      button_2.addActionListener(this);   // 註冊事件處理
      JPanel jpanel_1 = new JPanel();  // 建立JPanel物件
	  jpanel_1.setLayout(new BorderLayout());
      JPanel jpanel_2 = new JPanel();  // 建立JPanel物件
	  jpanel_2.setLayout(new BorderLayout());
      JPanel jpanel_3 = new JPanel();  // 建立JPanel物件
	  jpanel_3.setLayout(new BorderLayout());
	  /*輸入區域*/  
	  area_1 = new
            JTextField("請輸入想猜的數字XD\n");
	  area_1.setBorder(   // 設定框線
      	    BorderFactory.createLineBorder(Color.yellow));
	  area_1.setPreferredSize( new Dimension( 298, 24 ) );
      area_1.addMouseListener(this); // 註冊事件處理
	  /*輸入過的區域*/
	  area_2 = new JTextArea("這是您曾輸入過的數字\n"/* + guest[0] + guest[1] +guest[2] +guest[3]*/,5,26);
	  area_2.setBorder(   // 設定框線
      	    BorderFactory.createLineBorder(Color.blue));
	  area_2.setEditable(false);      
	  area_3 = new JTextField(10);
	  area_3.setBorder(   // 設定框線
      	    BorderFactory.createLineBorder(Color.black));
	  area_3.setText("");
	  area_3.setHorizontalAlignment(JTextField.CENTER);
	  area_3.setEditable(false);    
	  jpanel_1.add(button_1, BorderLayout.SOUTH);
	  jpanel_1.add(labelname,BorderLayout.NORTH);
	  jpanel_1.add(area,BorderLayout.CENTER);
	  jpanel_2.add(area_1,BorderLayout.WEST);
	  jpanel_2.add(area_2,BorderLayout.EAST);
      jpanel_3.add(label,BorderLayout.WEST);  // 新增元件到JPanel
      jpanel_3.add(button_2,BorderLayout.EAST);
	  jpanel_2.add(jpanel_3,BorderLayout.SOUTH);
	  jpanel_3.add(area_3,BorderLayout.CENTER);
      cards.add(jpanel_1, "開始介面");
      cards.add(jpanel_2, "遊戲介面");
      window.add(cards, BorderLayout.CENTER);
	  
   }
   
   // 實作事件處理方法
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
			 area_2.setText("這是您曾輸入過的數字\n");
			 area_3.setText("");
			 area_1.setText("請輸入想猜的數字XD\n");
			 check = -1;
		}
		if(evt.getSource()==gameexit){
			super.dispose();
		}
		
		if(evt.getSource()==button_1){
			c_1.next(cards);
			num = 5;
			label.setText(labelString+num); // 重設文字內容        //+"次機會"  只有第一次有 所以統一拿掉哦!(允)
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
						num--; // 按鈕次數加一
						if(check == 1){
						  area_3.setText("Bingo !!! \\^o^/");
						  num=0;
						  area_1.setEditable(false);
						  area_2.append("您的數字: " + answer +"\n");
						  area_2.append("A: "+ a +"   " + "B: " + b + "\n");
						}
						else if(num == 0 && check == 0){
							label.setText(labelString+num);
							area_3.setText("Fail !!! ╮(╯◇╰)╭");
							area_1.setText("The answer is : "+guest[0]+guest[1]+guest[2]+guest[3]);
							area_1.setEditable(false); 
						}
						else if(check == 0){
							area_3.setText("error !!! (⊙(∞)⊙)");
							label.setText(labelString+num); // 重設文字內容
							if((answer/1000%10) == 0)		//如果數字第一位是0的顯示
							{
								area_2.append("您的數字: 0"+ answer + "\n");
							}
							else
							{
								area_2.append("您的數字: " + answer +"\n");
							}
							area_2.append("A: "+ a +"   " + "B: " + b + "\n");
							area_1.setText("");
						}
					}
					else{
						area_3.setText("enter error !!! ＝　＝╬");
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
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式的物件
      Java_Final_Project GUESS_A_B = new Java_Final_Project();
      GUESS_A_B.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      GUESS_A_B.setSize(593,350);  // 設定視窗尺寸
      GUESS_A_B.setVisible(true);  // 顯示視窗
   }
}