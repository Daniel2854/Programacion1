package model;

import java.time.LocalDate;

public class Alimenticio extends Producto{

    private LocalDate vencimiento;

    public Alimenticio(String codigo, String nombre, double precioUnitario, Empresa ownedByEmpresa, LocalDate vencimiento) {
        super (codigo, nombre, precioUnitario,  ownedByEmpresa);
        this.vencimiento = vencimiento;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }
    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }
}
