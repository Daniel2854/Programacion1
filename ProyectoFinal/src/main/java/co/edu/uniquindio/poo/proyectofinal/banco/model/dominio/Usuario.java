package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

public class Usuario {
    private String username;
    private String password;
    private Cliente cliente;

    public Usuario(String username, String password, Cliente cliente) {
        this.username = username;
        this.password = password;
        this.cliente = cliente;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean autenticar(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }
}
