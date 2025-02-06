package zona_fit.dominio;
import java.util.Objects;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int miembro;

    public Cliente(){
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String nombre, String apellido, int miembro){
        this.nombre = nombre;
        this.apellido = apellido;
        this.miembro = miembro;
    }

    public Cliente(int id, String nombre, String apellido, int miembro){
        this(nombre, apellido, miembro);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMiembro() {
        return miembro;
    }

    public void setMiembro(int miembro) {
        this.miembro = miembro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", miembro=" + miembro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && miembro == cliente.miembro && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, miembro);
    }
}
