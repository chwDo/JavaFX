/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.Timu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafxapplication1.JavaFXApplication1;

/**
 *
 * @author Administrator
 */
public class Shijuan {
    private Timu []  xz=new Timu[10];
    private Timu []  tk=new Timu[10];
    private Timu []  pd=new Timu[5];
    private Timu []  jd=new Timu[5];   

    /**
     * @return the xz
     */
    public Timu[] getXz() {
        return xz;
    }

    /**
     * @param xz the xz to set
     */
    public void setXz(Timu[] xz) {
        this.xz = xz;
    }

    /**
     * @return the tk
     */
    public Timu[] getTk() {
        return tk;
    }

    /**
     * @param tk the tk to set
     */
    public void setTk(Timu[] tk) {
        this.tk = tk;
    }

    /**
     * @return the pd
     */
    public Timu[] getPd() {
        return pd;
    }

    /**
     * @param pd the pd to set
     */
    public void setPd(Timu[] pd) {
        this.pd = pd;
    }

    /**
     * @return the jd
     */
    public Timu[] getJd() {
        return jd;
    }

    /**
     * @param jd the jd to set
     */
    public void setJd(Timu[] jd) {
        this.jd = jd;
    }
    
    
}