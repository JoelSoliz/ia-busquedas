/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Windows
 */
public class Estado {

    private int almJ1;
    private int almJ2;
    private int almJ3;
    private String paso;
    
    public Estado(int almJ1, int almJ2, int almJ3){
        this.almJ1 = almJ1;
        this.almJ2 = almJ2;
        this.almJ3 = almJ3;
    }
    
    public Estado(int almJ1, int almJ2, int almJ3, String paso){
        this.almJ1 = almJ1;
        this.almJ2 = almJ2;
        this.almJ3 = almJ3;
        this.paso = paso;
    }
    
    public boolean compararEstado(Estado estado){
        boolean existe=false;
        if (getAlmJ1()==estado.getAlmJ1() && getAlmJ2()==estado.getAlmJ2() && getAlmJ3()==estado.getAlmJ3() ){
            existe = true;
        }
        return existe;
    }
    
    public int getAlmJ1() {
        return almJ1;
    }

    public void setAlmJ1(int capJ1) {
        this.almJ1 = capJ1;
    }

    public int getAlmJ2() {
        return almJ2;
    }

    public void setAlmJ2(int capJ2) {
        this.almJ2 = capJ2;
    }

    public int getAlmJ3() {
        return almJ3;
    }

    public void setAlmJ3(int capJ3) {
        this.almJ3 = capJ3;
    }
    
    public String getPaso() {
        return paso;
    }

    public void setPaso(String paso) {
        this.paso = paso;
    }
    
    
}
