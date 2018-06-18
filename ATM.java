package atm;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.*;

public class ATM extends JFrame implements ActionListener
{
        // Login and Create User ********************************************************************************************
        static Container frame; // The canvas for placing all of the objects on
        static String fpmoney = "";
        static int userPop = 0;
        static int balPop = 0;
        static int transPop = 0;
        static String userBal;
        static int balnum = 0;
        static Color lightblue;
        static Font titleF, boldF, gen, newUser, inF, bigF, inF2;
        static JLabel background, background2, UIcon; // Storing background picture in a JLabel
        static JLabel login; // First step to creating a clickable JLabel for the login button
        static JLabel createUserA; // User will click to create an account
        static JTextField cfirstnam, clastnam, email, birthdd, birthmm, birthyy, gender, captcha; // Get's user, email, birth months, day, and year, gender type, and comfirms whether the user is a robot or not
        static JLabel sfirstnam, slastnam, semail, sPass, sRetypePass, sbirthdd, sbirthmm, sbirthyy, sgender, scaptcha;
        static JTextField username; // Username JTextField input.
        static JTextField cardNum, expmm, expyy, securityNum;
        static JTextField searchF;
        static JLabel selectF;
        static JLabel scardNum, sexpmm, sexpyy, ssecurityNum;
        static JPasswordField password, cPass, cRetypePass;
        static JLabel cGen, captchaBox;
        static JLabel luser, lpass;
        static JButton back1;
        static JButton createUserB, createUserC;
        static String captchaKey = "";
        static String wUrlBG = "BlueBG.png", wUrlBG2 = "BlueBG.png", wUrlUIcon = "IconUser.png", wUrlLogin = "Arrow.png", wGenBox = "BlackBox.png"; // Windows image destinations that can be manipulated
        static String UrlBG = "/Users/NathanielMr/Downloads/BlueBG.png", UrlBG2 = "/Users/NathanielMr/Downloads/BlueBG.png", UrlUIcon = "/Users/NathanielMr/Downloads/IconUser.png", UrlLogin = "/Users/NathanielMr/Downloads/ezgif.com-resize.png", GenBox = "/Users/NathanielMr/Downloads/BlackBox.png"; // Macbook image destinations that can be manipulated
        // *********************************************************************************************************************

        // ATM interface *******************************************************************************************************
        static JLabel friendList, friendUp, friendDown;
        static JTextField giveFriend;
        static String friendLocked = "";
        static String transferLock = "";
        static JLabel balance, bal, transactions, transfer, welcome, bankNam, atm;
        static JPanel btnfTransfer, sLogout, btnfTransactions, btnfAbout, bannerTop, bannerTop2;
        static JLabel sTransfer, sTrans, sAbout;
        static JLabel sSearch, sendM, descS, sConfirm, logout; 
        static JButton setSend, btnConfirm;
        static JLabel backTransfer, backTransaction;
        static JLabel transferList, sTransferList;
        static JPasswordField confirmS;
        static JLabel aboutList, tAbout, backAbout;
        // *********************************************************************************************************************


        public ATM ()
        {
                super ("Royal bank of Nathaniel"); // Set the frame's name
                frame = getContentPane (); // Declaring frame to store all objects on

                obj (); // Declares all of the objects
                xy (); // Sets the coordinates of where the objects should be placed
                mouse (); // Creates a mouse listener for the objects as follows
                display (); // Shows all the objects on the container JFrame

                back1.addActionListener (this);
                createUserB.addActionListener (this);
                createUserC.addActionListener (this);
                setSize (1280, 985); // Set the frame's size
                show (); // Show the frame
        }


        public static void obj ()
        {

                titleF = new Font ("Monospace", Font.PLAIN, 19); // sets a custom font
                boldF = new Font ("Monospace", Font.BOLD, 19);
                gen = new Font ("Times New Roman", Font.BOLD, 45);
                newUser = new Font ("Monospace", Font.BOLD, 16);
                
                background = new JLabel (new ImageIcon (UrlBG)); // sets a picture into the background JLabel
                UIcon = new JLabel (new ImageIcon (UrlUIcon)); // sets a picture into the UIcon JLabel
                login = new JLabel (new ImageIcon (UrlLogin)); // sets a picture into the background JLabel

                username = new JTextField (); // Declares a textfield called username that sets it's text to "username"
                username.setFont (titleF); // sets font to titleF
                username.setText ("");

                password = new JPasswordField (24); // Declares a textfield called password that sets it's text to "password"
                password.setFont (titleF); // sets font to titleF
                password.setText ("");

                luser = new JLabel ("Email:");
                luser.setFont (boldF);

                lpass = new JLabel ("Password:");
                lpass.setFont (boldF);

                createUserA = new JLabel ("Create account"); // Declares a JLabel that when clicked will redirect the user to an account creation page
                createUserA.setForeground (Color.BLUE); // sets the color of the text to blue
                createUserA.setFont (titleF); // sets font to titleF

                back1 = new JButton ("Go back");
                back1.setVisible (false);
                back1.setBackground (Color.WHITE);
                back1.setFont (newUser);

                cfirstnam = new JTextField ("");
                cfirstnam.setFont (titleF);
                cfirstnam.setVisible (false);

                clastnam = new JTextField ("");
                clastnam.setFont (titleF);
                clastnam.setVisible (false);

                email = new JTextField ("");
                email.setFont (titleF);
                email.setVisible (false);

                cPass = new JPasswordField (24);
                cPass.setFont (titleF);
                cPass.setVisible (false);

                cRetypePass = new JPasswordField (24);
                cRetypePass.setFont (titleF);
                cRetypePass.setVisible (false);

                birthdd = new JTextField ("");
                birthdd.setFont (titleF);
                birthdd.setVisible (false);

                birthmm = new JTextField ("");
                birthmm.setFont (titleF);
                birthmm.setVisible (false);

                birthyy = new JTextField ("");
                birthyy.setFont (titleF);
                birthyy.setVisible (false);

                gender = new JTextField ("");
                gender.setFont (titleF);
                gender.setVisible (false);

                captcha = new JTextField ("");
                captcha.setVisible (false);

                cGen = new JLabel (captchaGen (captchaKey));
                cGen.setFont (gen);
                cGen.setVisible (false);

                captchaBox = new JLabel (new ImageIcon (GenBox));
                captchaBox.setFont (gen);
                captchaBox.setVisible (false);

                createUserB = new JButton ("Next");
                createUserB.setBackground (Color.WHITE);
                createUserB.setFont (newUser);
                createUserB.setVisible (false);

                //

                sfirstnam = new JLabel ("First name:");
                sfirstnam.setFont (titleF);
                sfirstnam.setVisible (false);

                slastnam = new JLabel ("Last name:");
                slastnam.setFont (titleF);
                slastnam.setVisible (false);

                semail = new JLabel ("Email:");
                semail.setFont (titleF);
                semail.setVisible (false);

                sPass = new JLabel ("Password:");
                sPass.setFont (titleF);
                sPass.setVisible (false);

                sRetypePass = new JLabel ("Re-type password:");
                sRetypePass.setFont (titleF);
                sRetypePass.setVisible (false);

                sbirthdd = new JLabel ("DD:");
                sbirthdd.setFont (titleF);
                sbirthdd.setVisible (false);

                sbirthmm = new JLabel ("MM:");
                sbirthmm.setFont (titleF);
                sbirthmm.setVisible (false);

                sbirthyy = new JLabel ("YYYY:");
                sbirthyy.setFont (titleF);
                sbirthyy.setVisible (false);

                sgender = new JLabel ("Gender:");
                sgender.setFont (titleF);
                sgender.setVisible (false);

                scaptcha = new JLabel ("Please enter the Captcha:");
                scaptcha.setFont (titleF);
                scaptcha.setVisible (false);

                //

                cardNum = new JTextField ("");
                cardNum.setVisible (false);

                expmm = new JTextField ("");
                expmm.setVisible (false);

                expyy = new JTextField ("");
                expyy.setVisible (false);

                securityNum = new JTextField ("");
                securityNum.setVisible (false);

                scardNum = new JLabel ("Card Number:");
                scardNum.setVisible (false);
                scardNum.setFont (titleF);

                sexpmm = new JLabel ("Exp: mm");
                sexpmm.setVisible (false);
                sexpmm.setFont (titleF);

                sexpyy = new JLabel ("Exp: yyyy");
                sexpyy.setVisible (false);
                sexpyy.setFont (titleF);

                ssecurityNum = new JLabel ("Security Code:");
                ssecurityNum.setVisible (false);
                ssecurityNum.setFont (titleF);

                createUserC = new JButton ("Create new account");
                createUserC.setVisible (false);
                createUserC.setBackground (Color.WHITE);
                createUserC.setFont (newUser);

        }


        public static String captchaGen (String a)
        {
                String r = "(?^(W7@+Z90fKCkU|D+o%qZL74xT^<TlU#HZ]v~VDHUOnN0*.8LF@pKPQ/`*KbZ/n<X4/Gf~9jjUw0I#!)RR;hPVJ@wVi+}[5XEwAN9ecsK.qhq+fGaeSxIb|)[YL4|r7&DFy!8.'6lJX'r)i4oWn(f}x=}wIP~auIgY_HXZ9+-69egJ>:'e8W%[PSilg_fBZgs5*IPvdY)tAAFiCkDuB.R>}Yl0Q-+wa[p}[xEc]Hmg'Hd@2EtI5(JwVOC4/npnw^7Mm><`mZ?xnO2bV0hILS?OYt&wm:0cs*]rt}`-n`b%wI/G1z|wH`VsIqKeEr^#9}HC:*Jv1-0'pP/3#T`Kc[:(mlLs4:s(tM!&Kf})W11v%<Fwi3~7Yq'2r;A+D%z/uK6]k~Xk~*$b'gvXFP=tS}fTQ8StbouFNM<:`wAQROh`FGh.[}!I-F7-;HiS{k_c<JY^f]K'pWk)q-JE3E)n~7Mx-5fX-Ka6[HTvEI&g?)xz9.'k]$3U$RD{po4jf6UW~MbrZ80da=_XE1_n0J]e%l&H(?7}%$yGN/nM?i)w%3t@gv%>UQabAT~O||?{]IG_:D~M5mCZO)Xapm&7dHF~sA5dPxDP9pn;Ha.R^5S>izvLq$Fy~*W![@'|FT!Ht[}zm6>rO#2M]uMp.}^C6=AR3:Dv<>NLEQ>0'D|!ax%9&Ea6~*HwexhD+oWAqU}t[h]V>N70q)yI[4b4A;85O~2hrFQz$h;RT5{;xwz:+E[gEUId$LG?5fA8?AUJQ:JH#CQd2#Tn3+re>j8-n[~)NS[l=#;rQ:8przM+?'5&ixO#n~Eq/Ix<0g_!d)ZW_<Wrh0/xN#z;)z=|$PZ~^odp/qpK8Rr8byp/Q}+9LG^87V}Ass3hP=n=9A@weRC;)%7N1n>m^l?LVa3my5'=RL0Od}ubk+/vnnb!&Ji6Qhj<=/.v=kI)N001_^i3SB0z_-G=s-Rv#<DC+4xR(0.qqsdHb$M{?k+bTJ?RGnVTl6L<yZP)mu+gt|cc?qkccci9Q6$;BAGaZut]pn(I%&)a*r[ol>E&";

                int max = 1040, min = 1, range = 0;
                int randB = 0;
                range = max - min + 1;

                try
                {
                        for (int b = 0 ; b < 6 ; b++)
                        {
                                randB = (int) (Math.random () * range) + min;

                                if (String.valueOf (r.charAt (randB)).equals ("  "))
                                {
                                        a = a + String.valueOf (r.charAt (randB + 10));
                                        captchaKey = captchaKey + String.valueOf (r.charAt (randB + 10));
                                }
                                else
                                {
                                        a = a + String.valueOf (r.charAt (randB)) + "  ";
                                        captchaKey = captchaKey + String.valueOf (r.charAt (randB) + "  ");
                                }

                        }
                }
                catch (StringIndexOutOfBoundsException e2)
                {
                        randB = randB - 10;
                }

                return a;
        }


        public static String space (String delSpace)
        {

                String c = "";
                for (int b = 0 ; b < delSpace.length () ; b++)
                {

                        if (delSpace.charAt (b) == ' ')
                        {
                                c = c + "";
                        }
                        else
                        {
                                c = c + delSpace.charAt (b);
                        }
                }
                return c;
        }


        public static void xy ()
        {
                // Variables that make readjusting positions way easier

                byte r = -70;
                short r2 = -270 - 50;
                short r3 = -300 - 50;
                short r4 = -150;
                byte d = 60;

                /*
                 *
                byte r = -10;
                short r2 = -200;
                short r3 = -230;
                byte d = 60;
                 *
                 */
                // increases every object by a value because I felt like doing
                // them all individually is inefficient and it feels for like VB

                UIcon.setBounds (382, 170 + r, 500, 350);
                login.setBounds (900, 507 + r, 80, 80);
                luser.setBounds (395, 440 + r, 500, 60);
                username.setBounds (390, 480 + r, 500, 60);
                lpass.setBounds (395, 530 + r, 500, 60);
                password.setBounds (390, 570 + r, 500, 60);
                createUserA.setBounds (565, 610 + r, 500, 60);

                back1.setBounds (-10 + d, 365 + r2, 200, 30);
                cfirstnam.setBounds (382 + d, 370 + r2, 200, 30);
                clastnam.setBounds (592 + d, 370 + r2, 200, 30);
                email.setBounds (382 + d, 440 + r2, 410, 30);
                cPass.setBounds (382 + d, 510 + r2, 410, 30);
                cRetypePass.setBounds (382 + d, 580 + r2, 410, 30);
                birthdd.setBounds (382 + d, 650 + r2, 200, 30);
                birthmm.setBounds (592 + d, 650 + r2, 100, 30);
                birthyy.setBounds (702 + d, 650 + r2, 90, 30);
                gender.setBounds (382 + d, 720 + r2, 410, 30);
                cGen.setBounds (430 + d, 795 + r2, 610, 130);
                captcha.setBounds (382 + d, 930 + r2, 410, 30);

                captchaBox.setBounds (382 + d, 800 + r2, 410, 100);
                createUserB.setBounds (485 + d, 980 + r2, 205, 30);

                sfirstnam.setBounds (382 + d, 370 + r3, 200, 30);
                slastnam.setBounds (592 + d, 370 + r3, 200, 30);
                semail.setBounds (382 + d, 440 + r3, 410, 30);
                sPass.setBounds (382 + d, 510 + r3, 410, 30);
                sRetypePass.setBounds (382 + d, 580 + r3, 410, 30);
                sbirthdd.setBounds (382 + d, 650 + r3, 200, 30);
                sbirthmm.setBounds (592 + d, 650 + r3, 100, 30);
                sbirthyy.setBounds (702 + d, 650 + r3, 90, 30);
                sgender.setBounds (382 + d, 720 + r3, 410, 30);
                scaptcha.setBounds (379 + d, 765 + r3, 410, 100);

                scardNum.setBounds (382 + d, 395 + r4, 410, 30);
                cardNum.setBounds (382 + d, 420 + r4, 410, 30);

                sexpmm.setBounds (382 + d, 472 + r4, 200, 30);
                expmm.setBounds (382 + d, 500 + r4, 120, 30);

                sexpyy.setBounds (510 + d, 472 + r4, 200, 30);
                expyy.setBounds (510 + d, 500 + r4, 120, 30);

                ssecurityNum.setBounds (638 + d, 472 + r4, 200, 30);
                securityNum.setBounds (638 + d, 500 + r4, 153, 30);

                createUserC.setBounds (470 + d, 560 + r4, 205, 35);

        }

        

        public static void obj2 ()
        {

                lightblue = new Color (51, 204, 255);
                
                background.setVisible (false);
                background2 = new JLabel (new ImageIcon (UrlBG2));
                
                bigF = new Font ("Monospace", Font.BOLD, 45);
                inF = new Font ("Monospace", Font.BOLD, 25);
                inF2 = new Font ("Monospace", Font.BOLD, 14);
                
                welcome = new JLabel ("Welcome");
                welcome.setFont (inF);
                welcome.setForeground (lightblue);
                welcome.setVisible (true);

                try
                {
                        bankNam = new JLabel (getfullnam (bNam));
                        bankNam.setVisible (true);
                }
                catch (IOException e)
                {
                        e.printStackTrace ();
                }
                
                bankNam.setFont (boldF);
                bankNam.setForeground (Color.WHITE);
                
                balance = new JLabel ("Balance");
                balance.setFont (inF);
                balance.setForeground (lightblue);
                balance.setVisible (true);
                
                bal = new JLabel ("$$$");
                bal.setFont (boldF);
                bal.setForeground (Color.WHITE);
                bal.setVisible (true);
                
                atm = new JLabel ("");
                atm.setFont (boldF);
                atm.setForeground (Color.WHITE);
                
                bannerTop = new JPanel ();
                bannerTop.setBackground (Color.WHITE);
                bannerTop.setVisible(false);
                
                bannerTop2 = new JPanel ();
                bannerTop2.setBackground (Color.WHITE);
                bannerTop2.setVisible(false);
                
                btnfTransfer = new JPanel ();
                btnfTransfer.setBackground (lightblue);
                btnfTransfer.setVisible (true);
                
                sTransfer = new JLabel ("TRANSFER");
                sTransfer.setForeground (Color.WHITE);
                sTransfer.setFont (boldF);
                sTransfer.setVisible (true);
                
                backTransfer = new JLabel("[ Back ]");
                backTransfer.setFont (inF);
                backTransfer.setForeground(lightblue);
                backTransfer.setVisible (false);
                
                btnfAbout = new JPanel ();
                btnfAbout.setBackground (lightblue);
                btnfAbout.setVisible (true);
                
                sAbout = new JLabel ("ABOUT");
                sAbout.setForeground (Color.WHITE);
                sAbout.setFont (boldF);
                sAbout.setVisible (true);
                
                String aboutProg = "";
                aboutList = new JLabel (about(aboutProg));
                aboutList.setForeground (Color.WHITE);
                aboutList.setFont (inF2);
                aboutList.setVisible (false);
                
                tAbout = new JLabel ("About this program");
                tAbout.setForeground (Color.WHITE);
                tAbout.setFont (bigF);
                tAbout.setVisible (false);
                
                backAbout = new JLabel ("[ Back ]");
                backAbout.setFont (inF);
                backAbout.setForeground(lightblue);
                backAbout.setVisible (false);
                
                sLogout = new JPanel ();
                sLogout.setBackground (lightblue);
                sLogout.setVisible (true);
                
                logout = new JLabel ("LOGOUT");
                logout.setForeground (Color.WHITE);
                logout.setFont (boldF);
                logout.setVisible (true);

                btnfTransactions = new JPanel ();
                btnfTransactions.setBackground (lightblue);
                btnfTransactions.setVisible (true);
                
                sTrans = new JLabel ("TRANSACTIONS");
                sTrans.setForeground (Color.WHITE);
                sTrans.setFont (boldF);
                sTrans.setVisible (true);

                friendUp = new JLabel ("Friend List");
                friendUp.setFont(bigF);
                friendUp.setForeground(Color.WHITE);

                friendList = new JLabel ("");
                friendList.setFont(newUser);
                friendList.setForeground(Color.WHITE);

                friendDown = new JLabel ("Down");
                friendDown.setFont(boldF);
                friendDown.setForeground(Color.WHITE);

                friendUp.setVisible (false);
                friendList.setVisible (false);
                friendDown.setVisible (false);

                searchF = new JTextField ();
                searchF.setVisible (false);

                selectF = new JLabel ("Choose a user");
                selectF.setBackground (Color.WHITE);
                selectF.setVisible (false);

                giveFriend = new JTextField ();
                giveFriend.setVisible (false);
                	
                confirmS = new JPasswordField ();
                confirmS.setVisible(false);

                sSearch = new JLabel ("Search");
                sSearch.setForeground(Color.WHITE);
                sSearch.setFont(boldF);
                sSearch.setVisible(false);

                sendM = new JLabel ("Money");
                sendM.setForeground(Color.WHITE);
                sendM.setFont(boldF);
                sendM.setVisible(false);

                descS = new JLabel ("");
                descS.setForeground(Color.WHITE);
                descS.setFont(boldF);
                descS.setVisible(false);

                setSend = new JButton ("Select");
                setSend.setBackground (Color.WHITE);
                setSend.setFont(boldF);
                setSend.setVisible(false);
                
                sConfirm = new JLabel ("Password");
                sConfirm.setForeground(Color.WHITE);
                sConfirm.setFont(boldF);
                sConfirm.setVisible(false);
                
                btnConfirm = new JButton ("Confirm");
                btnConfirm.setBackground (Color.WHITE);
                btnConfirm.setFont(boldF);
                btnConfirm.setVisible(false);
                
                transferList = new JLabel ("");
                transferList.setForeground (Color.WHITE);
                transferList.setFont(newUser);
                transferList.setVisible(false);
                
                sTransferList = new JLabel ("Transactions");
                sTransferList.setForeground (Color.WHITE);
                sTransferList.setVisible(false);
                sTransferList.setFont(bigF);
                
                backTransaction = new JLabel ("[ Back ]");
                backTransaction.setFont (inF);
                backTransaction.setForeground(lightblue);
                backTransaction.setVisible (false);
        }
        
        static short raise = 40;
        static short raise2 = -40;
        static short drag = 40;
        static short drag2 = 90;
        static short drag3 = 50;
        static short drag4 = 50;
        static String bNam = "";
        
        public static void xy2 ()
        {       
                atm.setBounds (64, 94 + raise, 300, 100);
                welcome.setBounds (64, 194 + raise, 200, 100);
                bankNam.setBounds (78, 218 + raise, 300, 100);
                balance.setBounds (64, 291 + raise, 200, 100);
                bal.setBounds (78, 315 + raise, 200, 100);
                
                backTransfer.setBounds (64, 100 + raise2, 130, 40);
                backTransaction.setBounds (64, 100 + raise2, 130, 40);
                backAbout.setBounds (64, 100 + raise2, 130, 40);
                
                bannerTop.setBounds(829 + 0, 100 + raise2, 10, 600);
                bannerTop2.setBounds(370 + 0, 100 + raise2, 10, 600);
                btnfTransfer.setBounds (407 + drag, 221 + raise, 256, 99);
                btnfAbout.setBounds (706 + drag, 221 + raise, 256, 99);
                sLogout.setBounds (706 + drag, 412, 256, 99);
                btnfTransactions.setBounds (407 + drag, 412, 256, 99);
                
                sTransfer.setBounds (437 + drag2, 221 + raise, 256, 99);
                sAbout.setBounds (736 + drag2, 221 + raise, 256, 99);
                logout.setBounds (736 + drag2, 412, 256, 99);
                sTrans.setBounds (407 + drag2, 412, 256, 99);
                
                friendUp.setBounds(435 + drag3, 120 + raise2, 256, 99);
                friendList.setBounds(447 + drag3, 120 + raise2, 256, 299);
                searchF.setBounds(390 + drag3, 561 + raise2, 256, 30);
                sendM.setBounds(650 + drag3, 531 + raise2, 70, 30);
                giveFriend.setBounds(650 + drag3, 561 + raise2, 70, 30);
                sConfirm.setBounds(880 + drag3, 531 + raise2, 186, 30);
                confirmS.setBounds(880 + drag3, 561 + raise2, 186, 30);
                btnConfirm.setBounds(880 + drag3, 591 + raise2, 186, 35);
                sSearch.setBounds(490 + drag3, 531 + raise2, 256, 30);
                descS.setBounds(850 + drag3, 120 + raise2, 256, 300);
                setSend.setBounds(390 + drag3, 591 + raise2, 330, 35);
                
                sTransferList.setBounds(480 + drag4, 120 + raise2, 330, 99);
                transferList.setBounds(490 + drag4, 200 + raise2, 330, 99);
                
                tAbout.setBounds(430 + drag4, 105 + raise2, 460, 99);
                aboutList.setBounds(270 + drag4, -30, 760, 899);
                
        }       
        

        static int incDec = 0;
        public static void mouse2 () 
        {

                

                setSend.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                                try 
                                {
                                if (searchF.getText().equals("") || searchF.getText().equals(" ") || Integer.parseInt(giveFriend.getText()) <= 0 && Integer.parseInt(giveFriend.getText()) > Integer.parseInt(bal.getText().substring(1, bal.getText().length())))
                                {
                                	   descS.setVisible (false);
                                	   sConfirm.setVisible (false);
                                    btnConfirm.setVisible (false);
                                    confirmS.setVisible (false);
                                    confirmS.setText("");
                                }
                                else 
                                {
                                	
                                	try {
                                		
                                		transferLock = giveFriend.getText();
                                		transferLock = giveFriend.getText();
                                		friendSearch (searchF.getText());
                                        
                                int total =  (Integer.parseInt(bal.getText().substring(1, bal.getText().length())) - Integer.parseInt(giveFriend.getText()));
                                
                                if (total < 0 || Integer.parseInt(giveFriend.getText()) <= 0)
                                {	
                                	   descS.setVisible (false);
                                	   sConfirm.setVisible (false);
                                    btnConfirm.setVisible (false);
                                    confirmS.setVisible (false);
                                    confirmS.setText("");
                                }
                                else if (friendLocked.length() < 2)
                                {
                                	
                                }
                                else
                                {
                                descS.setText("<html><div style='text-align: center;'>" + "You are attempting to send " + "$" + transferLock + " to " + friendLocked  + ". You currently have " + bal.getText() + " In your balance. Your remaining balance would be $" + total + ". Are you sure you wish to proceed with this?" + "<br> " + "<html>");
                                btnConfirm.setVisible(true);
                                confirmS.setVisible(true);
                                descS.setVisible(true);
                         	   sConfirm.setVisible(true);
                         	   confirmS.setText("");
                                }
                                
                                if ((Integer.parseInt(showBal(fpmoney)) + balnum) < Integer.parseInt(giveFriend.getText()))
                                {
                                descS.setVisible (true);
                                descS.setForeground(lightblue);
                                descS.setText("<html><div style='text-align: center;'>" + "Error! Insufficient funds" + "<br> " + "<html>");
                                }
                                
                                else if ((Integer.parseInt(showBal(fpmoney)) + balnum) > Integer.parseInt(giveFriend.getText()))
                                {
                                	 descS.setForeground(Color.WHITE);
                                }
                                	}
                                catch (IOException e1) 
                                {
                                        e1.printStackTrace();
                                }
                                
                                }
                                }
                                catch (NumberFormatException npe) 
                                {
                                		try {
											friendSearch (searchF.getText());
											
											descS.setVisible (false);
											sConfirm.setVisible (false);
											btnConfirm.setVisible (false);
											confirmS.setVisible (false);
											confirmS.setText("");
										} 
                                		catch (IOException e1)
                                			{
											e1.printStackTrace();
										}
                                }
                        }
                });
                
                btnConfirm.addMouseListener (new MouseAdapter () 
                {
                        public void mouseClicked (MouseEvent e) 
                        {
                                
                        	 	boolean check = false;
                        	 	try {
									if (passSend(check) == false) 
									{	
										JOptionPane.showMessageDialog(null, "Invalid password.\nPlease try again.");
									}	
									else
									{	
										sendMoney();
										realMoney();
										JOptionPane.showMessageDialog(null,"Money sent! Please logout to update your balance");
										
										realMoney();
                                         showBal(fpmoney);
                                         bal.setText("$" + (Integer.parseInt(showBal(fpmoney)) + balnum));
                                         displayTrans();
									}	
								} catch (HeadlessException e1) {
									
									e1.printStackTrace();
								} catch (IOException e1) {
									
									e1.printStackTrace();
								}
                                
                        }
                });


                sTrans.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                                sTrans.setVisible (false);
                                btnfTransactions.setVisible (false);
                                sLogout.setVisible (false);
                                logout.setVisible (false);
                                sAbout.setVisible (false);
                                btnfAbout.setVisible (false);
                                sTransfer.setVisible (false);
                                btnfTransfer.setVisible (false);
                                
                                sTransferList.setVisible (true);
                                transferList.setVisible (true);
                                backTransaction.setVisible (true);
                                
                                try 
                                	   {
									displayTrans();
									
								   } 
                                catch (IOException e1) 
                                	   {
									e1.printStackTrace();
								   }
                        }
                });
                
                backTransaction.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                                sTrans.setVisible (true);
                                btnfTransactions.setVisible (true);
                                
                                sLogout.setVisible (true);
                                logout.setVisible (true);
                                sAbout.setVisible (true);
                                btnfAbout.setVisible (true);
                                sTransfer.setVisible (true);
                                btnfTransfer.setVisible (true);
                                
                                sTransferList.setVisible (false);
                                transferList.setVisible (false);
                                transferList.setText("");
                                backTransaction.setVisible (false);
                        }
                });

                logout.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                                sTrans.setVisible (false);
                                btnfTransactions.setVisible (false);
                                sLogout.setVisible (false);
                                logout.setVisible (false);
                                sAbout.setVisible (false);
                                btnfAbout.setVisible (false);
                                sTransfer.setVisible (false);
                                btnfTransfer.setVisible (false);
                                background2.setVisible (false);
                                
                                welcome.setVisible (false);
                                welcome.setText("");
                                bankNam.setVisible (false);
                                bankNam.setText("");
                                balance.setVisible (false);
                                balance.setText("");
                                bal.setVisible (false);
                                bal.setText("");
                                atm.setVisible (false);
                                atm.setText("");
                                background.setVisible (true);
                                login();
                        }
                });

                sAbout.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                                sTrans.setVisible (false);
                                btnfTransactions.setVisible (false);
                                
                                sLogout.setVisible (false);
                                logout.setVisible (false);
                                sAbout.setVisible (false);
                                btnfAbout.setVisible (false);
                                sTransfer.setVisible (false);
                                btnfTransfer.setVisible (false);
                                
                                tAbout.setVisible (true);
                                aboutList.setVisible (true);
                                backAbout.setVisible (true);

                        }
                });
                backAbout.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                        		sTrans.setVisible (true);
                            btnfTransactions.setVisible (true);
                            
                            sLogout.setVisible (true);
                            logout.setVisible (true);
                            sAbout.setVisible (true);
                            btnfAbout.setVisible (true);
                            sTransfer.setVisible (true);
                            btnfTransfer.setVisible (true);
                            
                            tAbout.setVisible (false);
                            aboutList.setVisible (false);
                            backAbout.setVisible (false);
                               
                                
                        }
                });
                backTransfer.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                                
                        	   sTrans.setVisible (true);
                            btnfTransactions.setVisible (true);
                            sLogout.setVisible (true);
                            logout.setVisible (true);
                            sAbout.setVisible (true);
                            btnfAbout.setVisible (true);
                            sTransfer.setVisible (true);
                            btnfTransfer.setVisible (true);
                            
                            friendUp.setVisible (false);
                            friendList.setVisible (false);
                            friendList.setText("");
                            friendDown.setVisible (false);
                            friendDown.setText("");
                            searchF.setVisible (false);
                            searchF.setText("");
                            giveFriend.setVisible (false);
                            giveFriend.setText("");
                            sSearch.setVisible (false);
                            sendM.setVisible (false);
                            descS.setVisible (false);
                            descS.setText("");
                            bannerTop.setVisible (false);
                            bannerTop2.setVisible (false);
                            setSend.setVisible (false);
                            backTransfer.setVisible (false);
                            confirmS.setText("");
                            confirmS.setVisible (false);
                            sConfirm.setVisible (false);
                            btnConfirm.setVisible (false);
                                
                        }
                });

                sTransfer.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                                sTrans.setVisible (false);
                                btnfTransactions.setVisible (false);
                                logout.setVisible (false);
                                sLogout.setVisible (false);
                                sAbout.setVisible (false);
                                btnfAbout.setVisible (false);
                                sTransfer.setVisible (false);
                                btnfTransfer.setVisible (false);
                                friendUp.setVisible (true);
                                friendList.setVisible (true);
                                friendDown.setVisible (true);
                                searchF.setVisible (true);
                                giveFriend.setVisible (true);
                                sSearch.setVisible(true);
                                sendM.setVisible(true);
                                descS.setVisible(true);
                                bannerTop.setVisible(true);
                                bannerTop2.setVisible(true);
                                setSend.setVisible(true);
                                backTransfer.setVisible (true);
                                
                                try 
                                {
                                        friendPrint();
                                } 
                                catch (IOException e1) 
                                {
                                        e1.printStackTrace();
                                }
                        }
                });

        }

        //Test: static int a = 0;
        public static void display2 ()
        {       
        		    frame.add (bannerTop2);
                frame.add (bannerTop);
                frame.add (welcome);
                frame.add (bankNam);
                frame.add (balance);
                frame.add (bal);
                frame.add (backTransaction);   
                frame.add (backTransfer);
                
                frame.add (sTransfer);
                frame.add (sAbout);
                frame.add (tAbout);
                frame.add (aboutList);
                frame.add (backAbout);
                frame.add (logout);
                frame.add (sTrans);

                frame.add (btnfTransfer);
                frame.add (btnfAbout);
                frame.add (sLogout);
                frame.add (btnfTransactions);

                frame.add (friendUp);
                frame.add (friendList);
                frame.add (searchF);
                frame.add (giveFriend);
                frame.add (confirmS);
                
                frame.add (sSearch);
                frame.add (sendM);
                frame.add (descS);
                frame.add (setSend);
                frame.add (sConfirm);
                frame.add (btnConfirm);
                
                frame.add (sTransferList);
                frame.add (transferList);             
                frame.add (background2);
        }       


        public static void display ()
        {
                // Displaying all the objects on the Jframe

                // Create Account page 2
                frame.add (cardNum);
                frame.add (expmm);
                frame.add (expyy);
                frame.add (securityNum);

                frame.add (scardNum);
                frame.add (sexpmm);
                frame.add (sexpyy);
                frame.add (ssecurityNum);
                frame.add (createUserC);

                // Create Account
                frame.add (back1);
                frame.add (cfirstnam);
                frame.add (clastnam);
                frame.add (email);
                frame.add (cPass);
                frame.add (cRetypePass);
                frame.add (birthdd);
                frame.add (birthmm);
                frame.add (birthyy);
                frame.add (gender);
                frame.add (cGen);
                frame.add (scaptcha);
                frame.add (captchaBox);
                frame.add (captcha);
                frame.add (createUserB);
                frame.add (scaptcha);

                frame.add (sfirstnam);
                frame.add (slastnam);
                frame.add (semail);
                frame.add (sPass);
                frame.add (sRetypePass);
                frame.add (sbirthdd);
                frame.add (sbirthmm);
                frame.add (sbirthyy);
                frame.add (sgender);
                //

                // Login
                frame.add (luser);
                frame.add (lpass);
                frame.add (username);
                frame.add (password);
                frame.add (UIcon);
                frame.add (login);
                frame.add (createUserA);
                frame.add (background);

        }


        public static void mouse ()
        {
                login.addMouseListener (new MouseAdapter ()
                {

                        public void mouseClicked (MouseEvent e)
                        {

                               
                                int uCount = 0;
                                boolean open = false;
                                try
                                {

                                        userCount (uCount); // gets the number of users so that userLogin() understands how many array elements there are

                                        if (userLogin (open) == true)
                                        {
                                                luser.setVisible (false);
                                                username.setVisible (false);
                                                lpass.setVisible (false);
                                                password.setVisible (false);
                                                UIcon.setVisible (false);
                                                login.setVisible (false);
                                                createUserA.setVisible (false);
                                                
                                                obj2 ();
                                                xy2 ();
                                                mouse2 ();
                                                display2 ();

                                                try
                                                {
                                                        giveGift ();
                                                        realMoney();
                                                        showBal(fpmoney);
                                                        bal.setText("$" + (Integer.parseInt(showBal(fpmoney)) + balnum));
                                                }
                                                catch (IOException e1)
                                                {
                                                        e1.printStackTrace ();
                                                }
                                        }
                                        else if (userLogin (open) == false)
                                        {
                                                JOptionPane.showMessageDialog (null, "Invalid Email or Password");
                                        }

                                }
                                catch (IOException e1)
                                {
                                        e1.printStackTrace ();
                                }


                        }
                }
                                );

                createUserA.addMouseListener (new MouseAdapter ()
                {
                        public void mouseClicked (MouseEvent e)
                        {
                                luser.setVisible (false);

                                username.setText ("");
                                username.setVisible (false);

                                lpass.setVisible (false);

                                password.setText ("");
                                password.setVisible (false);

                                UIcon.setVisible (false);
                                login.setVisible (false);
                                createUserA.setVisible (false);

                                newUser ();
                        }
                }
                                );
        }


        public static void newUser ()
        {
                back1.setVisible (true);
                cfirstnam.setVisible (true);
                clastnam.setVisible (true);
                email.setVisible (true);
                cPass.setVisible (true);
                cRetypePass.setVisible (true);
                birthdd.setVisible (true);
                birthmm.setVisible (true);
                birthyy.setVisible (true);
                gender.setVisible (true);
                cGen.setVisible (true);
                captcha.setVisible (true);
                captcha.setText (captchaKey);
                captcha.setText ("");
                captchaBox.setVisible (true);
                createUserB.setVisible (true);

                sfirstnam.setVisible (true);
                slastnam.setVisible (true);
                semail.setVisible (true);
                sPass.setVisible (true);
                sRetypePass.setVisible (true);
                sbirthdd.setVisible (true);
                sbirthmm.setVisible (true);
                sbirthyy.setVisible (true);
                sgender.setVisible (true);
                scaptcha.setVisible (true);

        }


        public static void login ()
        {
                cfirstnam.setVisible (false);
                cfirstnam.setText ("");
                sfirstnam.setForeground (Color.BLACK);
                clastnam.setVisible (false);
                clastnam.setText ("");
                slastnam.setForeground (Color.BLACK);
                email.setVisible (false);
                email.setText ("");
                semail.setForeground (Color.BLACK);
                cPass.setVisible (false);
                cPass.setText ("");
                sPass.setForeground (Color.BLACK);
                cRetypePass.setVisible (false);
                cRetypePass.setText ("");
                sRetypePass.setForeground (Color.BLACK);
                birthdd.setVisible (false);
                birthdd.setText ("");
                sbirthdd.setForeground (Color.BLACK);
                birthmm.setVisible (false);
                birthmm.setText ("");
                sbirthmm.setForeground (Color.BLACK);
                birthyy.setVisible (false);
                birthyy.setText ("");
                sbirthyy.setForeground (Color.BLACK);
                gender.setVisible (false);
                gender.setText ("");
                sgender.setForeground (Color.BLACK);
                cGen.setVisible (false);
                //cGen.setText (captchaGen (space (captchaKey)));
                captcha.setVisible (false);
                captcha.setText ("");
                scaptcha.setForeground (Color.BLACK);
                captchaBox.setVisible (false);
                createUserB.setVisible (false);

                sfirstnam.setVisible (false);
                slastnam.setVisible (false);
                semail.setVisible (false);
                sPass.setVisible (false);
                sRetypePass.setVisible (false);
                sbirthdd.setVisible (false);
                sbirthmm.setVisible (false);
                sbirthyy.setVisible (false);
                sgender.setVisible (false);
                scaptcha.setVisible (false);

                luser.setVisible (true);
                username.setText ("");
                username.setVisible (true);
                lpass.setVisible (true);
                password.setText ("");
                password.setVisible (true);
                UIcon.setVisible (true);
                login.setVisible (true);
                createUserA.setVisible (true);

                cardNum.setVisible (false);
                cardNum.setText ("");
                expmm.setVisible (false);
                expmm.setText ("");
                expyy.setVisible (false);
                expyy.setText ("");
                createUserC.setVisible (false);
                securityNum.setVisible (false);
                securityNum.setText ("");
                scardNum.setVisible (false);
                scardNum.setForeground (Color.BLACK);
                sexpmm.setVisible (false);
                sexpmm.setForeground (Color.BLACK);
                sexpyy.setVisible (false);
                sexpyy.setForeground (Color.BLACK);
                sexpmm.setVisible (false);
                sexpmm.setForeground (Color.BLACK);
                sexpyy.setVisible (false);
                sexpyy.setForeground (Color.BLACK);
                ssecurityNum.setVisible (false);
                ssecurityNum.setForeground (Color.BLACK);
        }


        public static void cUser2 ()
        {
                cfirstnam.setVisible (false);
                clastnam.setVisible (false);
                email.setVisible (false);
                cPass.setVisible (false);
                cRetypePass.setVisible (false);
                birthdd.setVisible (false);
                birthmm.setVisible (false);
                birthyy.setVisible (false);
                gender.setVisible (false);
                cGen.setVisible (false);
                captcha.setVisible (false);
                captchaBox.setVisible (false);
                createUserB.setVisible (false);

                sfirstnam.setVisible (false);
                slastnam.setVisible (false);
                semail.setVisible (false);
                sPass.setVisible (false);
                sRetypePass.setVisible (false);
                sbirthdd.setVisible (false);
                sbirthmm.setVisible (false);
                sbirthyy.setVisible (false);
                sgender.setVisible (false);
                scaptcha.setVisible (false);

                cardNum.setVisible (true);
                expmm.setVisible (true);
                expyy.setVisible (true);
                createUserC.setVisible (true);
                securityNum.setVisible (true);
                scardNum.setVisible (true);
                sexpmm.setVisible (true);
                sexpyy.setVisible (true);
                sexpmm.setVisible (true);
                sexpyy.setVisible (true);
                ssecurityNum.setVisible (true);

        }


        public void actionPerformed (ActionEvent e)
        {

                String a, b, pass = cPass.getText ();
                a = space (captchaKey);
                b = captcha.getText ();

                int uCount = 0;
                boolean openA = false, openB = false, openC = false, openD = false, openS = false;
                try
                {
                        userCount (uCount);
                }
                catch (IOException e2)
                {
                        e2.printStackTrace ();
                }

                boolean m = false, n = false, c = false, g = false, exp = false;

                if (e.getSource () == back1)
                {
                        back1.setVisible (false);
                        cfirstnam.setVisible (false);
                        cfirstnam.setText ("");
                        sfirstnam.setForeground (Color.BLACK);
                        clastnam.setVisible (false);
                        clastnam.setText ("");
                        slastnam.setForeground (Color.BLACK);
                        email.setVisible (false);
                        email.setText ("");
                        semail.setForeground (Color.BLACK);
                        cPass.setVisible (false);
                        cPass.setText ("");
                        sPass.setForeground (Color.BLACK);
                        cRetypePass.setVisible (false);
                        cRetypePass.setText ("");
                        sRetypePass.setForeground (Color.BLACK);
                        birthdd.setVisible (false);
                        birthdd.setText ("");
                        sbirthdd.setForeground (Color.BLACK);
                        birthmm.setVisible (false);
                        birthmm.setText ("");
                        sbirthmm.setForeground (Color.BLACK);
                        birthyy.setVisible (false);
                        birthyy.setText ("");
                        sbirthyy.setForeground (Color.BLACK);
                        gender.setVisible (false);
                        gender.setText ("");
                        sgender.setForeground (Color.BLACK);
                        cGen.setVisible (false);
                        //cGen.setText (captchaGen (space (captchaKey)));
                        captcha.setVisible (false);
                        captcha.setText ("");
                        scaptcha.setForeground (Color.BLACK);
                        captchaBox.setVisible (false);
                        createUserB.setVisible (false);

                        sfirstnam.setVisible (false);
                        slastnam.setVisible (false);
                        semail.setVisible (false);
                        sPass.setVisible (false);
                        sRetypePass.setVisible (false);
                        sbirthdd.setVisible (false);
                        sbirthmm.setVisible (false);
                        sbirthyy.setVisible (false);
                        sgender.setVisible (false);
                        scaptcha.setVisible (false);

                        luser.setVisible (true);
                        username.setText ("");
                        username.setVisible (true);
                        lpass.setVisible (true);
                        password.setText ("");
                        password.setVisible (true);
                        UIcon.setVisible (true);
                        login.setVisible (true);
                        createUserA.setVisible (true);

                        cardNum.setVisible (false);
                        cardNum.setText ("");
                        expmm.setVisible (false);
                        expmm.setText ("");
                        expyy.setVisible (false);
                        expyy.setText ("");
                        createUserC.setVisible (false);
                        securityNum.setVisible (false);
                        securityNum.setText ("");
                        scardNum.setVisible (false);
                        scardNum.setForeground (Color.BLACK);
                        sexpmm.setVisible (false);
                        sexpmm.setForeground (Color.BLACK);
                        sexpyy.setVisible (false);
                        sexpyy.setForeground (Color.BLACK);
                        sexpmm.setVisible (false);
                        sexpmm.setForeground (Color.BLACK);
                        sexpyy.setVisible (false);
                        sexpyy.setForeground (Color.BLACK);
                        ssecurityNum.setVisible (false);
                        ssecurityNum.setForeground (Color.BLACK);
                }

                try
                {
                        if (e.getSource () == createUserB && b.equals (a) && checkNam (n) == true && mail (m) == true && (cPass.getText ().length () >= 6 && cPass.getText ().length () <= 24) && cPass.getText ().equals (cRetypePass.getText ()) && checkBirth (c) == true && checkGender (g) == true && sameMail (openA) == false && sameCard (openC) == false)
                        {
                                captchaKey = "";
                                back1.setVisible (false);
                                cUser2 ();
                        }

                        else if (e.getSource () == createUserB && (!b.equals (a) || checkNam (n) != true || mail (m) != true || !(cPass.getText ().length () >= 6 || cPass.getText ().length () <= 24) || !cRetypePass.getText ().equals (cPass.getText ()) || checkBirth (c) != true || checkGender (g) != true && sameMail (openA) != false && sameCard (openC) != false))
                        {

                                if (!b.equals (a))
                                {
                                        scaptcha.setForeground (Color.RED);
                                }
                                else
                                {
                                        scaptcha.setForeground (Color.BLACK);
                                }

                                if (sameMail (openA) != false)
                                {
                                        semail.setText ("Email: This email is already registered");
                                        semail.setForeground (Color.RED);
                                }
                                else
                                {
                                        semail.setText ("Email:");
                                        semail.setForeground (Color.BLACK);
                                }


                                if (checkNam (n) == false)
                                {
                                        sfirstnam.setForeground (Color.RED);
                                        slastnam.setForeground (Color.RED);
                                }
                                else
                                {
                                        sfirstnam.setForeground (Color.BLACK);
                                        slastnam.setForeground (Color.BLACK);
                                }
                                if (mail (m) == false)
                                {
                                        semail.setForeground (Color.RED);
                                }

                                if (cPass.getText ().length () < 6 && samePass (openB) == false)
                                {
                                        sPass.setForeground (Color.RED);
                                }
                                else if (cPass.getText ().length () >= 6 && samePass (openB) == false)
                                {
                                        sPass.setForeground (Color.BLACK);
                                }

                                if (cRetypePass.getText ().length () < 6)
                                {
                                        sRetypePass.setForeground (Color.RED);
                                }
                                else if (cRetypePass.getText ().length () >= 6 && cRetypePass.getText ().equals (cPass.getText ()))
                                {
                                        sRetypePass.setForeground (Color.BLACK);
                                }
                                else if (!cRetypePass.getText ().equals (cPass.getText ()))
                                {
                                        sRetypePass.setForeground (Color.RED);
                                }

                                try
                                {
                                        if (checkBirth (c) == false)
                                        {
                                                sbirthdd.setForeground (Color.RED);
                                                sbirthmm.setForeground (Color.RED);
                                                sbirthyy.setForeground (Color.RED);
                                        }
                                        else
                                        {
                                                sbirthdd.setForeground (Color.BLACK);
                                                sbirthmm.setForeground (Color.BLACK);
                                                sbirthyy.setForeground (Color.BLACK);
                                        }

                                }

                                catch (NumberFormatException nfe)
                                {
                                        sbirthdd.setForeground (Color.RED);
                                        sbirthmm.setForeground (Color.RED);
                                        sbirthyy.setForeground (Color.RED);
                                }

                                if (checkGender (g) == false)
                                {
                                        sgender.setForeground (Color.RED);
                                }
                                else
                                {
                                        sgender.setForeground (Color.BLACK);
                                }


                        }
                }
                catch (IOException e2)
                {

                        e2.printStackTrace ();
                }


                try
                {
                        if (e.getSource () == createUserC && cardNum.getText ().length () == 16 && expDate (exp) == true && securityNum.getText ().length () == 3 && sameCard (openC) == false && sameSecnum (openD) == false)
                        {
                                try
                                {
                                        EcreditNum (cardNum.getText ());
                                        getInfo ();
                                        login ();
                                }
                                catch (IOException e1)
                                {
                                        e1.printStackTrace ();
                                }

                        }
                }
                catch (IOException e2)
                {
                        e2.printStackTrace ();
                }


                try
                {
                        if (e.getSource () == createUserC && (cardNum.getText ().length () != 16 || cardNum.getText ().length () == 0 || expDate (exp) == false || securityNum.getText ().length () < 3 || securityNum.getText ().length () > 3 || sameCard (openC)) != false || sameSecnum (openD) != false)
                        {


                                try
                                {

                                        if (cardNum.getText ().length () != 16)
                                        {
                                                scardNum.setForeground (Color.RED);
                                        }
                                        else if (cardNum.getText ().length () == 16)
                                        {
                                                scardNum.setForeground (Color.BLACK);
                                        }
                                        else if (cardNum.getText ().equals (""))
                                        {
                                                scardNum.setForeground (Color.RED);
                                        }

                                        if (sameCard (openC) != false)
                                        {
                                                scardNum.setText ("Card Number: Please use a different card");
                                                scardNum.setForeground (Color.RED);
                                        }
                                        else
                                        {
                                                scardNum.setText ("Card Number:");
                                        }


                                }

                                catch (NumberFormatException nfe)
                                {
                                        scardNum.setForeground (Color.RED);
                                }
                                catch (IOException e1)
                                {
                                        e1.printStackTrace ();
                                }


                                try
                                {

                                        if (expDate (exp) == false)
                                        {
                                                sexpmm.setForeground (Color.RED);
                                                sexpyy.setForeground (Color.RED);
                                        }
                                        else if (expDate (exp) == true)
                                        {
                                                sexpmm.setForeground (Color.BLACK);
                                                sexpyy.setForeground (Color.BLACK);
                                        }
                                        else if (expmm.getText ().equals (""))
                                        {
                                                sexpmm.setForeground (Color.RED);
                                        }
                                        else if (expyy.getText ().equals (""))
                                        {
                                                sexpyy.setForeground (Color.RED);
                                        }

                                        if (sameSecnum (openD) != false)
                                        {
                                                ssecurityNum.setForeground (Color.RED);
                                        }
                                        else
                                        {
                                                ssecurityNum.setForeground (Color.BLACK);
                                        }




                                }
                                catch (NumberFormatException nfe)
                                {
                                        sexpmm.setForeground (Color.RED);
                                        sexpyy.setForeground (Color.RED);
                                }

                                try
                                {

                                        if (securityNum.getText ().length () < 3)
                                        {
                                                ssecurityNum.setForeground (Color.RED);
                                        }
                                        else if (securityNum.getText ().equals (""))
                                        {
                                                ssecurityNum.setForeground (Color.RED);
                                        }
                                        else if (securityNum.getText ().length () == 3)
                                        {
                                                ssecurityNum.setForeground (Color.RED);
                                        }

                                        if (sameSecnum (openD) != false)
                                        {
                                                ssecurityNum.setForeground (Color.RED);
                                        }
                                        else
                                        {
                                                ssecurityNum.setForeground (Color.RED);
                                        }

                                }
                                catch (NumberFormatException nfe)
                                {
                                        ssecurityNum.setForeground (Color.RED);
                                }

                        }
                }
                catch (IOException e1)
                {

                        e1.printStackTrace ();
                }
        }


        public static boolean expDate (boolean check)
        {

                try
                {
                        int mm = Integer.parseInt (expmm.getText ()), yy = Integer.parseInt (expyy.getText ());

                        if ((mm >= 1 && mm <= 12) && (yy >= 0 && yy <= 2054))
                        {
                                check = true;
                        }

                        else
                        {
                                check = false;
                        }

                }
                catch (NumberFormatException nfe)
                {
                        // Do Nothing
                }


                return check;
        }


        static String credit = "";
        public static void EcreditNum (String card)
        {

                String fill = "";
                int ctr = 0;

                for (int a = 0 ; a < card.length () ; a++)
                {
                        char n = card.charAt (a);
                        ctr++;

                        fill = fill + n;

                        if (ctr == 4 && a != card.length () - 1)
                        {
                                fill = fill + "-";
                                ctr = 0;
                        }
                }

                card = fill;
                String num = fill, s[];
                int check = 0;
                for (int a = 0 ; a < num.length () ; a++)
                {
                        s = card.split ("-");

                        String p1 = s [0], p2 = s [1], p3 = s [2], p4 = s [3];

                        if (p1.length () == 4)
                        {
                                check++;
                        }
                        if (p1.length () != 4)
                        {
                                check--;
                        }

                        if (p2.length () == 4)
                        {
                                check++;
                        }
                        if (p2.length () != 4)
                        {
                                check--;
                        }

                        if (p3.length () == 4)
                        {
                                check++;
                        }
                        if (p3.length () != 4)
                        {
                                check--;
                        }

                        if (p4.length () == 4)
                        {
                                check++;
                        }
                        if (p4.length () != 4)
                        {
                                check--;
                        }

                        if (check == 4)
                        {
                                num = Encrypt (p1) + "-" + Encrypt (p2) + "-" + Encrypt (p3) + "-" + Encrypt (p4);
                                credit = num;
                        }
                }

        }


        public static String DcreditNum (String card)
        {

                String num = card, s[];
                int check = 0;

                for (int a = 0 ; a < num.length () ; a++)
                {
                        s = card.split ("-");

                        String p1 = s [0], p2 = s [1], p3 = s [2], p4 = s [3];

                        if (p1.length () == 4)
                        {
                                check++;
                        }
                        if (p1.length () != 4)
                        {
                                check--;
                        }

                        if (p2.length () == 4)
                        {
                                check++;
                        }
                        if (p2.length () != 4)
                        {
                                check--;
                        }

                        if (p3.length () == 4)
                        {
                                check++;
                        }
                        if (p3.length () != 4)
                        {
                                check--;
                        }

                        if (p4.length () == 4)
                        {
                                check++;
                        }
                        if (p4.length () != 4)
                        {
                                check--;
                        }

                        if (check == 4)
                        {
                                num = Decrypt (p1) + Decrypt (p2) + Decrypt (p3) + Decrypt (p4);
                        }
                }
                credit = num;
                return num;
        }


        public static boolean checkBirth (boolean check)
        {

                int dd = Integer.parseInt (birthdd.getText ()), mm = Integer.parseInt (birthmm.getText ()), yy = Integer.parseInt (birthyy.getText ());

                if ((dd >= 1 && dd <= 31) && (mm >= 1 && mm <= 12) && (yy >= 0 && yy <= 2054))
                {
                        check = true;
                }

                else
                {
                        check = false;
                }

                return check;

        }


        public static boolean checkNam (boolean check)
        {
                if (cfirstnam.getText ().length () >= 2 && clastnam.getText ().length () >= 2)
                {
                        if (cfirstnam.getText ().equals (space (cfirstnam.getText ())) && clastnam.getText ().equals (space (clastnam.getText ())))
                        {
                                check = true;
                        }
                        else
                        {
                                check = false;
                        }

                }
                return check;
        }


        static String caught = "";
        static String w = "";

        public static String Encrypt (String e)
        {

                caught = e;

                String pass = "";
                for (int a = 0 ; a < e.length () ; a++)
                {
                        char l = e.charAt (a);
                        l += 2;
                        pass = pass + l;

                }

                w = pass;
                return pass.toString();

        }


        public static String Decrypt (String e)
        {

                String pass = "";
                for (int a = 0 ; a < e.length () ; a++)
                {
                        char l = e.charAt (a);
                        l -= 2;
                        pass = pass + l;
                }

                e = pass.toString();
                return e;

        }


        public static boolean specialChar (boolean check)
        {
                String special = " !#$%&'()*+,-/:;<=>?[]^_`{|}~";

                for (int a = 0 ; a < cfirstnam.getText ().length () ; a++)
                {
                        char s = special.charAt (a);
                        char fn = cfirstnam.getText ().charAt (a);
                        char ln = clastnam.getText ().charAt (a);
                        char mail = email.getText ().charAt (a);
                        char pass = cPass.getText ().charAt (a);
                        char rPass = cRetypePass.getText ().charAt (a);

                        if (fn == s || ln == s || mail == s || pass == s || rPass == s)
                        {
                                check = true;
                                break;
                        }
                        else if (fn != s || ln != s || mail != s || pass != s || rPass != s)
                        {
                                check = false;
                        }

                }
                return check;
        }


        public static boolean mail (boolean check)
        {
                try
                {
                        String line, s[];

                        for (int a = 0 ; a < email.getText ().length () - 1 ; a++)
                        {
                                line = email.getText ();
                                s = line.split ("@");

                                String part1 = s [0];
                                String part2 = s [1];

                                if (part1.length () <= 24)
                                {
                                        if (part1.equals (" "))
                                        {
                                                check = false;
                                        }
                                        if (part2.equals ("gmail.com") || part2.equals ("Hotmail.com") || part2.equals ("Outlook.com") || part2.equals ("pdsb.net") || part2.equals ("mail.com") || part2.equals ("yahoo.com"))
                                        {
                                                check = true;
                                        }
                                        else if (part2.equals (" "))
                                        {
                                                check = false;
                                        }
                                        else
                                        {
                                                check = false;
                                        }
                                }
                                else
                                {
                                        check = false;
                                }
                        }

                }
                catch (ArrayIndexOutOfBoundsException aiobe)
                {
                        // Do nothing
                }
                return check;


        }


        public static boolean checkGender (boolean check)
        {

                if (gender.getText ().equalsIgnoreCase ("Male") || gender.getText ().equalsIgnoreCase ("Female") || gender.getText ().equalsIgnoreCase ("Other"))
                {
                        check = true;
                }
                else
                {
                        check = false;
                }
                return check;

        }

        
        public static void getInfo () throws IOException
        {       
                PrintWriter ofile = new PrintWriter (new FileWriter (("userInfo.txt"), true));
                PrintWriter out = new PrintWriter (ofile);

                PrintWriter ofile2 = new PrintWriter (new FileWriter (("userCtr.txt"), true));
                PrintWriter out2 = new PrintWriter (ofile2);

                out2.print (1 + ",");
                out2.close ();
                ofile2.close();

                String info = (Encrypt (cfirstnam.getText ()) + ", " + Encrypt (clastnam.getText ()) + ", " + Encrypt (email.getText ()) + ", " + Encrypt (cPass.getText ()) + ", " + Encrypt (birthdd.getText ()) + ", " + Encrypt (birthmm.getText ()) + ", " + Encrypt (birthyy.getText ()) + ", " + Encrypt (gender.getText ()) + ", " + credit + ", " + Encrypt (expmm.getText ()) + ", " + Encrypt (expyy.getText ()) + ", " + Encrypt (securityNum.getText ()));
                out.print (info);
                out.println ();
                out.close ();
                ofile.close();
        }       


        public static int userCount (int count) throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userCtr.txt");
                BufferedReader in = new BufferedReader (file);

                String line = null;
                String s[] = null;
                int sum = 0;

                for (int a = 0 ; a < 1 ; a++)
                {
                        line = in.readLine ();
                }

                try
                {
                        for (int a = 0 ; a < line.length () ; a++)
                        {
                                s = line.split (",");
                                int one = Integer.parseInt (s [a]);
                                sum = sum + one;
                        }
                }
                catch (ArrayIndexOutOfBoundsException  /*NullPointerException*/ane)
                {
                        // Do nothing
                }

                userPop = sum;
                count = sum;

                file.close();
                return count;
        }
 
        public static boolean userLogin (boolean check) throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);
                
                int open = 0;
                userCount (open);

                String seg, s[];
                String email[] = new String [userPop];
                String pass[] = new String [userPop];

                for (int a = 0 ; a < userPop ; a++)
                {
                        seg = in.readLine ();
                        s = seg.split (", ");

                        email [a] = s [2];
                        pass [a] = s [3];

                        if (username.getText ().equals (Decrypt (email [a])) && password.getText ().equals (Decrypt (pass [a])))
                        {
                                check = true;
                                break;
                        }
                        else
                        {
                                check = false;
                        }
                }
                return check;
        }

        public static boolean sameMail (boolean check) throws IOException
        {

                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);

                String seg, s[];
                String uemail[] = new String [userPop];

                for (int a = 0 ; a < userPop ; a++)
                {
                        seg = in.readLine ();
                        s = seg.split (", ");

                        uemail [a] = s [2];

                }

                for (int a = 0 ; a < userPop ; a++)
                {
                        if (email.getText ().equals (Decrypt (uemail [a])))
                        {
                                check = true;
                                break;
                        }
                        else
                        {
                                check = false;
                        }
                }

                return check;
        }


        public static boolean samePass (boolean check) throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);

                String seg, s[];
                String upass[] = new String [userPop];

                for (int a = 0 ; a < userPop ; a++)
                {
                        seg = in.readLine ();
                        s = seg.split (", ");

                        upass [a] = s [3];

                        if (cPass.getText ().equals (Decrypt (upass [a])))
                        {
                                check = true;
                                break;
                        }
                        else
                        {
                                check = false;
                        }
                }

                return check;

        }


        public static boolean sameCard (boolean check) throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);

                String seg, s[];
                String ucard[] = new String [userPop];

                for (int a = 0 ; a < userPop ; a++)
                {
                        seg = in.readLine ();
                        s = seg.split (", ");

                        ucard [a] = s [8];

                        if (cardNum.getText ().equals (DcreditNum (ucard [a])))
                        {
                                check = true;
                                break;
                        }
                        else
                        {
                                check = false;
                        }
                }

                return check;

        }
        
        public static boolean sameSecnum (boolean check) throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);

                String seg, s[];
                String uSecnum[] = new String [userPop];

                for (int a = 0 ; a < userPop ; a++)
                {
                        seg = in.readLine ();
                        s = seg.split (", ");

                        uSecnum [a] = s [11];

                        if (securityNum.getText ().equals (Decrypt (uSecnum [a])))
                        {
                                check = true;
                                break;
                        }
                        else
                        {
                                check = false;
                        }
                }

                return check;
        }

        public static String getfullnam (String fullname) throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);

                int open = 0;
                userCount (open);
                fullname = "";
                int hold = 0;
                boolean confirm = false;

                String seg, s[];
                String fnam[] = new String [userPop], lnam[] = new String [userPop], email[] = new String [userPop], pass[] = new String [userPop];

                for (int a = 0 ; a < userPop ; a++)
                {

                        seg = in.readLine ();
                        s = seg.split (", ");

                        fnam [a] = s [0];
                        lnam [a] = s [1];
                        email [a] = s [2];
                        pass [a] = s [3];

                        if (username.getText ().equals (Decrypt (email [a])) && password.getText ().equals (Decrypt (pass [a])))
                        {
                                confirm = true;
                                hold = a;
                                break;
                        }
                        else
                        {
                                confirm = false;
                        }
                }

                file.close ();

                if (confirm == true)
                {
                        fullname = Decrypt (fnam [hold]) + " " + Decrypt (lnam [hold]);
                }
                else
                {
                        fullname = "User not found";
                }

                return fullname;

        }

        public static String give (String money)
        {
                String num = "";
                int min = 0, max = 5000, range = 0, rand = 0, m = 0;
                range = max - min + 1;

                rand = (int) (Math.random () * range) + min;
                num = String.valueOf (rand);
                money = Encrypt (num);

                return money;
        }


        public static void giveGift () throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);

                PrintWriter file2 = new PrintWriter (new FileWriter (("userBalance.txt"), true));
                PrintWriter out = new PrintWriter (file2);

                PrintWriter file3 = new PrintWriter (new FileWriter (("userBalanceCtr.txt"), true));
                PrintWriter out2 = new PrintWriter (file3);

                int open2 = 0;
                int open = 0;
                balanceCtr(open2);
                userCount (open);
                String money = "";
                userBal = give (money);
                int hold = 0;
                boolean c = false;

                String seg, s[];
                String email[] = new String [userPop], pass[] = new String [userPop];

                for (int a = 0 ; a < userPop ; a++)
                {       
                        seg = in.readLine ();
                        s = seg.split (", ");
                        email [a] = s [2];
                        pass [a] = s [3];

                        if (a <= balPop)
                        {
                                c = false;
                        }
                        else if (username.getText ().equals (Decrypt (email [a])) && password.getText ().equals (Decrypt (pass [a])))
                        {
                                c = true;
                                money = email [a] + ", " + pass [a] + ", " + userBal + ", ";
                                hold = a;
                                break;
                        }
                        else
                        {
                                c = false;
                        }


                }

                file.close ();

                if (c == true)
                {
                        out.print (money);
                        out.println ();
                        out.close ();

                        out2.print (1 + ",");   
                        out2.close();
                        JOptionPane.showMessageDialog (null, " Thank you for creating an account!\n     Since this is your first login\n         a total of $" + "money" + " has\nbeen added to your account balance");
                }
                else
                {
                        //JOptionPane.showMessageDialog (null, "Error while executing function: giveGift\n Hold = " + hold);
                }

                in.close ();

        }

        public static int balanceCtr (int ctr) throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userBalanceCtr.txt");
                BufferedReader in = new BufferedReader (file);

                String seg = null;
                String  s[] = null;
                int hold = 0;

                for (int a = 0; a < 1; a++)
                {
                        seg = in.readLine();
                }

                try 
                {
                        for (int a = 0 ; a < seg.length () ; a++)
                        {       
                                s = seg.split(",");
                                int one = Integer.parseInt(s [a]);
                                hold = hold + one;
                        }       
                }
                catch (ArrayIndexOutOfBoundsException  /*NullPointerException*/ane)
                {
                        // Do nothing
                }

                balPop = hold;
                ctr = hold;
                file.close();
                return ctr;

        }
        
        public static int moneyCtr (int ctr) throws IOException
        {	
        	    BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
            FileReader file = new FileReader ("MoneyCtr.txt");
            BufferedReader in = new BufferedReader (file);

            
            String seg = null;
            String  s[] = null;
            int hold = 0;
            try {
            
            for (int a = 0; a < 1; a++)
            {
                    seg = in.readLine();
            }

            try 
            {
                    for (int a = 0 ; a < seg.length () ; a++)
                    {       
                            s = seg.split(",");
                            int one = Integer.parseInt(s [a]);
                            hold = hold + one;
                    }       
            }
            catch (ArrayIndexOutOfBoundsException  /*NullPointerException*/ane)
            {
                    // Do nothing
            }
            
            }
            catch (NullPointerException npe)
            {
            	
            }
            transPop = hold;
            ctr = hold;
            file.close();
            
            
            return ctr;
        }	

        public static String showBal (String display) throws IOException
        {

                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userBalance.txt");
                BufferedReader in = new BufferedReader (file);

                int bal = 0;
                balanceCtr(bal);
                String seg = null, s[], email[] = new String [balPop], pass[] = new String [balPop], money[] = new String [balPop];
                int hold = 1;
                boolean set = false;

                for (int a = 0 ; a < balPop; a++)
                {       
                        seg = in.readLine();
                        s = seg.split(", ");

                        email[a] = s[0];
                        pass[a] = s[1];
                        money[a] = s[2];

                        if (username.getText ().equals (Decrypt (email[a])) && password.getText ().equals (Decrypt (pass[a])))
                        {       
                                set = true;
                                hold = a;
                                break;
                        }       
                        else
                        {
                                set = false;
                        }
                }       

                file.close();
                
                display = Decrypt(money [hold]);
                in.close();
                //balnum = Integer.parseInt(display);
                //JOptionPane.showMessageDialog(null, balnum + "!!!");
                //display = String.valueOf(balnum);
                return display;
        }
        
        
        public static void friendPrint () throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);

                int open = 0;
                userCount(open);
                String display = "";
                String seg = null, s[], fnam[] = new String [userPop], lnam[] = new String [userPop], email[] = new String [userPop], pass[] = new String [userPop];

                for (int a = 0; a < userPop ; a++)
                {
                        seg = in.readLine();
                        s = seg.split(", ");
                        fnam[a] = s[0];
                        lnam[a] = s[1];
                        email[a] = s[2];
                        pass[a] = s[3];

                        if (username.getText ().equals (Decrypt (email[a])) && password.getText ().equals (Decrypt (pass[a])))
                        {       
                                display = display + "";
                        }       
                        else
                        {       
                                display = display + "<html><div style='text-align: center;'>" + Decrypt(fnam[a]) + ", " + Decrypt(lnam[a]) + "<br> " + "<html>";
                        }       
                }

                friendList.setText(display);


        }
        static String iChooseYou = "null";
        public static void friendSearch (String select) throws IOException
        {
                BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
                FileReader file = new FileReader ("userInfo.txt");
                BufferedReader in = new BufferedReader (file);

                int open = 0;
                userCount(open);
                String display = "";
                String seg = null, s[], fnam[] = new String [userPop], lnam[] = new String [userPop], email[] = new String [userPop], pass[] = new String [userPop];

                for (int a = 0; a < userPop ; a++)
                {
                        
                        seg = in.readLine();
                        s = seg.split(", ");
                        fnam[a] = s[0];
                        lnam[a] = s[1];
                        email[a] = s[2];
                        pass[a] = s[3];
                        
                        if (username.getText ().equals (Decrypt (email[a])) && password.getText ().equals (Decrypt (pass[a])))
                        {       
                                display = display + "";
                        }  
                        
                        else if ((select.equalsIgnoreCase(Decrypt(fnam[a])) || select.equalsIgnoreCase(Decrypt(lnam[a])) || select.equalsIgnoreCase(Decrypt(fnam[a]) + ", " + Decrypt(lnam[a]))))
                        {       
                                display = display + "<html><div style='text-align: center;'>" + "[ " + Decrypt(fnam[a]) + ", " + Decrypt(lnam[a]) + " ]"  + "<br> " + "<html>";
                                friendLocked = Decrypt(fnam[a]) + ", " + Decrypt(lnam[a]);
                                iChooseYou = Decrypt(fnam[a]);
                        }       

                        else
                        {
                                display = display + "<html><div style='text-align: center;'>" + Decrypt(fnam[a]) + ", " + Decrypt(lnam[a]) + "<br> " + "<html>";
                        }
                }
                			friendList.setText(display);
                			
                	
        }
        
        
        public static boolean passSend (boolean check) throws IOException
        {
        	BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
        	FileReader file = new FileReader ("userInfo.txt");
        	BufferedReader in = new BufferedReader (file);

        	String seg, s[];
        	String upass[] = new String [userPop], email[] = new String [userPop];

        	for (int a = 0 ; a < userPop ; a++)
        	{
        		seg = in.readLine ();
        		s = seg.split (", ");

        		upass [a] = s [3];
        		email [a] = s[2];
        		
        		if (confirmS.getText ().equals (Decrypt (upass [a])) && username.getText ().equals (Decrypt (email[a])))
        		{
        			check = true;
        			break;
        		}
        		else
        		{
        			check = false;
        		}
        	}

        	return check;
        	
        }
        
        
        public static void sendMoney () throws IOException
        {	
        		BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
            FileReader fileA = new FileReader ("userInfo.txt");
            BufferedReader in = new BufferedReader (fileA);
            
            PrintWriter fileB = new PrintWriter (new FileWriter (("moneySent.txt"), true));
            PrintWriter out1 = new PrintWriter (fileB);
            
            PrintWriter fileC = new PrintWriter (new FileWriter (("MoneyCtr.txt"), true));
            PrintWriter out2 = new PrintWriter (fileC);
            
            int ctr = 0;
            int open = 0;
            String hold1 = "", hold2 = "";
            
            String seg = null, s[], credit[] = new String [userPop], email[] = new String [userPop], pass[] = new String [userPop], friend [] = new String [userPop], friendMail[] = new String [userPop];
            String email1 = "", money1 = "", email2 = "", money2 = "";
            for (int a = 0; a < userPop; a++)
            {	
            		seg = in.readLine();
            		s = seg.split(", ");
            		
            		credit[a] = s[8];
            		pass[a] = s[3];
            		email[a] = s[2];
            		
            		friend[a] = s[0];
            		friendMail[a] = s[2];
            		
            		if (Decrypt(friend[a]).equals(iChooseYou))
            		{	
            			String neg = String.valueOf((Integer.parseInt(giveFriend.getText()) * -1));
            			email1 = email[a];
            			money1 = Encrypt(neg);
            			
            		}	
            		if (username.getText ().equals (Decrypt (email[a])) && password.getText ().equals (Decrypt (pass[a])))
            		{	
            			email2 = email[a];
            			money2 = Encrypt(giveFriend.getText());
            			
            		}	
            	}	
            		
            		hold1 = email2 + ", " + money1;
            		hold2 = email1 + ", " + money2;
            		
            		if (email1.length() < 3 || email2.length() < 3)
            		{
            			JOptionPane.showMessageDialog(null, "Error! User not found.");
            		}
            		else
            		{
            			out1.print(hold1);
                		out1.println();
                		out1.print(hold2);
                		out1.println();
                		out1.close();
                		
                		out2.print (1 + "," + 1 + ",");   
                		out2.close();
            		}
            		
            		
        }		
        public static void realMoney () throws IOException
        {	
        	    BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
            FileReader fileA = new FileReader ("MoneySent.txt");
            BufferedReader in = new BufferedReader (fileA);
            
            
            int open1 = 0;
            moneyCtr(open1);
            int open2 = 0;
            balanceCtr(open2);
            int sum = 0, total = 0;
            
            String seg, s[];
            String userEmail[] = new String [transPop];
            int userMoney[] = new int [transPop], friendMoney[] = new int [transPop];
            String friendEmail[] = new String [transPop];
            int m = 0;
            
            try {
            
            		for (int a = 0; a < transPop; a++)
            		{
            			
            			seg = in.readLine();
            			s = seg.split(", ");
            			
            			userEmail[a] = s[0];
            			userMoney[a] = Integer.parseInt(Decrypt(s[1]));
            			
            			if (username.getText().equals(Decrypt(userEmail[a])))
            			{
            				sum = sum + userMoney[a];
            			}
            			
            		}
            	
            	  }
            catch (ArrayIndexOutOfBoundsException aiobe)
            {
            		JOptionPane.showMessageDialog(null, "ArrayIndexOutOfBoundsException");
            }
            
            
            //JOptionPane.showMessageDialog(null, sum);
            balnum = sum; 
            
            //fpmoney = String.valueOf(balnum);
            	fileA.close();
        }	
        		
        public static void displayTrans () throws IOException
        {	
        	    BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
            FileReader fileA = new FileReader ("MoneySent.txt");
            BufferedReader in = new BufferedReader (fileA);
            
            
            int open1 = 0;
            moneyCtr(open1);
            int open2 = 0;
            balanceCtr(open2);
            int sum = 0, total = 0;
            
            String seg, s[];
            String userEmail[] = new String [transPop];
            int userMoney[] = new int [transPop], friendMoney[] = new int [transPop];
            String friendEmail[] = new String [transPop];
            int m = 0;
            String display = "";
            
            try {
            
            		for (int a = 0; a < transPop; a++)
            		{
            			
            			seg = in.readLine();
            			s = seg.split(", ");
            			
            			userEmail[a] = s[0];
            			userMoney[a] = Integer.parseInt(Decrypt(s[1]));
            			
            			if (username.getText().equals(Decrypt(userEmail[a])))
            			{
            				
            				sum = sum + userMoney[a];
            				
            				if (sum < 0)
            				{
            					display = "<html><div style='text-align: center;'>" + username.getText() + " has sent " + " $" + (sum * -1) + "<br> " + "<html>";
            				}
            				else if (sum > 0)
            				{
            					display = "<html><div style='text-align: center;'>" + username.getText() + " has been sent " + " $" + sum + "<br> " + "<html>";
            				}
            				
            			}  
            		}
            	
            	  }
            catch (ArrayIndexOutOfBoundsException aiobe)
            {
            		JOptionPane.showMessageDialog(null, "ArrayIndexOutOfBoundsException");
            }
            
            transferList.setText(display);
            
            	fileA.close();
        }	
        public static String about (String info)
        {
        	
         info ="<html><div style='text-align: center;'>" + "•  Created by:" + "<br> " + "- Nathaniel Mitchell-Rhoden " + "<br> "  + "<br> " + "•  Created on:" + "<br> " + "- May 30th, 2018."  + "<br> "  + "<br> " + "•  Released: " + "<br> "  + "- June 18th, 2018." + "<br> "  + "<br> " + "•  Time spent: " + "<br> "  + "- over 400+ hours of work" + "<br> "  + "<br> " + "•  About creation: "  + "<br> " + "- This program was created for the user to be able to create an account using real or fake information so that they can log in and send fake money to other users. " + "<br> "  + "<br> " + "•  Code: " + "<br> " + "- 24 Methods(x, y)\n" + "<br> " + 
         		"	- 19 Functions ()\n" + "<br> "+
         		"\n" + 
         		"	- 2700+ lines of code\n" + "<br> "+
         		"	- 80+ integer variables\n" + "<br> "+
         		"	- 100+ String variables\n" + "<br> "+
         		"	- 20+ char variables\n" + "<br> "+
         		"	- 5+ short variables\n" + "<br> "+
         		"	- 2+ byte variables\n" + "<br> "+
         		"	- 50+ JLabels\n" + "<br> "+
         		"	- 4+ JButtons\n" + "<br> "+
         		"	- 15+ TextBoxes\n" + "<br> "+
         		"	- 3+ Fonts\n" + "<br> "+
         		"	- 5+ JPanels\n" + "<br> "+
         		"" +   "<html>";
         return info;
        }
        public static void main (String[] args)
        {
                new ATM ();    
        } // main method
} // ATM class
