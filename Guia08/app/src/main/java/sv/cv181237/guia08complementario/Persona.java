package sv.cv181237.guia08complementario;

public class Persona {
    private String dui;
    private String nombre;
    private String genero;
    private String fechanac;
    private String peso;
    private String altura;
    String key;

    public Persona() {
    }

    public Persona(String dui, String nombre, String genero, String fechanac, String peso, String altura) {
        this.dui = dui;
        this.nombre = nombre;
        this.genero = genero;
        this.fechanac = fechanac;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(){
        this.genero = genero;
    }

    public String getFechanac(){
        return fechanac;
    }

    public void setFechanac(){
        this.fechanac = fechanac;
    }

    public String getPeso(){
        return peso;
    }

    public void setPeso(){
        this.peso = peso;
    }

    public String getAltura(){
        return altura;
    }

    public void setAltura(){
        this.altura = altura;
    }
}