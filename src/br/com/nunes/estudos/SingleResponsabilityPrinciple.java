package br.com.nunes.estudos;

public class SingleResponsabilityPrinciple {
    //UMA CLASSE DEVE TER APENAS UMA RAZÃO PARA MUDAR

    /*
    Dado uma classe Empregado, devemos imprimir as horas desse empregado.

     */

    class WrongEmployee {
        String name;

        public String getName() {
            return name;
        }

        public String printTimeSheetReport(){
            /*
            Nesse caso estamos colocando a complexidade de imprimir o relatório na classe de empregados.
            O correto é criar uma classe especifica para tratar gerar o relatório
             */
            return "";
        }
    }

    class Employee {
        String name;

        public String getName() {
            return name;
        }
    }

    // Aqui a classe agrega Employee aos seus atributos
    class TimeSheetReport {
        Employee employee;
        void print(Employee employee){

        }
    }
}
