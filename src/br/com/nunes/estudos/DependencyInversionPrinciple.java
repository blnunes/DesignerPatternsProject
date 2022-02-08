package br.com.nunes.estudos;

import javax.xml.crypto.Data;

public class DependencyInversionPrinciple {
    //ALTO NIVEL
    class BudgetReport {
        DataBase db;
        //open(new MongoDB() or new MySQL())
        void open(DataBase db){
            //OU MYSQL CASO NECESSÁRIO
            this.db = db;
        }

        void save() {
            this.db.insert();
        }
    }

    //ALTO NIVEL
    interface DataBase {
        void insert();
        void save();
        void delete();
    }

    //BAIXO NIVEL
    class MySql implements DataBase {

        @Override
        public void insert() {

        }

        @Override
        public void save() {

        }

        @Override
        public void delete() {

        }
    }

    //BAIXO NIVEL
    class MongoDB implements DataBase {

        @Override
        public void insert() {

        }

        @Override
        public void save() {

        }

        @Override
        public void delete() {

        }
    }
}
