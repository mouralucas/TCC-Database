//package entities;
//
///**
// * @author Jociane Franzoni de Lima
// * @author Lucas Penha de Moura
// *
// * ------------------- Trabalho de Conclusão de Curso ---------------------
// * ---------------------- Engenharia de Computação ------------------------
// * ------------- Universidade Tecnológica Federal do Paraná ---------------
// *
// */
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@Entity
//public class Users implements Serializable {
//
//    @Id
//    @Column(name = "id", nullable = false, unique = true)
//    private int id;
//
//    @Column(name = "userName", nullable = false, unique = true)
//    private String nomeUsuario;
//
//    @Column(name = "password", nullable = false, unique = false)
//    private String senha;
//
//    @Column(name = "lastAccess", unique = true)
//    @Temporal(TemporalType.DATE)
//    private Date ultimoAcesso;
//
//    public String getNomeUsuario() {
//        return nomeUsuario;
//    }
//
//    public void setNomeUsuario(String nomeUsuario) {
//        this.nomeUsuario = nomeUsuario;
//    }
//
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
//
//    public Date getUltimoAcesso() {
//        return ultimoAcesso;
//    }
//
//    public void setUltimoAcesso(Date ultimoAcesso) {
//        this.ultimoAcesso = ultimoAcesso;
//    }
//}
