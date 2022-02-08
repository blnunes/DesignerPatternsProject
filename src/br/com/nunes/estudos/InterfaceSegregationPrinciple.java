package br.com.nunes.estudos;

import java.util.List;

public class InterfaceSegregationPrinciple {
    // CLIENTES NÃO DEVEM SER FORÇADOS A DEPENDER DE METODOS QUE NÃO USAM

    //problema
    interface CloudProviderWrong {
        void storeFile(String name);
        void getFile(String name);
        void createServer(String regiao);
        List<String> listServer(String regiao);
        void getCDNAdress();
    }
    //NESSE EXEMPLO TODOS ESSES METODOS SÃO OBRIGATÓRIOS PARA CLOUD DA AMAZON
    class Amzon1 implements CloudProviderWrong {

        @Override
        public void storeFile(String name) {

        }

        @Override
        public void getFile(String name) {

        }

        @Override
        public void createServer(String regiao) {

        }

        @Override
        public List<String> listServer(String regiao) {
            return null;
        }

        @Override
        public void getCDNAdress() {

        }
    }

    //PORÉM NEM TODOS SÃO OBRIGATÓRIOS PARA O DROPBOX
    class DropBox1 implements CloudProviderWrong {

        @Override
        public void storeFile(String name) {

        }

        @Override
        public void getFile(String name) {

        }

        @Override
        public void createServer(String regiao) {

        }

        @Override
        public List<String> listServer(String regiao) {
            return null;
        }

        @Override
        public void getCDNAdress() {

        }
    }

    interface CloudHostingProvider {
        void createServer(String regiao);
        List<String> listServer(String regiao);
    }

    interface CDNProvider {
        void getCDNAdress();
    }

    interface CloudStorageProvider {
        void storeFile(String name);
        void getFile(String name);
    }

    //NESSE EXEMPLO A CLOUD DA AMAZON IMPLEMENTA TODAS INTERFACES DISPONVEIS QUE ELA NECESSITA
    class Amazon implements CloudHostingProvider, CloudStorageProvider, CDNProvider {

        @Override
        public void createServer(String regiao) {

        }

        @Override
        public List<String> listServer(String regiao) {
            return null;
        }

        @Override
        public void getCDNAdress() {

        }

        @Override
        public void storeFile(String name) {

        }

        @Override
        public void getFile(String name) {

        }
    }

    //E O DROP BOX SÓ UTILIZA A INTERFACE QUE ELE PRECISA
    class DropBox implements CloudStorageProvider{

        @Override
        public void storeFile(String name) {

        }

        @Override
        public void getFile(String name) {

        }
    }
}
