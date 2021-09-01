package projetohospital;

public class ProjetoHospital {

    public static void main(String[] args) {
        Sistema.funcionarios[0] = new Funcionario("admin", "admin", "admin@gmail.com", "Turmalina", 
         "0", "admin", "admin", "Administrador", "admin");
        Sistema.funcionarios[1] = new Funcionario("Tulio", "(38)99103-9305", "tulioalves@gmail.com", "Turmalina", 
         "11111111111", "Miopia", "Masculino", "Funcionario", "123");
        Sistema.funcionarios[2] = new Enfermeiro("Polesca", "(32)98447-5253", "matheuspolesca@gmail.com", "Sete Lagoas", 
         "22222222222", "Miopia", "Masculino", "Enfermeiro", "456");
        Sistema.funcionarios[3] = new Medico("Brenda", "(32)98447-5253", "brendaorlandi@gmail.com", "Diamantina", 
         "33333333333", "Miopia", "Feminino" , "Medico", "789");
        
        System.out.println(Sistema.funcionarios[3].toString());
        
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
