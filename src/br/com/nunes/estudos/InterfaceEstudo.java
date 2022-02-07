package br.com.nunes.estudos;

import java.util.ArrayList;
import java.util.List;

public class InterfaceEstudo {

    public static void main(String[] args) {

        GameDev gameDev = new GameDev();
        System.out.println("Tipos empregados GAMEDEV: ");
        gameDev.getEmployees().forEach(Employee::doWork);

        Outsourcing outsourcing = new Outsourcing();
        System.out.println("Tipos empregados Outsourcing: ");
        outsourcing.getEmployees().forEach(Employee::doWork);


    }
    //PROGRAME PARA UMA INTERFACE, NÃO UMA IMPLEMENTAÇÃO
    abstract static class Company {
        abstract List<Employee> getEmployees();

        private void createSoftware(){

        }
    }

    static class GameDev extends Company{
        @Override
        List<Employee> getEmployees() {
            List<Employee> employees = new ArrayList<>();
            employees.add(new Designer());
            employees.add(new Tester());
            employees.add(new Developer());
            return employees;
        }


    }
    static class Outsourcing extends Company {
        @Override
        List<Employee> getEmployees() {
            ArrayList<Employee> employees = new ArrayList<>();
            employees.add(new Tester());
            employees.add(new Developer());
            return employees;
        }

    }

    interface Employee {
        void doWork();
    }

    static class Designer implements Employee {
        @Override
        public void doWork() {
            System.out.println("Trabalhando como Desginer");
        }
    }

    static class Developer implements Employee {
        @Override
        public void doWork() {
            System.out.println("Trabalhando como Developer");

        }
    }

    static class Tester implements Employee {
        @Override
        public void doWork() {
            System.out.println("Trabalhando como Tester");

        }
    }
}
