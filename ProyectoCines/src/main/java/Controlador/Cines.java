/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author isaia
 */
public class Cines {
    private int idPeliculas;
    private String Nombre;
    private String Clasificacion;
    private String Genero;
    private String Idioma;
    private String Subtitulado;
    private double precio;
    public Cines()
    {
    }

    public int getIdPeliculas() {
        return idPeliculas;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public String getGenero() {
        return Genero;
    }

    public String getIdioma() {
        return Idioma;
    }

    public String getSubtitulado() {
        return Subtitulado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdPeliculas(int idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public void setSubtitulado(String Subtitulado) {
        this.Subtitulado = Subtitulado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Cines(int idPeliculas)
    {
    this.idPeliculas=idPeliculas;
    }
    public Cines (int idPeliculas, String Nombre)
    {
    this.idPeliculas=idPeliculas;
    this.Nombre=Nombre;
    }
    public Cines (int idPeliculas, String Nombre, String Clasificacion)
    {
    this.idPeliculas=idPeliculas;
    this.Nombre=Nombre;
    this.Clasificacion=Clasificacion;
    }
    public Cines (int idPeliculas, String Nombre, String Clasificacion, String Genero)
    {
    this.idPeliculas=idPeliculas;
    this.Nombre=Nombre;
    this.Clasificacion=Clasificacion;
    this.Genero=Genero;
    }
    public Cines (int idPeliculas, String Nombre, String Clasificacion, String Genero, String Idioma)
    {
    this.idPeliculas=idPeliculas;
    this.Nombre=Nombre;
    this.Clasificacion=Clasificacion;
    this.Genero=Genero;
    this.Idioma=Idioma;
    }
    public Cines (int idPeliculas, String Nombre, String Clasificacion, String Genero, String Idioma, String Subtitulado)
    {
    this.idPeliculas=idPeliculas;
    this.Nombre=Nombre;
    this.Clasificacion=Clasificacion;
    this.Genero=Genero;
    this.Idioma=Idioma;
    this.Subtitulado=Subtitulado;
    }
    public Cines (int idPeliculas, String Nombre, String Clasificacion, String Genero, String Idioma, String Subtitulado, double precio)
    {
    this.idPeliculas=idPeliculas;
    this.Nombre=Nombre;
    this.Clasificacion=Clasificacion;
    this.Genero=Genero;
    this.Idioma=Idioma;
    this.Subtitulado=Subtitulado;
    this.precio=precio;
    }
    @Override
    public String toString() {
        return "Cines{" + "idPeliculas=" + idPeliculas + ", Nombre=" + Nombre + ", Clasificacion=" + Clasificacion + ", Genero=" + Genero + ", Idioma=" + Idioma + ", Subtitulado=" + Subtitulado + ", precio=" + precio + '}';
    }
    
}
