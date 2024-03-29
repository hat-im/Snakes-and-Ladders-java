import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class SnakesAndLadders extends javax.swing.JFrame {
    byte dice;
    int[][] loc,ladders,snakes;
    int pl1,pl2;
    boolean player1=true,six=false;
    public SnakesAndLadders() {
        initComponents();
        this.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        dice=1;
        setLocations();
        pl1=0;
        pl2=0;
        setPieces();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        pLabel2 = new javax.swing.JLabel();
        pLabel1 = new javax.swing.JLabel();
        diceLabel = new javax.swing.JLabel();
        diceSpinner = new javax.swing.JSpinner();
        diceDurLabel = new javax.swing.JLabel();
        diceRollLabel = new javax.swing.JLabel();
        playerLabel1 = new javax.swing.JLabel();
        playerLabel2 = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();
        pTextField1 = new javax.swing.JTextField();
        pTextField2 = new javax.swing.JTextField();
        chanceLabel = new javax.swing.JLabel();
        pNameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snakes And Ladders");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(901, 583));
        setMinimumSize(new java.awt.Dimension(901, 583));
        setPreferredSize(new java.awt.Dimension(901, 583));
        setResizable(false);
        getContentPane().setLayout(null);

        pLabel2.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\Player 2.png")); // NOI18N
        getContentPane().add(pLabel2);
        pLabel2.setBounds(730, 250, 25, 25);

        pLabel1.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\Player 1.png")); // NOI18N
        getContentPane().add(pLabel1);
        pLabel1.setBounds(730, 220, 25, 25);

        diceLabel.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\1.png")); // NOI18N
        diceLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diceLabelMouseClicked(evt);
            }
        });
        getContentPane().add(diceLabel);
        diceLabel.setBounds(750, 10, 120, 120);

        diceSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(0.25f), Float.valueOf(5.0f), Float.valueOf(0.25f)));
        diceSpinner.setToolTipText("Choose duration of dice roll (in seconds)");
        getContentPane().add(diceSpinner);
        diceSpinner.setBounds(835, 160, 60, 28);

        diceDurLabel.setText("Dice Roll Duration:");
        getContentPane().add(diceDurLabel);
        diceDurLabel.setBounds(730, 160, 110, 30);

        diceRollLabel.setText("Click the Dice to Roll");
        diceRollLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diceRollLabelMouseClicked(evt);
            }
        });
        getContentPane().add(diceRollLabel);
        diceRollLabel.setBounds(750, 140, 120, 16);

        playerLabel1.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\Player 1.png")); // NOI18N
        getContentPane().add(playerLabel1);
        playerLabel1.setBounds(65, 485, 25, 25);

        playerLabel2.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\Player 2.png")); // NOI18N
        getContentPane().add(playerLabel2);
        playerLabel2.setBounds(35, 485, 25, 25);

        backgroundLabel.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\Snakes And Ladders Background.png")); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 727, 548);

        pTextField1.setText("Player 1");
        pTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                pTextField1CaretUpdate(evt);
            }
        });
        getContentPane().add(pTextField1);
        pTextField1.setBounds(760, 220, 130, 28);

        pTextField2.setText("Player 2");
        pTextField2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                pTextField2CaretUpdate(evt);
            }
        });
        getContentPane().add(pTextField2);
        pTextField2.setBounds(760, 250, 130, 28);

        chanceLabel.setFont(new java.awt.Font("Felix Titling", 0, 14)); // NOI18N
        chanceLabel.setText("Chance of: ");
        getContentPane().add(chanceLabel);
        chanceLabel.setBounds(770, 290, 90, 17);

        pNameLabel.setFont(new java.awt.Font("Felix Titling", 0, 14)); // NOI18N
        pNameLabel.setText("Player 1");
        pNameLabel.setToolTipText("Displays player whose turn it is.");
        getContentPane().add(pNameLabel);
        pNameLabel.setBounds(730, 310, 170, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\Player 1.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(730, 330, 25, 25);

        resetButton.setText("Reset");
        resetButton.setToolTipText("Set players back to Start.");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton);
        resetButton.setBounds(830, 520, 61, 28);

        pack();
    }// </editor-fold>                        

    final void setLocations(){
        loc=new int[100][2];
        loc[0][0]=50;
        loc[0][1]=485;
        setLeftToRight(1);
        loc[10][0]=657;
        loc[10][1]=435;
        setRightToLeft(11);
        loc[20][0]=50;
        loc[20][1]=385;
        setLeftToRight(21);
        loc[30][0]=657;
        loc[30][1]=335;
        setRightToLeft(31);
        loc[40][0]=50;
        loc[40][1]=285;
        setLeftToRight(41);
        loc[50][0]=657;
        loc[50][1]=235;
        setRightToLeft(51);
        loc[60][0]=50;
        loc[60][1]=185;
        setLeftToRight(61);
        loc[70][0]=657;
        loc[70][1]=135;
        setRightToLeft(71);
        loc[80][0]=50;
        loc[80][1]=85;
        setLeftToRight(81);
        loc[90][0]=657;
        loc[90][1]=35;
        setRightToLeft(91);
        
        ladders=new int[7][2];
        ladders[0][0]=2; ladders[0][1]=20;
        ladders[1][0]=7; ladders[1][1]=29;
        ladders[2][0]=27;ladders[2][1]=83;
        ladders[3][0]=57;ladders[3][1]=76;
        ladders[4][0]=74;ladders[4][1]=85;
        ladders[5][0]=79;ladders[5][1]=99;
        ladders[6][0]=89;ladders[6][1]=90;
        
        snakes=new int[7][2];
        snakes[0][0]=16;snakes[0][1]=12;
        snakes[1][0]=51;snakes[1][1]=28;
        snakes[2][0]=56;snakes[2][1]=39;
        snakes[3][0]=61;snakes[3][1]=21;        
        snakes[4][0]=87;snakes[4][1]=17;
        snakes[5][0]=94;snakes[5][1]=50;
        snakes[6][0]=96;snakes[6][1]=78;
    }
    
    void setPieces(){
        playerLabel1.setLocation(loc[pl1][0],loc[pl1][1]);
        playerLabel2.setLocation(loc[pl2][0],loc[pl2][1]);
        adjust();
    }
    
    void adjust(){
        if(pl1==pl2){
            Timer timer = new Timer();
            class RemindTask extends TimerTask {
                public void run() {
                    int x1=loc[pl1][0]+15;
                    int x2=loc[pl2][0]-15;
                    playerLabel1.setLocation(x1,loc[pl1][1]);
                    playerLabel2.setLocation(x2,loc[pl2][1]);
                }
            }
            timer.schedule(new RemindTask(), 500);
        }
    }
    
    void setLeftToRight(int i){
        int lim=i+8;
        for(;i<=lim;i++){
            loc[i][0]=loc[i-1][0]+68-(i%2);
            loc[i][1]=loc[i-1][1];
        }
    }
    
    void setRightToLeft(int i){
        int lim=i+8;
        for(;i<=lim;i++){
            loc[i][0]=loc[i-1][0]-68+(i%2);
            loc[i][1]=loc[i-1][1];
        }
    }
    
    void roll(){
        float f=Float.parseFloat(diceSpinner.getValue().toString());
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){
            int n=1;
            public void run(){
                n++;
                diceLabel.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\"+((n%6)+1)+".png"));
                if(n==f*100){
                    timer.cancel();
                    diceLabel.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\"+dice+".png"));
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);//changes every 10 ms
    }
    
    void generateNumber(){
        double d=Math.random()*10;
        while(d>6)
            d=Math.random()*10;
        dice=(byte)(d+1);
    }
    
    void move(){
        if(player1)
            steps(pl1-dice, pl1, playerLabel1);
        else
            steps(pl2-dice, pl2, playerLabel2);
        player1=!player1;
    }
    
    private void diceLabelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        generateNumber();
        roll();
        if(((player1&&pl1==0)||(!player1&&pl2==0))&&!six){
            if(dice!=6){
                player1=!player1;
                setPlayer();
            }
            else
                six=true;
            return;
        }
        six=false;
        
        //timer to move piece only after die rolled
        float f=Float.parseFloat(diceSpinner.getValue().toString());
        if(player1){
            pl1+=dice;
            if(pl1>99){
                pl1-=dice;
                player1=!player1;
                return ;
            }
        }
        else{
            pl2+=dice;
            if(pl2>99){
                pl2-=dice;
                player1=!player1;
                return ;
            }
        }
        Timer timer = new Timer();
        class RemindTask extends TimerTask {
            public void run() {
                move();
                timer.cancel();
            }
        }
        timer.schedule(new RemindTask(), (int)(f*1000));
        //timer end
        setPlayer();
    }                                      

    void setPlayer(){
        String s=player1?pTextField1.getText():pTextField2.getText();
        int n=player1?1:2;
        pNameLabel.setText(s);
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Desktop\\Computer Board Projects\\Player "+n+".png"));
    }
    
    void checkSnakesAndLadders(){
        boolean p=!player1;
        float f=Float.parseFloat(diceSpinner.getValue().toString());
        if(p){
            for(int i=0;i<7;i++){
                if(pl1==ladders[i][0]||pl1==snakes[i][0]){
                    pl1=pl1==ladders[i][0]?ladders[i][1]:snakes[i][1];
                    Timer timer=new Timer();
                    TimerTask task=new TimerTask()
                    {
                        public void run()
                        {
                            playerLabel1.setLocation(loc[pl1][0],loc[pl1][1]);
                            if(pl1==99)
                                winScreen();
                            timer.cancel();
                        }
                    };
                    timer.scheduleAtFixedRate(task, (int)(f*1000+150), 100);
                    return ;
                }
            }
        }
        else{
            for(int i=0;i<7;i++){
                if(pl2==ladders[i][0]||pl2==snakes[i][0]){
                    pl2=pl2==ladders[i][0]?ladders[i][1]:snakes[i][1];
                    Timer timer=new Timer();
                    TimerTask task=new TimerTask()
                    {
                        public void run()
                        {
                            playerLabel2.setLocation(loc[pl2][0],loc[pl2][1]);
                            if(pl2==99)
                                winScreen();
                            timer.cancel();
                        }
                    };
                    timer.scheduleAtFixedRate(task, (int)(f*1000+150), 100);
                    return ;
                }
            }
        }
    }
    
    private void diceRollLabelMouseClicked(java.awt.event.MouseEvent evt) {                                           
        diceLabelMouseClicked(evt);
    }                                          

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Reset",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            reset();
        }
    }                                           

    private void pTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        setPlayer();
    }                                       

    private void pTextField2CaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        setPlayer();
    }                                       

    void reset(){
        pl1=0;
        pl2=0;
        player1=true;
        setPieces();
    }
    
    void winScreen(){
        if(pl1==99){
            String win=pTextField1.getText();
            new WinScreen(this,win).setVisible(true);
        }
        else if(pl2==99){
            String win=pTextField2.getText();
            new WinScreen(this,win).setVisible(true);
        }
    }
    
    void steps(int start, int end, javax.swing.JLabel label){
        SnakesAndLadders obj=this;
        Timer timer=new Timer();
        TimerTask task=new TimerTask()
        {
            int i=start+1;
            public void run()
            {
                
                if(i==end){
                    setPlayer();
                    timer.cancel();
                }
                label.setLocation(loc[i][0],loc[i][1]);
                checkSnakesAndLadders();
                adjust();
                i++;
            }
        };
        timer.scheduleAtFixedRate(task, 0, 100);//last parameter determines length of the step in ms
        //1000ms=1sec
        if(end==99){
            Timer timer2=new Timer();
            TimerTask task2=new TimerTask()
            {
                public void run()
                {
                    winScreen();
                    timer2.cancel();
                }
            };
            timer2.scheduleAtFixedRate(task2, 1000, 10);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SnakesAndLadders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SnakesAndLadders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SnakesAndLadders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SnakesAndLadders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SnakesAndLadders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel chanceLabel;
    private javax.swing.JLabel diceDurLabel;
    private javax.swing.JLabel diceLabel;
    private javax.swing.JLabel diceRollLabel;
    private javax.swing.JSpinner diceSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pLabel1;
    private javax.swing.JLabel pLabel2;
    private javax.swing.JLabel pNameLabel;
    private javax.swing.JTextField pTextField1;
    private javax.swing.JTextField pTextField2;
    private javax.swing.JLabel playerLabel1;
    private javax.swing.JLabel playerLabel2;
    private javax.swing.JButton resetButton;
    // End of variables declaration                   
}
