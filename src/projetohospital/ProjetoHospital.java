package projetohospital;

public class ProjetoHospital {

    public static void main(String[] args) {
        Sistema.funcionarios.add(new Funcionario("admin", "admin", "admin@gmail.com", "Turmalina", 
         "0", "admin", "admin", "Administrador", "admin"));
        Sistema.funcionarios.add(new Funcionario("Tulio", "(38)99103-9305", "tulioalves@gmail.com", "Turmalina", 
         "11111111111", "Miopia", "Masculino", "Funcionario", "123"));
        Sistema.funcionarios.add(new Funcionario("Polesca", "(32)98447-5253", "matheuspolesca@gmail.com", "Sete Lagoas", 
         "22222222222", "Miopia", "Masculino", "Enfermeiro", "456"));
        Sistema.funcionarios.add(new Funcionario("Brenda", "(32)98447-5253", "brendaorlandi@gmail.com", "Diamantina", 
         "33333333333", "Miopia", "Feminino" , "Medico", "789"));
        
        
        try {
            Sistema.fazerLogin();
            if(!"NULL".equals(Sistema.profissao)){
            Sistema.menuSistema();
        }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
