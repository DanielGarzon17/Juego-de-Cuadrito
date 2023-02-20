
package OFICIAL;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ventana extends JFrame implements MouseListener{

    private static final long serialVersionUID = 1L;
    //atributos globales
    int turno=0;
    int newx,newy,oldx,oldy;
    int ContAZUL=0,ContVERDE=0;
    
    //Panel
    JPanel panel = new JPanel();
    //JLabel
    JLabel Titulo = new JLabel("CUADRITO");
    JLabel TVERDE = new JLabel("VERDE:");
    JLabel VERDE = new JLabel();
    JLabel TAZUL = new JLabel("AZUL: ");
    JLabel AZUL = new JLabel();
    JLabel ERROR = new JLabel();
    //JButton
    JButton Limpiar = new JButton("LIMPIAR");
    JButton Jugar = new JButton("JUGAR");
    
    verificaciones ope=new verificaciones();
    
    public ventana(){
        this.setSize(410,540); //Establecemos el tamaño de nuestra ventana (Ancho, Largo)
        setTitle("CUADRITO V0.1"); //Establece el título que le daremos a la ventana
        setLocationRelativeTo(null); //Establece automáticamente la ubicación de la ventana en el centro de la pantalla

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //panel
        panel.setLayout(null); //Desactivamos el diseño por defecto
        panel.setBackground(Color.WHITE); //Definimos el color de el panel llamado "Panel1"
        this.getContentPane().add(panel);
        
        //TITULO
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setBounds(40, 132, 330, 40); //Configuramos la ubicación de la etiqueta

        Titulo.setForeground (Color.BLACK); //Establecemos el color de las letras de nuestra etiqueta
        Titulo.setFont(new Font("Times new Roman",Font.BOLD,35)); //Establecemos configuración del texto(Fuente,Tipo,Tamaño)
        panel.add(Titulo);
        //TVERDE
        TVERDE.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos alineación horizontal al texto
        TVERDE.setBounds(40 , 400, 160, 20); 
        TVERDE.setForeground(Color.GREEN);
        TVERDE.setFont(new Font("Times new Roman",1,17));//(0=Normal)
        panel.add(TVERDE);
        //VERDE
        VERDE.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos alineación horizontal al texto
        VERDE.setBounds(40 , 420, 160, 30); 
        VERDE.setForeground(Color.BLACK);
        VERDE.setFont(new Font("Times new Roman",1,22));//(0=Normal)
        panel.add(VERDE);
              
        //TAZUL
        TAZUL.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos alineación horizontal al texto
        TAZUL.setBounds(210 , 400, 160, 20); 
        TAZUL.setForeground(Color.BLUE );
        TAZUL.setFont(new Font("Times new Roman",1,17));//(0=Normal)
        panel.add(TAZUL);
        //AZUL
        AZUL.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos alineación horizontal al texto
        AZUL.setBounds(210 , 420, 160, 30); 
        AZUL.setForeground(Color.BLACK);
        AZUL.setFont(new Font("Times new Roman",1,22));//(0=Normal)
        panel.add(AZUL);
        
        ERROR.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos alineación horizontal al texto
        ERROR.setBounds(40 , 460, 330, 30); 
        ERROR.setForeground(Color.BLACK );
        ERROR.setFont(new Font("Times New Roman",Font.BOLD,20));//(0=Normal)
        panel.add(ERROR);
        
        //Limpiar
        Limpiar.setBounds(210, 350, 160, 40); //Configuramos la ubicación de la etiqueta
        Limpiar.setBackground(Color.LIGHT_GRAY);
        Limpiar.setFont(new Font("Times New Roman",Font.BOLD,20)); //Establecemos configuración del texto(Fuente,Tipo,Tamaño)
        Limpiar.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(Limpiar);
        
        //Jugar
        Jugar.setBounds(40, 350, 160, 40); //Configuramos la ubicación de la etiqueta
        Jugar.setBackground(Color.LIGHT_GRAY);
        Jugar.setFont(new Font("Times New Roman",Font.BOLD,20)); //Establecemos configuración del texto(Fuente,Tipo,Tamaño)
        Jugar.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(Jugar);
        
        Jugar();
        Limpiar();
        
        addMouseListener(this);
        
    }
    
    void dibujarmalla(){
        Graphics g=getGraphics();
        int x=40,y=370;
       
        g.setColor(Color.lightGray);
        g.drawLine(x, x, y, x);
        g.drawLine(y, x, y, y);
        g.drawLine(y, y, x, y);
        g.drawLine(x, y, x, x);
        
        for(int i=0; i<6;i++){
            for(int j=0; j<6;j++){
                g.drawRect(40+(j*55), 40+(i*55), 55,55);
            }
        }
    }
    
    public void Dibujar(){
//        System.out.println("nuevo x,y: "+newx+","+newy);
        Graphics g=getGraphics();
        if(turno%2==0){ 
            g.setColor(Color.BLUE);
        }
        else{
            g.setColor(Color.GREEN);
        }
        ope.filycol(oldx, oldy, newx, newy);
        if(ContAZUL==10 || ContVERDE==10){
            if(ContAZUL==10){
                ERROR.setText("Gano AZUL");
            }else{
                ERROR.setText("Gano VERDE");
            }
        }else{
            if(ope.Verificacion_Total()){
                g.drawLine(oldx, oldy, newx, newy);
                ERROR.setText(null);
                if(ope.Veri_Cuadro()){
                    if(turno%2==0){ 
                        ContAZUL++;
                        AZUL.setText(ContAZUL+"");
                    }
                    else{
                        ContVERDE++;
                        VERDE.setText(ContVERDE+"");
                    }
                }
            }
            else{
                ERROR.setText(ope.r1);
            }
        }
        
        turno++;
    }
    
    public void borrar(){
        Graphics g=getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(40, 40, 331, 331);
        dibujarmalla();
        ContAZUL=0;
        ContVERDE=0;
        turno=0;
        AZUL.setText(null);
        VERDE.setText(null);
        ope.borrartodo();
        ERROR.setText(null);
    }
    
//BOTONES
    void Limpiar(){
        ActionListener oyenteDeAccion = (ActionEvent ae) -> {
            borrar();
        } //@Override
        ;
        Limpiar.addActionListener(oyenteDeAccion);
        panel.add(Limpiar);
    }
    
    void Jugar(){
        ActionListener oyenteDeAccion;
        oyenteDeAccion = (ActionEvent ae) -> {
            Titulo.setText("");
            dibujarmalla();
        } //@Override
        ;
        Jugar.addActionListener(oyenteDeAccion);
        panel.add(Jugar);
    }
 
//MOUSE
    public void mouseEntered(MouseEvent e1){}
    public void mouseClicked(MouseEvent e1){}
    public void mousePressed(MouseEvent e1){
        Point p = e1.getPoint();
        oldx=p.x;
        oldy=p.y;
//        System.out.println("viejo x,y: "+viejox+","+viejoy);
    }
    public void mouseReleased(MouseEvent e1){
        Point p = e1.getPoint();
        newx=p.x;
        newy=p.y;
        Dibujar();
    }
    public void mouseExited(MouseEvent e1){}
    
    
}


