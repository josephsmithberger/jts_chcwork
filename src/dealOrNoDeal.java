   import BreezySwing.*;
   import javax.swing.*;
   import java.util.*;
   import chn.util.*;
   import java.io.*;
   import java.awt.*;

    public class dealOrNoDeal extends GBFrame{
    
    //Declare Instance Variables
    //Static Array of Case Buttons
      JButton[] caseButtons = new JButton[26];
    //Static Array of Remaining Values
      JLabel values[] = new JLabel[26];
   
   //GUI Headers
      private JLabel Title;
      private JLabel RemainingHeader;
      private JLabel Directions;
      private JLabel Cases;
   
   //Deal or No Deal Buttons
      private JLabel offer;
      private JButton Deal;
      private JButton NoDeal;
      public int a=1;
      public int b=1;
      
   //Generate Cases Method
   private int Case[] = new int [27];
   private int used[] = new int [26];
   private boolean found = false;
      private int l = 0;
      private int u = 0;
      private int i = 0;
      private int num = 0;
      private int list[] = new int [26];
      private double offer2 = 0;
   	
   //Opened Cases Array
      private ArrayList<JButton> opened = new ArrayList<JButton>();
   	
   //Game Flow Control
      int control;
   
   //List of All Values
      int[] Values = new int[26];
   	
   //your case value
      int yourcase, bankOffer;
      int yourCaseIndex = -1;
      
   // ArrayList of Integer Objects
      ArrayList<Integer> check = new ArrayList<Integer>();
      
   //Open Control
      boolean canOpen;
      boolean endGame;
      boolean lastmove;
   
      //Constructor for Board Object
       public dealOrNoDeal()
      {	canOpen=true;
         lastmove=false;
         control=1;
         Title = addLabel("Deal Or No Deal!!!",1,4,0,0);
         yourcase=0;
         bankOffer=0;
      	
         Values[0] = 1;
         Values[1] = 1;
         Values[2] = 5;
         Values[3] = 10;
         Values[4] = 25;
         Values[5] = 50;
         Values[6] = 75;
         Values[7] = 100;
         Values[8] = 200;
         Values[9] = 300;
         Values[10] = 400;
         Values[11] = 500;
         Values[12] = 750;
         Values[13] = 1000;
         Values[14] = 5000;
         Values[15] = 10000;
         Values[16] = 25000;
         Values[17] = 50000;
         Values[18] = 75000;
         Values[19] = 100000;
         Values[20] = 200000;
         Values[21] = 300000;
         Values[22] = 400000;
         Values[23] = 500000;
         Values[24] = 750000;
         Values[25] = 1000000;
      	
         
         Deal = addButton("Deal",9,4,1,1);
         NoDeal = addButton("No Deal!",9,5,1,1);
         Directions = addLabel("Pick a Case!!!",11,4,1,1);
      	
      
         for(int x=0; x<26; x++)
         {
            if(a>=14)
            {b=2;
               a=1;}
         
            values[x] = addLabel("$"+(String) Integer.toString(Values[x]),a,b,1,1);
            a++;}
      
         generateCases();
      
         int c=2;
         int d=3;
      
      
         for(int y=0; y<26; y++)
         {
            if(d>=8 && d<=13)
            {c++;
               d=3;}
            
            caseButtons[y] = addButton(""+(y+1),c,d,1,1);
            d++;
         
         }
      	
         uncolorButtons();
      }
   
   
   
   
//***************************************************************************
   
   //Generate the Cases at Random
       public void generateCases()
      {
      
         for (l = 0; l <= 25; l++)
            list[l] = 417; //arbitrary number
      	
         while (u <= 25)
         {
            num = 1+(int)(Math.random()*26);
            for (l = 0; l <= 25; l++)
            {
               if (list[l] == num)
               {
                  found = true;
                  break;
               }
            }
         	
            if (found == false)
            {
               used[u] = num;
               u++;
               for (l = 0; l <= 25; l++)
               {
                  if (list[l] == 417)
                  {
                     list[l] = num;
                     break;
                  }
               }
            }
            found = false;
         }
         
         Case[used[0]-1] = 1;
         Case[used[1]-1] = 1;
         Case[used[2]-1] = 5;
         Case[used[3]-1] = 10;
         Case[used[4]-1] = 25;
         Case[used[5]-1] = 50;
         Case[used[6]-1] = 75;
         Case[used[7]-1] = 100;
         Case[used[8]-1] = 200;
         Case[used[9]-1] = 300;
         Case[used[10]-1] = 400;
         Case[used[11]-1] = 500;
         Case[used[12]-1] = 750;
         Case[used[13]-1] = 1000;
         Case[used[14]-1] = 5000;
         Case[used[15]-1] = 10000;
         Case[used[16]-1] = 25000;
         Case[used[17]-1] = 50000;
         Case[used[18]-1] = 75000;
         Case[used[19]-1] = 100000;
         Case[used[20]-1] = 200000;
         Case[used[21]-1] = 300000;
         Case[used[22]-1] = 400000;
         Case[used[23]-1] = 500000;
         Case[used[24]-1] = 750000;
         Case[used[25]-1] = 1000000;
      
      }
   	
 //***************************************************************************
   	//Button CLicked Method
       public void buttonClicked (JButton buttonObj)
      {
         if(true)
         {
         
            if(control==8 || control==14 || control==19 || control==23 || control==26 || control==28 || control==30 ||control==32)
            {
            
            }
         
         }
       
         if(buttonObj==caseButtons[0])
         {
            casePicked(0);
         }
      	
         if(buttonObj==caseButtons[1])
         {
            casePicked(1);
         }
         if(buttonObj==caseButtons[2])
         {
         
            casePicked(2);
         
         }
         if(buttonObj==caseButtons[3])
         {
            casePicked(3);
         
         }
         if(buttonObj==caseButtons[4])
         {	
            casePicked(4);         
         }
         if(buttonObj==caseButtons[5])
         {
            casePicked(5);         
         }
         if(buttonObj==caseButtons[6])
         {
            casePicked(6);         
         }
         if(buttonObj==caseButtons[7])
         {
            casePicked(7);         		
         }
         if(buttonObj==caseButtons[8])
         {
            casePicked(8);         
         }
         if(buttonObj==caseButtons[9])
         {
            casePicked(9);
         }
         if(buttonObj==caseButtons[10])
         {
            casePicked(10);         
         }
         if(buttonObj==caseButtons[11])
         {
            casePicked(11);         
         }
         if(buttonObj==caseButtons[12])
         {
            casePicked(12);         
         }
      
         if(buttonObj==caseButtons[13])
         {
            casePicked(13);         
         }
      
         if(buttonObj==caseButtons[14])
         {
            casePicked(14);
         }
      
         if(buttonObj==caseButtons[15])
         {
            casePicked(15);         
         }
      
         if(buttonObj==caseButtons[16])
         {
            casePicked(16);
         }
      
         if(buttonObj==caseButtons[17])
         {
            casePicked(17);         
         }
      
         if(buttonObj==caseButtons[18])
         {
            casePicked(18);         
         }
      
         if(buttonObj==caseButtons[19])
         {
            casePicked(19); 
         }
      
         if(buttonObj==caseButtons[20])
         {
            casePicked(20);
         }
      
         if(buttonObj==caseButtons[21])
         {
            casePicked(21);         
         }
      
         if(buttonObj==caseButtons[22])
         {
            casePicked(22);         
         }
      
         if(buttonObj==caseButtons[23])
         {
            casePicked(23);         
         }
      
         if(buttonObj==caseButtons[24])
         {
            casePicked(24);         
         }
      
         if(buttonObj==caseButtons[25])
         {
            casePicked(25);         
         }
      	
         if(buttonObj==Deal)
         {
            if(lastmove)
            {
               Directions.setText("Your case contained: $"+ yourcase);
            }
            else
            {
               if(yourcase < bankOffer)
                  Directions.setText("You made a good deal!! Your case contained: $" + yourcase + " — You won $" + bankOffer);
               else if (yourcase > bankOffer)
                  Directions.setText("You made a bad deal!! Your case contained: $" + yourcase + " — You won $" + bankOffer);
               else
                  Directions.setText("It's a tie! Your case and the offer were both $" + bankOffer);
            }
         		
            canOpen=false;
            endGame=true; 
         	
            if(control==1)
            {
               Directions.setText("Pick a case first.");
               canOpen=true;
               endGame=true;
            }      
         }
      	     	
         if(buttonObj==NoDeal)
         {	
            if(lastmove)
            {
               Directions.setText("Your case contained: $"+ yourcase);
            }
         	else
            if(endGame==true)
            {
               System.exit(0);
            }
            else
            
               uncolorButtons();
            canOpen=true;
         
            if (control==2)
               Directions.setText("Open 6 Cases");
            if (control==9)
               Directions.setText("Open 5 Cases");
            if (control==15)
               Directions.setText("Open 4 Cases");
            if (control==20)
               Directions.setText("Open 3 Cases");
            if (control==24)
               Directions.setText("Open 2 Cases");
            if (control==27)
               Directions.setText("Open 1 Cases");
            if (control==29)
               Directions.setText("Open 1 Cases");
            if (control==31)
               Directions.setText("Open 1 Cases");
         	
         }
      
      			
      }
   	
  	
//***************************************************************************
    
       public void casePicked(int x)
      {
         if (yourCaseIndex == x)
         {Directions.setText("You can't pick your own case.");
            return;
         }
      
         for (int y=0;y<check.size();y++)
         {
            if(check.get(y)==(x))
               return;
         }
      	
      	
      
         if(control==8 || control==14 || control==19 || control==23 || control==26 || control==28 || control==30 ||control==32)
         {
            colorButtons();
            bankOffer();
            canOpen=false;
         }
         else
            if(canOpen==false)
            {
            	
            }
            else
               if(control==1)
               {
                  caseButtons[x].setText("Your Case"); 
                  yourcase=Case[x];
                  yourCaseIndex = x;
                  Directions.setText("Select 6 Cases to Eliminate");
                  opened.add(caseButtons[x]);
                  check.add(x);
                  control=2;
               }
               else
                  if(control==2 || control==3 || control==4 || control==5 ||control==6 || control==7)
                  {
                  
                     if(checkPicked(x))
                        revealValue(x);
                     else 
                        return;
                  	
                  }
                  else
                     if (control==9 || control==10 || control==11 || control==12 || control==13)
                     {
                        if(checkPicked(x))
                           revealValue(x);
                        else 
                           return;
                     }
                     else
                        if (control==15 || control==16 ||control==17 ||control==18)
                        {	
                           if(checkPicked(x))
                              revealValue(x);
                           else 
                              return;
                        }
                        else
                           if(control==20 || control==21 || control==22)
                           {
                              if(checkPicked(x))
                                 revealValue(x);
                              else 
                                 return;
                           }
                           else
                              if(control==24 || control==25)
                              {
                                 if(checkPicked(x))
                                    revealValue(x);
                                 else 
                                    return;
                              }
                              else
                                 if(control==27)
                                 {	
                                    if(checkPicked(x))
                                       revealValue(x);
                                    else 
                                       return;
                                 }
                                 else
                                    if(control==29)
                                    {	
                                       if(checkPicked(x))
                                          revealValue(x);
                                       else 
                                          return;
                                    }
                                    else
                                       if(control==31)
                                       {	
                                          if(checkPicked(x))
                                             revealValue(x);
                                          else 
                                             return;
                                       }
                                       else
                                          if(control==33)
                                          {	
                                             if(checkPicked(x))
                                                revealValue(x);
                                             else 
                                                return;
                                          }
                                          else
                                             if(control==34)
                                             {
                                                Deal.setText("Your Case");
                                                Directions.setText("Which case do you want to walk away with?");
                                                NoDeal.setText("The last remaining case");
                                                lastmove=true;
                                             }
      								
         
      								      
      }
   	
   	
      
      
      
      
//***************************************************************************    
      
       private boolean checkPicked(int x)
      {
         String txt = caseButtons[x].getText();
         if (txt.startsWith("$") || txt.startsWith("Your Case"))
         {
            return false;
         }
         else 
            return true;
      }
   	
   	
//***************************************************************************

       private void uncolorButtons()
      {
         for(int y=0; y<26; y++)
         {caseButtons[y].setBackground(Color.lightGray);
         
         }
      	
         Deal.setBackground(Color.lightGray);
         NoDeal.setBackground(Color.lightGray);
      	
      	
      }
   	
//***************************************************************************   
      
       private void colorButtons()
      {
         for(int y=0; y<26; y++)
         {caseButtons[y].setBackground(Color.RED);
         
         }
      	
         Deal.setBackground(Color.RED);
         NoDeal.setBackground(Color.RED);
      	
      
      }
   
//***************************************************************************
   
       private void revealValue(int x)
      {
         caseButtons[x].setText("$"+(String)Integer.toString(Case[x]));
         // mark as opened so it can't be selected again
         check.add(x);
         removeFromGrid(Case[x]);
         control++;
      }
     
     
//***************************************************************************  
     
       private void removeFromGrid(int x)
      {
         for(int y=0;y<26;y++)
         {
            if(Values[y]==x)
            {values[y].setText("");
               Values[y]=0;
               break;}
         }
      }
   	
//***************************************************************************

       private void bankOffer()
      {
         int sum=0;
         int size=0;
        
         for(int x=0; x<26; x++)
         {
            if(Values[x]>0)
            {size++;
               sum+=Values[x];}
         }
         bankOffer = (size==0) ? 0 : (sum/size);
      	
         Directions.setText("The Banker Has offered: $" + bankOffer);
         doYouAccept();
      	
      }
   	
//***************************************************************************     
      
       public void doYouAccept()
      {
         control++;
      }
   	
      
//*************************************************************************** 
 
       public static void main(String[] args)
      {
         dealOrNoDeal gui = new dealOrNoDeal();
         gui.setSize(800,1000);
         gui.setVisible(true);
         gui.setTitle("DEAL OR NO DEAL!!!");
      } 
   }