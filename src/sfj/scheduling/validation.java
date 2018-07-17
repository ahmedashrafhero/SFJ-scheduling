/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfj.scheduling;

import java.io.IOException;

/**
 *
 * @author Z51
 */
public class validation {
    public boolean negativeNum(int x)
    {
        //JOptionPane.showMessageDialog(null, "you must enter positive value");
        //return x!=0||x!=1||x!=2||x!=3||x!=4||x!=5||x!=6||x!=7||x!=8||x!=9;
        return x<0;
    }
    public boolean negativeNum(float x)
    {
        //JOptionPane.showMessageDialog(null, "you must enter positive value");
        //return x!=0||x!=1||x!=2||x!=3||x!=4||x!=5||x!=6||x!=7||x!=8||x!=9;
        return x<0;
    }
    public boolean isCharacter( String input )
{
    try
    {
      Integer.parseInt( input );
      return false;
    }
    catch( Exception e){
      return true;
    }
}
}
