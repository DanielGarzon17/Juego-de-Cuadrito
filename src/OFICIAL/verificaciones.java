
package OFICIAL;

import javax.swing.JComponent;

public class verificaciones extends JComponent{
    int colviejo,colnew,filviejo,filnew;
    int cont;
    int[][] NumRepetidos=new int [240][4];
    int[][] NumBaned=new int[240][4];
    String r1;
    int viejox,viejoy,newx,newy;
    int Hori1Final[]=new int[4],Hori2Final[]=new int[4],Verti1Final[]=new int[4],Verti2Final[]=new int[4];
    
    verificaciones(){
        for (int i=0;i<240;i++){
            for (int j=0;j<4;j++){
                NumRepetidos[i][j]=9;
                NumBaned[i][j]=9;
            }
        }
    }
    
    void filycol(int viejoox,int viejooy, int newwx,int newwy){
        int m,n,o,p;
        viejox=viejoox;
        viejoy=viejooy;
        newx=newwx;
        newy=newwy;
        
        for(int i=0;i<6;i++){
            if(viejox>40+(i*55) && viejox<40+((i+1)*55)) {//mirar columnas viejo
                m=i;
                colviejo=m;
            }
            if(viejoy>40+(i*55) && viejoy<40+((i+1)*55)) {//mirar filas viejo
                n=i;
                filviejo=n;
//                System.out.println("Fila inicial:"+i);
            }
            if(newx>40+(i*55) && newx<40+((i+1)*55)) {//mirar columnas nuevo
                o=i;
                colnew=o;
//                System.out.println("columna final:"+i);
            }
            if(newy>40+(i*55) && newy<40+((i+1)*55)) {//mirar filas nuevo
                p=i;
                filnew=p;
//                System.out.println("Fila final:"+i);
            }
        }
        System.out.println("inicial: ("+filviejo+","+colviejo+")");
        System.out.println("final: ("+filnew+","+colnew+")");
        
        
    }
    
    boolean Veri_Repetidos(){
        int[]Repetidos=new int[4];
        Repetidos[0]=filviejo;
        Repetidos[1]=colviejo;
        Repetidos[2]=filnew;
        Repetidos[3]=colnew;
        
        for(int i=0;i<240;i++){
            cont=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Repetidos[j]){
                    cont++;
                    //System.out.println("Entró a repetida idiota");
                }
                if(cont==4){
                    r1="Linea repetida";
                    return false;
                }
            }
        }

        int breakk=0;
        int aux=0;
        while(breakk!=1){
            if(NumRepetidos[aux][0]==9){
                //System.out.println("Ojito con la super duper verificacion");
                NumRepetidos[aux][0]=Repetidos[0];
                NumRepetidos[aux][1]=Repetidos[1];
                NumRepetidos[aux][2]=Repetidos[2];
                NumRepetidos[aux][3]=Repetidos[3];
                breakk=1;
            }
            aux++;
        }
        
        breakk=0;
        aux=0;
        Repetidos[2]=filviejo;
        Repetidos[3]=colviejo;
        Repetidos[0]=filnew;
        Repetidos[1]=colnew;
        
        while(breakk!=1){
            if(NumRepetidos[aux][0]==9){
                //System.out.println("Ojito con la super duper verificacion");
                NumRepetidos[aux][0]=Repetidos[0];
                NumRepetidos[aux][1]=Repetidos[1];
                NumRepetidos[aux][2]=Repetidos[2];
                NumRepetidos[aux][3]=Repetidos[3];
                breakk=1;
            }
            aux++;
        }
        return true;
    }
    
    boolean Verificacion_Grande(){
        if((viejox<40||viejoy<40||viejox>370||viejoy>370)||(newx<40||newy<40||newx>370||newy>370)){
            r1="Pinto por fuera de la cuadricula";
            return false; 
        }
        return true;
    }
    
    void borrartodo(){
        for(int i=0;i<240;i++){
            for(int j=0;j<4;j++){
                NumRepetidos[i][j]=9;
                NumBaned[i][j]=9;
            }
        }
        cont=0;
    }
    
    boolean MatrizConfirm(int Hori1[],int Hori1inver[],int Hori2[],int Hori2inver[],int Verti1[],int Verti1inver[],int Verti2[],int Verti2inver[]){
        int H1=0,H2=0,V1=0,V2=0,tot=0;
        int H1inver=0,H2inver=0,V1inver=0,V2inver=0;
        
        for(int i=0;i<240;i++){
            H1=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Hori1[j]){
                    H1++;
                }
                if(H1==4){
                    tot++;
                }
            }
        }
        for(int i=0;i<240;i++){
            H2=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Hori2[j]){
                    H2++;
                }
                if(H2==4){
                    tot++;
                }
            }
        }
        for(int i=0;i<240;i++){
            V1=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Verti1[j]){
                    V1++;
                }
                if(V1==4){
                    tot++;
                }
            }
        }
        for(int i=0;i<240;i++){
            V2=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Verti2[j]){
                    V2++;
                }
                if(V2==4){
                    tot++;
                }
            }
        }
        
        
        for(int i=0;i<240;i++){
            H1inver=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Hori1inver[j]){
                    H1inver++;
                }
                if(H1inver==4){
                    tot++;
                }
            }
        }
        for(int i=0;i<240;i++){
            H2inver=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Hori2inver[j]){
                    H2inver++;
                }
                if(H2inver==4){
                    tot++;
                }
            }
        }
        for(int i=0;i<240;i++){
            V1inver=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Verti1inver[j]){
                    V1inver++;
                }
                if(V1inver==4){
                    tot++;
                }
            }
        }
        for(int i=0;i<240;i++){
            V2inver=0;
            for(int j=0;j<4;j++){
                if(NumRepetidos[i][j]==Verti2inver[j]){
                    V2inver++;
                }
                if(V2inver==4){
                    tot++;
                }
            }
        }
        
        if(tot==8){
//            System.out.println("El valor del total es: "+tot);
            return true;
        }
        else{
            return false;
        }
    }
    
    boolean BANED(int Hori1[],int Hori1inver[],int Hori2[],int Hori2inver[],int Verti1[],int Verti1inver[],int Verti2[],int Verti2inver[]){
        int H1=0,H2=0,V1=0,V2=0,tot=0;
        int H1inver=0,H2inver=0,V1inver=0,V2inver=0;
        
        
        for(int i=0;i<240;i++){
            H1=0;
            for(int j=0;j<4;j++){
                if(NumBaned[i][j]==Hori1[j]){
                    H1++;
                }
                if(H1==4){
                    tot++;
                    for(int k=0;k<4;k++){
                        Hori1Final[k]=Hori1[k];
                    }
                }
            }
        }
        for(int i=0;i<240;i++){
            H2=0;
            for(int j=0;j<4;j++){
                if(NumBaned[i][j]==Hori2[j]){
                    H2++;
                }
                if(H2==4){
                    tot++;
                    Hori2Final=Hori2;
                }
            }
        }
        for(int i=0;i<240;i++){
            V1=0;
            for(int j=0;j<4;j++){
                if(NumBaned[i][j]==Verti1[j]){
                    V1++;
                }
                if(V1==4){
                    tot++;
                    Verti1Final=Verti1;
                }
            }
        }
        for(int i=0;i<240;i++){
            V2=0;
            for(int j=0;j<4;j++){
                if(NumBaned[i][j]==Verti2[j]){
                    V2++;
                }
                if(V2==4){
                    tot++;
                    Verti2Final=Verti2;
                }
            }
        }
        
        for(int i=0;i<240;i++){
            H1inver=0;
            for(int j=0;j<4;j++){
                if(NumBaned[i][j]==Hori1inver[j]){
                    H1inver++;
                }
                if(H1inver==4){
                    tot++;
                    Hori1Final=Hori1inver;
                }
            }
        }
        for(int i=0;i<240;i++){
            H2inver=0;
            for(int j=0;j<4;j++){
                if(NumBaned[i][j]==Hori2inver[j]){
                    H2inver++;
                }
                if(H2inver==4){
                    tot++;
                    Hori2Final=Hori2inver;
                }
            }
        }
        for(int i=0;i<240;i++){
            V1inver=0;
            for(int j=0;j<4;j++){
                if(NumBaned[i][j]==Verti1inver[j]){
                    V1inver++;
                }
                if(V1inver==4){
                    tot++;
                    Verti1Final=Verti1inver;
                }
            }
        }
        for(int i=0;i<240;i++){
            V2inver=0;
            for(int j=0;j<4;j++){
                if(NumBaned[i][j]==Verti2inver[j]){
                    V2inver++;
                }
                if(V2inver==4){
                    tot++;
                    Verti2Final=Verti2inver;
                    
                }
            }
        }
//      System.out.println("Antes del for tot= "+tot);
        if(tot<=6){
            for(int i=0;i<240;i++){
                for(int j=0;j<4;j++){
                    if(NumBaned[i][j]==9){
                        NumBaned[i][0]=Hori1[0];
                        NumBaned[i][1]=Hori1[1];
                        NumBaned[i][2]=Hori1[2];
                        NumBaned[i][3]=Hori1[3];  
                        
                        NumBaned[i+1][0]=Hori2[0];
                        NumBaned[i+1][1]=Hori2[1];
                        NumBaned[i+1][2]=Hori2[2];
                        NumBaned[i+1][3]=Hori2[3];
                        
                        NumBaned[i+2][0]=Verti1[0];
                        NumBaned[i+2][1]=Verti1[1];
                        NumBaned[i+2][2]=Verti1[2];
                        NumBaned[i+2][3]=Verti1[3]; 
                        
                        NumBaned[i+3][0]=Verti2[0];
                        NumBaned[i+3][1]=Verti2[1];
                        NumBaned[i+3][2]=Verti2[2];
                        NumBaned[i+3][3]=Verti2[3];
                        
                        NumBaned[i+4][0]=Hori1inver[0];
                        NumBaned[i+4][1]=Hori1inver[1];
                        NumBaned[i+4][2]=Hori1inver[2];
                        NumBaned[i+4][3]=Hori1inver[3];  
                        
                        NumBaned[i+5][0]=Hori2inver[0];
                        NumBaned[i+5][1]=Hori2inver[1];
                        NumBaned[i+5][2]=Hori2inver[2];
                        NumBaned[i+5][3]=Hori2inver[3];
                        
                        NumBaned[i+6][0]=Verti1inver[0];
                        NumBaned[i+6][1]=Verti1inver[1];
                        NumBaned[i+6][2]=Verti1inver[2];
                        NumBaned[i+6][3]=Verti1inver[3]; 
                        
                        NumBaned[i+7][0]=Verti2inver[0];
                        NumBaned[i+7][1]=Verti2inver[1];
                        NumBaned[i+7][2]=Verti2inver[2];
                        NumBaned[i+7][3]=Verti2inver[3];
//                        
//                        System.out.println("======================================");
//                        System.out.println("["+Hori1[0]+","+Hori1[1]+","+Hori1[2]+","+Hori1[3]+"]");
//                        System.out.println("["+Hori2[0]+","+Hori2[1]+","+Hori2[2]+","+Hori2[3]+"]");
//                        System.out.println("["+Verti1[0]+","+Verti1[1]+","+Verti1[2]+","+Verti1[3]+"]");
//                        System.out.println("["+Verti2[0]+","+Verti2[1]+","+Verti2[2]+","+Verti2[3]+"]");
//                        System.out.println("El valor de tot es "+tot);
//            
                        return true;
                    }                 
                }
            }
            
            
            
        }
        
        return false;
        
      
    }
    
    boolean Veri_Cuadro(){
        int x1,x2,y1,y2,X,Y;
        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                //Principales Horizontales
                int Hori1[]={i,j,i,j+1};
                int Hori1inver[]={i,j+1,i,j};
                
                //Secundarios Horizontales
                int Hori2[]={i+1,j,i+1,j+1};
                int Hori2inver[]={i+1,j+1,i+1,j};  
                
                //Principales Verticales
                int Verti1[]={i,j,i+1,j};
                int Verti1inver[]={i+1,j,i,j};
                
                //Secundarios Verticales
                int Verti2[]={i,j+1,i+1,j+1};
                int Verti2inver[]={i+1,j+1,i,j+1};
                
                
                if(MatrizConfirm(Hori1,Hori1inver,Hori2,Hori2inver,Verti1,Verti1inver,Verti2,Verti2inver)){
//                    System.out.println("Matriz confirmó");
                    if(BANED(Hori1,Hori1inver,Hori2,Hori2inver,Verti1,Verti1inver,Verti2,Verti2inver)){
//                        System.out.println("Lista negra confirmó");
                        //dib1=Hori1[0];
                        //dib2=Hori1[1];
//                        System.out.println("Ganaste xd");
//                        for(int k=0;k<10;k++){
//                        System.out.println("["+Repe[k][0]+","+Repe[k][1]+","+Repe[k][2]+","+Repe[k][3]+"]");
//                        }
                        return true;
                    
                    
                    }
                }
            }
        }
        return false;
    }
    
    boolean verdiagonal(){
        if((filviejo==filnew || colviejo==colnew)){
            return true;   
        }
        r1="Pintó una diagonal";
        return false;
    }
    
    boolean verdistancia(){
        if((Math.abs(filviejo-filnew))!=1 && (Math.abs(colviejo-colnew))!=1){
                r1="La linea es muy larga o muy corta";
                return false;
        }
        
        return true;
    }
    
    boolean Verificacion_Total(){
        if(Verificacion_Grande()){
            if(verdiagonal()){
                if(verdistancia()){
                    if(Veri_Repetidos()){
                        return true;
                        }
                    }
                }

            }
        return false;
        }
    
}


